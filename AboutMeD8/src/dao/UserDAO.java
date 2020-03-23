package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.User;
import util.DBConnectionUtil;

public class UserDAO {
	private Statement st;
	private ResultSet rs;
	private Connection conn;
	private PreparedStatement pst; 
	
	public List<User> getUserList() {
		List<User> userList = new ArrayList<User>();
		conn = DBConnectionUtil.getConnection();
		final String SQL = "SELECT id, username, password, fullname FROM users"; //DESC-ORDER BY ID ASC
		try {
			st = conn.createStatement();
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				User user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("fullname"));
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();	
		} finally {
			DBConnectionUtil.close(conn, st, rs);
		}
		return userList;
	}
	public static void main(String[] args) {
		System.out.println(new UserDAO().getUserList().size());
	}
	public User checkLogin(String username, String password) {
		conn = DBConnectionUtil.getConnection();
		User user = null;
		final String SQL = "SELECT * FROM users WHERE username = ? AND password = ? ";
		try {
			pst = conn.prepareStatement(SQL);	
			pst.setString(1, username);
			pst.setString(2, password);
			rs = pst.executeQuery();
			while (rs.next()) {
				user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password") , rs.getString("fullname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();	
		} finally {
			DBConnectionUtil.close(conn, pst);
		}
		return user;
	}
	public int checkTrung(String username) {
		int result =0;
		conn = DBConnectionUtil.getConnection();
		final String SQL = "SELECT * FROM users WHERE username = ?";
		try {
			pst = conn.prepareStatement(SQL);	
			pst.setString(1, username);
			rs = pst.executeQuery();
			while (rs.next()) {
				result++;
			}
			System.out.println("Query success :" + result);
		} catch (SQLException e) {
			e.printStackTrace();	
		} finally {
			DBConnectionUtil.close(conn, pst);
		}
		return result;
	}
	public int addItem(User user) {
		int result =0;
		conn = DBConnectionUtil.getConnection();
		final String SQL = "INSERT INTO users(username, password, fullname) VALUES(?, ? , ?)";
		try {
			pst = conn.prepareStatement(SQL);	
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getFullname());
			result = pst.executeUpdate(); //Số kết quả thành công truy vấn trả về kiểu 
			System.out.println("Query success :" + result);
		} catch (SQLException e) {
			e.printStackTrace();	
		} finally {
			DBConnectionUtil.close(conn, pst);
		}
		return result;
	}
	public int delItem(int id) {
		int result =0;
		conn = DBConnectionUtil.getConnection();
		final String SQL = "DELETE FROM users WHERE id = ?";
		try {
			pst = conn.prepareStatement(SQL);	
			pst.setInt(1, id);
			result = pst.executeUpdate(); //Số kết quả thành công truy vấn trả về kiểu 
			System.out.println("Query success :" + result);
		} catch (SQLException e) {
			e.printStackTrace();	
		} finally {
			DBConnectionUtil.close(conn, pst);
		}
		return result;
	}
	public User getItemById(int id) {
		User cat = null;
		conn = DBConnectionUtil.getConnection();
		final String SQL = "SELECT id, username, password, fullname FROM users WHERE id = ?"; //DESC-ORDER BY ID ASC
		try {
			pst = conn.prepareStatement(SQL);	
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while (rs.next()) {
				cat = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password") , rs.getString("fullname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();	
		} finally {
			DBConnectionUtil.close(conn, pst, rs);
		}
		return cat;
	}
	public int editItem(User user) {
		int result =0;
		conn = DBConnectionUtil.getConnection();
		final String SQL = "UPDATE users SET username = ?, password = ?, fullname = ?  WHERE id = ?";
		try {
			pst = conn.prepareStatement(SQL);	
			pst.setString(1,user.getUsername());
			pst.setString(2,user.getPassword());
			pst.setString(3,user.getFullname());
			pst.setInt(4,user.getId());
			result = pst.executeUpdate(); //Số kết quả thành công truy vấn trả về kiểu 
			System.out.println("Query success :" + result);
		} catch (SQLException e) {
			e.printStackTrace();	
		} finally {
			DBConnectionUtil.close(conn, pst);
		}
		return result;
	}
	
}
