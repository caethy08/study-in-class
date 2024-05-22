package pack1;

import java.nio.file.FileSystem;

public class Ex5Main {

	public static void main(String[] args) {
		// 메소드 오버로딩 연습용
		Ex5AnimalOverload tiger = new Ex5AnimalOverload(); 
		//animal 탕비의 객체 Ex5AnimalOverload() 생성. 주소는 tiger이 가지고 있음 
		tiger.display();
		tiger.display(5); 
		//인수(인자, argument)가 메소드의 파라미터(매개변수)와 연결(매핑)되어서 타입, 순서, 개수가 달라야 성립
		tiger.display("호랑이");
		tiger.display("호랭이",2);
		tiger.display(3, "호돌이");
		
		System.out.println("\n생성자 오버로딩----");
		Ex5AnimalOverload dog = new Ex5AnimalOverload();
		dog.display();
		
		Ex5AnimalOverload hen = new Ex5AnimalOverload(2);
		hen.display();
		
		Ex5AnimalOverload wolf = new Ex5AnimalOverload("늑대", 3, 4);
		wolf.display();

	}

}
