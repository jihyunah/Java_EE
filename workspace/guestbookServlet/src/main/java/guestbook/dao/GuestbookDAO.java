package guestbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

		public GuestbookDTO guestbookSearch(int seq) {
			GuestbookDTO selectGuestbookDTO = null;
			
			String sql = "select seq, name, email, homepage, subject, content, "
					+ "to_char(logtime, 'YYYY.MM.DD')as logtime from guestbook where seq=?";
			getConnection();
			
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, seq);
				rs = pstmt.executeQuery();//select 실행해서 result set에 담기. 
				
				while(rs.next()) { //현재 레코드가 있느냐 없느냐 체크.  
					selectGuestbookDTO = new GuestbookDTO(); //dto 안에는 name,email,homepage,content,... 만들어져 있다. 
					//여기서 꺼내오기 시작하기.
					selectGuestbookDTO.setSeq(rs.getInt("seq"));//seq를 가져와서 dto안에 넣기. 
					selectGuestbookDTO.setName(rs.getString("name"));
					selectGuestbookDTO.setEmail(rs.getString("email"));
					selectGuestbookDTO.setHomepage(rs.getString("homepage"));
					selectGuestbookDTO.setSubject(rs.getString("subject"));
					selectGuestbookDTO.setContent(rs.getString("content"));
					selectGuestbookDTO.setLogtime(rs.getString("logtime"));
				}
					
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				GuestbookDAO.close(conn, pstmt, rs);
			}
			return selectGuestbookDTO;
		}

		public ArrayList<GuestbookDTO> guestbookList(int startNum, int endNum) {
			ArrayList<GuestbookDTO> list = new ArrayList<GuestbookDTO>();
			
			String sql  = "select * from"
						+ "(select rownum rn, aa.* from"
						+ "(select seq, name, email, homepage, subject, content, "
						+ "to_char(logtime, 'YYYY.MM.DD') as logtime"
						+ " from guestbook order by seq desc) aa"
						+ " ) where rn>=? and rn<=?";
			
			getConnection();
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, startNum);
				pstmt.setInt(2, endNum);
				rs = pstmt.executeQuery(); //rs로 결과 받아오기. 
				
				while(rs.next()) { //rs 값이 있으면 또 dto 만들고, 또 만들고,,
					GuestbookDTO guestbookDTO = new GuestbookDTO();
					
					guestbookDTO.setSeq(rs.getInt("seq"));//seq를 가져와서 dto안에 넣기. 
					guestbookDTO.setName(rs.getString("name"));
					guestbookDTO.setEmail(rs.getString("email"));
					guestbookDTO.setHomepage(rs.getString("homepage"));
					guestbookDTO.setSubject(rs.getString("subject"));
					guestbookDTO.setContent(rs.getString("content"));
					guestbookDTO.setLogtime(rs.getString("logtime"));
					
					
					list.add(guestbookDTO);
					
				}//while
				
			} catch (SQLException e) {
				e.printStackTrace();
				list = null; //try{}에서 db처리에 문제가 있으면 list를 null값으로 내보내라! 
			}finally {
				GuestbookDAO.close(conn, pstmt, rs);
			}
			
			
			
			return list;
		}

		public int getTotalA() {
			int totalA = 0;
			
			String sql = "Select count(*) from guestbook";
			getConnection();
			
			try {
				pstmt = conn.prepareStatement(sql);
				// setInt() 메소드 사용하지 않음
		        rs = pstmt.executeQuery();
		        
		        rs.next();
		        totalA = rs.getInt(1);
		        
		        
		        
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				GuestbookDAO.close(conn, pstmt, rs);
			}
			
			return totalA;
		}

		
	   
	   
	   
}
