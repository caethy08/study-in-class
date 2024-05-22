package pack1;

public class ClassPreseding {
	//클래스 이해 전애 자원의 재활용에 대해 알아보기
	public static void main(String[] args) {
		int su1 =6;
		int su2 = 3;
		
		System.out.println("방법1 사용");
		System.out.println("합은 " + (su1 + su2)); //방법 1  숫자열 더하기 다음 문자열 더하기
		System.out.println("차는" + (su1 - su2));
		//뭔가를 하다가..
		System.out.println();
		//합과 차 구하기 또 필요
		System.out.println("합은 " + (su1 + su2)); //방법 1은 계속해서 써줘야 함
		System.out.println("차는" + (su1 - su2));
		
		System.out.println("\n방법 2사용");
		//별도의 단위 프로그램(unit)을 작성 후 필요할때마다 호출 
		hap(su1, su2); //호출 후 반드시 돌아온다
		cha(su1, su2);
		
		System.out.println("\n방법 3사용 - ClassPre2의 단위 프로그램을 호출");
		//별도의 단위 프로그램(unit)을 작성 후 필요할때마다 호출
		ClassPre2 my = new ClassPre2();
		my.hap(su1, su2);
		my.hap(20, 5);
		my.cha(su1, su2);

	}
	
	public static void hap(int su1, int su2) { //방법 2: 합구하기 코드 별도 작성
		System.out.println("합은 " + (su1 + su2));
	}
	public static void cha(int su1, int su2) {
		System.out.println("차는" + (su1 - su2));
	}
}
