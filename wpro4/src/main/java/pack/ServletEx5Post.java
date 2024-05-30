package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Post.do")
public class ServletEx5Post extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");  //수신자료 한글 깨짐 방지
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter(); //웹으로 출력하는 객체 out
		out.println("<html><body>");
		out.println("<h1>post 요청 결과</h1>");
		
		String irum = request.getParameter("name");
		String []juso = request.getParameterValues("addr"); //매개변수 중복인 경우 배열 처리
		
		out.println("이름은" + irum + ", 주소는 " + juso[0] + " " + juso[1]);
		
		//checkbox
		String []sports = request.getParameterValues("sports");
		try {
			out.println("<br>선택한 종목은 ");
			for (String s : sports) {
				out.println(s + " ");
			}
		} catch (Exception e) {
			out.println("<br>종목 하나 이상을 선택하면 어쩔지...");
		}
		
		//radio
		String language = request.getParameter("Lan");
		out.println("<br> 자신있는 언어는?" + language);
		
		//select
		String tr = request.getParameter("tr");
		out.println("<br> 고통수단은?" + tr);
		
		//hidden
		String edu = request.getParameter("edu");
		out.println("<br> 교육 기관은?" + edu);
		
		
		out.println("<br><br><a href='postdata.html'> 자료 다시 입력  </a>");
		out.println("</body></html>");
		out.close();
	}

}
