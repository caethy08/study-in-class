package pack;

public class ExamProcess {
	//연산용 클래스 (Business Logic용)
	private ExamBean bean;
	
	public void setBean(ExamBean bean) {
		this.bean = bean;
	}
	
	public int getTot() { //getter을 부르기 때문에 꼭 get으로 시작되는 이름이 붙어야 한다.
		return bean.getKor() + bean.getEng() + bean.getMat();
	}
	
	public double getAvg() {
		return getTot() / 3.0;
	}
}
