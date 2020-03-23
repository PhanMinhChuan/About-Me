package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDAO;
import dao.NewDAO;
import dao.ProjectDAO;

public class AdminDelProjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	public AdminDelProjectController() {
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProjectDAO projectDao = new ProjectDAO();
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath() + "/admin");
			return;		
		}
		
		int delCat = projectDao.delItem(id);
		if(delCat > 0) {
			response.sendRedirect(request.getContextPath()+"/admin/project/index?msg=3");
			return;
		} else {
			response.sendRedirect(request.getContextPath()+"/admin/project/index?msg=0");
			return;
		}
	}	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
