package shoponline.com.shoponline.dao.impl.admin;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import shoponline.com.shoponline.dao.admin.IOrderDAO;
import shoponline.com.shoponline.dao.impl.AbstractDAO;
import shoponline.com.shoponline.mapper.OrderDetailMapper;
import shoponline.com.shoponline.model.OrderDetailModel;
import shoponline.com.shoponline.paging.Pageble;

public class OrderDAO extends AbstractDAO<OrderDetailModel> implements IOrderDAO {

	@Override
	public List<OrderDetailModel> findAll(Pageble pageble) {
		StringBuilder sql = new StringBuilder("SELECT DISTINCT * FROM orderdetail");
		if (pageble.getSorter() != null && StringUtils.isNotBlank(pageble.getSorter().getSortName())
				&& StringUtils.isNotBlank(pageble.getSorter().getSortBy())) {
			sql.append(" ORDER BY " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy() + "");
		}
		if (pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append(" LIMIT " + pageble.getOffset() + ", " + pageble.getLimit() + "");
		}
		return query(sql.toString(), new OrderDetailMapper());
	}

	@Override
	public int getTotalItem(OrderDetailModel model) {
		String sql = "SELECT count(*) FROM orderdetail WHERE userId=? && productId=?";
		return count(sql, model.getUserId(), model.getProductId());
	}

	@Override
	public OrderDetailModel findOne(Long id) {
		String sql = "SELECT * FROM orderdetail WHERE id = ?";
		List<OrderDetailModel> proruducts = query(sql, new OrderDetailMapper(), id);
		return proruducts.isEmpty() ? null : proruducts.get(0);
	}

	@Override
	public List<OrderDetailModel> detail(Long id) {
		StringBuilder sql = new StringBuilder(
				"SELECT * FROM  orderdetail inner join product on orderdetail.productId = product.id WHERE orderdetail.userId =?");
		return query(sql.toString(), new OrderDetailMapper(), id);
	}
	
	@Override
	public Long save(OrderDetailModel model) {
		StringBuilder sql = new StringBuilder("INSERT INTO orderdetail (productId, quantity, userId, userName, productName) VALUES (?, ?, ?, ?, ?)");
		return insert(sql.toString(), model.getProductId(), model.getQuantity(), model.getUserId(), model.getUserName(),
				model.getProductName(), model.getCreatedDate(), model.getCreatedBy());
	}

}
