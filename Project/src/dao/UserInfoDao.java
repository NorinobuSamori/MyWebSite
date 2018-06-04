package dao;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import model.BeansUserInfo;
import templates.DBManager;

/////-----------------------------------------------------------------------------------------------------------
public class UserInfoDao {
	public BeansUserInfo findByLoginInfo(String login_Id, String password) {
		Connection conn = null;
		try {
			conn = DBManager.getConnection();

			String sql = "SELECT * FROM user_info WHERE login_id = ? and password = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, login_Id);
			pStmt.setString(2, ConvertMD5(password));
			ResultSet rs = pStmt.executeQuery();

			if (!rs.next()) {
				return null;
			}
			String login_id = rs.getString("login_id");
			String password1 = rs.getString("password");
			System.out.println("login_id = " + login_id);
			return new BeansUserInfo(login_id, password1);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}

		}
	}

	//////---------------------------------------------------------------------------------------------
	public List<BeansUserInfo> findAll() {
		Connection conn = null;
		List<BeansUserInfo> empList = new ArrayList<BeansUserInfo>();

		try {
			conn = DBManager.getConnection();

			String sql = "SELECT * FROM user_info where login_id not in ('admin')";

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
				String login_id = rs.getString("login_id");
				String name = rs.getString("name");
				Date birth_date = rs.getDate("birth_date");
				String password = rs.getString("password");
				String create_date = rs.getString("create_date");
				String update_date = rs.getString("update_date");
				BeansUserInfo BeansUser = new BeansUserInfo(id, login_id, name, birth_date, password, create_date, update_date);
				empList.add(BeansUser);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return empList;
	}

	////-----------------------------------------------------------------------------------------------------------
	public List<BeansUserInfo> findSearch(String loginId, String name, String calendar1, String calendar2) {
		Connection conn = null;
		List<BeansUserInfo> empList = new ArrayList<BeansUserInfo>();

		try {
			conn = DBManager.getConnection();

			String sql = "SELECT * FROM user_info where login_id not in ('admin')";

			if(!loginId.equals("")) {
				sql += " and login_id = '" + loginId + "'";
			}
			if(!name.equals("")) {
				sql += " and name LIKE '%" + name + "%'";
			}
			if(!calendar1.equals("") && !calendar2.equals("")) {
				sql += " and birth_date between '" + calendar1 + "' and '" + calendar2 + "'";
			}


			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
				String login_id = rs.getString("login_id");
				String name1 = rs.getString("name");
				Date birth_date = rs.getDate("birth_date");
				String password = rs.getString("password");
				String create_date = rs.getString("create_date");
				String update_date = rs.getString("update_date");
				BeansUserInfo BeansUser = new BeansUserInfo(id, login_id, name1, birth_date, password, create_date, update_date);
				empList.add(BeansUser);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQLException e　から　e.printStackTrace();  findSearch()内のエラー");
			return null;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return empList;
	}

	////---------------------------------------------------------------------------------------------------------------


	public boolean SignUpInfo(String login_Id, String password, String name, String birth_date ) {////BeansUserがvoidになりました
		Connection conn = null;
		try {
			conn = DBManager.getConnection();

			String sql = "INSERT INTO user_info (login_id, name, password, birth_date, create_date, update_date) VALUES (?, ?, ?, ?, now(), now())";



			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login_Id);
			pStmt.setString(2, name);
			pStmt.setString(3, ConvertMD5(password));
			pStmt.setString(4, birth_date);
			pStmt.executeUpdate();


		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQLException e    e.printStackTrace();  11111");

			return false;

		} finally {
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


	public BeansUserInfo findByDetailInfo(String id) {
		Connection conn = null;
		try {
			conn = DBManager.getConnection();

			String sql = "SELECT * FROM user_info WHERE id = ?";



			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);
			ResultSet rs = pStmt.executeQuery();

			if (!rs.next()) {
				return null;
			}


			int id2 = rs.getInt("id");
			String login_id = rs.getString("login_id");
			String name = rs.getString("name");
			Date birth_date = rs.getDate("birth_date");
			String password = rs.getString("password");
			String create_date = rs.getString("create_date");
			String update_date = rs.getString("update_date");
			BeansUserInfo BeansUser = new BeansUserInfo(id2, login_id, name, birth_date, password, create_date, update_date);////値を渡しているのではなく、引っ張っているらしい。

			return BeansUser;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQLException e    e.printStackTrace();  3333");

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("SQLException e    e.printStackTrace(); 4444");

				}
			}

		}
		return null;
	}

	/////-------------------------------------------------------------------------------------------------------------



	public void byUpdateInfo(String login_Id, String password, String name, String birth_date ) {////BeansUser→voidへ
		Connection conn = null;
		try {
			conn = DBManager.getConnection();

			String sql = "UPDATE user_info SET password = ?, name= ?, birth_date= ?, update_date = now() where login_id = ? ";




			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, ConvertMD5(password));
			pStmt.setString(2, name);
			pStmt.setString(3, birth_date);
			pStmt.setString(4, login_Id);
			pStmt.executeUpdate();


		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQLException e    e.printStackTrace();  9999");

		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("SQLException e    e.printStackTrace(); 10101010");

				}
			}

		}
	}

	//////---------------------------------------------------------------------------------------------


	public void findByDeleteInfo(String id){
		Connection conn = null;
		try {
			conn = DBManager.getConnection();

			String sql = "DELETE from user_info where id = ?";


			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);
			pStmt.executeUpdate();




		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQLException e    e.printStackTrace();  11111");

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("SQLException e    e.printStackTrace(); 22222");

				}
			}

		}
	}

	////-------------------------------------------------------------------------------------------------------------

	private String ConvertMD5(String password) {
		Charset charset = StandardCharsets.UTF_8;
		//ハッシュアルゴリズム
		String algorithm = "MD5";

		//ハッシュ生成処理
		byte[] bytes = null;
		try {
			bytes = MessageDigest.getInstance(algorithm).digest(password.getBytes(charset));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		String result = DatatypeConverter.printHexBinary(bytes);
		//標準出力
		return result;
	}

	/////-------------------------------------------------------------------------------------------------------------

	public BeansUserInfo SelectAllByLogin_id(String login_id) {
		Connection conn = null;
		try {
			conn = DBManager.getConnection();


			String sql = "SELECT * FROM user_info WHERE login_id = ?";


			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login_id);
			ResultSet rs = pStmt.executeQuery();

			if (!rs.next()) {
				return null;
			}


			int id2 = rs.getInt("id");
			String login_id2 = rs.getString("login_id");
			String name = rs.getString("name");
			Date birth_date = rs.getDate("birth_date");
			String password = rs.getString("password");
			String create_date = rs.getString("create_date");
			String update_date = rs.getString("update_date");
			BeansUserInfo beansUserInfo = new BeansUserInfo(id2, login_id2, name, birth_date, password, create_date, update_date);

			return beansUserInfo;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error on UserInfoDao SelectAllByLogin_id");

		} finally {
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
}
