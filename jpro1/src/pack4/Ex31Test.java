package pack4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Ex31Test {
	
	ArrayList<Ex31studDto> list = new ArrayList<Ex31studDto>();
	Ex31studDto dto;
	
	public void aList() {	
		boolean b =true;
		while (b) {			
			Scanner sc =new Scanner(System.in);
			System.out.print("이름을 입력: ");
			String name = sc.next();
			System.out.print("국어점수를 입력: ");
			int kn = sc.nextInt();
			System.out.print("영어점수를 입력: ");
			int en = sc.nextInt();
			
			
			dto = new Ex31studDto();
			dto.setName(name);
			dto.setKorean(kn);
			dto.setEnglish(en);
			list.add(dto);	
			
			
			System.out.println("계속할까요?(y/n)");
			String n =sc.next();
			if (n.equalsIgnoreCase("n")) {
				b = false;
			}			
		}
		
		for (int i = 0; i < list.size(); i++) {
			Ex31studDto all = list.get(i);
			System.out.println("이름" + "국어" + "영어" + "총점");
			System.out.println(all.getName() + all.getKorean() + all.getEnglish() + (all.getKorean() + all.getEnglish()));
		}
		
	}
	
	public void bList() {
		System.out.println("응시인원" + list.size() + "명");
		
	}
	public static void main(String[] args) {
		Ex31Test dtoTest = new Ex31Test();
		dtoTest.aList();
		dtoTest.bList();
	}
}
