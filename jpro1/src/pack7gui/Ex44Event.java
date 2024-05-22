package pack7gui;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Ex44Event extends Frame implements ActionListener {

	private Button btn1 = new Button("button1");
	private Button btn2 = new Button("button2");
	private Button btn3 = new Button("button3");
	private Button btn4 = new Button("button4");
	private Button btn5 = new Button("button5");
	
	public Ex44Event() {
		// TODO Auto-generated constructor stub
		super("이벤트 연습");
		
		addlayout();
		
		setBounds(200, 200, 400, 400);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
	}
	
	private void addlayout() {
		// TODO Auto-generated method stub
		add("East", btn1); //프레임은 보더레이아웃의 기본
		add("West", btn2);
		add("South", btn3);
		add("North", btn4);
		add("Center", btn5);
		
		btn1.addActionListener(this); //방법1. 현재 클래스에 implements actionlistner 사용
		btn2.addActionListener(this);
		
		btn3.addActionListener(new EventTest()); // 방법2. 내부 클래스 사용해 implements actionlistner 사용
		
		btn4.addMouseListener(new EventTest2());// 방법3 : 내부 클래스 사용 extends 사용
		
		btn5.addMouseListener(new MouseAdapter() {// 방법4: 내부 무명 클래스 사용
			@Override
			public void mouseClicked(MouseEvent e) { 
				// btn5 클릭하면 수행되는 클래스
				setTitle("버튼 5 클릭 클릭");
			}
		});
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// 버튼1,2를 눌렀을때 수행되는 메소드 
		
		//System.out.println(e.getActionCommand());
		//System.out.println(e.getSource());
		if (e.getSource() == btn1) {//객체 비교 ==사용. 문자열 비교는 equals
			setTitle("버튼 1 클릭");
		}else if(e.getSource() == btn2) {
			setTitle("버튼 2 click");
		}
	}
	
	class EventTest implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {//추상메소드 오버라이딩
			// 버튼3을 눌렀을때 수행되는 메소드 
			setTitle("버튼 3을 누르다니");
			
		}
	}
	
	class EventTest2 extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {//일반 메소드 오버라이딩
			// btn4 클릭하면 수행되는 클래스
			setTitle("버튼 마우스 이벤트로 btn4처리");
		}
	}
	
	public static void main(String[] args) {
		// 이벤트 처리 정리
		new Ex44Event();

	}

}
