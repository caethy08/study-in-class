package pack;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class DbTest2CRUD {
	private Connection conn;
	private Statement pstmt;
	private ResultSet rs;
	private Properties prop = new Properties();
	
	public DbTest2CRUD() { // secure coding의 하나로 연결정보 별도 저장 후 읽기
		
		try {
			prop.load(new FileInputStream("C:\\work\\jsou\\jpro2\\src\\pack\\dbTest2")); 
		
		   Class.forName(prop.getProperty("driver"));
		   conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"), prop.getProperty("passwd"));
		   
		   pstmt = conn.createStatement();
		   
		   String sql = "";
		   
		   //자료 추가
		   //auto commit이 기본
		   //sql = "insert into sangdata values(5, '새우깡', 55,3000)";
		   //pstmt.executeUpdate(sql); //insert, update, delete
		  
		   /*
		 //auto commit을 수동으로 전환해 작업 : Transaction 처리가 필요
		   conn.setAutoCommit(false); //수동으로 전환 > 마무리 작업 필요
		   sql = "insert into sangdata values(6, '감자깡', 7,3000)";
		   pstmt.executeUpdate(sql); //transaction 시작
		   sql = "insert into sangdata values(7, '고구마깡', 17,2000)";
		   pstmt.executeUpdate(sql);
		  // conn.rollback(); //transaction 종료 및 클라이언트에서 입력한 내용 취소
		   conn.commit(); // transaction끝 - 클라이언트에서 입력한 자료를 원격 DB의 저장
		   conn.setAutoCommit(true); //자동으로 전환
		   */
		   
		   // 자료 수정
		  // sql = "update sangdata set sang = '데일리 콤부차', su=12, dan=8000 where code=5";
		  // pstmt.executeUpdate(sql);
		   
		   //자료 삭제
		   sql = "delete from  sangdata where code >= 5";
		  // pstmt.executeUpdate(sql);
		   //insert, update, delete는 수행 후 처리 수만큼 행의 개수를 반환/ update와 delete는 여러개가 처리 될 수 있다. insert는1
		   int result = pstmt.executeUpdate(sql);
		   System.out.println("result : " + result);
		   if(result == 0) System.out.println("삭제 실패");
		   
		   //모든 자료 읽기
		   sql = "select * from sangdata order by code desc";
		   rs = pstmt.executeQuery(sql); //select
		   int cou = 0;
		   while(rs.next()) {
			   System.out.println(rs.getString("code") + " " + rs.getString("sang") + " " + rs.getString("su") + " " + rs.getString("dan"));
			   
			   cou++;
		   }
		   System.out.println("전체 자료수: " + cou);
		   
		 //부분 자료 읽기
		   sql = "select * from sangdata where code = 1";
		   rs = pstmt.executeQuery(sql);
		   if (rs.next()) {
			   System.out.println(rs.getString("code") + " " + rs.getString("sang") + " " + rs.getString("su") + " " + rs.getString("dan"));

		}else {
			System.out.println("해당 자료는 없어요");
		}
		
		} catch (Exception e) {
			System.out.println("err : " + e);
		} finally {
			try {
				if (rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}
	
	public static void main(String[] args) {
		new DbTest2CRUD();

	}

}
