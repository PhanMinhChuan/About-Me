package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Category;
import model.Comment;
import model.Contact;
import util.DBConnectionUtil;
import util.DefineUtil;
import java.util.Collections;

public class CommentDAO {

	private Statement st;
	private ResultSet rs;
	private Connection conn;
	private PreparedStatement pst; 
	
	public List<Comment> getcontactList() {
		List<Comment> commentList = new ArrayList<Comment>();
		conn = DBConnectionUtil.getConnection();
		final String SQL = "SELECT  * FROM comment";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				Comment comment = new Comment( rs.getInt("id"),rs.getString("username"),rs.getString("email"), rs.getString("messenger"),rs.getString("date_create"), rs.getInt("id_new"));
				commentList.add(comment);
			}
		} catch (SQLException e) {
			e.printStackTrace();	
		} finally {
			DBConnectionUtil.close(conn, st, rs);
		}
		return commentList;
	}
	public static void main(String[] args) {
		System.out.println(new CommentDAO().getcontactList().size());
	}
	public List<Comment> getcommentListByID(int id) {
		List<Comment> commentList = new ArrayList<Comment>();
		conn = DBConnectionUtil.getConnection();
		final String SQL = "SELECT  * FROM comment WHERE id_new = ? ";
		try {
			pst = conn.prepareStatement(SQL);	
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while (rs.next()) {
				Comment comment = new Comment( rs.getInt("id"),rs.getString("username"),rs.getString("email"), rs.getString("messenger"),rs.getString("date_create"), rs.getInt("id_new"));
				commentList.add(comment);
			}
		} catch (SQLException e) {
			e.printStackTrace();	
		} finally {
			DBConnectionUtil.close(conn, st, rs);
		}
		return commentList;
	}
	public int addItem(Comment comment) {
		int result =0;
		conn = DBConnectionUtil.getConnection();
		final String SQL = "INSERT INTO comment(username, email, messenger, date_create, id_new) VALUES(?, ?, ?, ?, ?)";
		try {
			pst = conn.prepareStatement(SQL);	
			pst.setString(1, comment.getName());
			pst.setString(2, comment.getEmail());
			pst.setString(3, comment.getMessage());
			pst.setString(4, comment.getDateCreate());
			pst.setInt(5, comment.getId_cat());
			result = pst.executeUpdate();
			System.out.println("Query success :" + result);
		} catch (SQLException e) {
			e.printStackTrace();	
		} finally {
			DBConnectionUtil.close(conn, pst);
		}
		return result;
	}

}
