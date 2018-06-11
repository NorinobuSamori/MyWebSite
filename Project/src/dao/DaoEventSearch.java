package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.BeansEventDetailInfo;
import templates.DBManager;



//モデルはItemDAO.java

public class DaoEventSearch {



	public static DaoEventSearch getInstance() {
		return new DaoEventSearch();
	}




	public ArrayList<BeansEventDetailInfo> SelectAllEventsByRandom(int outputLimitNumber) {
        Connection conn = null;
        PreparedStatement pStmt = null;
        ArrayList<BeansEventDetailInfo> beansEventDetailInfoList = new ArrayList<BeansEventDetailInfo>();

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT * FROM event_detail ORDER BY RAND() LIMIT ?";
            pStmt = conn.prepareStatement(sql);
            pStmt.setInt(1, outputLimitNumber);
            ResultSet rs = pStmt.executeQuery();

            while (rs.next()) {
            	int id2 = rs.getInt("id");
                String title = rs.getString("title");
                String img_name = rs.getString("img_name");
                String summary = rs.getString("summary");
                String event_category = rs.getString("event_category");
                String schedule = rs.getString("schedule");
                String local_region = rs.getString("local_region");
                int fees = rs.getInt("fees");
                String access = rs.getString("access");
                String qualification = rs.getString("qualification");
                String presenter = rs.getString("presenter");
                String organizer = rs.getString("organizer");

                BeansEventDetailInfo beansEventDetailInfo = new BeansEventDetailInfo
                		(id2, title, img_name, summary, event_category,
                	    		schedule, local_region, fees, access, qualification, presenter,
                	    		organizer);
                beansEventDetailInfoList.add(beansEventDetailInfo);
            }


//return new beansEventDetailInfo(id, login_id, name, birth_date, password, create_date, update_date);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQLException on ArrayList<BeansEventDetailInfo> SelectAllEventsByRandom(int outputLimitNumber)");
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return beansEventDetailInfoList;
    }

	/**
	 * 商品IDによる商品検索
	 * @param event_id
	 * @return BeansEventDetailInfo
	 * @throws SQLException
	 */
	public static BeansEventDetailInfo getItemByItemID(int event_id) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();

			st = con.prepareStatement("SELECT * FROM event_detail WHERE id = ?");
			st.setInt(1, event_id);

			ResultSet rs = st.executeQuery();

			BeansEventDetailInfo item = new BeansEventDetailInfo();
			if (rs.next()) {
				BeansEventDetailInfo beansEventDetailInfo = new BeansEventDetailInfo();
				beansEventDetailInfo.setId(rs.getInt("id"));
				beansEventDetailInfo.setTitle(rs.getString("title"));
				beansEventDetailInfo.setImg_name(rs.getString("img_name"));
				beansEventDetailInfo.setSummary(rs.getString("summary"));
				beansEventDetailInfo.setEvent_category(rs.getString("event_category"));
				beansEventDetailInfo.setSchedule(rs.getString("schedule"));
				beansEventDetailInfo.setLocal_region(rs.getString("local_region"));
				beansEventDetailInfo.setFees(rs.getInt("fees"));
				beansEventDetailInfo.setAccess(rs.getString("access"));
				beansEventDetailInfo.setQualification(rs.getString("qualification"));
				beansEventDetailInfo.setPresenter(rs.getString("presenter"));
				beansEventDetailInfo.setOrganizer(rs.getString("organizer"));
			}

			System.out.println("searching item by event_id has been completed");

			return item;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	/**
	 * 商品検索
	 * @param searchWord
	 * @param pageNum
	 * @param pageMaxItemCount
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<BeansEventDetailInfo> getAllSearchEventDetail(String searchWord, int pageNum, int pageMaxItemCount) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			int startEventNum = (pageNum - 1) * pageMaxItemCount;
			con = DBManager.getConnection();

			if (searchWord.length() == 0) {
				// 全検索
				st = con.prepareStatement("SELECT * FROM event_detail ORDER BY id ASC LIMIT ?,? ");
				st.setInt(1, startEventNum);
				st.setInt(2, pageMaxItemCount);
			} else {
				// イベント名全検索
				st = con.prepareStatement("SELECT * FROM event_detail WHERE ( title LIKE ? ) OR ( summary LIKE ? ) OR ( event_category LIKE ? ) OR ( schedule LIKE ? ) OR ( local_region LIKE ? ) OR  ( fees LIKE ? ) OR ( access LIKE ? )  OR ( qualification LIKE ? ) OR ( presenter LIKE ? ) OR ( organizer LIKE ? )  ORDER BY id ASC LIMIT ?,? ");
				st.setString(1, "%" + searchWord  + "%");
				st.setString(2, "%" + searchWord  + "%");
				st.setString(3, "%" + searchWord  + "%");
				st.setString(4, "%" + searchWord  + "%");
				st.setString(5, "%" + searchWord  + "%");
				st.setString(6, "%" + searchWord  + "%");
				st.setString(7, "%" + searchWord  + "%");
				st.setString(8, "%" + searchWord  + "%");
				st.setString(9, "%" + searchWord  + "%");
				st.setString(10, "%" + searchWord  + "%");
				st.setInt(11, startEventNum);
				st.setInt(12, pageMaxItemCount);

			}



			ResultSet rs = st.executeQuery();
			ArrayList<BeansEventDetailInfo> beansEventDetailInfoList = new ArrayList<BeansEventDetailInfo>();

			while (rs.next()) {
				BeansEventDetailInfo beansEventDetailInfo = new BeansEventDetailInfo();

				beansEventDetailInfo.setId(rs.getInt("id"));
				beansEventDetailInfo.setTitle(rs.getString("title"));
				beansEventDetailInfo.setImg_name(rs.getString("img_name"));
				beansEventDetailInfo.setSummary(rs.getString("summary"));
				beansEventDetailInfo.setEvent_category(rs.getString("event_category"));
				beansEventDetailInfo.setSchedule(rs.getString("schedule"));
				beansEventDetailInfo.setLocal_region(rs.getString("local_region"));
				beansEventDetailInfo.setFees(rs.getInt("fees"));
				beansEventDetailInfo.setAccess(rs.getString("access"));
				beansEventDetailInfo.setQualification(rs.getString("qualification"));
				beansEventDetailInfo.setPresenter(rs.getString("presenter"));
				beansEventDetailInfo.setOrganizer(rs.getString("organizer"));

				beansEventDetailInfoList.add(beansEventDetailInfo);
			}

			System.out.println("get Items by itemName has been completed");
			return beansEventDetailInfoList;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}
	/**
	 * 商品総数を取得
	 *
	 * @param searchWord
	 * @return
	 * @throws SQLException
	 */
	public static double getAllEventDetailCount(String searchWord) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("select count(*) as cnt FROM event_detail WHERE ( title LIKE ? ) OR ( summary LIKE ? ) OR ( event_category LIKE ? ) OR ( schedule LIKE ? ) OR ( local_region LIKE ? ) OR  ( fees LIKE ? ) OR ( access LIKE ? )  OR ( qualification LIKE ? ) OR ( presenter LIKE ? ) OR ( organizer LIKE ? )");
			st.setString(1, "%" + searchWord + "%");
			st.setString(2, "%" + searchWord  + "%");
			st.setString(3, "%" + searchWord  + "%");
			st.setString(4, "%" + searchWord  + "%");
			st.setString(5, "%" + searchWord  + "%");
			st.setString(6, "%" + searchWord  + "%");
			st.setString(7, "%" + searchWord  + "%");
			st.setString(8, "%" + searchWord  + "%");
			st.setString(9, "%" + searchWord  + "%");
			st.setString(10, "%" + searchWord  + "%");
			ResultSet rs = st.executeQuery();
			double coung = 0.0;
			while (rs.next()) {
				coung = Double.parseDouble(rs.getString("cnt"));
			}
			return coung;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}
}
