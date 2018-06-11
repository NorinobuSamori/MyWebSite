package dao;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.BeansEventDetailInfo;
import templates.DBManager;

/////-----------------------------------------------------------------------------------------------------------
public class EventDetailInfoDao {

	//////---------------------------------------------------------------------------------------------
	/*変更予定：
	 * beansEventDetailInfoInfo
	 * BeansEventDetailInfo
	 *
	 * beansEventDetailInfoList （List<BeansEventDetailInfo> beansEventDetailInfoList = new ArrayList<BeansEventDetailInfo>();）
	 * beansEventDetailInfoList
	 *
	 * beansEventDetailInfo （BeansEventDetailInfo beansEventDetailInfo = new BeansEventDetailInfo(id, login_id, name1, birth_date, password, create_date, update_date);）
	 * beansEventDetailInfo
	 *
	 * */


	////-----------------------------------------------------------------------------------------------------------
	public ArrayList<BeansEventDetailInfo> SelectAllEventsByAllSearch(String SearchWord, int outputLimitNumber) {
		Connection conn = null;
		PreparedStatement pStmt = null;
		ArrayList<BeansEventDetailInfo> beansEventDetailInfoList = new ArrayList<BeansEventDetailInfo>();

		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// SELECT文を準備
			String sql = "SELECT * FROM event_detail WHERE ????= ????  ORDER BY RAND() LIMIT ?  ";
			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, SearchWord);
			pStmt.setInt(2, outputLimitNumber);
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


		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQLException on ArrayList<BeansEventDetailInfo> SelectAllEventsByAllSearch(String SearchWord, int outputLimitNumber)");
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

	////---------------------------------------------------------------------------------------------------------------


	public boolean InsertOneEventDetailInfo(String title, String img_name, String summary, String event_category,
			String schedule, String local_region, String fees, String access, String qualification, String presenter,
			String organizer ) {

		Connection conn = null;
		try {
			conn = DBManager.getConnection();

			String sql = "INSERT INTO event_detail  (title, img_name, summary, event_category, schedule, local_region, fees, access, qualification, presenter, organizer) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, title);
			pStmt.setString(2, img_name);
			pStmt.setString(3, summary);
			pStmt.setString(4, event_category);
			pStmt.setString(5, schedule);
			pStmt.setString(6, local_region);
			pStmt.setString(7, fees);
			pStmt.setString(8, access);
			pStmt.setString(9, qualification);
			pStmt.setString(10, presenter);
			pStmt.setString(11, organizer);
			pStmt.executeUpdate();


		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQLException on InsertOneEventDetailInfo()");

			return false;

		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("SQLException e    e.printStackTrace(); 22222");

				}
			}

		}
		return true;
	}
	/////-------------------------------------------------------------------------------------------------------------

	public BeansEventDetailInfo SelectOneEventDetailInfo(String id) {
		Connection conn = null;
		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			String sql = "SELECT * FROM event_detail WHERE id = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);

			ResultSet rs = pStmt.executeQuery();

			if (!rs.next()) {////1行であるはずなのに0行だったらよくないからnext()
				return null;
			}


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

			return beansEventDetailInfo;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQLException on BeansEventDetailInfo SelectOneEventDetailInfo(String id)");

		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return null;
	}

	/////-------------------------------------------------------------------------------------------------------------

	public ArrayList<BeansEventDetailInfo> SelectOneListEventDetailInfo(String id) {
		Connection conn = null;
		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			String sql = "SELECT * FROM event_detail WHERE id = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);

			ResultSet rs = pStmt.executeQuery();

			if (!rs.next()) {////1行であるはずなのに0行だったらよくないからnext()
				return null;
			}
			ArrayList<BeansEventDetailInfo> beansEventDetailInfoList = new ArrayList<BeansEventDetailInfo>();

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


			return beansEventDetailInfoList;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQLException on BeansEventDetailInfo SelectOneListEventDetailInfo(String id)");

		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return null;
	}

	/////-------------------------------------------------------------------------------------------------------------



	public boolean UpdateOneEventDetailInfo(String id, String title, String img_name, String summary, String event_category,
			String schedule, String local_region, String fees, String access, String qualification, String presenter,
			String organizer ) {
		Connection conn = null;
		try {
			conn = DBManager.getConnection();

			String updatesql = "UPDATE event_detail SET title = ?, img_name= ?, summary= ?, event_category = ?, schedule = ?, local_region = ?, fees = ?, access = ?, qualification = ?, presenter = ?, organizer = ? WHERE id = ? ";
			PreparedStatement pStmt3 = conn.prepareStatement(updatesql);
			pStmt3.setString(1, title);
			pStmt3.setString(2, img_name);
			pStmt3.setString(3, summary);
			pStmt3.setString(4, event_category);
			pStmt3.setString(5, schedule);
			pStmt3.setString(6, local_region);
			pStmt3.setString(7, fees);
			pStmt3.setString(8, access);
			pStmt3.setString(9, qualification);
			pStmt3.setString(10, presenter);
			pStmt3.setString(11, organizer);
			pStmt3.setString(12, id);
			pStmt3.executeUpdate();


		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQLException on UpdateOneEventDetailInfo()");
			return false;

		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return true;
	}

	//////---------------------------------------------------------------------------------------------

	public void DeleteOneEventDetailInfoById(String id){
		Connection conn = null;
		try {
			// データベースへ接続
			conn = DBManager.getConnection();
			String selectsql = "select * FROM event_detail where id = ?";

			//idによる既存のimg_nameのファイル名を取得するために記述
			PreparedStatement pStmt = conn.prepareStatement(selectsql);
			pStmt.setString(1, id);
			ResultSet rs = pStmt.executeQuery();

			if (!rs.next()) {
				return ;
			}
			String img_name = rs.getString("img_name");




			//対象のimg_nameファイルを消去する処理開始-----------------------------------------------------------

			File file = new File("C:\\Users\\Samori-Norinobu\\Documents\\MyWebSite\\Project\\WebContent\\img\\" +img_name);//+ \\img_nameを入力したいです

			if (file.exists()){
				if (file.delete()){
					System.out.println("対象のファイルを削除しました on DeleteOneEventDetailInfoById");
				}else{
					System.out.println("対象のファイルの削除に失敗しました on DeleteOneEventDetailInfoById");
				}
			}else{
				System.out.println("対象のファイルが見つかりません on DeleteOneEventDetailInfoById");
			}


			//対象のimgファイルを消去する処理終了-----------------------------------------------------------


			//以下の処理は失敗しなかった
			String deletesql = "DELETE from event_detail where id = ?";

			PreparedStatement pStmt2 = conn.prepareStatement(deletesql);
			pStmt2.setString(1, id);
			pStmt2.executeUpdate();




		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQLException on DeleteOneEventDetailInfoById()");

		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
	}

	////-------------------------------------------------------------------------------------------------------------

}
