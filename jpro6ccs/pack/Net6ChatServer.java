package pack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//멀티 채팅 서버 : thread + socket
public class Net6ChatServer {
	private static final int PORT = 5000;
	//private static List<Socket> clients = new ArrayList<Socket>();
	//CopyOnWriteArrayList<> : thread에 최적화된 arraylist. 컨텐츠를 읽어 어딘가에 전달할 때 컨텐츠를 복사해서 전달함. 스레드에서 안심하고 처리가 가능.
	private static List<Socket> clients = new CopyOnWriteArrayList<Socket>();   //클라이언트가 접속할때마다 어레이 리스트에 담김
	
	//ExecutorService를 이용하면 thread pool을 생성해 병렬 처리를 할 수 있다.
	private static ExecutorService pool = Executors.newFixedThreadPool(4);
	
	
	public static void main(String[] args) throws IOException{
		ServerSocket serverSocket = new ServerSocket();
		System.out.println("채팅 서버 서비스 시작....");
		
		try {
			while (true) {
				Socket clientsSocket = serverSocket.accept();
				System.out.println("새 접속자와 연결:" + clientsSocket.getInetAddress());
				clients.add(clientsSocket);
				
				//스래드 풀 객체가 스레드를 실행
				pool.execute(null);
			}
		} finally {
			// 에러를 무시할 경우 바로 finally사용
			serverSocket.close();
		}
	}
	
	static class ClientHandler implements Runnable{
		private Socket socket;
		private BufferedReader in;
		private PrintWriter out;
		
		public ClientHandler(Socket socket) throws IOException{
			this.socket = socket;
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
		}
		
		@Override
		public void run() {
			try {
				String name = in.readLine();  //접속자명 받기
				if (name == null) {
					throw new IOException("클라이언트 연결이 끊어졌습니다.");
				}
				System.out.println(name = "님이 접속했습니다");
				broadcastMessage("XD" + name + "님 입장~~");
				
				String message;
				while ((message = in.readLine()) != null)  {//메세지 수신
					broadcastMessage(name + "님 메세지:" + message); //접속자 모두에게 메세지를 뿌림: broadcastMessage
				}
			} catch (Exception e) {
				System.out.println("접속자 연결 오류 : " + e.getMessage());
			}finally {
				try {
					if (socket != null) {
						socket.close();
						clients.remove(socket); //어레이리스트에 담긴 클라이언트 제거
						
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			
		}
		
		private void broadcastMessage(String message) {
			for(Socket client:clients) {
				try {
					if (!client.isClosed()) {//client가 살아있으면 메세지전달
						//클라이언트로 송신할 데이터를 위한 PrintWriter객체를 생성해 송신 후 자동으로 flush(메모리를 비움)
						PrintWriter clientOut = new PrintWriter(client.getOutputStream(), true);
						clientOut.println(message);
					}
				} catch (Exception e) {
					System.out.println("broadcastMessage err : " + e.getMessage());
				}
			}
		}
	}

}
