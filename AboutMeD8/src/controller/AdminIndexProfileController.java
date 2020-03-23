package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProfileDAO;
import model.Profile;

public class AdminIndexProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	public AdminIndexProfileController() {
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProfileDAO profileDao = new ProfileDAO();
		Profile profile = new Profile();
		profile = profileDao.getProfile();
		
		request.setAttribute("profile", profile);
		RequestDispatcher rd = request.getRequestDispatcher("/view/admin/profile/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
