package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Category;
import model.Profile;
import model.Project;
import model.Skill;
import util.DBConnectionUtil;
import util.DefineUtil;

public class SkillDAO {
	private Statement st;
	private ResultSet rs;
	private Connection conn;
	private PreparedStatement pst; 
	
	public List<Skill> getSkillList() {
		List<Skill> skillList = new ArrayList<Skill>(); 
		conn = DBConnectionUtil.getConnection();
		final String SQL = "SELECT * FROM skill"; //DESC-ORDER BY ID ASC
		try {
			st = conn.createStatement();
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				Skill skill = new Skill(rs.getInt("id"), rs.getString("name"), rs.getInt("finish"));
				skillList.add(skill);
			}
		} catch (SQLException e) {
			e.printStackTrace();	
		} finally {
			DBConnectionUtil.close(conn, st, rs);
		}
		return skillList;
	}
	
	public static void main(String[] args) {
		System.out.println(new SkillDAO().getSkillList().size());
	}

	public int checkTrung(String name) {
		int result =0;
		conn = DBConnectionUtil.getConnection();
		final String SQL = "SELECT * FROM skill WHERE name = ?";
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

	public int addItem(Skill skill) {
		System.out.println(skill.getName());
		int result =0;
		conn = DBConnectionUtil.getConnection();
		final String SQL = "INSERT INTO skill(name, finish) VALUES(?, ?)";
		try {
			pst = conn.prepareStatement(SQL);	
			pst.setString(1, skill.getName());
			pst.setInt(2, skill.getFinish());
			result = pst.executeUpdate(); 
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
		final String SQL = "DELETE FROM skill WHERE id = ?";
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
}
