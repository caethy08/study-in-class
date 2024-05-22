package pack2;

public class Ex10PohamHandle {
	int quantity;  //자동차의 회전양
	
	public Ex10PohamHandle() {
		quantity = 0;
	}
	
	String leftTurn(int q) {
		quantity = q;
		return "좌회전";
	}
	
	String rightTurn(int quantitiy) {
		this.quantity = quantitiy;
		return "우회전";
	}
	
	String straight(int quantitiy) {
		this.quantity = quantitiy;
		return "직진";
	}
}
