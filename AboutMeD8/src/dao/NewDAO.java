package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.New;
import util.DBConnectionUtil;
import util.DefineUtil;

public class NewDAO {
	private Statement st;
	private ResultSet rs;
	private Connection conn;
	private PreparedStatement pst; 
	
	public List<New> getNewList() {
		List<New> NewList = new ArrayList<New>();
		conn = DBConnectionUtil.getConnection();
		final String SQL = "SELECT id, name, preview_text, detail_text, date_create, counter,cat_id FROM news"; //DESC-ORDER BY ID ASC
		try {
			st = conn.createStatement();
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				New New = new New(rs.getInt("id"), rs.getString("name"), rs.getString("preview_text"), rs.getString("detail_text"), rs.getTimestamp("date_create"),rs.getInt("counter") , rs.getInt("cat_id"));
				NewList.add(New);
			}
		} catch (SQLException e) {
			e.printStackTrace();	
		} finally {
			DBConnectionUtil.close(conn, st, rs);
		}
		return NewList;
	}

	public List<New> getNewListNew() {
		List<New> NewList = new ArrayList<New>();
		conn = DBConnectionUtil.getConnection();
		final String SQL = "SELECT id, name, preview_text, detail_text, date_create, counter,cat_id FROM News ORDER BY date_create DESC LIMIT 5"; //DESC-ORDER BY ID ASC
		try {
			st = conn.createStatement();
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				New New = new New(rs.getInt("id"), rs.getString("name"), rs.getString("preview_text"), rs.getString("detail_text"), rs.getTimestamp("date_create"),rs.getInt("counter") , rs.getInt("cat_id"));
				NewList.add(New);
			}
		} catch (SQLException e) {
			e.printStackTrace();	
		} finally {
			DBConnectionUtil.close(conn, st, rs);
		}
		return NewList;
	}

	public New getNewbyID(int id) {
		New NewEx = new New();
		conn = DBConnectionUtil.getConnection();
		final String SQL = "SELECT news.id, news.name, news.preview_text, news.detail_text, news.date_create, news.counter, news.cat_id, news.picture, categories.name AS catName FROM news INNER JOIN categories ON news.cat_id = categories.id WHERE news.id = ?"; //DESC-ORDER BY ID ASC
		try {
			pst = conn.prepareStatement(SQL);	
			pst.setInt(1, id);
			rs = pst.executeQuery();
			//st = conn.createStatement();
			//rs = st.executeQuery(SQL);
			while (rs.next()) {
				NewEx = new New(rs.getInt("id"), rs.getString("name"), rs.getString("preview_text"), rs.getString("detail_text"), rs.getTimestamp("date_create"),rs.getInt("counter") , rs.getInt("cat_id"), rs.getString("picture"), rs.getString("catName"));
			}
		} catch (SQLException e) {
			e.printStackTrace();	
		} finally {
			DBConnectionUtil.close(conn, pst, rs);
		}
		return NewEx;
	}
	
	public List<New> getNewListbyid_cat(int id_cat) {
		List<New> NewList = new ArrayList<New>();
		conn = DBConnectionUtil.getConnection();
		final String SQL = "SELECT id, name, preview_text, detail_text, date_create,picture ,counter,cat_id FROM news WHERE cat_id = ?"; 
		try {
			pst = conn.prepareStatement(SQL);	
			pst.setInt(1, id_cat);
			rs = pst.executeQuery();
			//st = conn.createStatement();
			//rs = st.executeQuery(SQL);
			while (rs.next()) {
				New New = new New(rs.getInt("id"), rs.getString("name"), rs.getString("preview_text"), rs.getString("detail_text"), rs.getTimestamp("date_create"),rs.getInt("counter") , rs.getInt("cat_id"),rs.getString("picture"),rs.getString("picture"));
				NewList.add(New);
			}
		} catch (SQLException e) {
			e.printStackTrace();	
		} finally {
			DBConnectionUtil.close(conn, pst, rs);
		}
		return NewList;
	}
	
	public List<New> getNewListbyidCat(int id_cat, int id) {
		List<New> NewList = new ArrayList<New>();
		conn = DBConnectionUtil.getConnection();
		final String SQL = "SELECT id, name, preview_text, detail_text, date_create,picture ,counter,cat_id FROM news WHERE cat_id = ? and id != ?"; 
		try {
			pst = conn.prepareStatement(SQL);	
			pst.setInt(1, id_cat);
			pst.setInt(2, id);
			rs = pst.executeQuery();
			//st = conn.createStatement();
			//rs = st.executeQuery(SQL);
			while (rs.next()) {
				New New = new New(rs.getInt("id"), rs.getString("name"), rs.getString("preview_text"), rs.getString("detail_text"), rs.getTimestamp("date_create"),rs.getInt("counter") , rs.getInt("cat_id"),rs.getString("picture"),rs.getString("picture"));
				NewList.add(New);
			}
		} catch (SQLException e) {
			e.printStackTrace();	
		} finally {
			DBConnectionUtil.close(conn, pst, rs);
		}
		return NewList;
	}


	public List<New> getNewbyid_cat(int id_cat, int id) {
		List<New> NewList = new ArrayList<New>();
		conn = DBConnectionUtil.getConnection();
		final String SQL = "SELECT id, name, preview_text, detail_text, date_create, counter,cat_id FROM news WHERE cat_id = ? && id != ?"; 
		try {
			pst = conn.prepareStatement(SQL);	
			pst.setInt(1, id_cat);
			pst.setInt(2, id);
			rs = pst.executeQuery();
			//st = conn.createStatement();
			//rs = st.executeQuery(SQL);
			while (rs.next()) {
				New New = new New(rs.getInt("id"), rs.getString("name"), rs.getString("preview_text"), rs.getString("detail_text"), rs.getTimestamp("date_create"),rs.getInt("counter") , rs.getInt("cat_id"));
				NewList.add(New);
			}
		} catch (SQLException e) {
			e.printStackTrace();	
		} finally {
			DBConnectionUtil.close(conn, pst, rs);
		}
		return NewList;
	}

	public List<New> getNewbyIDOfCat(int id) {
		List<New> NewList = new ArrayList<New>();
		conn = DBConnectionUtil.getConnection();
		final String SQL = "SELECT id, name, preview_text, detail_text, date_create, counter,cat_id FROM news WHERE cat_id = ?"; 
		try {
			pst = conn.prepareStatement(SQL);	
			pst.setInt(1, id);
			rs = pst.executeQuery();
			//st = conn.createStatement();
			//rs = st.executeQuery(SQL);
			while (rs.next()) {
				New New = new New(rs.getInt("id"), rs.getString("name"), rs.getString("preview_text"), rs.getString("detail_text"), rs.getTimestamp("date_create"),rs.getInt("counter") , rs.getInt("cat_id"));
				NewList.add(New);
			}
		} catch (SQLException e) {
			e.printStackTrace();	
		} finally {
			DBConnectionUtil.close(conn, pst, rs);
		}
		return NewList;
	}

	public List<New> getNewListAdmin() {
		List<New> NewList = new ArrayList<New>();
		conn = DBConnectionUtil.getConnection();
		final String SQL = "SELECT news.id, news.name, news.preview_text, news.detail_text, news.date_create, news.counter, news.cat_id, news.picture, categories.name AS catName FROM news INNER JOIN categories ON news.cat_id = categories.id";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				New New = new New(rs.getInt("id"), rs.getString("name"), rs.getString("preview_text"), rs.getString("detail_text"), rs.getTimestamp("date_create"),rs.getInt("counter") , rs.getInt("cat_id"), rs.getString("picture"), rs.getString("catName"));
				NewList.add(New);
			}
		} catch (SQLException e) {
			e.printStackTrace();	
		} finally {
			DBConnectionUtil.close(conn, st, rs);
		}
		return NewList;
	}
	
//	public static void main(String[] args) {
//		System.out.println(new NewDAO().getNewListAdmin().get(4).getName());
//	}
	
	public int addItem(New New) {
		int result =0;
		conn = DBConnectionUtil.getConnection();
		final String SQL = "INSERT INTO News(name, preview_text, detail_text, picture, cat_id) VALUES(?, ?, ?, ?, ?)";
		try {
			pst = conn.prepareStatement(SQL);	
			pst.setString(1, New.getName());
			pst.setString(2, New.getPreview_text());
			pst.setString(3, New.getDetail_text());
			pst.setString(4, New.getPicture());
			pst.setInt(5, New.getCat_id());
			result = pst.executeUpdate(); //Số kết quả thành công truy vấn trả v�? kiểu 
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
		final String SQL = "DELETE FROM news WHERE id = ?";
		try {
			pst = conn.prepareStatement(SQL);	
			pst.setInt(1, id);
			result = pst.executeUpdate(); //Số kết quả thành công truy vấn trả v�? kiểu 
			System.out.println("Query success :" + result);
		} catch (SQLException e) {
			e.printStackTrace();	
		} finally {
			DBConnectionUtil.close(conn, pst);
		}
		return result;
	}
	
	public int editItem(New New) {
		int result =0;
		conn = DBConnectionUtil.getConnection();
		final String SQL = "UPDATE news SET name = ?, preview_text = ?, detail_text = ?, picture = ? ,cat_id = ? WHERE id = ?";
		try {
			pst = conn.prepareStatement(SQL);	
			pst.setString(1, New.getName());
			pst.setString(2, New.getPreview_text());
			pst.setString(3, New.getDetail_text());
			pst.setString(4, New.getPicture());
			pst.setInt(5, New.getCat_id());
			pst.setInt(6, New.getId());
			result = pst.executeUpdate();
			System.out.println("Query success :" + result);
		} catch (SQLException e) {
			e.printStackTrace();	
		} finally {
			DBConnectionUtil.close(conn, pst);
		}
		return result;
	}

	public New getNewbyIDAdmin(int id) {
		conn = DBConnectionUtil.getConnection();
		New New = null;
		final String SQL = "SELECT news.id, news.name, news.preview_text, news.detail_text, news.date_create, news.counter, news.cat_id, news.picture, categories.name AS catName FROM news INNER JOIN categories ON news.cat_id = categories.id WHERE news.id = ?";
		try {
			pst = conn.prepareStatement(SQL);	
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while (rs.next()) {
				New = new New(rs.getInt("id"), rs.getString("name"), rs.getString("preview_text"), rs.getString("detail_text"), rs.getTimestamp("date_create"),rs.getInt("counter") , rs.getInt("cat_id"), rs.getString("picture"), rs.getString("catName"));
			}
		} catch (SQLException e) {
			e.printStackTrace();	
		} finally {
			DBConnectionUtil.close(conn, st, rs);
		}
		return New;
	}

	public int delItemByCatId(int id) {
		int result =0;
		conn = DBConnectionUtil.getConnection();
		final String SQL = "DELETE FROM News WHERE cat_id = ?";
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

	public int delPicture(int id) {
			int result =0;
			conn = DBConnectionUtil.getConnection();
			final String SQL = "DELETE FROM news WHERE id = ?";
			try {
				pst = conn.prepareStatement(SQL);	
				pst.setInt(1, id);
				rs = pst.executeQuery();
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
		final String SQL = "SELECT * FROM news WHERE name = ?";
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
		final String SQL = "SELECT COUNT(*) FROM news INNER JOIN categories ON news.cat_id = categories.id ";
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
	
	public int numberOfItemsTop() {
		int result =0;
		conn = DBConnectionUtil.getConnection();
		final String SQL = "SELECT COUNT(*) FROM NewsTop";
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

	public List<New> getItemsPagination(int offset) {
		List<New> NewList = new ArrayList<New>();
		conn = DBConnectionUtil.getConnection();
		final String SQL = "SELECT news.id, news.name, news.preview_text, news.detail_text, news.date_create, news.counter, news.cat_id, news.picture, categories.name AS catName FROM news INNER JOIN categories ON news.cat_id = categories.id LIMIT ?, ?";
		try {
			pst = conn.prepareStatement(SQL);	
			pst.setInt(1, offset);
			pst.setInt(2, DefineUtil.NUMBER_PER_PAGE);
			rs = pst.executeQuery();
			while (rs.next()) {
				New New = new New(rs.getInt("id"), rs.getString("name"), rs.getString("preview_text"), rs.getString("detail_text"), rs.getTimestamp("date_create"),rs.getInt("counter") , rs.getInt("cat_id"), rs.getString("picture"), rs.getString("catName"));
				NewList.add(New);
			}
		} catch (SQLException e) {
			e.printStackTrace();	
		} finally {
			DBConnectionUtil.close(conn, pst, rs);
		}
		return NewList;
	}
//	public static void main(String[] args) {
//		System.out.println(new NewDAO().getItemsPagination(4));
//	}
	public List<New> getItemsPaginationTop(int offset) {
		List<New> NewTopList = new ArrayList<New>();
		conn = DBConnectionUtil.getConnection();
		final String SQL = "SELECT News.id, News.name, News.preview_text, News.detail_text, News.date_create, News.counter, News.cat_id, News.picture, categories.name AS catName  FROM News INNER JOIN categories  ON News.cat_id = categories.id ORDER BY News.counter DESC LIMIT ?";
		try {
			pst = conn.prepareStatement(SQL);	
			pst.setInt(1, offset);
			rs = pst.executeQuery();
			while (rs.next()) {
				New New = new New(rs.getInt("id"), rs.getString("name"), rs.getString("preview_text"), rs.getString("detail_text"), rs.getTimestamp("date_create"),rs.getInt("counter") , rs.getInt("cat_id"), rs.getString("picture"), rs.getString("catName"));
				NewTopList.add(New);
			}
		} catch (SQLException e) {
			e.printStackTrace();	
		} finally {
			DBConnectionUtil.close(conn, st, rs);
		}
		return NewTopList;
	}

	public List<New> getItemsPaginationPublic(int offset) {
		List<New> NewList = new ArrayList<New>();
		conn = DBConnectionUtil.getConnection();
		final String SQL = "SELECT News.id, News.name, News.preview_text, News.detail_text, News.date_create, News.counter, News.cat_id, News.picture, categories.name AS catName  FROM News INNER JOIN categories  ON News.cat_id = categories.id LIMIT ?,?	";
		try {
			pst = conn.prepareStatement(SQL);	
			pst.setInt(1, offset);
			pst.setInt(2, DefineUtil.NUMBER_PER_PAGE);
			rs = pst.executeQuery();
			while (rs.next()) {
				New New = new New(rs.getInt("id"), rs.getString("name"), rs.getString("preview_text"), rs.getString("detail_text"), rs.getTimestamp("date_create"),rs.getInt("counter") , rs.getInt("cat_id"), rs.getString("picture"), rs.getString("catName"));
				NewList.add(New);
			}
		} catch (SQLException e) {
			e.printStackTrace();	
		} finally {
			DBConnectionUtil.close(conn, pst, rs);
		}
		return NewList;
	}

	public List<New> SearchNew(String editbox_search) {
		System.out.println(editbox_search);
		List<New> NewList = new ArrayList<New>();
		conn = DBConnectionUtil.getConnection();
		final String SQL = "SELECT News.id, News.name, News.preview_text, News.detail_text, News.date_create, News.counter, News.cat_id, News.picture, categories.name AS catName FROM News INNER JOIN categories ON News.cat_id = categories.id WHERE News.name LIKE ? "; //DESC-ORDER BY ID ASC
		String search = "N%" + editbox_search + "%";
		//System.out.println(search);
		try {
			pst = conn.prepareStatement(SQL);	
			pst.setString(1, search);
			rs = pst.executeQuery();
			while (rs.next()) {
				New New = new New(rs.getInt("id"), rs.getString("name"), rs.getString("preview_text"), rs.getString("detail_text"), rs.getTimestamp("date_create"),rs.getInt("counter") , rs.getInt("cat_id"), rs.getString("picture"), rs.getString("catName"));
				NewList.add(New);
			}
		} catch (SQLException e) {
			e.printStackTrace();	
		} finally {
			DBConnectionUtil.close(conn, pst, rs);
		}
		return NewList;
	}
	
	//public static void main(String[] args) {
		//System.out.println(new NewDAO().SearchNew("Nơi").get(0).getName());
	//}

	public List<New> TopNew() {
		List<New> NewList = new ArrayList<New>();
		conn = DBConnectionUtil.getConnection();
		final String SQL = "SELECT id, name, preview_text, detail_text, date_create, counter,cat_id FROM NewsTop ORDER BY"; //DESC-ORDER BY ID ASC
		try {
			st = conn.createStatement();
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				New New = new New(rs.getInt("id"), rs.getString("name"), rs.getString("preview_text"), rs.getString("detail_text"), rs.getTimestamp("date_create"),rs.getInt("counter") , rs.getInt("cat_id"));
				NewList.add(New);
			}
		} catch (SQLException e) {
			e.printStackTrace();	
		} finally {
			DBConnectionUtil.close(conn, st, rs);
		}
		return NewList;
	}

	public int getNewCount() {
		int result =0;
		conn = DBConnectionUtil.getConnection();
		final String SQL = "SELECT count FROM NewTop";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				result = rs.getInt("count");
			}
			System.out.println("Count: " + result);
		} catch (SQLException e) {
			e.printStackTrace();	
		} finally {
			DBConnectionUtil.close(conn, st, rs);
		}
		return result;
	}
	
	public void settingCount(int count) {
		int check = 0;
		conn = DBConnectionUtil.getConnection();
		final String SQL = "UPDATE Newtop SET count = ?";
		try {
			pst = conn.prepareStatement(SQL);	
			pst.setInt(1, count);
			pst.executeUpdate();
			System.out.println("SUCCESS!!!!");
		} catch (SQLException e) {
			e.printStackTrace();	
		} finally {
			DBConnectionUtil.close(conn, pst, rs);
		}
	}

	public int getCountConnect() {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		final String SQL = "SELECT News.id, News.name, News.preview_text, News.detail_text, News.date_create, News.counter, News.cat_id, News.picture, categories.name AS catName  FROM News INNER JOIN categories  ON News.cat_id = categories.id";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				result++;
			}
		} catch (SQLException e) {
			e.printStackTrace();	
		} finally {
			DBConnectionUtil.close(conn, st, rs);
		}
		return result;
	}

	public int soSanhNew(New NewOld, New NewNew) {
		int count =0;
		if(NewOld.getName().equals(NewNew.getName())) {
			++count;
		}
		if(NewOld.getCatName().equals(NewNew.getCatName())) {
			++count;
		}
		if(NewOld.getPicture().equals(NewNew.getPicture())) {
			++count;
		}
		if(NewOld.getDetail_text().equals(NewNew.getDetail_text())) {
			++count;
		}
		if(NewOld.getPreview_text().equals(NewNew.getPreview_text())) {
			++count;
		}
		return count;
	}

	public List<New> getNewListSearch(int Cat_id, String stringSearch, int offset) {
		List<New> NewListSearch = new ArrayList<New>();
		New NewEx = new New();
		conn = DBConnectionUtil.getConnection();
		final String SQL = "SELECT News.id, News.name, News.preview_text, News.detail_text, News.date_create, News.counter, News.cat_id, News.picture, categories.name AS catName FROM News INNER JOIN categories ON News.cat_id = categories.id WHERE News.name LIKE ? AND categories.id = ? LIMIT ?, ?"; //DESC-ORDER BY ID ASC
		String search = "N%" + stringSearch + "%";
		try {
			pst = conn.prepareStatement(SQL);	
			pst.setString(1, search);
			pst.setInt(2, Cat_id);
			pst.setInt(3, offset);
			pst.setInt(4, DefineUtil.NUMBER_PER_PAGE);
			rs = pst.executeQuery();
			while (rs.next()) {
				NewEx = new New(rs.getInt("id"), rs.getString("name"), rs.getString("preview_text"), rs.getString("detail_text"), rs.getTimestamp("date_create"),rs.getInt("counter") , rs.getInt("cat_id"), rs.getString("picture"), rs.getString("catName"));
				NewListSearch.add(NewEx);
			}
		} catch (SQLException e) {
			e.printStackTrace();	
		} finally {
			DBConnectionUtil.close(conn, pst, rs);
		}
		return NewListSearch;
	}

	public List<New> getNewListSearch(int Cat_id, String stringSearch) {
		List<New> NewListSearch = new ArrayList<New>();
		New NewEx = new New();
		conn = DBConnectionUtil.getConnection();
		final String SQL = "SELECT News.id, News.name, News.preview_text, News.detail_text, News.date_create, News.counter, News.cat_id, News.picture, categories.name AS catName FROM News INNER JOIN categories ON News.cat_id = categories.id WHERE News.name LIKE ? AND categories.id = ?"; //DESC-ORDER BY ID ASC
		String search = "N%" + stringSearch + "%";
		try {
			pst = conn.prepareStatement(SQL);	
			pst.setString(1, search);
			pst.setInt(2, Cat_id);
			rs = pst.executeQuery();
			while (rs.next()) {
				NewEx = new New(rs.getInt("id"), rs.getString("name"), rs.getString("preview_text"), rs.getString("detail_text"), rs.getTimestamp("date_create"),rs.getInt("counter") , rs.getInt("cat_id"), rs.getString("picture"), rs.getString("catName"));
				NewListSearch.add(NewEx);
			}
		} catch (SQLException e) {
			e.printStackTrace();	
		} finally {
			DBConnectionUtil.close(conn, pst, rs);
		}
		return NewListSearch;
	}

	public List<New> getListByID(int id) {
		List<New> NewList = new ArrayList<New>();
		conn = DBConnectionUtil.getConnection();
		final String SQL = "SELECT news.id, news.name, news.preview_text, news.detail_text, news.date_create, news.counter, news.cat_id, news.picture, categories.name AS catName FROM news INNER JOIN categories ON news.cat_id = categories.id WHERE news.id = ?";
		try {
			pst = conn.prepareStatement(SQL);	
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while (rs.next()) {
				New New = new New(rs.getInt("id"), rs.getString("name"), rs.getString("preview_text"), rs.getString("detail_text"), rs.getTimestamp("date_create"),rs.getInt("counter") , rs.getInt("cat_id"), rs.getString("picture"), rs.getString("catName"));
				NewList.add(New);
			}
		} catch (SQLException e) {
			e.printStackTrace();	
		} finally {
			DBConnectionUtil.close(conn, st, rs);
		}
		return NewList;
	}	
	public List<New> getNewbySearchName(String searchname) {
		List<New> NewList = new ArrayList<New>();
		conn = DBConnectionUtil.getConnection();
		final String SQL = "SELECT id, name, preview_text, detail_text, date_create,picture ,counter,cat_id FROM news WHERE name LIKE ?"; 
		try {
			pst = conn.prepareStatement(SQL);	
			pst.setString(1, "%"+searchname+"%");
			rs = pst.executeQuery();
			//st = conn.createStatement();
			//rs = st.executeQuery(SQL);
			while (rs.next()) {
				New New = new New(rs.getInt("id"), rs.getString("name"), rs.getString("preview_text"), rs.getString("detail_text"), rs.getTimestamp("date_create"),rs.getInt("counter") , rs.getInt("cat_id"),rs.getString("picture"),rs.getString("picture"));
				NewList.add(New);
			}
		} catch (SQLException e) {
			e.printStackTrace();	
		} finally {
			DBConnectionUtil.close(conn, pst, rs);
		}
		return NewList;
	}
	public static void main(String[] args) {
		System.out.println(new NewDAO().getNewbySearchName("clean").size());
	}
}






