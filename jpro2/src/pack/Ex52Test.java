package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Ex52Test {
	private Connection conn;
	private Statement stmt; 
	private ResultSet rs;
	
	
	public Ex52Test() {
		
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("로딩 실패: " + e);
			return;
		}
		
		try {
			String url="jdbc:mariadb://localhost:3306/test";
			conn = DriverManager.getConnection(url, "root", "123");
			
		} catch (Exception e) {
			System.out.println("연결 실패: "+ e.getMessage());
			return;
		}
		
		try {
			Scanner sc = new Scanner(System.in);   
			System.out.print("부서번호 입력:");
			int number = sc.nextInt();
			stmt = conn.createStatement(); 
			rs = stmt.executeQuery("select jikwon_no as 사번, jikwon_name as 이름, buser_name as 부서, jikwon_jik as 직급, jikwon_pay as 연봉 from jikwon INNER join buser ON buser_num = buser_no where buser_num="+number);
			
			System.out.println("사번" + " " + "이름" + " " + "부서" + " " + "직급" + " " + "연봉");
			
			while (rs.next()) {
			int no = rs.getInt(1);
			String name = rs.getString(2); // 칼럼은 순서가 1부터 부여됨
			String buser = rs.getString(3);
			String jik = rs.getString(4);
			int pay = rs.getInt(5);
			
			System.out.println(no + " " + name + " " + buser + " " + jik + " " + pay);
			}
			String sql = "select count(*) from jikwon INNER join buser ON buser_num = buser_no where buser_num="+number;
			rs = stmt.executeQuery(sql);
			rs.next();
			
			System.out.println("건수 : " + rs.getString(1));
		
		} catch (Exception e) {
			System.out.println("처리 실패: "+ e.getMessage());
		} finally {
			try {
				if (rs != null)  rs.close();
				if (stmt != null)  stmt.close();	
				if (conn != null)  conn.close();	
			} catch (Exception e2) {
				
			}
		}
	}
	
	public static void main(String[] args) {
		new Ex52Test();

	}

}
