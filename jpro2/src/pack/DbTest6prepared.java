package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//preparedstatement : 선처리 방식이 가능, SQL문에 입력자료 적용 시 ? 연산자 사용 가능 > secure coding 가이드라인에 맞춘다
public class DbTest6prepared {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public DbTest6prepared() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		
			String url="jdbc:mariadb://localhost:3306/test";
			conn = DriverManager.getConnection(url, "root", "123");
			
			String sql = " ";
			
			/*
			//자료 추가
			sql = "insert into sangdata values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "10");
			pstmt.setString(2, "신상품");
			pstmt.setInt(3, 12);
			pstmt.setString(4, "5000");
			int re = pstmt.executeUpdate();			
			System.out.println("insert 반환 값 : " + re);
			*/
			
			/*
			//자료 수정
			sql = "update sangdata set sang=?, su=? where code=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "아메리카노");
			pstmt.setInt(2, 33);
			pstmt.setInt(3, 10);
			
			int re = pstmt.executeUpdate();
			System.out.println("insert 반환 값 : " + re);
			*/
			
			//자료 삭제
			sql = "delete from sangdata where code=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 10);
			if (pstmt.executeUpdate() >= 1) {
				System.out.println("삭제 성공");
			} else {
				System.out.println("삭제 실패");
			}
			
			//전체 자료 읽기
			sql = "select * from sangdata";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); //sql문장을 사용하지 않는다
			
			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4)); 
			}
			
			System.out.println();
			// 부분 자료 읽기
			String no = "2";  //외부에서 값을 받았다고 가정
			//sql = "select * from sangdata where code=" + no;  // 이렇게 작성할 경우 sql injection 대상이 될 수 있다.
			//secure coding 가이드라인에 맞춰서 코딩한다면
			sql = "select * from sangdata where code=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no); //첫번째 ?에 no가 대응, 매핑되는 데이터 타입에따라 타입이 바뀐다
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println(rs.getString("code") + " " + rs.getString("sang") + " " + rs.getString("su") + " " + rs.getString("dan"));
			}
			
		} catch (Exception e) {
			System.out.println("accDb err : " + e);
		}
	}
	
	public static void main(String[] args) {
		new DbTest6prepared();

	}

}
