package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProjectDAO;
import model.Project;

public class AdminIndexProjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	public AdminIndexProjectController() {
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProjectDAO projectDao = new ProjectDAO();
		List<Project> projectList =  projectDao.getProjectList();
		
		request.setAttribute("projectList", projectList);
		RequestDispatcher rd = request.getRequestDispatcher("/view/admin/project/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
