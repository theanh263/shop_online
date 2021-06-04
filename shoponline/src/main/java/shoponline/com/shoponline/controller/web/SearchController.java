package shoponline.com.shoponline.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoponline.com.shoponline.constant.SystemConstant;
import shoponline.com.shoponline.model.ProductModel;
import shoponline.com.shoponline.service.web.IProductService;
import shoponline.com.shoponline.utils.FormUtil;

@WebServlet(urlPatterns = { "/search" })
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = -2628110191045051317L;

	@Inject
	private IProductService productService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = request.getParameter("title");
		String name = "%" + title + "%";
		request.setAttribute("products", productService.resultSearch(name));
		String view = "/views/web/Search.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

}
