package user.service;

import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserInsertService implements UserService {

	@Override
	public void execute() {
		System.out.println();
		
		//데이터
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("이름 입력 : ");
		String name = scanner.next();
		
		System.out.print("id 입력 : ");
		String id = scanner.next();
		
		System.out.print("비밀번호 입력 : ");
		String pwd = scanner.next();
		
		UserDTO userDTO = new UserDTO();
		userDTO.setName(name);
		userDTO.setId(id);
		userDTO.setPwd(pwd);
		
		//DB
		UserDAO userDAO = UserDAO.getInstance(); // 싱글톤
		userDAO.write(userDTO);
		
		System.out.println("데이터를 저장하였습니다.");
	}

}
