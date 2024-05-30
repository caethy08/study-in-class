package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



//@WebServlet("/HelloServlet") //@: annotation
@WebServlet( name = "ServletGo",  urlPatterns = { "/HelloServlet", "/good.kor", "/dajeong"}, loadOnStartup = 1)      // 요청이 없어도, 웹서비스가 시작되면 서블릿 수행

public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; //서블릿 시리얼넘버(무시가능, 삭제 가능)

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { //일반 메소드 오버라이딩
		// TODO Auto-generated method stub
		System.out.println("get 요청 성공");
		
		//서블릿(웹용 자바)으로 클라이언트 브라우저에 데이터 전송
		response.setContentType("text/html;charset=utf-8");  //mime type과 문자 코드
		PrintWriter out = response.getWriter(); //웹으로 출력하는 객체 out
		out.println("<html><body>");
		out.println("<h1>서블릿 문서</h1>");
		out.println("안녕 반가워");
		out.println("</body></html>");
		out.close();
	}

}
