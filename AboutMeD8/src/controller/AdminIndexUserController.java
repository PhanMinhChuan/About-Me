package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model.User;

public class AdminIndexUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	public AdminIndexUserController() {
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		
		UserDAO userDao = new UserDAO();
		List<User> userList =  userDao.getUserList();
		
		request.setAttribute("userList", userList);
		RequestDispatcher rd = request.getRequestDispatcher("/view/admin/user/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
