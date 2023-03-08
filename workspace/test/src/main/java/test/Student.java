package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Student {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "1234";

	Scanner scanner = new Scanner(System.in);

	public void menu() {
		while (true) {
			System.out.println();
			System.out.println("***************");
			System.out.println("관리");
			System.out.println("***************");
			System.out.println("1. 입력 ");
			System.out.println("2. 관리 ");
			System.out.println("3. 삭제 ");
			System.out.println("4. 종료 ");
			System.out.println("***************");
			System.out.println("번호 선택 : ");
			int num = scanner.nextInt();

			if (num == 4)
				break;

			if (num == 1)
				insertArticle();
			else if (num == 2)
				selectArticle();
			else if (num == 3)
				deleteArticle();
		}
	}

	public Student() {
		// driver loading
		try {
			Class.forName(driver); // Class타입으로 생성
			System.out.println("driver loading 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	} // 접속은 한번만 하는 것이 아니기 때문에 생성자에서 하면 안된다. getConnection()

	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("connection 성공 ");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void deleteArticle() {
		// TODO Auto-generated method stub

	}

	private void selectArticle() {
		// TODO Auto-generated method stub

	}

	private void insertArticle() {
		String name = null;
		String value = null;

		while (true) {
			System.out.println("***********");
			System.out.println("1. 학생 ");
			System.out.println("2. 교수 ");
			System.out.println("3. 관리자 ");
			System.out.println("4. 이전 메뉴 ");
			System.out.println("***********");
			System.out.println("번호 선택 : ");
			int number = scanner.nextInt();

			if (number == 4)
				break;

			System.out.println("이름 입력 : ");
			name = scanner.next();

			if (number == 1) {
				System.out.println("학번 입력 : ");
				value = scanner.next();
			}

			else if (number == 2) {
				System.out.println("과목 입력 : ");
				value = scanner.next();
			}

			else if (number == 3) {
				System.out.println("부서 입력 : ");
				value = scanner.next();
			}

			this.getConnection(); // 접속
			String sql = "insert into student2 values(?,?,?)";

			try {
				pstmt = conn.prepareStatement(sql); // 생성
				// ?에 데이터 대입
				pstmt.setString(1, name);
				pstmt.setString(2, value);
				pstmt.setInt(3, number);

				int su = pstmt.executeUpdate(); // 실행 - 개수 리턴
				System.out.println(su + " 행이(가) 삽입되었습니다. ");

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstmt != null)
						pstmt.close();
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public static void main(String[] args) {

	}

}
