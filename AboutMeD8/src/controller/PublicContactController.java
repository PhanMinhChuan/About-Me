package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContactDAO;
import model.Contact;

public class PublicContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	public PublicContactController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("html/text");
		request.setCharacterEncoding("UTF-8");
		
		int id = 0;
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");
		Contact contact = new Contact(id, name, email, subject, message);
		ContactDAO contactDao = new ContactDAO();
		int result = contactDao.addItem(contact);
		
		out.print("alert.");
		
		
		if(result > 0) {
			response.sendRedirect(request.getContextPath()+"/index?msg=1#contact-section");
			return;
		} else {
			response.sendRedirect(request.getContextPath()+"/index?msg=0#contact-section");
			return;
		}
	}

}
