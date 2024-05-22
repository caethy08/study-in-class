package pack7gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Ex48Test extends JFrame implements ActionListener {
	JTextField no1, no2;
	ButtonGroup buttonGroup = new ButtonGroup();
	JRadioButton plus, minus, times, divided;
	JLabel lblResult;
	JButton btn1, btn2, btn3;
	
	public Ex48Test() {
		super("미니 계산기");
		
		layoutInit();
		
		setBounds(200, 200, 300, 300);
		setVisible(true);
		
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void layoutInit() {
		setLayout(new GridLayout(5, 1));
		
		JLabel lbl1 = new JLabel("숫자1 : ");
		no1 = new JTextField(" ", 10);
		JPanel panel1 = new JPanel();
		panel1.add(lbl1);
		panel1.add(no1);
		add("West",panel1);
		
		JLabel lbl2 = new JLabel("숫자2 : ");
		no2 = new JTextField(" ", 10);
		JPanel panel2 = new JPanel();
		panel2.add(lbl2);
		panel2.add(no2);
		add(panel2);
		
		JLabel lbl3 = new JLabel("연산선택 : ");
		plus = new JRadioButton("+");
		minus = new JRadioButton("-");
		times = new JRadioButton("*");
		divided = new JRadioButton("/");
		buttonGroup.add(plus);
		buttonGroup.add(minus);
		buttonGroup.add(times);
		buttonGroup.add(divided);
		JPanel panel3 = new JPanel();
		panel3.add(lbl3);
		panel3.add(plus);
		panel3.add(minus);
		panel3.add(times);
		panel3.add(divided);
		add(panel3);
		
		lblResult = new JLabel("결과 : ");
		JPanel panel4 = new JPanel();
		panel4.add(lblResult);
		add(panel4);
		
		
		btn1 = new JButton("계산");
		btn2 = new JButton("초기화");
		btn3 = new JButton("종료");
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		JPanel panel5 = new JPanel();
		panel5.add(btn1);
		panel5.add(btn2);
		panel5.add(btn3);		
		add(panel5);
		
			
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (no1.getText().equals("")) {
			lblResult.setText("");
			no1.requestFocus();
			return;
		}
		
		if (no2.getText().equals("")) {
			lblResult.setText("");
			no2.requestFocus();
			return;
		}
		double nu1, nu2;
		try {
			nu1 = Integer.parseInt(no1.getText());
			nu2 = Integer.parseInt(no2.getText());
		} catch (Exception e2) {
			return;
		}
		
		double result;
		if (plus.isSelected()) {
			result = nu1 + nu2;
		}else if (minus.isSelected()) {
			result = nu1 - nu2;
		}else if (times.isSelected()) {
			result = nu1 * nu2;
		}else {
			result = nu1 / nu2;
		}
		
		if (e.getSource() == btn1) {
			lblResult.setText("" + result);
		}else if(e.getSource() == btn2) {
			no1.setText("");
			no2.setText("");
		}else if(e.getSource() == btn3) {
			System.exit(0);
		}
		
		// 버튼이 안먹었던 이유는 위의 90~99번 if 문에서 전부 반환되었기 때문
		//해결방법은 120번 조건문을 90번 위로 올려서 값이 들어갈 수 있게 만든다.
		
		
	}
	
	public static void main(String[] args) {
		new Ex48Test();

	}

}
