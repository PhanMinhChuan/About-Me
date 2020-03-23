package controller;

import java.io.IOException;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.jdt.internal.compiler.util.Sorting;

import dao.CategoryDAO;
import dao.CommentDAO;
import dao.NewDAO;
import dao.ProfileDAO;
import model.Category;
import model.Comment;
import model.New;
import model.Profile;
import java.util.Collections;

public class PublicBlogController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PublicBlogController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("html/text");
		request.setCharacterEncoding("UTF-8");
		
		int id = 0;
		int idCat = 0;
		int showCat = 0;
		NewDAO newDao = new NewDAO();
		try {
			id = Integer.parseInt(request.getParameter("id"));
			idCat = Integer.parseInt(request.getParameter("idCat"));
			showCat = Integer.parseInt(request.getParameter("showCat"));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		String msg = request.getParameter("msg");
		String editbox_search = request.getParameter("editbox_search");
		if (editbox_search != null) {
			List<New> newSearchList= newDao.getNewbySearchName(editbox_search);
			
			request.setAttribute("newSearchList", newSearchList);
			
			RequestDispatcher rd = request.getRequestDispatcher("/view/public/single.jsp");
			rd.forward(request, response);
			
		} else if (msg != null) {
			List<New> newListCat = newDao.getNewListbyid_cat(Integer.parseInt(msg));
			
			request.setAttribute("newListCat", newListCat);
			HttpSession session = request.getSession();
			CategoryDAO catDao  = new CategoryDAO();
			List<Category> catList = catDao.getcatList();
			session.setAttribute("catList", catList);
			
			RequestDispatcher rd = request.getRequestDispatcher("/view/public/single.jsp");
			rd.forward(request, response);
		} else {
			New news = newDao.getNewbyID(id);
			
			request.setAttribute("new", news);
			CommentDAO commentDao = new CommentDAO();
			List<Comment> commentList = commentDao.getcommentListByID(id);
			Collections.reverse(commentList);
			ProfileDAO profileDao = new ProfileDAO();
			Profile profile = profileDao.getProfile();
			request.setAttribute("profile", profile);
			HttpSession session = request.getSession();
			CategoryDAO catDao  = new CategoryDAO();
			List<Category> catList = catDao.getcatList();
			
			session.setAttribute("commentList", commentList);
			request.setAttribute("id", id);
			session.setAttribute("catList", catList);
			
			List<New> newList = newDao.getNewListbyidCat(idCat, id);
			
			request.setAttribute("newList", newList);
//			String searchname = request.getParameter("searchname");
//			List<New> newSearchList= newDao.getNewbySearchName(searchname);
			
//			request.setAttribute("newSearchList", newSearchList);
			RequestDispatcher rd = request.getRequestDispatcher("/view/public/single.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("html/text");
		request.setCharacterEncoding("UTF-8");
		int id_new = 0;
		
	    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	    LocalDateTime now = LocalDateTime.now();  
		PrintWriter out = response.getWriter();
		try {
			id_new = Integer.parseInt(request.getParameter("idNew"));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
			String username = request.getParameter("username");
			String email = request.getParameter("email");
			String message = request.getParameter("message");
			
			if ("".equals(username) == false) {
			Comment comment = new Comment(0, username, "", message, dtf.format(now), id_new);
			CommentDAO commentDao = new CommentDAO();
			int result = commentDao.addItem(comment);
			
			List<Comment> commentList = commentDao.getcommentListByID(id_new);
			request.setAttribute("commentList", commentList);
			
			String s="\"vcard bio\">";
				out.print("<li class=\"comment\">");
				out.print("<div class ="+ s);
				out.print("<img src=\" " + request.getContextPath() + "/templates/public/images/person_1.jpg\"" + "alt=\"Image placeholder\">");
				out.print("</div>");
				out.print("<div class=\"comment-body\">");
				out.print("<h3>"+ username +"</h3>");
				out.print("<div class=\"meta\"></div>");
				out.print("<p>" + message + "</p>");
				out.print("<p><a href='#' class=\"reply\">Reply</a></p>");
				out.print("</div>");
				out.print("</li>");
			}
	}

}
