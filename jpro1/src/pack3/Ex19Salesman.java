package pack3;

public class Ex19Salesman extends Ex19Regular {
	private double sales;
	private double commission;
	
	public Ex19Salesman(String irum, int nai, double salary, double sales, double commission) {
		super(irum, nai, salary);
		this.sales = sales;
		this.commission = commission;
	}
	
	
	@Override
	public void print() {
		display();
		System.out.println(pay() + (sales * commission));
	}
}
