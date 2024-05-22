package Pack6thread;

public class Ex41Bank {
	private int money = 10000; //프로세스가 가진 자원(스레드 공유 자료로 만드려고함)
	
	public int getMoney() {
		return money;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	//synchronized : 스레드의 동기화를 가능하게 함
	//공유자원에 lock이 걸림 : 하나의 스레드가 공유자원을 사용하는 동안 다른 스레드는 작업이 끝날때까지 사용 대기상태가 됨.
	public synchronized void saveMoney(int mon) {//입금
		int m = this.getMoney();
		try {
			Thread.sleep(2000);//은행에서 입금시 약간의 지연시간을 표혐
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		setMoney(m + mon);
		
	}
	public synchronized void minusMoney(int mon) {//출금
		int m = this.getMoney();
		if(mon > m) {
			System.out.println("잔고액보다 출금액이 더 많아요");
			//System.exit(0);//응용프로그램의 무조건 종료
			return; //메소드 탈출
		}
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			
		}
		
		setMoney(m - mon); 
	}
}
