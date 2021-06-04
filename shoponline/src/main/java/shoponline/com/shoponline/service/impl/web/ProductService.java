package shoponline.com.shoponline.service.impl.web;

import java.util.List;

import javax.inject.Inject;

import shoponline.com.shoponline.dao.web.IProductDAO;
import shoponline.com.shoponline.model.ProductModel;
import shoponline.com.shoponline.service.web.IProductService;

public class ProductService implements IProductService {
	@Inject
	private IProductDAO productDAO;

	@Override
	public List<ProductModel> findByCategory(Long id) {
		return productDAO.findByCategory(id);
	}

	@Override
	public int totalInCart(Long id) {
		return productDAO.totalInCart(id);
	}

	@Override
	public void delete(long[] ids) {
		for (Long id : ids) {
			productDAO.delete(id);
		}	
	}

	@Override
	public List<ProductModel> resultSearch(String name) {
		return productDAO.resultSearch(name);
	}

}
