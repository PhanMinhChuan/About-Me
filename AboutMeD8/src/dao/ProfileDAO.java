package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Category;
import model.New;
import model.Profile;
import util.DBConnectionUtil;
import util.DefineUtil;

public class ProfileDAO {
	private Statement st;
	private ResultSet rs;
	private Connection conn;
	private PreparedStatement pst; 
	
	public Profile getProfile() {
		Profile profile = new Profile();
		conn = DBConnectionUtil.getConnection();
		final String SQL = "SELECT * FROM profile"; //DESC-ORDER BY ID ASC
		try {
			st = conn.createStatement();
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				profile = new Profile(rs.getString("ten"),rs.getInt("tuoi"), rs.getString("ngaySinh"), rs.getString("diaChi"),rs.getInt("SĐT"), rs.getString("picture"), rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();	
		} finally {
			DBConnectionUtil.close(conn, st, rs);
		}
		return profile;
	}
	
	public static void main(String[] args) {
		System.out.println(new ProfileDAO().getProfile().getName());
	}

	public int editProfile(Profile profile) {
		int result =0;
		conn = DBConnectionUtil.getConnection();
		final String SQL = "UPDATE profile SET ten = ?, tuoi = ?, ngaysinh = ?, diachi = ? ,picture = ?,email = ?";
		try {
			pst = conn.prepareStatement(SQL);	
			pst.setString(1, profile.getName());
			pst.setInt(2, profile.getTuoi());
			pst.setString(3, profile.getNgaySinh());
			pst.setString(4, profile.getDiaChi());
			pst.setString(5, profile.getPicture());
			pst.setString(6, profile.getEmail());
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
