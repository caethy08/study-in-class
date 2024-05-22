package pack;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Net4TestClient {

	public static void main(String[] args) {
		try {
			//InetAddress ia = InetAddress.getByName("127.0.0.1"); //InetAddress: ip어드레스를 객체로 얻음
			//System.out.println(ia);
			//Socket socket = new Socket(ia, 9999); 사용하는 포트번호 확인
			
			Socket socket = new Socket("192.168.0.16", 9999); //10과 11문을 합친것. //서버와 접속 클라이언트가 9999번 포트를 타고 192.168.0.23에 들어옴
			
			PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true); //이 컴퓨터에 데이터(아래) 전송
			writer.println("Hi I'am seohyun" + "\n"); //서버로 자료 전송. 
			
			writer.close();
			socket.close();
		} catch (Exception e) {
			System.out.println("client err : " + e);
		}
		
		//특정 컴의 접속 후 메세지 전달용

	}

}
