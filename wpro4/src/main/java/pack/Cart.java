package pack;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Cart")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		HttpSession session = request.getSession(true);
		
		ArrayList<Goods> glist = (ArrayList<Goods>)session.getAttribute("list"); //arratList로 캐스팅해서 세션 밖으로 glist를 꺼냄 list라는 이름의 새손을 꺼내서 glist에게 줌
		
		if(glist == null) glist = new ArrayList<Goods>(); //최초의 상품일경우 goods 객체를 담을 glist 생성 arraylist생성
		glist.add(new Goods(name, price)); //이름과 가격을 가진 goods를 glist에 추가
		session.setAttribute("list", glist); //list라는 이름을 준 세션에 glist를 담음
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body>▶" + name + "구입했습니다.");
		out.println("<br>[<a href='myshop.html'>계속 쇼핑</a>]");
		out.println("[<a href='Buy'>결제하기</a>]<br>");
		
		out.println("<p><table width='80%'>");
		out.println("<tr><th>상품명</th><th>가격</th></tr>");
		for (int i = 0; i < glist.size(); i++) {
			Goods goods = (Goods)glist.get(i); //glist의 요소들을 순서대로 goods타입으로 꺼냄
			out.println("<tr><td>" + goods.getName() + "</td>");
			out.println("<td>" + goods.getPrice() + "</td></tr>");
		}
		out.println("</table>");
		out.println("</body></html>");
		out.close();
	
	}

}
