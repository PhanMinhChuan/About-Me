package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model.User;

public class AdminAddUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	public AdminAddUserController() {
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/view/admin/user/add.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("html/text");
		request.setCharacterEncoding("UTF-8");
		
		UserDAO userDao = new UserDAO();
		String username = request.getParameter("username");
		int check = 0;
		check = userDao.checkTrung(username);
		if (check == 0) {
			String fullname = request.getParameter("fullname");
			String password = request.getParameter("password");
			User user = new User(0, username, password, fullname);
			int addCat = userDao.addItem(user);
			if(addCat > 0) {
				response.sendRedirect(request.getContextPath()+"/admin/user/index?msg=1");
				return;
			} else {
				response.sendRedirect(request.getContextPath()+"/admin/user/index?msg=0");
				return;
			}
		} else {
			response.sendRedirect(request.getContextPath()+"/admin/user/index?msg=0");
			return;
		}
	}	
}
