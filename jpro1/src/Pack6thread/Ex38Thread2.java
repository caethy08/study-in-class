package Pack6thread;

public class Ex38Thread2 implements Runnable {
 //Ex38Thread2가 러너블의 런메소드를 임플리멘츠 하여 사용하는 방법
	public Ex38Thread2() {
		
	}
	public Ex38Thread2(String name) {
		Thread tt = new Thread(this, name);
		tt.start();
	}
	
	@Override
	public void run() {
		for (int i = 1; i <= 50; i++) {
			//System.out.println(i);
			System.out.println(i + ":" + Thread.currentThread().getName());//현재 수행되는 스레드의 겟네임
			try {
				Thread.sleep(100); //thread를 일정 시간동안 비활성화
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Ex38Thread2 my1 = new Ex38Thread2();
		Ex38Thread2 my2 = new Ex38Thread2();
		Thread t1 = new Thread(my1);
		t1.start();
		Thread t2 = new Thread(my2);
		t2.start();
		*/
		new Ex38Thread2("하나");
		new Ex38Thread2("둘");
		System.out.println("프로그램 종료");
	}

}
