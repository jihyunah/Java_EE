package member.dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
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

import member.bean.MemberDTO;

public class MemberDAO {

	private SqlSessionFactory sqlSessionFactory;	//클래스 안에 있는 모든 객체는 null로 초기화 되어있다.
	private static MemberDAO memberDAO = new MemberDAO();

	public static MemberDAO getInstance() {

		return memberDAO;
	}
	
	

	public MemberDAO() {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public MemberDTO memberLogin(Map map){
		SqlSession sqlSession = sqlSessionFactory.openSession(); //생성
		MemberDTO memberDTO = sqlSession.selectOne("memberSQL.memberLogin", map);
		sqlSession.close();
		return memberDTO;	
				//여기서 id랑 pwd를 받아와서 select * from member where id=id and pwd=pwd를 거쳐 list에 값을 가지고 오겠지
	}
//	


	public int memberWrite(MemberDTO memberDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession(); //생성
		
		int su = sqlSession.insert("memberSQL.memberWrite", memberDTO); //넘길 데이터
		sqlSession.commit();
		sqlSession.close();
		
		
		return su;
	}
	
	public boolean isExistId(String id) {
		boolean existId = false;
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MemberDTO memberDTO = sqlSession.selectOne("memberSQL.isExistId", id);
		if(memberDTO != null) {
			existId = true;
		}
		
		sqlSession.close();
		
		return existId;
	}
	
	
	public MemberDTO getMember(String id){ //updateForm.jsp의 memberDAO.getMember(id)의 값을 전달
		SqlSession sqlSession = sqlSessionFactory.openSession(); //생성
		MemberDTO memberDTO = sqlSession.selectOne("memberSQL.getMember", id);
		sqlSession.close();

		return memberDTO;
	}
	
	public void memberUpdate(MemberDTO memberDTO){
		SqlSession sqlSession = sqlSessionFactory.openSession(); //생성
		sqlSession.update("memberSQL.memberUpdate", memberDTO);
		sqlSession.commit();
		sqlSession.close();
		
	}
		

	public boolean isExistPwd(String id, String pwd){
		SqlSession sqlSession = sqlSessionFactory.openSession(); //생성
		boolean exist = false;
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pwd", pwd);
		MemberDTO memberDTO = sqlSession.selectOne("memberSQL.isExistPwd", map);
		
		if(memberDTO != null) {
			exist = true;
		}
		
		sqlSession.close();
		return exist;
		
	}
	
	public void memberDelete(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession(); //생성
		sqlSession.delete("memberSQL.memberDelete", id);
		sqlSession.commit();
		sqlSession.close();
	
	}

}
