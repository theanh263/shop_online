package shoponline.com.shoponline.dao.admin;

import java.util.List;

import shoponline.com.shoponline.dao.GenericDAO;
import shoponline.com.shoponline.model.OrderDetailModel;
import shoponline.com.shoponline.paging.Pageble;

public interface IOrderDAO extends GenericDAO<OrderDetailModel>{
	List<OrderDetailModel> findAll(Pageble pageble);
	int getTotalItem(OrderDetailModel model);
	OrderDetailModel findOne(Long id);
	List<OrderDetailModel> detail (Long id);
	Long save(OrderDetailModel model);
}
