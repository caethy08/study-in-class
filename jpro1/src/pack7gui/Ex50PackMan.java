package pack7gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class Ex50PackMan extends JFrame implements KeyListener{
	Image image;
	int x = 100, y = 100;
	int selImage = 1;
	
	public Ex50PackMan() {
		super("상하좌우 화살표를 사용하세요");
		
		//
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\work\\jsou\\jpro1\\src\\pack7gui\\pack1.jpg"));
		
		setLayout(null); //배치 관리자 없음(누를때마다 조금씩 움직여야 해서)
		setResizable(false);
		setBounds(200, 200, 300, 300);
		setBackground(Color.WHITE);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		addKeyListener(this);
		
		x = super.getWidth() /2; //x는 frame 너비의 절반의 값을 가짐
		y = super.getHeight()/2; //y는 frame 높이의 절반의 값을 가짐
	}
	
	@Override
	public void paint(Graphics g) {
		// frame에 뭔가를 주려는 메소드로 자동 호출
		switch (selImage) {
		case 1:
			image = Toolkit.getDefaultToolkit().getImage("C:\\work\\jsou\\jpro1\\src\\pack7gui\\pack1.jpg");
			break;
		case 2: 
			image = Toolkit.getDefaultToolkit().getImage("C:\\work\\jsou\\jpro1\\src\\pack7gui\\pack2.jpg");
			break;
		case 3: 
			image = Toolkit.getDefaultToolkit().getImage("C:\\work\\jsou\\jpro1\\src\\pack7gui\\pack3.jpg");
			break;
		case 4: 
			image = Toolkit.getDefaultToolkit().getImage("C:\\work\\jsou\\jpro1\\src\\pack7gui\\pack4.jpg");
			break;
		case 5: 
			image = Toolkit.getDefaultToolkit().getImage("C:\\work\\jsou\\jpro1\\src\\pack7gui\\pack5.jpg");
			break;
		case 6: 
			image = Toolkit.getDefaultToolkit().getImage("C:\\work\\jsou\\jpro1\\src\\pack7gui\\pack6.jpg");
			break;
		case 7: 
			image = Toolkit.getDefaultToolkit().getImage("C:\\work\\jsou\\jpro1\\src\\pack7gui\\pack7.jpg");
			break;
		case 8: 
			image = Toolkit.getDefaultToolkit().getImage("C:\\work\\jsou\\jpro1\\src\\pack7gui\\pack8.jpg");
			break;
			
		}
		
		g.clearRect(0, 0, getWidth(), getHeight()); //이전 그림을 지우기 위해 화면 전체를 선택해 지움 : 잔상 해결
		
		g.drawImage(image, x - image.getWidth(this) /2, y - image.getHeight(this) /2, this); // 이미지를 가운데로 옮겨둠
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		//System.out.println("key : " + key);
		
		//오른쪽 화살표
		if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_NUMPAD6) {
			//System.out.println("go");
			selImage  = (selImage == 1)?2:1; //삼항 연산자 움직일 때 그림을 바꾸기 위해 사용
			// x = x + 10; 무한이 늘어나 팩맨이 사라진다
			x = (x < getWidth())?x +=10:-image.getWidth(this); //x좌표 값이 프레임의 너비보다 작으면 10씩 늘어나고 아니면 x죄표값이 0이 된다			
		}else if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_NUMPAD4) {
			selImage  = (selImage == 3)?4:3;
			x = (x > 0)?x -=10:300 + image.getWidth(this);
		}else if (key == KeyEvent.VK_UP || key == KeyEvent.VK_NUMPAD8) {
			selImage  = (selImage == 7)?8:7;
			y = (y > 0)?y -=10: + image.getHeight(this);
		}else if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_NUMPAD2) {
			selImage  = (selImage == 5)?6:5;
			y = (y < getHeight())?y +=10:-image.getHeight(this);
			
		}
		
		repaint(); //paint  호출
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
	@Override
	public void keyTyped(KeyEvent e) {
	}
	
	public static void main(String[] args) {
		// 키보드 이벤트 연습
		new Ex50PackMan();

	}

}
