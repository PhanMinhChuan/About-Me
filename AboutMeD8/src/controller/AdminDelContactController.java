package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContactDAO;
import dao.UserDAO;

public class AdminDelContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	public AdminDelContactController() {
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContactDAO contactDao = new ContactDAO();
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath() + "/admin");
			return;		
		}
		int delCat = contactDao.delItem(id);
		if(delCat > 0) {
			response.sendRedirect(request.getContextPath()+"/admin/contact/index?msg=1");
			return;
		} else {
			response.sendRedirect(request.getContextPath()+"/admin/contact/index?msg=0");
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
