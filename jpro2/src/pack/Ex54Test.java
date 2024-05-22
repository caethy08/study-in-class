package pack;

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
import javax.swing.JTextField;

public class Ex54Test extends JFrame implements ActionListener {
	JTextField name, p_no, b_no;
	JLabel result;
	JButton confirm;
	
	Connection conn;
	Statement pstmt;
	ResultSet rs;
	
	public Ex54Test() {
		layInit();
		accDb();
		
		setBounds(200, 200, 300, 250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	private void layInit() {
		JLabel lbl1 = new JLabel("고객명 : ");
		name = new JTextField(" ", 3); 
		JPanel panel1 = new JPanel();
		panel1.add(name);
		add(panel1);
		
		JLabel lbl2 = new JLabel("주민번호 : ");
		p_no = new JTextField(" ", 3);
		b_no = new JTextField(" ", 3);
		confirm = new JButton("확인");
		confirm.addActionListener(this);
		JPanel panel2 = new JPanel();
		panel2.add(p_no);
		panel2.add(b_no);
		panel2.add(confirm);
		add(panel2);
		
		result = new JLabel();
		add(result);
		
		

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
			
			String sql = "select jikwon_no, jikwon_name, buser_name, buser_tel, jikwon_jik FROM jikwon INNER JOIN buser ON buser.buser_no = jikwon.buser_num INNER JOIN gogek ON jikwon_no = gogek_damsano where gogek_name";
			if (e.getSource() == confirm) {
				sql += " ";
			}
		
		
		} catch (Exception e2) {
			// TODO: handle exception
		}
		
	}
	
	public static void main(String[] args) {
		new Ex54Test();

	}

}
