package pack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ProductList")
public class ProductList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> products = new ArrayList<Product>();
		products.add(new Product("스페셜티 블렌드", 5000.0, "맛있다1", new Date()));
		products.add(new Product("메가커피,", 5500.0, "맛있다2", new Date()));
		products.add(new Product("춘식이 우유,", 3500.0, "맛있다3", new Date()));
		products.add(new Product("곤약 젤리", 3300.0, "맛있다4", new Date()));
		
		request.setAttribute("products", products);
		request.getRequestDispatcher("/pshow.jsp").forward(request, response);
	}


}
