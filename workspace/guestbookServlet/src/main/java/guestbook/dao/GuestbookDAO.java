package guestbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import guestbook.bean.GuestbookDTO;


public class GuestbookDAO {
	
	private Connection conn;
	   private PreparedStatement pstmt;
	   private ResultSet rs;

	   private String driver = "oracle.jdbc.driver.OracleDriver";
	   private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	   private String username = "c##java";
	   private String password = "1234";
	   
	   private static GuestbookDAO guestbookDAO = new GuestbookDAO();

	   public static GuestbookDAO getInstance() {

	      return guestbookDAO;
	   }
	   
	   public GuestbookDAO() {
		   try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	   }
	   
	   public void getConnection() {
		      try {
		         conn = DriverManager.getConnection(url, username, password);/* 오라클 드라이버 */
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
		   }
	   
	   public void guestbookWrite(GuestbookDTO guestbookDTO) {
		
		   this.getConnection();//db접속
		   String sql = "insert into guestbook values(seq_guestbook.nextval,?,?,?,?,?,sysdate)";
		  
		   
		   try {
			pstmt = conn.prepareStatement(sql);
			
			//?에 데이터 주입
			pstmt.setString(1, guestbookDTO.getName());
			pstmt.setString(2, guestbookDTO.getEmail());
			pstmt.setString(3, guestbookDTO.getHomepage());
			pstmt.setString(4, guestbookDTO.getSubject());
			pstmt.setString(5, guestbookDTO.getContent());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			GuestbookDAO.close(conn, pstmt);
		}
		
		 
		   
	   }
	   private static void close(Connection conn, PreparedStatement pstmt) {
		      try {
		         if (pstmt != null)
		            pstmt.close();
		         if (conn != null)
		            conn.close();
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }

		   }
		   
		   private static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
			      try {
			         if (pstmt != null)
			            pstmt.close();
			         if (conn != null)
			            conn.close();
			         if (rs != null)
			        	 rs.close();
			   } catch (SQLException e) {
			        e.printStackTrace();
			   }
			      

		 }
		   public String guestbookWrite(String name, String email, String homepage, String subject, String content) {
			   
			   String sql = "insert into guestbook values(seq_guestbook.nextval, ?, ?, ?, ?, ?, sysdate)";
			   getConnection();//오라클 접속 
			   try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.setString(2, email);
				pstmt.setString(3, homepage);
				pstmt.setString(4, subject);
				pstmt.setString(5, content);
				rs = pstmt.executeQuery();//ResultSet 리턴
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				GuestbookDAO.close(conn, pstmt, rs);
			}
			   
			   
			   return "글이 작성되었습니다.";
		   }
	   
	   
	   
}
