package user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserUpdateService implements UserService {

	@Override
	public void execute() {
		Scanner scanner = new Scanner(System.in);
		System.out.println();
		
		System.out.print("찾고자 하는 아이디 입력 : ");
		String id = scanner.next();
		
		UserDAO userDAO = UserDAO.getInstance();
		UserDTO userDTO = userDAO.getUser(id);
		
		if(userDTO == null) {
			System.out.println("아이디가 없습니다.");
			//return; else를 쓰지 않으면 return을 해서 다시 반환해도 됨.
		}
		else {
			System.out.println();
			System.out.println("이름\t아이디\t비밀번호");
			System.out.println(userDTO.getName() + "\t" + userDTO.getId() + "\t" + userDTO.getPwd());
		
			System.out.println();
			System.out.print("변경할 이름 입력 : ");
			String name = scanner.next();
			System.out.print("변경할 비밀번호 입력 : ");
			String pwd = scanner.next();
			
			Map<String, String> map = new HashMap<>();
			map.put("name", name);
			map.put("id", id);
			map.put("pwd", pwd);
			
			userDAO.update(map);
			
			System.out.println("데이터를 수정하였습니다.");
		}
		

	}

}
