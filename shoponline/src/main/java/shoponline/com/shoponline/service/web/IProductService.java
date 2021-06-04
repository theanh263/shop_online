package shoponline.com.shoponline.service.web;

import java.util.List;

import shoponline.com.shoponline.model.OrderDetailModel;
import shoponline.com.shoponline.model.ProductModel;

public interface IProductService {
	List<ProductModel> findByCategory(Long id);
	int totalInCart(Long id);
	
	void delete(long[] ids );
	List<ProductModel> resultSearch(String name);
}
