package pack4;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex31DtoExam {
	ArrayList<Ex31studDto> list = new ArrayList<Ex31studDto>();
	
	public void insertList() {//입력 메소드
		while (true) {	
			try {
				Scanner sc =new Scanner(System.in);
				System.out.print("이름: ");
				String name = sc.next();
				System.out.print("국어: ");
				int kn = sc.nextInt();
				System.out.print("영어: ");
				int en = sc.nextInt();
				
				
				Ex31studDto dto = new Ex31studDto();
				dto.setName(name);
				dto.setKorean(kn);
				dto.setEnglish(en);
				list.add(dto);	
				
				System.out.println("계속할까요?(y/n)");
				if (sc.next().equalsIgnoreCase("n")) break; 
			} catch (Exception e) {
				System.out.println("처리 중 오류 발생: " + e);
				break;
			}
		}
	}
	
	public void showlist() {//출력 메소드
		System.out.println("이름\t국어\t영어\t총점");
		for (Ex31studDto my : list) {
			int tot = my.getKorean() + my.getEnglish();
			System.out.println(my.getName() + "\t" + my.getKorean() 
							+ "\t" + my.getEnglish() + "\t" + tot);
		}
		System.out.println("응시 인원: " + list.size() + "명");	
	}
	
	public static void main(String[] args) {
		Ex31DtoExam dtoexam = new Ex31DtoExam();
		dtoexam.insertList();
		dtoexam.showlist();
	}
}
