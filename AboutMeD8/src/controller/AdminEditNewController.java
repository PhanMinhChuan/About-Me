package controller;

import java.io.File;
import java.io.IOException;
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
import model.Category;
import model.New;
import util.FileUtil;
@MultipartConfig

public class AdminEditNewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	public AdminEditNewController() {
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
				response.sendRedirect(request.getContextPath() + "/admin");
				return;		
		}
		NewDAO newDao = new NewDAO();
		New news = newDao.getNewbyIDAdmin(id);
		CategoryDAO categoryDao = new CategoryDAO();
		List<Category> catList = categoryDao.getcatList();

		request.setAttribute("news", news);
		request.setAttribute("catList", catList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/view/admin/new/edit.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("html/text");
		request.setCharacterEncoding("UTF-8");
		
		NewDAO newDao = new NewDAO();
		int id = 0;
		int catId = 0;
		
		try {
			id = Integer.parseInt(request.getParameter("id"));
			catId = Integer.parseInt(request.getParameter("category"));
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath() + "/admin");
			return;		
		}
		String name = request.getParameter("name");
		if ("".equals(name) != false || name != null ) { 
			String description = request.getParameter("preview");
			String detail = request.getParameter("detail");
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
			int addSong = 0;
			CategoryDAO categoryDao = new CategoryDAO();
			New newNew = new New(id, name, description, detail, null, 0, catId, fileName, categoryDao.getItemById(catId).getName());
			New songOld = newDao.getNewbyID(id);
			int checkSong = newDao.soSanhNew(songOld,newNew);
			System.out.println("Check song :" + checkSong);
			if (checkSong != 5) {
				addSong = newDao.editItem(newNew);
			} 
			if(addSong > 0 && checkSong != 5) {
				response.sendRedirect(request.getContextPath()+"/admin/new/index?msg=2");
				return; 
			} else {
				response.sendRedirect(request.getContextPath()+"/admin/new/index?msg=0&id="+id);
				return;
			}
		} 
	}
}







