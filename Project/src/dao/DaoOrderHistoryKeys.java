package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.BeansEventDetailInfo;
import templates.DBManager;

//モデルはBuyDetailDAO.java

public class DaoOrderHistoryKeys {
	public static void insertOrderHistoryKeysByBeans(BeansEventDetailInfo beansEventDetailInfo) throws SQLException {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBManager.getConnection();
			st = conn.prepareStatement(
					"INSERT INTO user_order_history_keys(order_id,event_detail_id) VALUES(?,?)");
			st.setInt(1, beansEventDetailInfo.getOrder_id_key());
			st.setInt(2, beansEventDetailInfo.getEvent_id_key());
			st.executeUpdate();
			System.out.println("inserting OrderHistoryKeys has been completed");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	/**
	 * 購入IDによる購入情報検索
	 * @param order_id
	 * @return {BuyDataDetailBeans}
	 * @throws SQLException
	 */
	public ArrayList<BeansEventDetailInfo> getOrderDataListByOrder_id(int order_id) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();

			st = con.prepareStatement("SELECT * FROM user_order_history_keys WHERE order_id = ?");
			st.setInt(1, order_id);

			ResultSet rs = st.executeQuery();
			ArrayList<BeansEventDetailInfo> beansEventDetailInfoList = new ArrayList<BeansEventDetailInfo>();

			while (rs.next()) {
				BeansEventDetailInfo beansEventDetailInfo = new BeansEventDetailInfo();
				beansEventDetailInfo.setId(rs.getInt("id"));
				beansEventDetailInfo.setOrder_id_key(rs.getInt("order_id"));
				beansEventDetailInfo.setEvent_id_key(rs.getInt("event_id"));
				beansEventDetailInfoList.add(beansEventDetailInfo);
			}

			System.out.println("searching BuyDataBeansList by BuyID has been completed");
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
     * 購入IDによる購入詳細情報検索
     * @param order_id
     * @return beansEventDetailInfoList ArrayList<BeansEventDetailInfo>
     *             購入詳細情報のデータを持つJavaBeansのリスト
     * @throws SQLException
     */
	public static ArrayList<BeansEventDetailInfo> getBeansEventDetailInfoListByOrder_Id(int order_id) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();

			st = con.prepareStatement(
					"SELECT * "
					+ " FROM user_order_history_keys"
					+ " JOIN event_detail"
					+ " ON user_order_history_keys.event_detail_id = event_detail.id"
					+ " WHERE user_order_history_keys.order_id = ?");
			st.setInt(1, order_id);

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

			System.out.println("searching BeansEventDetailInfoList by order_id has been completed");
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

	public ArrayList<BeansEventDetailInfo> getOrder_id_keyDistinct() throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();

			st = con.prepareStatement("SELECT DISTINCT order_id FROM user_order_history_keys");
			ResultSet rs = st.executeQuery();

			ArrayList<BeansEventDetailInfo> beansEventDetailInfoList = new ArrayList<BeansEventDetailInfo>();

			while (rs.next()) {
				BeansEventDetailInfo beansEventDetailInfo = new BeansEventDetailInfo();
				beansEventDetailInfo.setOrder_id_key(rs.getInt("order_id"));
				beansEventDetailInfoList.add(beansEventDetailInfo);
			}

			System.out.println("searching BeansEventDetailInfoList with DISTINCT has been completed");
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
}
