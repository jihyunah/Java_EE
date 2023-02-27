package student.dao;

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
			System.out.println("****************");
			System.out.println("관리");
			System.out.println("****************");
			System.out.println("1. 입력");
			System.out.println("2. 검색");
			System.out.println("3. 삭제");
			System.out.println("4. 종료");
			System.out.println("****************");
			System.out.print("번호선택 :");
			int number = scanner.nextInt();

			if (number == 4) {
				break;
			} else if (number == 1) {
				insertArticle();
			} else if (number == 2) {
				selectArticle();
			} else if (number == 3) {
				deleteArticle();
			}
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
		// 접속은 한번만 하는것이 아니기 때문에 생성자에서 하면 안됨.
	}

	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password);/* 오라클 드라이버 */
			System.out.println("connection 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertArticle() {
		String name = null;
		String value = null;
		while (true) {
			System.out.println("****************");
			System.out.println("1. 학생");
			System.out.println("2. 교수");
			System.out.println("3. 관리자");
			System.out.println("4. 이전메뉴");
			System.out.println("****************");
			System.out.print("번호 선택 : ");
			int number = scanner.nextInt();

			if (number == 4) {
				break;
			}
			System.out.print("이름 입력 : ");
			name = scanner.next();
			if (number == 1) {
				System.out.print("학번 입력 : ");
				value = scanner.next();

			} else if (number == 2) {
				System.out.print("과목 입력 : ");
				value = scanner.next();

			} else if (number == 3) {
				System.out.print("부서 입력 : ");
				value = scanner.next();

			}
			this.getConnection(); // 접속
			String sql = "INSERT INTO STUDENT2 VALUES(?, ?, ?)";
			try {
				pstmt = conn.prepareStatement(sql); // 생성
				// ?에 데이터 대입
				pstmt.setString(1, name);
				pstmt.setString(2, value);
				pstmt.setInt(3, number);

				int su = pstmt.executeUpdate(); // 실행 - 개수 리턴
				System.out.println(su + " 행이(가) 삽입되었습니다.");
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstmt != null)
						pstmt.close();
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public void selectArticle() {
		String name = null;
		String sql = null;
		while (true) {
			System.out.println("****************");
			System.out.println("1. 이름 검색 (1개 글자가 포함된 이름은 모두 검색)");
			System.out.println("2. 전체 검색");
			System.out.println("3. 이전메뉴");
			System.out.println("****************");
			System.out.print("번호선택 : ");
			int number = scanner.nextInt();

			if (number == 3) {
				break;
			} else if (number == 1) {
				System.out.print("검색할 이름 입력: ");
				name = scanner.next();

			} else if (number == 2) {
				sql = "select * from student2";
			}
			getConnection();

			if (number == 1) {
				sql = "select * from student2 where name like ?";
			} else if (number == 2) {
				sql = "select * from student2";
			}

			try {
				pstmt = conn.prepareStatement(sql); // 생성
				// ?에 데이터 대입
				if (number == 1) {
					pstmt.setString(1, "%" + name + "%");
				}
				rs = pstmt.executeQuery();

				while (rs.next()) {
					System.out.print("이름 = " + rs.getString("name") + "\t");

					if (rs.getInt("code") == 1) {
						System.out.println("학번 = " + rs.getString("value"));
					} else if (rs.getInt("code") == 2) {
						System.out.println("과목 = " + rs.getString("value"));
					} else if (rs.getInt("code") == 3) {
						System.out.println("부서 = " + rs.getString("value"));
					}

				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstmt != null)
						pstmt.close();
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void deleteArticle() {
		System.out.print("삭제할 이름 입력 : ");
		String name = scanner.next();

		getConnection();
		String sql = "DELETE STUDENT2 WHERE NAME=?";
		try {
			pstmt = conn.prepareStatement(sql); // 생성
			// ?에 데이터 대입
			pstmt.setString(1, name);

			int su = pstmt.executeUpdate(); // 실행 - 개수 리턴
			System.out.println(su + " 행이(가) 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		Student s = new Student();
		s.menu();
		System.out.println("프로그램을 종료합니다.");
	}

}
