package shoponline.com.shoponline.service.impl.admin;

import java.util.List;

import javax.inject.Inject;

import shoponline.com.shoponline.dao.admin.IOrderDAO;
import shoponline.com.shoponline.model.OrderDetailModel;
import shoponline.com.shoponline.paging.Pageble;
import shoponline.com.shoponline.service.admin.IOrderService;

public class OrderService implements IOrderService {
	@Inject
	private IOrderDAO orderDAO;

	@Override
	public List<OrderDetailModel> findAll(Pageble pageble) {
		return orderDAO.findAll(pageble);
	}

	@Override
	public int getTotalItem(OrderDetailModel model) {
		return orderDAO.getTotalItem(model);
	}

	@Override
	public OrderDetailModel findOne(Long id) {
		return orderDAO.findOne(id);
	}

	@Override
	public List<OrderDetailModel> detail(Long id) {
		return orderDAO.detail(id);
	}

	@Override
	public OrderDetailModel save(OrderDetailModel model) {
		Long id = orderDAO.save(model);
		return orderDAO.findOne(id);
	}

}
