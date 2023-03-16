package user.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserDeleteService implements UserService {

	@Override
	public void execute() {
		Scanner scanner = new Scanner(System.in);
		System.out.println();
		
		System.out.print("삭제할 아이디 입력 : ");
		String id = scanner.next();
		
		UserDAO userDAO = UserDAO.getInstance();
		UserDTO userDTO = userDAO.getUser(id);
		
		if(userDTO == null) {
			System.out.println("아이디가 없습니다.");
			//return; else를 쓰지 않으면 return을 해서 다시 반환해도 됨.
		}
		else {
			userDAO.delete(id);
			System.out.println("삭제하였습니다.");
		}

	}

}
