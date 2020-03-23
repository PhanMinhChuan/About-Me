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
public class AdminAddNewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	public AdminAddNewController() {
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryDAO categoryDao = new CategoryDAO();
		List<Category> catList = categoryDao.getcatList();
		
		request.setAttribute("catList", catList);
		RequestDispatcher rd = request.getRequestDispatcher("/view/admin/new/add.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		NewDAO newDao = new NewDAO();
		
		String name = request.getParameter("name");
		int check = 0;
		check = newDao.checkTrung(name);
		if (check == 0) {
			int catId = 0;
			try {
				catId = Integer.parseInt(request.getParameter("category"));
			} catch (NumberFormatException e) {
				response.sendRedirect(request.getContextPath() + "/index");
				return;		
			}
			String description = request.getParameter("preview");
			String detail = request.getParameter("detail");
			//Xử lý upload file
			Part filePart = request.getPart("picture");
			System.out.println(filePart.getSubmittedFileName());
			String fileName = FileUtil.rename(filePart.getSubmittedFileName());
			if (!"".equals(fileName)) {
				String webPath = request.getServletContext().getRealPath("");
				String dirPath = webPath + CommomConstant.DIR_UPLOAD;
				File createDir = new File(dirPath);
				if (!createDir.exists()) {
					createDir.mkdir();
				}
				String filePath = dirPath + File.separator +fileName;
				System.out.println(filePath);
				filePart.write(filePath);
			}
			//Song song = new Song("0", name, "0", fileName, );
			New news = new New(0, name, description, detail, null, 0, catId, fileName, "");
			int addCat = newDao.addItem(news);
			if(addCat > 0) {
				response.sendRedirect(request.getContextPath()+"/admin/new/index?msg=1");
				return;
			} else {
				response.sendRedirect(request.getContextPath()+"/admin/new/index?msg=0");
				return;
			}
		} else {
			response.sendRedirect(request.getContextPath()+"/admin/new/index?msg=0");
			return;
		}
		
	}

}
