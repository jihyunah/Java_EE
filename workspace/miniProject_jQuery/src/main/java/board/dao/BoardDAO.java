package board.dao;

import java.io.IOException;
import java.io.Reader;
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

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.bean.BoardDTO;



public class BoardDAO {
	private SqlSessionFactory sqlSessionFactory;
   
   private static BoardDAO boardDAO = new BoardDAO();

   public static BoardDAO getInstance() {
      return boardDAO;
   }

   public BoardDAO() {
	   try {
	         Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
	         
	         sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	         
	      } catch (IOException e) {
	         
	         e.printStackTrace();
	      }
   }

   
   
   public void boardWrite(Map<String, String> map) {
	   
	  SqlSession sqlSession = sqlSessionFactory.openSession();
	  sqlSession.insert("boardSQL.boardWrite", map);
	  sqlSession.commit();
	  sqlSession.close();
   	}
	
   
   public List<BoardDTO> boardList(Map<String, Integer> map){
	  SqlSession sqlSession = sqlSessionFactory.openSession();
	  List<BoardDTO> list = sqlSession.selectList("boardSQL.boardList", map);
	  sqlSession.close();
	  return list;
   }
	   
   
   public int getTotalA() {
	   SqlSession sqlSession = sqlSessionFactory.openSession();
	   int totalA = sqlSession.selectOne("boardSQL.getTotalA");
	   sqlSession.close();
	   return totalA;
   }
	  
   public BoardDTO getBoard(int seq) {
	   SqlSession sqlSession = sqlSessionFactory.openSession();
	   BoardDTO boardDTO = sqlSession.selectOne("boardSQL.getBoard", seq);
	   sqlSession.close();
	   return boardDTO;
   }

   
   public BoardDTO boardReply(Map<String, String> map) {
	   SqlSession sqlSession = sqlSessionFactory.openSession();
	   
	   //원글
	   BoardDTO boardDTO = sqlSession.selectOne("boardSQL.getBoard", map.get("pseq")); //원글번호 꺼내온다.
	   
	   
	   // step update
	   //update board set step=step+1 where ref=원글ref and step>원글step
	   sqlSession.update("boardSQL.boardReply1", boardDTO);
	   
	   //insert
	   //답글ref = 원글ref
	   //답글lev = 원글lev + 1
	   //답글step = 원글step + 1
	   
	   //reply update
	   //update board set reply=reply+1 where seq=원글번호
	   return null;
}
	   
} 