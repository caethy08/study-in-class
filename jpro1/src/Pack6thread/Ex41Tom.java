package Pack6thread;

public class Ex41Tom extends Thread{
	@Override
	public void run() {
		Ex41BankMain.bank.saveMoney(5000);
		
		System.out.println("탐편 톰 예금 후 잔고:" + Ex41BankMain.bank.getMoney());
	}
}
