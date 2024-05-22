package pack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DbTest3Gogek extends JFrame implements ActionListener {
	JButton btnA = new JButton("전체");
	JButton btnM = new JButton("남자");
	JButton btnF = new JButton("여자");
	JTextArea txtResult = new JTextArea();
	
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	public DbTest3Gogek() {
		setTitle("고객 자료");
		
		layInit();
		accDb();
		
		setBounds(200, 200, 300, 250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	private void layInit() { // 디자인
		JPanel jpanel = new JPanel();
		jpanel.add(btnA);
		jpanel.add(btnM);
		jpanel.add(btnF);
		
		txtResult.setEditable(false); //read only
		JScrollPane pane = new JScrollPane(txtResult); //스크롤바를 텍스트 에리어에 추가
		
		add("Center", pane);
		add("North", jpanel);
		
		btnA.addActionListener(this);
		btnM.addActionListener(this);
		btnF.addActionListener(this);

	}
	
	private void accDb() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("accDb err : " + e);
		}

	}
	

	@Override
	public void actionPerformed(ActionEvent e) {//버튼 누를때만 연결
		// Db 연결은 필요시 접속하고 작업이 끝나면 반드시 연결을 해제한다
		try {
			String url="jdbc:mariadb://localhost:3306/test"; //url 정의
			conn = DriverManager.getConnection(url, "root", "123"); //conn인스턴스
			stmt = conn.createStatement(); //stmt 인스턴스
			
			String sql = "select gogek_no, gogek_name,gogek_jumin from gogek"; //조건을 다르게 걸때 반복하지 않기 위해 분류
			
			if (e.getSource() == btnA) {
				
			}else if (e.getSource() == btnM) {
				sql += " where gogek_jumin like '%-1%'"; //sql에서  gogek의 뒤를 띄우지 않아서 띄워줘야 함
				// sql += " where substr(gogek_jumin,8,1) =1";
			}else if (e.getSource() == btnF) {
				sql += " where gogek_jumin like '%-2%'";
			}
			
			txtResult.setText(null);  //자료 입력 전에 출력 영역을 비워냄
			
			rs = stmt.executeQuery(sql);
			int count = 0;
			txtResult.setText("고객번호\t고객명\t주민번호\n");
			
			while (rs.next()) {
				String imsi =  rs.getString("gogek_no") + "\t" + rs.getString("gogek_name") + "\t" +rs.getString("gogek_jumin") + "\n";
				
				txtResult.append(imsi);
				count++;
				
			}
			
			txtResult.append("인원수 : " + count);
			
		} catch (Exception e2) {
			System.out.println("actionPerformed err : " + e);
		}finally { //사용 후 반드시 끊기
			try {
				if (rs != null)  rs.close();
				if (stmt != null)  stmt.close();	
				if (conn != null)  conn.close();	
			} catch (Exception e2) {
				
			}
		}
		
	}
	
	public static void main(String[] args) {
		new DbTest3Gogek();

	}


}
