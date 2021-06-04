package shoponline.com.shoponline.dao.impl.web;

import java.util.List;

import shoponline.com.shoponline.dao.impl.AbstractDAO;
import shoponline.com.shoponline.dao.web.IProductDAO;
import shoponline.com.shoponline.mapper.ProductMapper;
import shoponline.com.shoponline.model.ProductModel;

public class ProductDAO extends AbstractDAO<ProductModel> implements IProductDAO {

	@Override
	public List<ProductModel> findByCategory(Long id) {
		StringBuilder sql = new StringBuilder("SELECT * FROM product WHERE categoryid =?");
		return query(sql.toString(), new ProductMapper(), id);
	}

	@Override
	public int totalInCart(Long id) {
		String sql = "SELECT count(*) FROM orderdetail WHERE userId=?";
		return count(sql, id);
	}

	@Override
	public void delete(long id) {
		String sql1 = "DELETE FROM orderdetail WHERE productId = ?";
		update(sql1, id);		
	}

	@Override
	public List<ProductModel> resultSearch(String name) {
		StringBuilder sql = new StringBuilder("SELECT * FROM product WHERE title LIKE ?");
		return query(sql.toString(), new ProductMapper(), name);
	}

}
