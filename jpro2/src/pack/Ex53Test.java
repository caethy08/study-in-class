package pack;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.mariadb.jdbc.Statement;

public class Ex53Test extends JFrame implements ActionListener {
	
	JTextField code, name, no, price ;
	JLabel result;
	JButton btnP; 
	int no1, no2, no3;
	
	Connection conn;
	Statement stmt; 
	ResultSet rs;
	
	public Ex53Test() {
		super("상품 처리");
			
		layInit();
		accDb();
		
		setBounds(200, 200, 300, 250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		
	}
	
	private void layInit() {
		setLayout(new GridLayout(2,1));
		
		JLabel lbl1 = new JLabel("코드 : ");
		JLabel lbl2 = new JLabel("품명 : ");
		JLabel lbl3 = new JLabel("수량 : ");
		JLabel lbl4 = new JLabel("단가 : ");		
		code = new JTextField(" ", 2); 
		name = new JTextField(" ", 2);
		no = new JTextField(" ", 2); 
		price = new JTextField(" ", 2);
		btnP = new JButton("추가");
		btnP.addActionListener(this);
		JPanel panel1 = new JPanel();
		panel1.add(lbl1);
		panel1.add(code);
		panel1.add(lbl2);
		panel1.add(name);
		panel1.add(lbl3);
		panel1.add(no);
		panel1.add(lbl4);
		panel1.add(price);
		panel1.add(btnP);
		add(panel1);
		
		result = new JLabel();
		add(result);
		

	}
	
	private void accDb() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		
			String url="jdbc:mariadb://localhost:3306/test";
			conn = DriverManager.getConnection(url, "root", "123");
			
			stmt = (Statement) conn.createStatement();
			String sql ="select code, sang, su, dan";
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			System.out.println("accDb err : " + e);
		}	

	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnP ) {
			if (code.getText().equals("")) {
				result.setText("코드 입력");
				code.requestFocus();
				return;	
			}
			try {
				no1 = Integer.parseInt(code.getText());
			} catch (Exception e2) {
				result.setText("코드는 정수로 입력");
				code.requestFocus();
				return;
			}
			if (name.getText().equals("")) {
				result.setText("품명 입력");
				name.requestFocus();
				return;	
			}
			if (no.getText().equals("")) {
				result.setText("수량 입력");
				no.requestFocus();
				return;	
			}
			try {
				no2 = Integer.parseInt(no.getText());
			} catch (Exception e2) {
				result.setText("수량은 정수로 입력");
				no.requestFocus();
				return;
			}
			if (price.getText().equals("")) {
				result.setText("코드 입력");
				code.requestFocus();
				return;	
			}
			try {
				no3 = Integer.parseInt(price.getText());
			} catch (Exception e2) {
				result.setText("단가는 정수로 입력");
				price.requestFocus();
				return;
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		new Ex53Test();

	}

}
