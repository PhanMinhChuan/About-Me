package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import constant.CommomConstant;
import dao.NewDAO;
import model.New;

public class AdminDelNewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	public AdminDelNewController() {
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NewDAO newDao = new NewDAO();
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath() + "/admin");
			return;		
		}
		//------------------------------------------------------------------------
		New news = newDao.getNewbyID(id);
		if (!"".equals(news.getPicture())) {
			String webPath = request.getServletContext().getRealPath("");
			String dirPath = webPath + CommomConstant.DIR_UPLOAD;
			String filePath = dirPath + File.separator +news.getPicture();
			File file = new File(filePath);
			file.delete();
			System.out.println("�?ã xóa file!");
		}
		//------------------------------------------------------------------------
		int delSong = newDao.delItem(id);
		if(delSong > 0) {
			response.sendRedirect(request.getContextPath()+"/admin/new/index?msg=3");
			return;
		} else {
			response.sendRedirect(request.getContextPath()+"/admin/new/index?msg=0");
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
