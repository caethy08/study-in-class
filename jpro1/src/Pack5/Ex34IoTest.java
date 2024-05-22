package Pack5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex34IoTest {

	public static void main(String[] args)throws Exception {
		// console과 file을 통한 입력
		//1. console을 통한 입력-최근에는 잘 사용하지 않음
		/*
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		System.out.println("이름은");
		String ir = br.readLine();//throw로 던져버려서 오류 처리
		System.out.println("이름은" + ir);
		br.close();
		in.close(); //문을 닫아준다
		 */
		
		//2. scanner을 통한 입력
		/*
		Scanner scanner = new Scanner(System.in);
		System.out.println("이름은");
		String ir = scanner.nextLine();
		System.out.println("몸무게는");
		double w = scanner.nextDouble();
		System.out.println(ir + "님의 몸무게는 " + w);
		scanner.close();
		*/
		
		//파일 읽기
		File f = new File("c:\\work\\good.txt");
		//문자일 경우 문자 단위로 사용
		FileReader fr = new FileReader(f); //파일을 읽는 키워드 filereader
		BufferedReader br = new BufferedReader(fr); //버퍼는 선택사항
		System.out.println(br.readLine());//한줄 출력
		while (true) {//무한 반복
			String ss = br.readLine();
			if(ss == null) break; //ss가 null값을 가지면(끝을 만나면) 빠져나옴
			System.out.println(ss);
		}
		br.close(); //버퍼 닫기  garbage collecter(gc)로 하여금 점유 메모리 해제 요청> gc가 빨리 찾음
		fr.close(); //파일리더 닫기
		
		System.out.println("전국 도서관 정보 파일 일부 읽기-------");
		File file = new File("c:/work/전국도서관표준데이터.csv");
		FileReader fr2 = new FileReader(file);
		BufferedReader br2 = new BufferedReader(fr2);
		int count = 0;
		String ss = br2.readLine();
		while (true) {
			count++;
			ss = br2.readLine();
			if (ss == null || count > 10) break; //더이상 읽을 정보값이 없고 || count가 10회 미만으로 돌릴때 break.
				StringTokenizer tok = new StringTokenizer(ss, ",");
				String s1 = tok.nextToken();
				String s2 = tok.nextToken();
				String s3 = tok.nextToken();
				String s4 = tok.nextToken();
				
				System.out.println(s1 + "\t" + s2 + "\t"  + s3 + "\t" + s4);		
		}
		System.out.println("건수 : " + count);
	}

}
