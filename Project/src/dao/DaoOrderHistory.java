package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import model.BeansEventDetailInfo;
import templates.DBManager;

//モデルはBuyDAO.java

public class DaoOrderHistory {
	public static int insertOrder(BeansEventDetailInfo beansEventDetailInfo) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		int autoIncKey = -1;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement(
					"INSERT INTO user_order_history(user_id, total_fees, order_create_date) VALUES(?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			st.setInt(1, beansEventDetailInfo.getUser_id());
			st.setInt(2, beansEventDetailInfo.getTotal_fees());
			st.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			st.executeUpdate();

			ResultSet rs = st.getGeneratedKeys();////これでStatement.RETURN_GENERATED_KEYSを取得している
			if (rs.next()) {////nullを想定しているものではないので要注意※
				autoIncKey = rs.getInt(1);////なぜgetInt(1);なのかは謎。これは後回しにする。
			}
			System.out.println("inserting order-datas has been completed");

			return autoIncKey;
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
	 * 購入IDによる購入情報検索
	 * @param buyId
	 * @return BeansEventDetailInfo
	 * 				購入情報のデータを持つJavaBeansのリスト
	 * @throws SQLException
	 * 				呼び出し元にスローさせるため
	 */
	public static BeansEventDetailInfo getBeansEventDetailInfoByOrder_id(int order_id) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();

			st = con.prepareStatement(
					"SELECT * FROM user_order_history"
							+ " WHERE id = ?");
			st.setInt(1, order_id);

			ResultSet rs = st.executeQuery();

			BeansEventDetailInfo beansEventDetailInfo = new BeansEventDetailInfo();
			if (rs.next()) {
				beansEventDetailInfo.setId(rs.getInt("id"));
				beansEventDetailInfo.setTotal_fees(rs.getInt("total_fees"));
				beansEventDetailInfo.setOrder_create_date(rs.getTimestamp("order_create_date"));
				beansEventDetailInfo.setUser_id(rs.getInt("user_id"));
			}


			System.out.println("searching BeansEventDetailInfo by order_id has been completed");

			return beansEventDetailInfo;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	public static ArrayList<BeansEventDetailInfo> getBeansEventDetailInfoWhereUser_Id(int user_id) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();

			ArrayList<BeansEventDetailInfo> beansEventDetailInfoList = new ArrayList<BeansEventDetailInfo>();

			st = con.prepareStatement(
					"SELECT * FROM user_order_history WHERE user_id = ?");
			st.setInt(1, user_id);

			ResultSet rs = st.executeQuery();


			while (rs.next()) {
				BeansEventDetailInfo beansEventDetailInfo = new BeansEventDetailInfo();

				beansEventDetailInfo.setId(rs.getInt("id"));
				beansEventDetailInfo.setUser_id(rs.getInt("user_id"));
				beansEventDetailInfo.setTotal_fees(rs.getInt("total_fees"));
				beansEventDetailInfo.setOrder_create_date(rs.getTimestamp("order_create_date"));

				beansEventDetailInfoList.add(beansEventDetailInfo);
			}



			System.out.println("searching BeansEventDetailInfo by USER_ID has been completed");

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
