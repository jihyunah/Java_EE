package user.service;

import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserInsertService implements UserService {

	@Override
	public void execute() {
		System.out.println();
		
		//데이터 
		Scanner scan = new Scanner(System.in);
		
		System.out.println("이름 입력 : ");
		String name = scan.next();
		
		System.out.println("아이디 입력 : ");
		String id = scan.next();
		
		System.out.println("비밀번호 입력 : ");
		String pwd = scan.next();
		
		//DTO 안에 위 내용을 넣어주기. 
		UserDTO userDTO = new UserDTO();
		userDTO.setName(name);
		userDTO.setId(id);
		userDTO.setPwd(pwd);
		
		//DB
		UserDAO userDAO = new UserDAO();
		userDAO.insert(userDTO);
		
		System.out.println("데이터를 저장하였습니다.");
	}

}
