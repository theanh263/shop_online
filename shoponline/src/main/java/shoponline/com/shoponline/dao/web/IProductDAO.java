package shoponline.com.shoponline.dao.web;

import java.util.List;

import shoponline.com.shoponline.dao.GenericDAO;
import shoponline.com.shoponline.model.ProductModel;

public interface IProductDAO  extends GenericDAO<ProductModel>{
	List<ProductModel> findByCategory(Long id );
	int totalInCart (Long id);
	void delete(long id);
	List<ProductModel> resultSearch(String name);
}
