package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDAO;
import dao.NewDAO;

public class AdminDelCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	public AdminDelCatController() {
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryDAO categoryDAO = new CategoryDAO();
		NewDAO newDao = new NewDAO();
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath() + "/admin");
			return;		
		}
		
		int delCat = categoryDAO.delItem(id);
		int delSong = newDao.delItemByCatId(id);
		if(delCat > 0 && delSong > 0) {
			response.sendRedirect(request.getContextPath()+"/admin/cat/index?msg=3");
			return;
		} else {
			response.sendRedirect(request.getContextPath()+"/admin/cat/index?msg=0");
			return;
		}
	}	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
