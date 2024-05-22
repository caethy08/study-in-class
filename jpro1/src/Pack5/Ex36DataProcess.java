package Pack5;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Ex36DataProcess {
	
	public static void main(String[] args) throws Exception {
		//이진 데이터 처리
		
		Ex36BinaryData binaryData = new Ex36BinaryData();
		
		//저장. 인코딩
		//File f = new File("c:/work/iotest3.dat"); 
		File dir = new File("c:/work/");
		File file = new File(dir, "iotest3.dat");//경로를 따로 나누어 저장 c:/work폴더에 iotest3.dat이라는 이름의 file객체 생성
		
		FileOutputStream fo = new FileOutputStream(file); //file객체의 위치에 fo객체가 파일을 생성함
		BufferedOutputStream bo = new BufferedOutputStream(fo, 1024); //1킬로바이트로 처리
		ObjectOutputStream oo =new ObjectOutputStream(bo); //버퍼에서 fo위치에 있는 파일을 oo객체가 인코딩
		oo.writeObject(binaryData); //Ex36BinaryData타입의 binaryData를 oo에 쓰기
		oo.close();
		bo.close();
		fo.close();
		System.out.println("저장 성공");
		
		//읽기. 디코딩
		File file2 = new File("c:/work/iotest3.dat");
		
		FileInputStream fis = new FileInputStream(file2);
		BufferedInputStream bi = new BufferedInputStream(fis, 1024); //1킬로바이트로 처리
		ObjectInputStream oi = new ObjectInputStream(bi);
		Object obj = oi.readObject();//oi.readObject()는 오브젝트의 파생 클래스 > 캐스팅가능
		//oi에서 readObject메소드를 불러와 객체변수obj에 치환 
		Ex36BinaryData data = (Ex36BinaryData)obj;
		
	}
}
