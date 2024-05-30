package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletEx6Cookie")
public class ServletEx6Cookie extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter(); //웹으로 출력하는 객체 out
		out.println("<html><head><meta charset=\"UTF-8\"></head><body>");
		
		
		//쿠키가 있는 경우 로그인한 상태를 알리고 없다면 로그인 화면 출현
		String id = null;
		String pwd = null;
		try {
			Cookie[] cookies = request.getCookies(); //클라이언트의 모든 쿠키 읽기 //클라이언트는 서버에게 요청을 하면서 모든 쿠키를 들고 간다
			for (int i = 0; i < cookies.length; i++) {
				//쿠키는 key: value(키이름: 값) 형태로 구성됨
				String name = cookies[i].getName();
				System.out.println("name : " + name);
				
				if (name.equalsIgnoreCase("id")) {
					//쿠키값 디코딩(암호해제)
					id = URLDecoder.decode(cookies[i].getValue(), "utf-8");
				}
			if (name.equals("pwd")) {
				//쿠키값 디코딩(암호해제)
				pwd = URLDecoder.decode(cookies[i].getValue(), "utf-8");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (id != null && pwd != null) {
			out.println(id + "님 쿠키를 통해 로그인한 상태입니다");
			out.println("</body></html>");
			out.close();
			return;
		}
		
		//id, pwd가 없는 경우
		out.println("<h2>로그인</h2>");
		out.println("<form method='post'>");
		out.println("id : <input type='text' name='id'><br>");
		out.println("pwd : <input type='text' name='pwd'><br>");
		out.println("<input type='submit' value='로그인'>"); //자기가 자기를 부름
		out.println("</form>");
		out.println("</body></html>");
		out.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("</body></html>");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		//System.out.println(id + " " + pwd);
		
		if (id.equals("aaa") && pwd.equals("111")) {
			//쿠키 생성
			try {
				id = URLEncoder.encode(id, "utf-8"); //암호화
				Cookie idcookie = new Cookie("id", id); //암호화된 아이디로 쿠키 생성
				idcookie.setMaxAge(60 * 60 * 24 * 365); //쿠키 유효기간(1년간 저장될 수도 있다.)
				
				pwd = URLEncoder.encode(pwd, "utf-8"); //암호화
				Cookie pwdcookie = new Cookie("pwd", pwd);
				pwdcookie.setMaxAge(60 * 60 * 24 * 365);
				
				response.addCookie(idcookie);
				response.addCookie(pwdcookie);  //클라이언트 컴에 쿠키를 저장
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			out.println("로그인 성공 - 쿠키가 설정되었습니다.");
		}else {
			out.println("로그인 실패");
		}
		
		out.println("</body></html>");
		out.close();
	}

}
