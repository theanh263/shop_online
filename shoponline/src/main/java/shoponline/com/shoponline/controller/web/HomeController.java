package shoponline.com.shoponline.controller.web;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoponline.com.shoponline.model.UserModel;
import shoponline.com.shoponline.service.IUserService;
import shoponline.com.shoponline.service.admin.ICategoryService;
import shoponline.com.shoponline.service.admin.IOrderService;
import shoponline.com.shoponline.service.admin.IProductService;
import shoponline.com.shoponline.utils.FormUtil;
import shoponline.com.shoponline.utils.SessionUtil;

@WebServlet(urlPatterns = { "/trang-chu", "/dang-nhap", "/thoat", "/dang-ky", "/detail" })
public class HomeController extends HttpServlet {

	@Inject
	private ICategoryService categoryService;
	@Inject
	private IProductService productService;
	@Inject
	private shoponline.com.shoponline.service.web.IProductService productServiceWeb;

	@Inject
	private IUserService userService;
	@Inject
	private IOrderService orderService;

	private static final long serialVersionUID = 2686801510274002166L;

	ResourceBundle resourceBundle = ResourceBundle.getBundle("message");

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null && action.equals("login")) {
			String alert = request.getParameter("alert");
			String message = request.getParameter("message");
			if (message != null && alert != null) {
				request.setAttribute("message", resourceBundle.getString(message));
				request.setAttribute("alert", alert);
			}
			RequestDispatcher rd = request.getRequestDispatcher("/views/login.jsp");
			rd.forward(request, response);
		} else if (action != null && action.equals("logout")) {
			SessionUtil.getInstance().removeValue(request, "USERMODEL");
			response.sendRedirect(request.getContextPath() + "/trang-chu");
		} else {
			String idProduct = request.getParameter("id");
			String idCategory = request.getParameter("category");
			if (idProduct == null && idCategory == null) {
				request.setAttribute("products", productService.findAll());
				RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
				rd.forward(request, response);
			}
			if (idProduct != null) {
				Long id = Long.parseLong(idProduct);
				request.setAttribute("product", productService.findOne(id));
				RequestDispatcher rd = request.getRequestDispatcher("/views/web/detail.jsp");
				rd.forward(request, response);
			}
			if (idCategory != null) {
				Long id = Long.parseLong(idCategory);
				request.setAttribute("products", productServiceWeb.findByCategory(id));
				request.setAttribute("category", categoryService.findOne(id));
				RequestDispatcher rd = request.getRequestDispatcher("/views/web/products.jsp");
				rd.forward(request, response);
			}

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		UserModel model = FormUtil.toModel(UserModel.class, request);
		if (action != null && action.equals("login")) {
			UserModel model1 = userService.findByUserNameAndPasswordAndStatus(model.getUserName(), model.getPassword(),
					1);
			if (model1 != null) {
				SessionUtil.getInstance().putValue(request, "USERMODEL", model1);
				if (model1.getRole().getCode().equals("USER")) {
					response.sendRedirect(request.getContextPath() + "/trang-chu");
				} else if (model1.getRole().getCode().equals("ADMIN")) {
					response.sendRedirect(request.getContextPath() + "/admin/trang-chu");
				}
			} else {
				response.sendRedirect(request.getContextPath()
						+ "/dang-nhap?action=login&message=username_password_invalid&alert=danger");
			}
		}
		if (action != null && action.equals("register")) {
			userService.save(model.getUserName(), model.getFullName(), model.getPassword(), 1);
			response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login");
		}

	}
}
