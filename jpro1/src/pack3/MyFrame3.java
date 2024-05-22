package pack3;

import java.awt.Color;
import java.awt.Frame; //frame가져오기 위해
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener; //windowlistner 가져오기 위해

//인터페이스를 이용한 이벤트 처리 연습
public class MyFrame3 extends Frame implements WindowListener, MouseListener{
//frame이라는 전문가가 만든 클래스의 멤버를 내것처럼 사용한다 > 자원의 재활용
	public MyFrame3() {
		//생성자
		//super("상속 사용");
		super.setTitle("상속 사용");
		
		display();
		
		super.addWindowListener(this); //현재 프레임에 이벤트 리스너를 장착
		//윈도우 리스너를 arguments로 달라고 하는데 클래스에 windowlistner이 들어있어서 현재 클래스가 가지고 있다는 의미로 this		
	
		addMouseListener(this);
	}
	
	void display() {
		setSize(500, 300);
		//super.setLocation(200, 150);
		setLocation(200, 150);
		setVisible(true);
	}
	
	//windowlistner가 가진 추상메소드 오버라이딩
	@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
		public void windowClosing(WindowEvent e) {
		//System.out.println("종료");
		//setTitle("안녕 종료는 아직..");
		System.exit(0);
			
		}
	@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
	@Override
		public void windowDeiconified(WindowEvent e) {
			System.out.println("windowDeiconified");				
		}
	@Override
		public void windowIconified(WindowEvent e) {
			System.out.println("windowIconified");			
		}
	@Override
		public void windowOpened(WindowEvent e) {
			System.out.println("windowOpened");
			
		}
	
	
	@Override
		public void mouseClicked(MouseEvent e) {
			//System.out.println("클릭 성공 후 점심 먹기");	
			//setBackground(new Color(255, 0, 0));
			System.out.println((int)Math.random()*255);
			int r = (int)(Math.random()*255);
			int g = (int)(Math.random()*255);
			int b = (int)(Math.random()*255);
			setBackground(new Color(r, g, b));
		}
	@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub			
		}
	@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub			
		}
	@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub			
		}
	@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub			
		}
	
	
	
	public static void main(String[] args) {
		new MyFrame3(); //위 생성자에서 display를 선언해서 객체만 생성하면 된다.
	}

}
