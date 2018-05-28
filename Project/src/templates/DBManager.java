package templates;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**(model by LIKEIT @author d-yamaguchi)
 *
 * @author d-yamaguchi
 *
 */
public class DBManager {
	public static Connection getConnection() {
		Connection conn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
//					"jdbc:mysql://localhost:3306/ec_db?useUnicode=true&characterEncoding=utf8", "root", "password");/* 各環境に合わせて変更してください*/
//					"jdbc:mysql://localhost:3306/user?useUnicode=true&characterEncoding=utf8", "root", "password");/* 各環境に合わせて変更してください*/
			"jdbc:mysql://localhost:3306/ece_db?useUnicode=true&characterEncoding=utf8", "root", "password");/* 各環境に合わせて変更してください*/

			return conn;
		} catch (ClassNotFoundException e) {
			throw new IllegalMonitorStateException();
		} catch (SQLException e) {
			throw new IllegalMonitorStateException();
		}
	}
}
