package pack;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ex55Test extends JFrame implements ActionListener {
	JTextField no, name;
	JTextArea result1, result2;
	JButton btnlo; 
	int no1;
	String name1;
	
	Connection conn;
	Statement pstmt;
	ResultSet rs;
	
	public Ex55Test() {
		layInit();
		accDb();
		
		setBounds(200, 200, 300, 250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void layInit() {
		
		JLabel lbl1 = new JLabel("직원번호 : ");
		JLabel lbl2 = new JLabel("이름 : ");	 
		no = new JTextField(" ", 3); 
		name = new JTextField(" ", 3);
		btnlo = new JButton("로그인");
		JPanel panel1 = new JPanel();
		panel1.add(lbl1);
		panel1.add(no);
		panel1.add(lbl2);
		panel1.add(name);
		panel1.add(btnlo);
		add(panel1);
		
		result1.setEditable(false);
		result2.setEditable(false);
		
		add(result1);
		add(result2);
		
		btnlo.addActionListener(this);

	}
	private void accDb() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("accDb err : " + e);
		}

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String url="jdbc:mariadb://localhost:3306/test"; 
			conn = DriverManager.getConnection(url, "root", "123"); 
			pstmt = conn.createStatement();
			
			if (e.getSource() == btnlo) {
				String sql = "select jikwon_no, jikwon_name, jikwon_pay, jikwon_jik, jikwon_rating from jikwon";
				if (no.getText().equals("")) {
					result1.setText("직원번호 입력");
					no.requestFocus();
					return;	
			}
				try {
					no1 = Integer.parseInt(no.getText());
				} catch (Exception e2) {
					result1.setText("직원번호는 정수로 입력");
					no.requestFocus();
					return;
			}
				if (name.getText().equals("")) {
					result1.setText("이름 입력");
					name.requestFocus();
					return;	
			}
			result1.setText(null);
			
			rs = pstmt.executeQuery(sql);
		}
	} catch (Exception e2) {
		System.out.println("actionPerformed err : " + e);
	}finally {
		try {
			if (rs != null)  rs.close();
			if (pstmt != null)  pstmt.close();	
			if (conn != null)  conn.close();	
		} catch (Exception e2) {
			
		}
	}
		
	}
	
	public static void main(String[] args) {
		new Ex55Test();

	}

}
