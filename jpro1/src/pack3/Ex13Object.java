package pack3;

//public class Ex13Object extends Object {아래와 동일. extands object를 숨김.단일 상속을 위해서
public class Ex13Object {
	
	@Override
	public String toString() {
		//오버라이딩: 부모의 본래 기능을 자식이 원하는 명령으로 재정의
		return "자바여 영원하라";
	}
	
	public static void main(String[] args) {
		// 최상위 수퍼 클래스 object
		//모든 클래스는 자동으로 object 클래스를 상속 받는다. -자바의 진리
		Ex13Object obj = new Ex13Object();
		System.out.println(obj);//원래 객체변수의 주소가 나오지만 위에서 오버라이딩을 통해 변경해줌
		System.out.println(obj.toString());//위와 동일
		
	}

}
