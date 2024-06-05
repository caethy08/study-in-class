package pack;

public class ExamBean { 
	//클라이언트로부터 전송되는 복수 개의 값을 한개의 그룹으로 묶어 처리하는 클래스
	//이런 용도의 클래스를 FormBean이라고 부른다 (DTO, FormBean
	private String name;
	private int kor;
	private int eng;
	private int mat;  //main의 요소와 동일한 이름을 가져야 한다
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	
	

	

}
