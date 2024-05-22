package pack3;

public class Ex19Manager extends Ex19Regular {
	private double incentive;
	
	public Ex19Manager(String irum, int nai, double salary) {
		super(irum, nai, salary);
		
		if (salary < 2000000) {
			incentive = (salary * 0.4);			
		}else if (salary >= 2000000 ) {
			incentive = (salary * 0.5);
		}else if (salary >= 2500000) {
			incentive = (salary * 0.6);
		}
	}

	@Override
	public void print() {
		display();
		System.out.println(pay() + incentive);
	}
}
