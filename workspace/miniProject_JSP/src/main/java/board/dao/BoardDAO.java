package board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import board.bean.BoardDTO;
import member.dao.MemberDAO;


public class BoardDAO {
   private Connection conn;
   private PreparedStatement pstmt;
   private ResultSet rs;

   private DataSource ds;

   
   private static BoardDAO boardDAO = new BoardDAO();

   public static BoardDAO getInstance() {

      return boardDAO;
   }
   
   public static void close(Connection conn, PreparedStatement pstmt) {
      try {
         if (pstmt != null)
            pstmt.close();
         if (conn != null)
            conn.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }

   }
   
   public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
      try {
         if (pstmt != null)
            pstmt.close();
         if (conn != null)
            conn.close();
         if(rs != null) 
            rs.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }

   }
   
   public BoardDAO() {
      try {
         Context ctx = new InitialContext(); //생성
         ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
         
      } catch (NamingException e) {
         
         e.printStackTrace();
      }
   }

   
   
   public void boardWrite(Map<String, String> map) {
      String sql = "insert into board(seq,id,name,email,subject,content,ref)"
            + "values(seq_board.nextval,?,?,?,?,?,seq_board.currval)";
      
      
      
      try {
         conn = ds.getConnection();
         
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, map.get("id"));
         pstmt.setString(2, map.get("name"));
         pstmt.setString(3, map.get("email"));
         pstmt.setString(4, map.get("subject"));
         pstmt.setString(5, map.get("content"));
         
         pstmt.executeUpdate(); // 실행 - 개수 리턴
      } catch (SQLException e) {
         
         e.printStackTrace();
      } finally {
         BoardDAO.close(conn, pstmt);
      }
      
      
   }
   
   public List<BoardDTO> boardList(Map<String, Integer> map){
      List<BoardDTO> list = new ArrayList<BoardDTO>();
      String sql = "select * from "
      			+ "(select rownum rn, tt.* from "
      			+ "(select * from board order by ref desc, step asc) TT "
      			+ ")where rn>=? and rn<=?";
      
      
      
      try {
         conn = ds.getConnection();
         
         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, map.get("startNum"));
         pstmt.setInt(2, map.get("endNum"));
         
         rs = pstmt.executeQuery();
         
         while(rs.next()) {
            BoardDTO boardDTO = new BoardDTO();
            boardDTO.setSeq(rs.getInt("seq"));
            boardDTO.setId(rs.getString("id"));
            boardDTO.setNameString(rs.getString("name"));
            boardDTO.setEmail(rs.getString("email"));
            boardDTO.setSubject(rs.getString("subject"));
            boardDTO.setContent(rs.getString("content"));
            boardDTO.setRef(rs.getInt("ref"));
            boardDTO.setLev(rs.getInt("lev"));
            boardDTO.setStep(rs.getInt("step"));
            boardDTO.setPseq(rs.getInt("pseq"));
            boardDTO.setReply(rs.getInt("reply"));
            boardDTO.setHit(rs.getInt("hit"));
            boardDTO.setLogtime(rs.getDate("logtime"));
            
            list.add(boardDTO);
         } //while
         
      } catch (SQLException e) {
         e.printStackTrace();
         list = null;
      } finally {
         BoardDAO.close(conn, pstmt, rs);
      }
      
      return list;
   }
   
   public int getTotalA() {
	   int totalA = 0;
	   
	   String sql = "select count(*) from board";
	   
	   try {
		conn = ds.getConnection();
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		rs.next();
		totalA = rs.getInt(1);
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		BoardDAO.close(conn, pstmt, rs);
	}
	   return totalA;
   }
   
   public boolean isExistId(String id) {
	   boolean existId = false;
	   String sql = "select * from member where id=?";
	   
	   try {
		   conn = ds.getConnection();
		
		   pstmt = conn.prepareStatement(sql);
		   pstmt.setString(1, id);
		
		   rs = pstmt.executeQuery();
		
		   if(rs.next()) existId = true;
		
	   } catch (SQLException e) {
		   e.printStackTrace();
	   } finally {
		   MemberDAO.close(conn, pstmt, rs);
	   }
			   
	   
	   	return existId;
   	}

} 