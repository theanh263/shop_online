package shoponline.com.shoponline.controller.admin;

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
import shoponline.com.shoponline.model.ProductModel;
import shoponline.com.shoponline.model.UserModel;
import shoponline.com.shoponline.paging.PageRequest;
import shoponline.com.shoponline.paging.Pageble;
import shoponline.com.shoponline.service.admin.ICategoryService;
import shoponline.com.shoponline.service.admin.IProductService;
import shoponline.com.shoponline.sort.Sorter;
import shoponline.com.shoponline.utils.FormUtil;
import shoponline.com.shoponline.utils.HttpUtil;
import shoponline.com.shoponline.utils.MessageUtil;
import shoponline.com.shoponline.utils.SessionUtil;


@WebServlet(urlPatterns = { "/admin-myproducts" })
public class ProductsController extends HttpServlet {

	private static final long serialVersionUID = 1799846476577373279L;
	@Inject
	private IProductService productService;
	@Inject
	private ICategoryService categoryService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductModel model = FormUtil.toModel(ProductModel.class, request);
		String view = "";
		if (model.getType().equals(SystemConstant.LIST)) {
			Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
					new Sorter(model.getSortName(), model.getSortBy()));
			model.setListResult(productService.findAll(pageble));
			model.setTotalItem(productService.getTotalItem());
			model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
			view = "/views/admin/product/list.jsp";
		} else if (model.getType().equals(SystemConstant.EDIT)) {
			if (model.getId() != null) {
				model = productService.findOne(model.getId());
			}
			request.setAttribute("categories", categoryService.findAll());
			view = "/views/admin/product/edit.jsp";
		}
		MessageUtil.showMessage(request);
		request.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		ProductModel productModel = HttpUtil.of(request.getReader()).toModel(ProductModel.class);
		productModel.setCreatedBy(((UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL")).getUserName());
		productModel = productService.save(productModel);  
		mapper.writeValue(response.getOutputStream(), productModel);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		ProductModel updateProduct = HttpUtil.of(request.getReader()).toModel(ProductModel.class);
		updateProduct
				.setModifiedBy(((UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL")).getUserName());
		updateProduct = productService.update(updateProduct);
		mapper.writeValue(response.getOutputStream(), updateProduct);
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		ProductModel productModel =  HttpUtil.of(request.getReader()).toModel(ProductModel.class);
		productService.delete(productModel.getIds());
		mapper.writeValue(response.getOutputStream(), "{}");
	}

}
