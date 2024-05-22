package pack3;

public class Ex19Temporary extends Ex19Employee {
	 private double ilsu;
	 private double ildang;
	
	 public Ex19Temporary(String irum, int nai, double ilsu, double ildang) {
		super(irum, nai);
		this.ilsu = ilsu;
		this.ildang = ildang;
	}
	 
	@Override
	public double pay() {
		return (ilsu * ildang);
	}
	@Override
	public void print() {
		display();
		System.out.println(pay());
		
	}
	
}
