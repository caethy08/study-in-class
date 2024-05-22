package pack;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;

//URL 클래스로 특정 웹 서버 컴의 문서 읽기
//인터넷이 가능한 서버 들의 자원에 접근하여 주소 및 기타 정보를 다루는 클래스
public class Net1URL {
	
	public static void main(String[] args) {
		try {
			URL url = new URL("https://www.daum.net"); //네이버 서버에 요청
			//https://www.naver.com:80/index.html
			//https : http보안용 서버 ==> https: tcp 프로토콜 기반 응용 프로그램 계층에서 사용
			InputStream is = url.openStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			//System.out.println(br.read());
			
			//읽은 문서 파일로 저장
			PrintWriter pw = new PrintWriter(System.out, true);  //자료를 읽은 뒤 메모리 상의 데이터는 지울 것
			PrintWriter fw = new PrintWriter(new FileOutputStream("C:/work/ok.html"));
			
			String line = "";
			while ((line = br.readLine()) != null) {
				pw.println(line); //console에 출력
				fw.println(line);
				fw.flush();
			}
			br.close();
			is.close();
			pw.close();
			fw.close();
			
		} catch (Exception e) {
			System.out.println("err : " + e);
		}

	}

}
