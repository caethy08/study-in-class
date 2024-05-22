package pack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Net4TestServer {

	public static void main(String[] args) {
		// 단순 서버 
		ServerSocket ss = null;
		
		//내 컴퓨터가 사용 중인 port number확인
		/*
		for (int i = 0; i < 65536; i++) {
			try {
				ss = new ServerSocket(i);
				ss.close(); //객체 생성 후 close
			} catch (Exception e) {
				System.out.println(i + "번 port는 사용 중");
			}
		}
		System.out.println("확인 종료");
		*/
		
		Socket socket = null; //TCP기반의 통신용 클래스(파일)
		try {
			ss = new ServerSocket(9999); //서버 소켓
			System.out.println("서버 서비스 시작...");
			socket = ss.accept();  //서버 소켓으로 부터 클라인언트 컴과 통신하기 위한 개별 소켓 생성
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			String data = reader.readLine();
			System.out.println("수신 자료 : " + data);
			
			reader.close();
			socket.close();
			ss.close();  //받고 죽는다. 서버 역할 못함				
		} catch (Exception e) {
			System.out.println("서버 에러:" + e);
		}
		
	}

}
