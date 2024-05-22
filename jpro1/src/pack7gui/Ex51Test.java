package pack7gui;

import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ex51Test extends JFrame implements ActionListener {

	JTextField name, kor, eng, math, sum, avg, evel;
	JLabel  result, picture ;
	JButton confirm, reset;
	int no1, no2, no3;
	Image image;
	int x = 100, y = 100;
	int selImage = 1;
	
	
	public Ex51Test() {
		super("성적 출력");
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\work\\jsou\\jpro1\\src\\pack7gui\\testp1.png"));
		layoutInit();
		setBounds(200, 200, 300, 300);
		setVisible(true);
		
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void layoutInit() {
		setLayout(new GridLayout(5,1));
		
		JLabel lbl1 = new JLabel("이름 : ");
		name = new JTextField(" ", 10);
		JPanel panel1 = new JPanel();
		panel1.add(lbl1);
		panel1.add(name);
		add("west", panel1);
		
		JLabel lbl2 = new JLabel("국어 : ");
		JLabel lbl3 = new JLabel("영어 : ");
		JLabel lbl4 = new JLabel("수학 : ");
		kor = new JTextField(" ", 3);
		eng = new JTextField(" ", 3);
		math = new JTextField(" ", 3);
		JPanel panel2 = new JPanel();
		panel2.add(lbl2);
		panel2.add(kor);
		panel2.add(lbl3);
		panel2.add(eng);
		panel2.add(lbl4);
		panel2.add(math);
		add("west", panel2);
		
		JLabel lbl5 = new JLabel("총점: ");
		JLabel lbl6 = new JLabel("평균: ");
		JLabel lbl7 = new JLabel("평가: ");
		sum = new JTextField(" ", 3);
		avg = new JTextField(" ", 3);
		evel = new JTextField(" ", 3);
		JPanel panel3 = new JPanel();
		panel3.add(lbl5);
		panel3.add(sum);
		panel3.add(lbl6);
		panel3.add(avg);
		panel3.add(lbl7);
		panel3.add(evel);
		add(panel3);
		
		confirm = new JButton("확인");
		reset = new JButton("초기화");
		confirm.addActionListener(this);
		reset.addActionListener(this);
		JPanel panel4 = new JPanel();
		panel4.add(confirm);
		panel4.add(reset);
		add(panel4);
		
		result = new JLabel();
		picture = new JLabel();
		add(result);
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (name.getText().equals("")) {
			name.requestFocus();
			return;
		}
		if (e.getSource() == confirm) {
			
			if (kor.getText().equals("")) {
				result.setText("국어 점수 입력");
				kor.requestFocus();
				return;	
			}
			try {
				no1 = Integer.parseInt(kor.getText());
			} catch (Exception e2) {
				result.setText("국어 점수는 정수로 입력");
				kor.requestFocus();
				return;
			}
			
			if (eng.getText().equals("")) {
				result.setText("영어 점수 입력");
				eng.requestFocus();
				return;
			}
			try {
				no2 = Integer.parseInt(eng.getText());
			} catch (Exception e2) {
				result.setText("영어 점수는 정수로 입력");
				eng.requestFocus();
				return;
			}
			
			if (math.getText().equals("")) {
				result.setText("수학 점수 입력");
				math.requestFocus();
				return;
			}
			try {
				no3 = Integer.parseInt(math.getText());
			} catch (Exception e2) {
				result.setText("수학 점수는 정수로 입력");
				math.requestFocus();
				return;
			}
			int hap, pyung; 
			String jumsu;
			hap = no1 + no2 + no3;
			pyung = hap / 3;
			if (pyung >=90) {
				jumsu = "A";
			}
			else if (pyung >=80) {
				jumsu = "B";
			}
			else if (pyung >=70) {
				jumsu = "C";
			}
			else if (pyung >=60) {
				jumsu = "D";
			}
			else if (pyung >=70) {
				jumsu = "E";
			}
			else {
				jumsu = "F";
			}
			sum.setText("" + jumsu);
			avg.setText("" + pyung);
			evel.setText(jumsu);					
		}
		else if (e.getSource() == reset) {
			name.setText("");
			kor.setText("");
			eng.setText("");
			math.setText("");
			sum.setText("");
			avg.setText("");
			evel.setText("");
			result.setText("");
		}
	}
	
	
	public static void main(String[] args) {
		new Ex51Test();

	}

}
