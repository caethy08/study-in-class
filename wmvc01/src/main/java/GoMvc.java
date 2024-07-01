

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GoMvc")
public class GoMvc extends HttpServlet { //controller 역할
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String result="", viewName="/WEB-INF/";
		String name;
		
		try {
			name = request.getParameter("name");
		} catch (Exception e) {
			name = null;
		}
		
		//클라이언트의 요청을 받아 분석(판단) : 모델과뷰를 선택하는 기능 기술
		if(name == null || name.equals("")) {
			result = "환영합니다";  //Model(Business Logic)을 수행한 결과(result가 그 값을 받음)라고 가정
			//viewName = "/WEB-INF/views/view1.jsp"; forward방식이며 밑과 동일
			viewName += "views/view1.jsp";
		}else if (name.equals("korea")) {
			result = "한국인이군요";
			viewName += "views/view2.jsp"; 
		}else {
			result = name + "님 반가워요";
			viewName += "views/view3.jsp"; 
		}
		
		request.setAttribute("result", result);
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewName);
		dispatcher.forward(request, response);
	}

}
