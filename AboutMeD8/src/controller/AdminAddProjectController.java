package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import constant.CommomConstant;
import dao.CategoryDAO;
import dao.ProjectDAO;
import dao.SkillDAO;
import model.Category;
import model.Project;
import model.Skill;
import util.FileUtil;

@MultipartConfig
public class AdminAddProjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	public AdminAddProjectController() {
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		
		RequestDispatcher rd = request.getRequestDispatcher("/view/admin/project/add.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("html/text");
		request.setCharacterEncoding("UTF-8");
		
		ProjectDAO projectDao = new ProjectDAO();
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		Part filePart = request.getPart("picture");
		System.out.println(filePart.getSubmittedFileName());
		String fileName = FileUtil.rename(filePart.getSubmittedFileName());
		if (!"".equals(fileName)) {
			String webPath = request.getServletContext().getRealPath("");
			String dirPath = webPath + CommomConstant.DIR_UPLOAD;
			File createDir = new File(dirPath);
			if (!createDir.exists()) {
				createDir.mkdir();
			}
			String filePath = dirPath + File.separator +fileName;
			System.out.println(filePath);
			filePart.write(filePath);
		int check = 0;
		check = projectDao.checkTrung(id, name);
		System.out.println(check);
		if (check == 0) {
			Project project = new Project(id, name, fileName);
			int addCat = projectDao.addItem(project);
			if(addCat > 0) {
				response.sendRedirect(request.getContextPath()+"/admin/project/index?msg=1");
				return;
			} else {
				response.sendRedirect(request.getContextPath()+"/admin/project/index?msg=0");
				return;
			}
		} else {
			response.sendRedirect(request.getContextPath()+"/admin/project/index?msg=0");
			return;
		}
	}	
}
}
