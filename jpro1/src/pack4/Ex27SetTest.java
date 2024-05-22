package pack4;

import java.util.HashSet;
import java.util.Iterator;

//collection : 다수의 객체를 담을 수 있는 집합형 자료 구조
public class Ex27SetTest {

	public static void main(String[] args) {
		// set류의 hashset으로 연습 : 중복 불가, 순서 x
		
		Ex27SetTest test = new Ex27SetTest();
		//HashSet<Ex27SetTest> list = new HashSet<Ex27SetTest>();
		//list.add(1);
		//list.add(test);
		
		HashSet<String> list = new HashSet<String>();
		list.add("lee");
		list.add("lee");
		list.add("lee");
		list.add("park");
		list.add("hong");
		//list.remove("park"); //collection의 자료 구조 중 일부를 지움
		//list.clear(); //collection의 자료 구조를 지움
		System.out.println("크기 : " + list.size());
		
		for(Object obj:list) {
			System.out.println(obj);
		}
		
		System.out.println();
		//iterator(반복자) : 개발자가 컨테이너, 특히 리스트를 순회할 수 있게 해주는 객체다
		Iterator iter =list.iterator();
		while(iter.hasNext()) { //hasNext : 포인터를 이동하며 자료가 있으면 자료값을 받아온다
			String ss = (String)iter.next();
			System.out.println(ss);
		}
	}
	
	

}
