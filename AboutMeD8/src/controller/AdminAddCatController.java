package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDAO;
import model.Category;

public class AdminAddCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	public AdminAddCatController() {
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		
		RequestDispatcher rd = request.getRequestDispatcher("/view/admin/category/add.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("html/text");
		request.setCharacterEncoding("UTF-8");
		
		CategoryDAO categoryDao = new CategoryDAO();
		String name = request.getParameter("name");
		int check = 0;
		check = categoryDao.checkTrung(name);
		System.out.println(check);
		if (check == 0 && name != null) {
			Category cat = new Category(0, name);
			int addCat = categoryDao.addItem(cat);
			if(addCat > 0) {
				response.sendRedirect(request.getContextPath()+"/admin/cat/index?msg=1");
				return; //chuyển hướng nên return 
			} else {
				response.sendRedirect(request.getContextPath()+"/admin/cat/index?msg=0");
				return;
			}
		} else {
			response.sendRedirect(request.getContextPath()+"/admin/cat/index?msg=0");
			return;
		}
	}	
}
