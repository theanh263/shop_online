package shoponline.com.shoponline.service.admin;

import java.util.List;

import shoponline.com.shoponline.model.OrderDetailModel;
import shoponline.com.shoponline.paging.Pageble;

public interface IOrderService {
	List<OrderDetailModel> findAll(Pageble pageble);
	int getTotalItem(OrderDetailModel model);
	OrderDetailModel findOne(Long id);
	List<OrderDetailModel> detail (Long id);
	OrderDetailModel save(OrderDetailModel model);
}
