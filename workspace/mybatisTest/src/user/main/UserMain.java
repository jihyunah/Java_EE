package user.main;

import java.util.Scanner;

import user.service.UserInsertService;
import user.service.UserSelectService;
import user.service.UserService;

public class UserMain {
	
	public void menu() {
		Scanner scan = new Scanner(System.in);
		UserService userService =  null; //부모 (interface) 생성. null값으로. --> 리모컨 역할!
		int num;
		
		while(true) {
			System.out.println();
			System.out.println("*******************");
			System.out.println("1. 입력 ");
			System.out.println("2. 출력 ");
			System.out.println("3. 수정 ");
			System.out.println("4. 삭제 ");
			System.out.println("5. 검색 ");
			System.out.println("6. 종료 ");
			System.out.println("*******************");
			System.out.println("번호 입력 : ");
			num = scan.nextInt();
			
			if(num == 6) break;
			
			//클래스의 개수가 적으면 1:1관계로 생성해도 상관없다. 
			//but 클래스의 개수(100개)가 많으면, 객체도 100개가 필요하다. 
			//그래서 결합도 낮추기! --> 다형성 => 부모 = 자식을 참조.(상속)
			
			if(num == 1) {
				userService = new UserInsertService();//부모 = 자식, 다형성 
				
				
			}else if( num ==2) {
				userService = new UserSelectService();
				
			}
			
			userService.execute();//호출 
			
			
		}//while
	}
	
	public static void main(String[] args) {
		UserMain userMain = new UserMain(); //클래스 생성
		userMain.menu();
		System.out.println("프로그램을 종료합니다. ");
		
	}
}
