package lambda;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import javax.management.loading.PrivateClassLoader;

public class MyLambda5Db {

	public MyLambda5Db() {
		// Consumer 인터페이스는 accept()를 갖고 있다.
		// 주로 Collection API의 for each에서 주로 사용
		abc();
		
		System.out.println();
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("Driver loading fail : " + e);
			return;
		}
		queryTable("select * from sangdata", rs -> {
			System.out.println("처리 2");
			try {
				while (rs.next()) {
					System.out.println(rs.getString("code") + " " + rs.getString("sang") + " " + rs.getString("su") + " " + rs.getString("dan"));
					
				}
			} catch (Exception e) {
				System.out.println("err : + e");
			}
		});
		
	}
	
	private void abc() {
		
		Consumer<Integer> printInt = i -> System.out.println(i);
		
		List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		numbers.forEach(printInt);	//consumer객체 printint를 주는데 printint는 람다 표현식을 가지고 있따

	}
	
	private void queryTable(String sql, Consumer<ResultSet> consumer) {
		//try문에 매개 변수를 줄 수 있다. try with resource 문법에 준함
		try(Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/test","root","123");
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
				System.out.println("처리 1");
				consumer.accept(rs); //28번문으로 이동
				System.out.println("처리 3");
				
				rs.close();
				pstmt.close();
				conn.close();
		} catch (Exception e) {
			System.out.println("queryTable err : " + e);
		}
	}
	public static void main(String[] args) {
		new MyLambda5Db();

	}

}
