package Pack6thread;

import java.security.PublicKey;

public class Ex41BankMain {	
		public static Ex41Bank bank = new Ex41Bank();
	
		
	public static void main(String[] args) {
		System.out.println("원금:" + bank.getMoney());
		
		Ex41Tom tom = new Ex41Tom();
		Ex41Wife wife = new Ex41Wife();
		
		tom.start();//메인에서 스레드 시작 호출
		wife.start();
	}
}
