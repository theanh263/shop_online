package shoponline.com.shoponline.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import shoponline.com.shoponline.constant.SystemConstant;
import shoponline.com.shoponline.model.OrderDetailModel;
import shoponline.com.shoponline.model.ProductModel;
import shoponline.com.shoponline.model.UserModel;
import shoponline.com.shoponline.service.admin.ICategoryService;
import shoponline.com.shoponline.service.admin.IOrderService;
import shoponline.com.shoponline.service.web.IProductService;
import shoponline.com.shoponline.utils.FormUtil;
import shoponline.com.shoponline.utils.HttpUtil;
import shoponline.com.shoponline.utils.SessionUtil;

@WebServlet(urlPatterns = { "/myproducts" })
public class ProductsController extends HttpServlet {

	private static final long serialVersionUID = 1799846476577373279L;
	@Inject
	private IProductService productService;
	@Inject
	private IOrderService orderService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrderDetailModel model = FormUtil.toModel(OrderDetailModel.class, request);
		String id = request.getParameter("userCart");
		if (id != null) {
			Long idCart = Long.parseLong(id);
			model.setListResult(orderService.detail(idCart));
			request.setAttribute(SystemConstant.MODEL, model);
		}
		String view = "/views/web/cart.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		OrderDetailModel orderModel = HttpUtil.of(request.getReader()).toModel(OrderDetailModel.class);
		orderModel = orderService.save(orderModel);
		mapper.writeValue(response.getOutputStream(), orderModel);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		OrderDetailModel productModel =  HttpUtil.of(request.getReader()).toModel(OrderDetailModel.class);
		productService.delete(productModel.getIds());
		mapper.writeValue(response.getOutputStream(), "{}");
	}

}
