package pack1;

import java.time.LocalDate;

public class Ex8Main {

	public static void main(String[] args) {
		// singleton 패턴을 연습하는 곳
		Ex8SingletonClass s1 = new Ex8SingletonClass();
		System.out.println(s1.kor);
		
		Ex8SingletonClass s2 = new Ex8SingletonClass();
		System.out.println(s2.kor);
		
		System.out.println(s1 + " " + s2); //서로 다른 주소를 가짐
		System.out.println(s1.hashCode() + " " + s2.hashCode());
		//s1과 s2에게 같은주소를 주고 싶을 때 singleton 패턴을 사용
		
		System.out.println("----------");
		Ex8SingletonClass s3 = Ex8SingletonClass.getInstence();
		System.out.println(s3.kor);
		
		Ex8SingletonClass s4 = Ex8SingletonClass.getInstence();
		System.out.println(s4.kor);
		
		System.out.println(s3.hashCode() + " " + s4.hashCode());
		
		System.out.println("날짜 출력 싱클톤 사용 예");
		LocalDate mynow = LocalDate.now();
		LocalDate mynow2 = LocalDate.now();
		System.out.println(mynow.hashCode() + " " + mynow2.hashCode());
		System.out.println(mynow2.getYear());
	

	}

}
