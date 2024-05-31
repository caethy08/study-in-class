package pack.other;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pack.test_grade;

@WebServlet("/test_result")
public class test_result extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String no = request.getParameter("no");
		String name = request.getParameter("name");
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		HttpSession session = request.getSession(true);
		
		ArrayList<test_grade> glist = (ArrayList<test_grade>)session.getAttribute("list");
		
		if (glist == null) glist = new ArrayList<test_grade>();
		glist.add(new test_grade(no, name, kor, eng));
		session.setAttribute("list", glist);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body> 세션처리 결과.");
		out.println("<br>학생들 성적표<br>");
		
		out.println("<p><table width='80%'>");
		out.println("</body></html>");
		out.println("<tr><th>번호</th><th>이름</th><th>국어</th><th>영어</th><th>총점</th></tr>");
		int total = 0;
		int count = 0;
		for (int i = 0; i < glist.size(); i++) {
			test_grade grade =(test_grade)glist.get(i);
			out.println("<tr><td>" + grade.getNo() + "</td>");
			out.println("<td>" + grade.getName() + "</td>");
			out.println("<td>" + grade.getKor() + "</td>");
			out.println("<td>" + grade.getEng() + "</td>");
			total = grade.getKor() + grade.getEng();
			out.println("<td>" + total + "</td></tr>");			
			count ++;
		}
		out.println("<tr><td colspan = '2'>인원수: " + count + "명</td><tr>");
		out.println("</table>");
		
		out.println("<br>[<a href='servlet_test.html'> 새로입력 </a>]");
		out.println("[<a href='test_delete.jsp'> 세션삭제 </a>]");
		out.println("</body></html>");
		out.close();
	}

}
