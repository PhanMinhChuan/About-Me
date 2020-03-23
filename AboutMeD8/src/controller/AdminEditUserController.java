package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model.User;

public class AdminEditUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	public AdminEditUserController() {
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
		UserDAO userDao = new UserDAO();
		User user = userDao.getItemById(id);
		request.setAttribute("user", user);
		
		RequestDispatcher rd = request.getRequestDispatcher("/view/admin/user/edit.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("html/text");
		request.setCharacterEncoding("UTF-8");
		
		UserDAO userDao = new UserDAO();
		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		int check = 0;
		check = userDao.checkTrung(username);
		if (check == 0) {
			String fullname = request.getParameter("fullname");
			String password = request.getParameter("password");
			User user = new User(id, username, password, fullname);
			int addCat = userDao.editItem(user);
			if(addCat > 0) {
				response.sendRedirect(request.getContextPath()+"/admin/user/index?msg=2");
				return;
			} else {
				response.sendRedirect(request.getContextPath()+"/admin/user/index?msg=0&id="+id);
				return;
			}
		}else {
			response.sendRedirect(request.getContextPath()+"/admin/user/index?msg=0&id="+id);
			return;
		}
	}
}
