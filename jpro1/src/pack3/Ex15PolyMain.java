package pack3;

public class Ex15PolyMain {

	public static void main(String[] args) {
		Ex15PolyCar car1 = new Ex15PolyCar();
		Ex15PolyBus bus1 = new Ex15PolyBus();//polybus의 생성자로 가나 생성자가 생략되어 부모인 polycar의 생성자를 가지고 온다
		Ex15PolyTaxi taxi1 = new Ex15PolyTaxi();
		
		System.out.println();
		car1.displaySpeed();
		System.out.println(car1.getSpeed());
		
		System.out.println();
		bus1.displaySpeed();
		System.out.println(bus1.getSpeed());
		bus1.show();
		
		System.out.println();
		taxi1.displaySpeed();
		System.out.println(taxi1.getSpeed());
		
		System.out.println("~~객체 주소 치환~~");
	
		Ex15PolyCar car2 = new Ex15PolyBus();//promotion
		car2.displaySpeed(); //오버라이딩된 메소드는 부모 객체의 이름으로 자식의 객체호출 가능 그러나 자식 고유위 멤버는 불가능
		System.out.println(car2.getSpeed());
		//car2.show(); //에러: 오버라이딩 하지 않는 고유메소드는 불간섭의 원칙에 따라 간섭 불가능
		//자식 고유의 메소드는 부모 메소드가 간섭(호출) 불가
		
		System.out.println();
		Ex15PolyCar car3 = taxi1; //promotion
		System.out.println("주소 확인 :" + car3 + " " + taxi1);
		car3.displaySpeed();
		System.out.println(car3.getSpeed());
		
		
		System.out.println("===============");
		//Ex15PolyBus bus2 = new Ex15PolyCar(); //X 
		
		Ex15PolyBus bus3 = (Ex15PolyBus)car2; //type mismatch car2는 폴리버스의 속성을 가짐 > casting가능
		//car2는 부모 타입이지만 자식인 bus의 주소를 갖고 있으므로 casting에 의해 치환이 가능 //클래스 casting
		bus3.displaySpeed();
		
		System.out.println();
		//Ex15PolyTaxi taxi2 = new Ex15PolyCar(); //x 부모탕비의 인스턴스 가질 수 없다
		Ex15PolyTaxi taxi2 = (Ex15PolyTaxi)car3; //성립: casting
		taxi2.displaySpeed();
		
		//Ex15PolyTaxi taxi3 = (Ex15PolyTaxi)car1;//실행오류(runtime error):문법상 에러는 아니나 실행 시 에러(런타임에러)
		//car1이 polytaxi의 속성을 하나도 가지지 않기 때문에 문법적으로는 괜찮으나 실행되지 않음
		System.out.println("^^^^^^^^^^^^^^^^^^^^");
		Ex15PolyCar mycar;
		mycar = bus1;
		mycar.displaySpeed();
		
		System.out.println();
		mycar = taxi1;
		mycar.displaySpeed();
		
		System.out.println();
		Ex15PolyCar p[] = new Ex15PolyCar[3];
		p[0] = car1;
		p[1] = bus1;
		p[2] = taxi1;
		for(Ex15PolyCar poly:p) {
			poly.displaySpeed();
		}
	}

}
