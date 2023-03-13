package user.dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import user.bean.UserDTO;

public class UserDAO {

	private SqlSessionFactory sqlSessionFactory; //객체 생성 
	private SqlSession sqlSession;
	
	public UserDAO() {
		 
		InputStream inputStream;
		try {
			//Reader reader = Resources.getResourceAsReader("mybatis-config.xml"); //이 환경설정 파일을 읽어와라.
			inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream); 
			//inputStream 파일로 sessionFactory를 만들어라.
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		 
	}
	
	public void insert(UserDTO userDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession(); //생성 
		sqlSession.insert("userSQL.write", userDTO); //write id in userMapper에 userDTO데이터를 넘겨준다. 
		sqlSession.commit();
		sqlSession.close();
		
	}

}
