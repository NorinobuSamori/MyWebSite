package dao;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.xml.bind.DatatypeConverter;

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

    public void UpdateOneEventDetailInfo(String login_Id, String password, String name, String birth_date ) {////beansEventDetailInfo→voidへ
        Connection conn = null;
        try {
          conn = DBManager.getConnection();

           String sql = "UPDATE event_detail SET password = ?, name= ?, birth_date= ?, update_date = now() where login_id = ? ";


            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, ConvertMD5(password));
            pStmt.setString(2, name);
            pStmt.setString(3, birth_date);
            pStmt.setString(4, login_Id);
            pStmt.executeUpdate();



        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQLException on UpdateOneEventDetailInfo()");

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

    public boolean DeleteOneEventDetailInfoById(String id){////beansEventDetailInfoがvoidに
        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();
            String sql = "DELETE from event_detail where id = ?";


            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, id);
            pStmt.executeUpdate();




        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQLException on DeleteOneEventDetailInfo()");
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

////-------------------------------------------------------------------------------------------------------------

    private String ConvertMD5(String password) {
    	//ハッシュ生成前にバイト配列に置き換える際のCharset
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
}
