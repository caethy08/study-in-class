package pack3;

//public interface Ex22InterVol { Ex22InterVol는 추상 메소드 2개
public interface Ex22InterVol extends Ex22VolEtc { //Ex22InterVol는 추상메소드 4개(Ex22VolEtc의 추상메소드 2개를 받아옴)
	String vol = "볼륨";
	
	void volUp(int v);
	void volDown(int v);
}
