package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CategoryDAO;
import dao.NewDAO;
import model.Category;
import model.New;
import util.DefineUtil;

public class AdminIndexNewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	public AdminIndexNewController() {
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NewDAO NewDAO = new NewDAO();
		CategoryDAO categoryDao = new CategoryDAO();
		int numberOfItems = NewDAO.numberOfItems();
		int numberOfPages = (int) Math.ceil((float) numberOfItems / DefineUtil.NUMBER_PER_PAGE);
		
		int currentPage = 1;
		try {
			currentPage = Integer.parseInt(request.getParameter("page"));
		} catch (NumberFormatException e) {	
		}
		
		if (currentPage > numberOfPages || currentPage < 1) {
			currentPage = 1;
		}
		int offset = (currentPage - 1) * DefineUtil.NUMBER_PER_PAGE; 
		
		//List<New> NewList = NewDAO.getNewListAdmin();
		List<New> NewList = NewDAO.getItemsPagination(offset);
		List<Category> catList = categoryDao.getcatList();
		
		HttpSession session = request.getSession();
		session.setAttribute("catList", catList);
		request.setAttribute("NewList", NewList);
		request.setAttribute("numberOfPages", numberOfPages);
		request.setAttribute("currentPage", currentPage);
		
		RequestDispatcher rd = request.getRequestDispatcher("/view/admin/new/index.jsp");
		rd.forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
