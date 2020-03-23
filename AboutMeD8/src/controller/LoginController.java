package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import model.User;
import util.StringUtil;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	public LoginController() {
    }	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (request.getParameter("msgout") != null) {
			session.invalidate();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/view/auth/login.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String username = request.getParameter("username");
		String password = StringUtil.md5(request.getParameter("password"));
		System.out.println(username + password);
		UserDAO userDao = new UserDAO();
		User userInfo = userDao.checkLogin(username, password);
		if (userInfo != null) {
			//login success
			session.setAttribute("userInfo", userInfo);
			response.sendRedirect(request.getContextPath()+"/admin");
			return;
		} else {
			response.sendRedirect(request.getContextPath()+"/auth/login?msg=error");
			return;
		}
		
	}	
}
