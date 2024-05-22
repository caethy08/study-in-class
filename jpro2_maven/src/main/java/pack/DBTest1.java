package pack;

import java.nio.channels.SelectableChannel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;

//mariaDB(원격 DB서버) 연동 프로그래밍
public class DBTest1 {
	private Connection conn; //connection 객체가 있어야 연결 가능
	private Statement stmt; //연결을 통해 자바프로그램은 db에게 sql문 전송, db는 처리된 결과를 자바프로그램쪽으로 전달한다
	private ResultSet rs;
	
	public DBTest1() {
		// 1. Driver file loading
		try {
			//maria DB ver.
			Class.forName("org.mariadb.jdbc.Driver");        // jdbc패키지에 있는 드라이버 사용	
			//oracle ver.
			//mysql ver.
		} catch (Exception e) {
			System.out.println("로딩 실패: " + e);
			return;
		}
		//2. DB서버와 연결
		try {
			String url="jdbc:mariadb://localhost:3306/test";
			conn = DriverManager.getConnection(url, "root", "123");
			
		} catch (Exception e) {
			System.out.println("연결 실패: "+ e.getMessage());
			return;
		}
		
		//3. 연결된 DB server에 SQL 실행
		try {
			// sangdata 테이블 자료 읽기
			stmt = conn.createStatement(); //스테이트먼트
			
			//rs = stmt.executeQuery("select*from sangdata"); //*을 사용해 전체 읽기 가능
			rs = stmt.executeQuery("select code, sang, su, dan from sangdata"); // 그러나 하나하나 호출하는 방법 추천
			//System.out.println( rs.next()); // cursor(레코드 포인터) 이동
			//rs.next();
			//System.out.println(rs.getString("sang"));
			
			while (rs.next()) {
				String code = rs.getString("code");
				String sangname = rs.getString("sang");
				int su = rs.getInt("su");
				int dan = rs.getInt("dan");
				System.out.println(code + " " + sangname + " " + su + " " + dan);
			}
			
			System.out.println("---------------");
			rs.close(); //resultes를 닫고, 아래에서 다시 열기
			
			rs = stmt.executeQuery("select code as 코드, sang as상품명, su, dan from sangdata"); // 객체 생성
			// String sql = "select count(*) as cou from sangdata"; //별명이 변경되면 아래도 바꾸어주어야 한다
			while (rs.next()) {
				String code = rs.getString("코드");
				String sangname = rs.getString(2); // 칼럼은 순서가 1부터 부여됨
				int su = rs.getInt(3);
				int dan = rs.getInt("dan");
				System.out.println(code + " " + sangname + " " + su + " " + dan);
			}
			//String sql = "select count(*) as 건수 from sangdata";
			String sql = "select count(*) from sangdata";
			rs = stmt.executeQuery(sql);
			rs.next();
			//System.out.println("건수 : " + rs.getString("cou")); 
			//System.out.println("건수 : " + rs.getString("count(*)")); // 별명을 사용하지 않아 그대로 사용
			System.out.println("건수 : " + rs.getString(1)); // 1번째 사용

		} catch (Exception e) {
			System.out.println("처리 실패: "+ e.getMessage());
		} finally {
			try {
				if (rs != null)  rs.close();
				if (stmt != null)  stmt.close();	
				if (conn != null)  conn.close();	
			} catch (Exception e2) {
				// 캐치로 잡을 것 x
			}
			
		}
		System.out.println("go");
	}
	
	public static void main(String[] args) {
		new DBTest1();

	}

}
