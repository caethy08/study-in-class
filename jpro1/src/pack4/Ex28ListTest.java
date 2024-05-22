package pack4;

import java.util.ArrayList;
import java.util.Iterator;

public class Ex28ListTest {

	public static void main(String[] args) {
		// List류의 ArrayList로 연습 : 중복 가능, 순서O
		ArrayList<String> list = new ArrayList<String>();
		list.add("lee");
		list.add("lee");
		list.add("lee");
		list.add("park");
		list.add("hong");
		//list.remove("park"); //collection의 자료 구조 중 일부를 지움
		list.remove(0); //list는 가능, set은 불가>set은 순서가 없어 indexing 불가. 순서대로 지움
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
