package pack;

public class Test10array {

	public static void main(String[] args) {
		// 배열(array) : 성격과 크기가 일치하는 복수 개의 기억장소에 대해 대표명 하나를 주고 첨자(index)로 각 기어강소를 구분
		//반복처리에 효과적
		
		int aa; //기억장소 한개 선언
		//int ar[]; //배별로 선언  int[] ar;
		//ar = new int[5];
		int ar[] = new int[5];
		System.out.println("배열 크기 : " + ar.length);
		ar[0] = 10;
		ar[1] = 20;
		ar[4] = ar[0] + ar[1] + ar[2]; //첨자(index)로 각 기억장소를 호출
		System.out.println(ar[4]);
		//ar[5] = 50; //런타임 오류(실행 오류): ArrayIndexOutOfBoundsException/5번째 기억장소 없음 > 에러
		int a = 4, b = 4;
		System.out.println(ar[4] + " " + ar[a] + " " + ar[b] + " " + ar[1 + 3]);
		
		System.out.println();
		int[] ar1 = {1,2,3,4,5};  //배열 선언과 동시에 값을 기억
		System.out.println(ar1[0] + " " + ar1[1] + " " + ar1[2]);
		//반복문으로 배열 자료 출력
		for(int i = 0; i < ar1.length; i++) {
			System.out.println(ar1[i] + " ");
		}
		
		//향상된 for : 배열, 컬렉션에서 사용가능
		for (int i : ar1) {//ar1의 타입을 적어주고 변수 i
			System.out.print(i + " ");
			
		}
		
		System.out.println();
		String city[] = {"서울", "대전", "제주"};
		System.out.println(city[0] + " " + city[1] + " " + city[2]);
		
		for(String lee : city) {
			System.out.print(lee + " ");
		}
		System.out.println();
		
		System.out.println("배열의 값 저장 후 출력 ---");
		int[] ar2 = new int[5];
		int tot = 0;
		for(int i = 0; i < ar2.length; i++) {
			ar2[i] = i + 1; //i번째에 1을 주다
		}
		for(int i = 0; i < ar2.length; i++) {
			System.out.print(ar2[i] + " ");
			tot += ar2[i];
		}
		System.out.println("ar2 요소 값 총합 : " + tot);
		
		System.out.println("\n다차원 배열 ----");
		// int au[] = new int [12];  1차원 배열로 요소 수 12개
		int su[][] = new int[3][4];  //2차원 배열로 요소 수 12개
		su[0][0] = 100;
		System.out.println(su[0][0]);
		System.out.println("행수:" + su.length + ", 열수:" + su[0].length);
		
		//2차원 배열의 값 저장
		int num = 10;
		for (int i = 0; i < su.length; i++) {
			for (int j = 0; j < su[i].length; j++) {
				su[i][j] = num++;
				//su[i][j] = num++; // 들어가는 값이 다르다. 11
			}
		}
		System.out.println(su[0][0] + " " + su[2][0]);
		for (int i = 0; i < su.length; i++) {//2차원 배열이어서 for이 2번 들어감
			for (int j = 0; j < su[i].length; j++) {
				System.out.print(su[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("위 소스를 향상된 for로 출력");
		for(int[] row:su) {
			for(int ele:row) {
				System.out.println(ele + " ");
			}
			System.out.println();
		}
		
		System.out.println("가변 배열: 행마다 요소의 개수가 동적");
		int[][] scores = new int [2][];
		scores[0] = new int[2];
		scores[1] = new int[3];
		System.out.println(scores.length + " " + scores[0].length + " " + scores[1].length);
		
		System.out.println();
		int [][] jum = {{90,87},{88,99,100}};  //가변 배열 선언 후 값 저장
		for (int i = 0; i < jum.length; i++) {
			for (int j = 0; j < jum[i].length; j++) {
				System.out.print(jum[i][j] + " ");
				
			}
			System.out.println();
			
		}
	}

}
