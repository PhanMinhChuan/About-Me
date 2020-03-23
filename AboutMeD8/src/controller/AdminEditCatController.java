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
import model.Category;

public class AdminEditCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	public AdminEditCatController() {
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
		CategoryDAO categoryDao = new CategoryDAO();
		Category cat = categoryDao.getItemById(id);
		request.setAttribute("cat", cat);
		
		RequestDispatcher rd = request.getRequestDispatcher("/view/admin/category/edit.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("html/text");
		request.setCharacterEncoding("UTF-8");
		
		CategoryDAO categoryDAO = new CategoryDAO();
		String name = request.getParameter("name");
		int id = Integer.parseInt(request.getParameter("id"));
		int check = 0;
		check = categoryDAO.checkTrung(name);
		if (check == 0) {
			Category cat = new Category(id, name);
			int addCat = categoryDAO.editItem(cat);
			if(addCat > 0) {
				response.sendRedirect(request.getContextPath()+"/admin/cat/index?msg=2");
				return; //chuyển hướng nên return 
			} else {
				response.sendRedirect(request.getContextPath()+"/admin/cat/index?msg=0&id="+id);
				return;
			}
		} else {
			response.sendRedirect(request.getContextPath()+"/admin/cat/index?msg=0&id="+id);
			return;
		}
	}
}
