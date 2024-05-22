package pack3;

public class Ex19Regular extends Ex19Employee{
	private double salary;
	
	public Ex19Regular(String irum, int nai, double salary) {
		super(irum, nai);
		this.salary = salary;
	}
	
	@Override
	public double pay()  {
		return salary;
	}
	@Override
	public void print() {
		display();
		System.out.println(pay());
	}
}
