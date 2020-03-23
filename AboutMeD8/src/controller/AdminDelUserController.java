package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CategoryDAO;
import dao.UserDAO;
import model.Category;

public class AdminDelUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	public AdminDelUserController() {
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO userDao = new UserDAO();
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath() + "/admin");
			return;		
		}
		int delCat = userDao.delItem(id);
		if(delCat > 0) {
			response.sendRedirect(request.getContextPath()+"/admin/user/index?msg=3");
			return;
		} else {
			response.sendRedirect(request.getContextPath()+"/admin/user/index?msg=0");
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
