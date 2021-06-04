package shoponline.com.shoponline.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoponline.com.shoponline.constant.SystemConstant;
import shoponline.com.shoponline.model.OrderDetailModel;
import shoponline.com.shoponline.paging.PageRequest;
import shoponline.com.shoponline.paging.Pageble;
import shoponline.com.shoponline.service.admin.ICategoryService;
import shoponline.com.shoponline.service.admin.IOrderService;
import shoponline.com.shoponline.sort.Sorter;
import shoponline.com.shoponline.utils.FormUtil;
import shoponline.com.shoponline.utils.MessageUtil;

@WebServlet(urlPatterns = { "/admin-myorders" })
public class OrdersController extends HttpServlet {
	private static final long serialVersionUID = 4641207652096095165L;
	
	@Inject
	private IOrderService orderService;
	@Inject
	private ICategoryService categoryService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrderDetailModel model = FormUtil.toModel(OrderDetailModel.class, request);
		String view = "";
		if (model.getType().equals(SystemConstant.LIST)) {
			Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
					new Sorter(model.getSortName(), model.getSortBy()));
			model.setListResult(orderService.findAll(pageble));
			model.setTotalItem(orderService.getTotalItem(model));
			model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
			view = "/views/admin/orders/list.jsp";
		} else if (model.getType().equals(SystemConstant.EDIT)) {
			if (model.getId() != null) {
				Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
						new Sorter(model.getSortName(), model.getSortBy()));
				model.setTotalItem(orderService.getTotalItem(model));
				model.setListResult(orderService.detail(model.getUserId()));
			}
			request.setAttribute("categories", categoryService.findAll());
			view = "/views/admin/orders/edit.jsp";
		}
		MessageUtil.showMessage(request);
		request.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
}
