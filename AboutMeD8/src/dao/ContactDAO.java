package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Contact;
import util.DBConnectionUtil;
import util.DefineUtil;

public class ContactDAO {

	private Statement st;
	private ResultSet rs;
	private Connection conn;
	private PreparedStatement pst; 
	
	public List<Contact> getcontactList() {
		List<Contact> contactList = new ArrayList<Contact>();
		conn = DBConnectionUtil.getConnection();
		final String SQL = "SELECT id, name, email, website, message FROM contacts";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				Contact contact = new Contact(rs.getInt("id"), rs.getString("name"),rs.getString("email"), rs.getString("website"), rs.getString("message"));
				contactList.add(contact);
			}
		} catch (SQLException e) {
			e.printStackTrace();	
		} finally {
			DBConnectionUtil.close(conn, st, rs);
		}
		return contactList;
	}

	public int delItem(int id) {
		int result =0;
		conn = DBConnectionUtil.getConnection();
		final String SQL = "DELETE FROM contacts WHERE id = ?";
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
	
	public int addItem(Contact contact) {
		int result =0;
		conn = DBConnectionUtil.getConnection();
		final String SQL = "INSERT INTO contacts(name, email, website, message) VALUES(?, ?, ?, ?)";
		try {
			pst = conn.prepareStatement(SQL);	
			pst.setString(1, contact.getName());
			pst.setString(2, contact.getEmail());
			pst.setString(3, contact.getWebsite());
			pst.setString(4, contact.getMessage());
			result = pst.executeUpdate(); //Sá»‘ káº¿t quáº£ thÃ nh cÃ´ng truy váº¥n tráº£ vá»� kiá»ƒu 
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
		final String SQL = "SELECT COUNT(*) FROM contacts";
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

	public List<Contact> getItemsPagination(int offset) {
		List<Contact> contactList = new ArrayList<Contact>();
		conn = DBConnectionUtil.getConnection();
		final String SQL = "SELECT id, name, email, website, message FROM contacts LIMIT ?, ?";
		try {
			pst = conn.prepareStatement(SQL);	
			pst.setInt(1, offset);
			pst.setInt(2, DefineUtil.NUMBER_PER_PAGE);
			rs = pst.executeQuery();
			while (rs.next()) {
				Contact contact = new Contact(rs.getInt("id"), rs.getString("name"),rs.getString("email"), rs.getString("website"), rs.getString("message"));
				contactList.add(contact);
			}
		} catch (SQLException e) {
			e.printStackTrace();	
		} finally {
			DBConnectionUtil.close(conn, pst, rs);
		}
		return contactList;
	}

}
