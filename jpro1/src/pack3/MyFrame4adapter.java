package pack3;

import java.awt.Color;
import java.awt.Frame; //frame가져오기 위해
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener; //windowlistner 가져오기 위해

//adapter 클래스를 이용한 이벤트 처리 연습
//windowadapter 추상 클래스는 windowlistner 인터페이스를 구현한 클래스
//windowlistner의 추상 메소드가 windowadapter에서 일반 메소드로 오버라이드(재정의)
public class MyFrame4adapter extends WindowAdapter{//상속(강결합)
	private Frame frame;
	
	public MyFrame4adapter() {
		frame = new Frame("Adapter 연습");//포함(약결합)
				
		frame.setSize(300, 250);
		frame.setLocation(200, 200);
		frame.setVisible(true);
		
		frame.addWindowListener(this);
		//windowadapter은 windowlistner을 implements함(가짐) 따라서 windowadapter을 가진 현재의 클래스를 표시하기 위해 this사용	
	}
		@Override
			public void windowClosing(WindowEvent e) {
				// 선택적으로 필요한 메소드를 오버라이딩 할 수 있다.
				System.exit(0);
			}
		

	public static void main(String[] args) {
		new MyFrame4adapter(); //위 생성자에서 display를 선언해서 객체만 생성하면 된다.
	}

}
