package controller;

import java.io.File;
import java.io.IOException;
import java.net.FileNameMap;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import constant.CommomConstant;
import dao.CategoryDAO;
import dao.NewDAO;
import dao.ProfileDAO;
import model.Category;
import model.New;
import model.Profile;
import util.FileUtil;
@MultipartConfig

public class AdminEditProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	public AdminEditProfileController() {
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProfileDAO profileDao = new ProfileDAO();
		Profile profile = profileDao.getProfile();
		
		request.setAttribute("profile", profile);
		RequestDispatcher rd = request.getRequestDispatcher("/view/admin/profile/edit.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("html/text");
		request.setCharacterEncoding("UTF-8");
		
		
		String name = request.getParameter("name");
		int tuoi = Integer.parseInt(request.getParameter("tuoi"));
		String ngaySinh =request.getParameter("ngaysinh");
		String diaChi = request.getParameter("diachi");
		String email = request.getParameter("email");
		
		Part filePart = request.getPart("picture");
		String fileName = FileUtil.rename(filePart.getSubmittedFileName());
		System.out.println("Day la ten fileName: " + fileName);
		if (!"".equals(fileName)) {
			String oldPicture = request.getParameter("oldFileName");
			if (!"".equals(oldPicture)) {
				String webPath = request.getServletContext().getRealPath("");
				String dirPath = webPath + CommomConstant.DIR_UPLOAD;
				String filePath = dirPath + File.separator + oldPicture;
				File file = new File(filePath);
				file.delete();
				System.out.println("Đã Xóa file!");
			} else {
				System.out.println("Chưa Có File Từ trước!");
			}
			String webPath = request.getServletContext().getRealPath("");
			String dirPath = webPath + CommomConstant.DIR_UPLOAD;
			File createDir = new File(dirPath);
			if (!createDir.exists()) {
				createDir.mkdir();
			}
			String filePath = dirPath + File.separator +fileName;
			System.out.println(filePath);
			filePart.write(filePath);
			
		} else {
			fileName = request.getParameter("oldFileName");
		}
		int addProfile = 0;
		System.out.println(fileName);
		Profile profileNew = new Profile(name, tuoi, ngaySinh, diaChi, fileName, email);
		
		ProfileDAO profileDao = new ProfileDAO();
		addProfile = profileDao.editProfile(profileNew);
		
		if(addProfile > 0 ) {
			response.sendRedirect(request.getContextPath()+"/admin/profile/index?msg=2");
			return; 
		} else {
			response.sendRedirect(request.getContextPath()+"/admin/profile/index?msg=0");
			return;
		}
	}
}







