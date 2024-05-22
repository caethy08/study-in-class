package pack7gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;

import javax.management.loading.PrivateClassLoader;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

//JDialog : 맞춤형 대화상자 작성, 커스터마이징 가능
//frame에서 자식창으로 호출 가능
public class Ex49MemoAbout extends JDialog implements ActionListener{
	public Ex49MemoAbout(JFrame frame) {
		//super(frame);
		super(frame, "메모장이란", true); // 모달, false: 모달리스
		
		setTitle("메모장이란");
		setModal(true); //true modal
		//setModal(false); //false modal, modaless
		
		initLayoutAbout();
		
		setBackground(Color.lightGray);
		setBounds(350, 350, 200, 200);
		setVisible(true);  //버튼 누르면 닫힘
	}	
		private void initLayoutAbout() {
			JLabel lblMes = new JLabel("미니 메모장 ver 0.9");
			JButton btnConFirm = new JButton("확인");
			btnConFirm.addActionListener(this);
			add("Center", lblMes);
			add("South", btnConFirm);
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		dispose(); //JDialog닫기
		
	}
}
