package user.dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import user.bean.UserDTO;

public class UserDAO {
	private SqlSessionFactory sqlSessionFactory;	//sqlSession을 만들기 위해 만듬.
	private static UserDAO userDAO = new UserDAO();
	
	public static UserDAO getInstance() {
		return userDAO;
	}
	
	public UserDAO() {
		try {
			//Reader reader = Resources.getResourceAsReader("mybatis-config.xml");//추상클래스여서 직접적으로 new 할 수 없다.
			InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void write(UserDTO userDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession(); //생성
		
		sqlSession.insert("userSQL.write", userDTO); //넘길 데이터
		sqlSession.commit();
		sqlSession.close();
		
	}

	public List<UserDTO> getUserList() {
		SqlSession sqlSession = sqlSessionFactory.openSession(); //생성
		List<UserDTO> list = sqlSession.selectList("userSQL.getUserList");
		sqlSession.close();	//오라클 lock => insert/ delete/ update => 반드시 Commit
		
		return list;
	}

	public UserDTO getUser(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession(); //생성
		UserDTO userDTO = sqlSession.selectOne("userSQL.getUser", id);
		sqlSession.close();
		
		return userDTO;
	}

	public void update(Map<String, String> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession(); //생성
		sqlSession.update("userSQL.update", map);
		sqlSession.commit();
		sqlSession.close();
		
	}
	
	public void delete(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession(); //생성
		sqlSession.delete("userSQL.delete", id);
		sqlSession.commit();
		sqlSession.close();
	}

	 public List<UserDTO> search(Map<String, String> map) {
	        SqlSession sqlSession = sqlSessionFactory.openSession();
	        List<UserDTO> list = sqlSession.selectList("userSQL.search", map);
	        sqlSession.close();
	        return list;
	 }

	

}

