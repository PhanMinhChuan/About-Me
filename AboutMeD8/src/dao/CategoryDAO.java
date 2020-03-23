package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Category;
import util.DBConnectionUtil;
import util.DefineUtil;

public class CategoryDAO {
	private Statement st;
	private ResultSet rs;
	private Connection conn;
	private PreparedStatement pst; 
	
	public List<Category> getcatList() {
		List<Category> catList = new ArrayList<Category>();
		conn = DBConnectionUtil.getConnection();
		final String SQL = "SELECT id, name FROM categories"; //DESC-ORDER BY ID ASC
		try {
			st = conn.createStatement();
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				Category cat = new Category(rs.getInt("id"), rs.getString("name"));
				catList.add(cat);
			}
		} catch (SQLException e) {
			e.printStackTrace();	
		} finally {
			DBConnectionUtil.close(conn, st, rs);
		}
		return catList;
	}
	

	public int addItem(Category cat) {
		System.out.println(cat.getName());
		int result =0;
		conn = DBConnectionUtil.getConnection();
		final String SQL = "INSERT INTO categories(name) VALUES(?)";
		try {
			pst = conn.prepareStatement(SQL);	
			pst.setString(1, cat.getName());
			result = pst.executeUpdate(); //Sá»‘ káº¿t quáº£ thÃ nh cÃ´ng truy váº¥n tráº£ vá»� kiá»ƒu 
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
		final String SQL = "DELETE FROM categories WHERE id = ?";
		try {
			pst = conn.prepareStatement(SQL);	
			pst.setInt(1, id);
			result = pst.executeUpdate(); //Sá»‘ káº¿t quáº£ thÃ nh cÃ´ng truy váº¥n tráº£ vá»� kiá»ƒu 
			System.out.println("Query success :" + result);
		} catch (SQLException e) {
			e.printStackTrace();	
		} finally {
			DBConnectionUtil.close(conn, pst);
		}
		return result;
	}

	public Category getItemById(int id) {
		Category cat = null;
		conn = DBConnectionUtil.getConnection();
		final String SQL = "SELECT id, name FROM categories WHERE id = ?"; //DESC-ORDER BY ID ASC
		try {
			pst = conn.prepareStatement(SQL);	
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while (rs.next()) {
				cat = new Category(rs.getInt("id"), rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();	
		} finally {
			DBConnectionUtil.close(conn, pst, rs);
		}
		return cat;
	}

	public int editItem(Category cat) {
		int result =0;
		conn = DBConnectionUtil.getConnection();
		final String SQL = "UPDATE categories SET name = ? WHERE id = ?";
		try {
			pst = conn.prepareStatement(SQL);	
			pst.setString(1, cat.getName());
			pst.setInt(2, cat.getId());
			result = pst.executeUpdate(); //Sá»‘ káº¿t quáº£ thÃ nh cÃ´ng truy váº¥n tráº£ vá»� kiá»ƒu 
			System.out.println("Query success :" + result);
		} catch (SQLException e) {
			e.printStackTrace();	
		} finally {
			DBConnectionUtil.close(conn, pst);
		}
		return result;
	}

	public int checkTrung(String name) {
		int result =0;
		conn = DBConnectionUtil.getConnection();
		final String SQL = "SELECT * FROM categories WHERE name = ?";
		try {
			pst = conn.prepareStatement(SQL);	
			pst.setString(1, name);
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

	public int numberOfItems() {
		int result =0;
		conn = DBConnectionUtil.getConnection();
		final String SQL = "SELECT COUNT(*) FROM categories";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				result = rs.getInt("COUNT(*)");
			}
			System.out.println("Query success :" + result);
		} catch (SQLException e) {
			e.printStackTrace();	
		} finally {
			DBConnectionUtil.close(conn, st, rs);
		}
		return result;
	}

	public List<Category> getItemsPagination(int offset) {
		Category cat = null;
		List<Category> catList = new ArrayList<Category>();
		conn = DBConnectionUtil.getConnection();
		final String SQL = "SELECT * FROM categories LIMIT ?, ?";
		try {
			pst = conn.prepareStatement(SQL);	
			pst.setInt(1, offset);
			pst.setInt(2, DefineUtil.NUMBER_PER_PAGE);
			rs = pst.executeQuery();
			while (rs.next()) {
					cat = new Category(rs.getInt("id"), rs.getString("name"));
					catList.add(cat);
			}
		} catch (SQLException e) {
			e.printStackTrace();	
		} finally {
			DBConnectionUtil.close(conn, pst, rs);
		}
		return catList;
	}
}
