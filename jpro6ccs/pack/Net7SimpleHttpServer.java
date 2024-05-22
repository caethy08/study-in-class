package pack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

//Thread와 Socket을 사용해 간단한 웹 서버 작성

public class Net7SimpleHttpServer {
	private ServerSocket serverSocket;
	private final int PORT;
	
	public Net7SimpleHttpServer(int port) {
		this.PORT = port;
	}
	
	public void gogo() throws IOException {
		serverSocket = new ServerSocket(PORT); //8080의 서버소켓 생성
		System.out.println("HTML Server started on post : " + PORT);
		
		while (true) {
			try {
				Socket clientSocket = serverSocket.accept(); //사람이 들어올때마다 통신하기 위한 소켓 생성
				System.out.println("Received request from" + clientSocket.getRemoteSocketAddress()); //서버에서 주소 보임
				
				ClientHandler clientHandler = new ClientHandler(clientSocket); //아래 내부 클래스 생성자 생성. 소켓 인스턴스의 주소 넘김
				new Thread().start();
			} catch (Exception e) {
				System.out.println("gogo err " + e.getMessage());
				break;
			}
		}
	}
	
	//내부 클래스 소켓 내부 처리
	private static class ClientHandler implements Runnable{
		private Socket clientSocket;
		
		public ClientHandler(Socket socket) {
			clientSocket = socket;
		}
		
		@Override
		public void run() {
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true); //오토 플러쉬 기능 true
				
				String requestLine = in.readLine();
				System.out.println("Request : " + requestLine);
				
				//HTTP 요청(request)에 대항 응답(response)
				out.println("HTTP/1.1 200 OK"); 
				out.println("Content_Type:text/html;charset=UTF-8"); 
				out.println(" ");
				out.println("<html><head><title>연습</title></head>");
				out.println("<body> ");
				out.println("<h1>홈페이지</h1>");
				out.println("<a href='https://www.daum.net'> 다음으로</a>출발<br>");
				out.println("<a href='https://www.naver.net'> 네이버로</a>가자<br>");
				out.println("</body> ");
				out.println("</html> ");
				
				out.close();
				in.close();
				clientSocket.close();		
			} catch (Exception e) {
				System.out.println("error client request : " + e.getMessage());
			}
			
		}
	}
	
	public static void main(String[] args) {
		int port = 8080;   //test용 웹서버의 default port
		
		try {
			Net7SimpleHttpServer httpServer = new Net7SimpleHttpServer(port);
			httpServer.gogo();
		} catch (Exception e) {
			System.out.println("err : " + e);
		}

	}

}
