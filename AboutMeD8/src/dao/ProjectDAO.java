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

public class ProjectDAO {
	private Statement st;
	private ResultSet rs;
	private Connection conn;
	private PreparedStatement pst; 
	
	public List<Project> getProjectList() {
		List<Project> projectList = new ArrayList<Project>(); 
		conn = DBConnectionUtil.getConnection();
		final String SQL = "SELECT * FROM project"; //DESC-ORDER BY ID ASC
		try {
			st = conn.createStatement();
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				Project project = new Project(rs.getInt("id"), rs.getString("name"), rs.getString("picture"));
				projectList.add(project);
			}
		} catch (SQLException e) {
			e.printStackTrace();	
		} finally {
			DBConnectionUtil.close(conn, st, rs);
		}
		return projectList;
	}
	
//	public static void main(String[] args) {
//		System.out.println(new ProjectDAO().getProjectList().size());
//	}

	public int checkTrung(int id, String name) {
		int result =0;
		conn = DBConnectionUtil.getConnection();
		final String SQL = "SELECT * FROM project WHERE name = ? or id = ?";
		try {
			pst = conn.prepareStatement(SQL);	
			pst.setString(1, name);
			pst.setInt(2, id);
			rs = pst.executeQuery();
			while (rs.next()) {
				result++;
			}
		} catch (SQLException e) {
			e.printStackTrace();	
		} finally {
			DBConnectionUtil.close(conn, pst);
		}
		return result;
	}
	
	public int addItem(Project project) {
		System.out.println(project.getName());
		int result =0;
		conn = DBConnectionUtil.getConnection();
		final String SQL = "INSERT INTO project(id, name, picture) VALUES(?, ?, ?)";
		try {
			pst = conn.prepareStatement(SQL);	
			pst.setInt(1, project.getId());
			pst.setString(2, project.getName());
			pst.setString(3, project.getPicture());
			result = pst.executeUpdate();
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
		final String SQL = "DELETE FROM project WHERE id = ?";
		try {
			pst = conn.prepareStatement(SQL);	
			pst.setInt(1, id);
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
