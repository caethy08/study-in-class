package pack3;

public class Ex14Main {

	public static void main(String[] args) {
		// 개과의 동물들을 상속으로 처리
		Ex14Dog dog = new Ex14Dog();
		dog.printMsg();
		System.out.println(dog.callName());
		
		System.out.println("HouseDog-------");
		Ex14HouseDog hd = new Ex14HouseDog("집개");
		hd.printMsg();
		System.out.println(hd.callName());
		
		System.out.println("WolfDog-------");
		Ex14WolfDog wolfdog = new Ex14WolfDog("늑대");
		wolfdog.printMsg();
		System.out.println(wolfdog.callName());
		System.out.println();
		wolfdog.display();
		
		System.out.println("\n주소 치환********");
		Ex14WolfDog bushDog = wolfdog; //같은 타입의 변수에게 주소를 치환
		bushDog.printMsg();
		wolfdog.printMsg();
		
		System.out.println();
		//Ex14HouseDog hd2 = wolfdog; //type missmatch에러 
		Ex14Dog dog2 = wolfdog; //ex14dog타입의 dog2에게 wolfdog타입의 wolfdog의주소를 치환. 
		//타입은 다르지만 부모변소에 자식변수 주소 치환 가능(promotion)
		dog2.printMsg();
		
		Ex14Dog dog3 = new Ex14Dog();
		dog3.printMsg();//부모 객체변수
		//Ex14WolfDog wolfDog2 = dog3;  //자식 객체변수의 부모변수 주소 치환은 불가능하다.
		//wolfdog = dog3;
		
	}

}
