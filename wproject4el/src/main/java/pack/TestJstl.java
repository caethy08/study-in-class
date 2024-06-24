package pack;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Testjstl")
public class TestJstl {
	private static final long serialversonUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) {
		String irum = "신기해";
		request.setAttribute("irum", irum);
		
		Person person = new Person();
		person.setName("한국인");
		request.setAttribute("persom", person);
		
		Student student = new Student();
		student.setAge(22);
		request.setAttribute("student", student);
		
		String[] ani = {"댕댕이", "냥이", "말"};
		request.setAttribute("animal", ani);
		
		String[] food = {"당근", "시금치", "호박"};
		List<Object> list = new ArrayList<Object>();
		list.add(ani);
		list.add(food);
		request.setAttribute("list", list);
		
		//response.sendRedirect("testjstl.jsp")irum=irum&person=person;
		request.getRequestDispatcher("testjstl.jsp").forward(request, response); //순서 변경 안됨
	}
}
