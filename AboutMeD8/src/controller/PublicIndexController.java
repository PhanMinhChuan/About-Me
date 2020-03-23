package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NewDAO;
import dao.ProfileDAO;
import dao.ProjectDAO;
import dao.SkillDAO;
import model.New;
import model.Profile;
import model.Project;
import model.Skill;

public class PublicIndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PublicIndexController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SkillDAO skillDao = new SkillDAO();
		ProjectDAO projectDao = new ProjectDAO();
		NewDAO newDao = new NewDAO();
		ProfileDAO profileDao = new ProfileDAO();
		
		List<New> newList = newDao.getNewListAdmin();
		List<Project> projectList = projectDao.getProjectList();
		Profile profile = profileDao.getProfile();
		List<Skill> skillList = skillDao.getSkillList();
		
		request.setAttribute("newList", newList);
		request.setAttribute("skillList", skillList);
		request.setAttribute("projectList", projectList);
		request.setAttribute("profile", profile);
		
		
		
		//response.sendRedirect("?/trang-chu.html");
		RequestDispatcher rd = request.getRequestDispatcher("/view/public/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
