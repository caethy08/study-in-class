package pack;

import java.util.Scanner;

public class Test9while {

	public static void main(String[] args) {
		// 반복문 while
		// while(조건) {실행문들...}
		int w = 1;
		while (w <= 5) {
			System.out.print("w=" + w + " ");
			w++;
		}
		System.out.println("\nwhile 수행 후 w:" + w);

		System.out.println();
		int count = 0;
		while (count < 5) {
			count++;
			System.out.println("count : " + count);
			if (count == 3) {
				System.out.println("쉬어가기");
			}
			if (count == 5) {
				System.out.println("count가 5라서 종료:" + count);
			}
		}

		System.out.println();
		w = 0;
		while (true) {// 무한 루프
			w++;
			if (w == 5)
				break;
			if (w == 3)
				continue;
			System.out.println("w는 " + w);
		}

		System.out.println();
		// factorial n!은 1부터 n까지의 모든 정수의 곱의 결과를 의미한다
		// ex. 5! = 5*4*3*2*1 = 120
//		Scanner scanner = new Scanner(System.in);
//		System.out.print("정수 입력:");
//		int number = scanner.nextInt(); //API를 가져다 적용한것
		int number = 5;
		// factorial 계산을 위한 초기값 설정
		int factorial = 1;
		int i = 1; // 반복을 위한 counter 변수
		while (i <= number) {
			// System.out.println(i);
			factorial *= i;
			i++;
		}
		System.out.printf("number는 %d factorial은 %d이다", number, factorial);

		System.out.println("\n다중 while ----");
		int a = 1;
		while (a <= 3) {
			System.out.println("a:" + a);
			int b = 1;
			while (b <= 4) {
				System.out.print("b:" + b);
				b++;
			}
			a++;
			System.out.println();
		}
		System.out.println();
		/*
		// 키보드로 입력받은 숫자에 대해 1부터 시작해 그 숫자까지 모든 수에 나누기를 시도하고
		// 나누어 떨어지는 경우(약수) 그 수를 출력한다.
		// 0이나 음수를 입력하면 프로그램 종료
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print("정수 입력(0이나 음수면 종료):");
			int num = scanner.nextInt();
			if (num <= 0) {
				System.out.println("프로그램 종료");
				break;
			}
			System.out.println(num + "의 약수는");
			int divisor = 1; //약수를 찾기 위해 1부터 시작
			while(divisor <= num) {
				if(num % divisor == 0) {
					System.out.println(divisor); //약수 출력
				}
				divisor++; //다음 수로 이동
			}
		}
	 	*/
		System.out.println();
		//do{반복 수행문...}while(조건);
		int k = 10;
		do {//최소 1회는 수행
			System.out.println("k : " + k);
			k = k + 1; 
		}while(k <= 5);
		
		System.out.println("exam -------");
		//문1) 1~100사이의 정수 중 3의 배수이지만 2의 배수가 아닌 수를 출력하고, 합과 갯수도 출력
		System.out.println("문제 1");
		int bae = 1;
		int hap = 0;
		int gaesu = 0;
				while( bae <= 100) {
					if(bae % 3 == 0 && bae % 2 != 0) {
					System.out.print(bae + " ");	
					hap += bae; //누적
					gaesu +=1; //1씩 늘어나도록
				}
					bae++;					
			}
				System.out.println();
				System.out.println("합: " + hap + "갯수: " + gaesu);
				
		//문2) -1, 3,-5,7,-9,11 ...99까지의 합 출력
				System.out.println();
				System.out.println("문제 2 -------");
				int gae = 1, cnt = 1, hol = 0;
				while( gae < 100) {
					if(cnt % 2 == 0) {
						hol += gae;
						System.out.println("짝수" + gae);
					}else {
						int imsi = gae * -1;
						hol += imsi;  //부호 변경 후 누락
					System.out.println("홀수" + imsi);						
					}
					//System.out.println(gae);
					gae += 2;
					cnt += 1;
				}
			System.out.println("while합은 " + hol + "입니다");
			
			//for로 출력
			int hap2 = 0, cnt2 = 1;
			for(int c = 1; c < 100; c += 2) {
				if(cnt2 % 2 == 0) {
					hap2 += c;
				}else {
					hap2 += (-1) * c;
				}
				cnt2++;
			}
			System.out.println("for의 합은 " + hap2 + "입니다");
		
		//문3) 1~100사이의 정수 중에서 소수와 그 갯수를 출력
		//소수 : 1보다 크며 1과 그 수 자체 이외의 다른 수로는 나누어 떨어지지 않는 수
		//힌트 : 1은 소수가 아니므로 2부터출발
				System.out.println();
				System.out.println("문제 3------");
				int aa = 2;
				int count2 = 0;
				int su2 = 0;
				System.out.println("1부터 100까지의 소수");
				while(aa <= 100) {
					boolean imsi = false;
					
					int bb = 2;
					//System.out.println(aa - 1);
					while(bb <= aa -1) {
						if(aa % bb == 0) {
							imsi =true;
						}
						bb++;
					}
					if(imsi == false) {
						System.out.print(aa + " ");
						count2 ++;
					}
					aa++;
				}
				System.out.println("\n건수 :" + count2);
				
				System.out.println("2부터 그 숫자의 제곱근 까지의 모든 수로 나누어 떨어지는지 확인");
				//소수를 찾는 이유로 제곱근까지만 검사하는 것은 어떤 수의 약수는 그 수의 제곱근을 넘지 않기 때문
				int num = 2;  //1이 소수가 아니기 때믄에 2부터 출발
				int count3 = 0; //소수의 건수
				System.out.println("1부터 100까지의 소수");
				while(num <= 100) {
					boolean isPrime = true;   //현재 숫자다 소수인지 판별
					int dvisor =2;   //나누는 수는 2부터 시작
					while(dvisor <= Math.sqrt(num)) {
						if(num % dvisor == 0) {
							isPrime = false;
						break;  //나누어 떨어지지 않으묜 더 이상의 검사는 필요 없다					
					}
					dvisor++;
				}
				
				if(isPrime) {  //if(isPrime == true)과 같은 뜻{
					count3++;  //소수의 갯수 증가
					System.out.println(num + " ");
				}
				num++;
				}
				System.out.println("\n 건수 : " + count2);
	}
}
	
