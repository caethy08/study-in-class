package pack3;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MYFrame5Inner extends Frame {//frame을 상속받고 필요한 내부 클래스를 만들어 사용한다
	//private Wevent wevent = new Wevent(); 9,18줄과 동일
	//private Wevent wevent;
	int x, y;  //mouseclicked에서 발생한 x,y 좌표를 기억 두개 이상의 메소드에서 공유 위해 전역변수로 변경
	private String[] names = {"정재형","이원재","지명기","김성하", "김서현"};
	
		public MYFrame5Inner() {
			setTitle("내부 클래스");
			
			setSize(300, 250);
			setLocation(200, 200);
			setVisible(true);
			
			//wevent = new Wevent();
			//addWindowListener(wevent);//Frame의 상위 클래스가 가짐
			addWindowListener(new Wevent());
			addMouseListener(new Mevent());
		}
		class Wevent extends WindowAdapter{ //내부 클래스
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		}
		
		class Mevent extends MouseAdapter{ //내부 클래스
			@Override
			public void mouseClicked(MouseEvent e) {
				//setTitle("클릭");
				//int x = e.getX(); //e의 x값을 구한다
				//int y = e.getY(); //지역변수
				
				x = e.getX();
				y = e.getY(); //전역변수에 값 치환
				setTitle("x:" + x + ", y:" + y);
				
				paint(getGraphics());//자동호출되는 paint()를 명시적으로 호출할 수 있다
				repaint();  //graphics객체를 가진 paint()를 호출하고 refresh됨 
			}
		}
		@Override
			public void paint(Graphics g) { //자동 호출이  기본
				// Graphics : Frame이 제공하는 그림 그리기 객체
				g.setFont(new Font("굴림", Font.BOLD,(int) (Math.random() * 50 + 8)));
				
				int n = (int)(Math.random() * 5);
				//g.drawString("홍길동", x, y);
				g.drawString(names[n], x, y);
			}
		
	public static void main(String[] args) {
		new MYFrame5Inner();
	}
}
