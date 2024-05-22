package Pack6thread;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.LocalTime;

public class Ex39ThreadClock extends Frame implements ActionListener, Runnable {
	Label lblMessage;
	boolean bExit = false;
	Thread thread;
	
	public Ex39ThreadClock() {
		lblMessage = new Label("show time", Label.CENTER); //new label 생성자 중 쇼티임이라는 메세자를 레이블의 센터에 위치
		super.add("Center", lblMessage); //프레임에 메세지 가운데 애드
		
		Button btnClick = new Button("click");
		super.add("South", btnClick);
		btnClick.addActionListener(this);
		
		setTitle("스레드 시계");
		setBounds(200, 200, 300, 300);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				bExit = true; //run()의 무한루핑을 탈출하기 위해 
				System.exit(0);
			}
		});
		
		thread = new Thread(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 버튼을 클릭하면 수행될 메소드
		//System.out.println("와우");
		//showData();
		//만약 사용자 정의 스레드가 이미 있다면 start()를 호출하지 않음
		if (thread.isAlive())return; //if 조건을 만족하면 리턴을 만나서 밑에 스타트 스레드를 다시 만나지 못한다
		thread.start();
		System.out.println("1");
	}
	@Override
	public void run() {
		while (true) {
			//if(bExit == true) break;
			if(bExit) break;
			
			showData();
			try {
				Thread.sleep(1000); //1초 동안 비활성화
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println("2");
	}
	
	
	private void showData() {
		LocalDate date  = LocalDate.now(); //싱글톤 패턴
		int y = date.getYear();
		int m = date.getMonthValue();
		int d = date.getDayOfMonth();
		
		LocalTime time = LocalTime.now();
		int h = time.getHour();
		int mi = time.getMinute();
		int s = time.getSecond();
		
		String ss = y + "-" + m + "-" + d + "  " + h + " : " + mi + " : " + s;
		lblMessage.setText(ss);
		lblMessage.setFont(new Font("Times new Roman", Font.BOLD, 20));
	}

	public static void main(String[] args) {
		// 스레드를 이용한 현재 날짜와 시간 표시
		new Ex39ThreadClock();
	}

}
