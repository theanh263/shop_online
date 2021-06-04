package shoponline.com.shoponline.mapper;

import java.sql.ResultSet;

import shoponline.com.shoponline.model.OrderDetailModel;

public class OrderDetailMapper implements RowMapper<OrderDetailModel> {

	@Override
	public OrderDetailModel mapRow(ResultSet resultSet) {
		try {
			OrderDetailModel order = new OrderDetailModel();
			order.setId(resultSet.getLong("id"));
			order.setProductId(resultSet.getLong("productId"));
			order.setQuantity(resultSet.getLong("quantity"));
			order.setUserId(resultSet.getLong("userId"));
			order.setUserName(resultSet.getString("userName"));
			order.setProductName(resultSet.getString("productName"));
			order.setCreatedBy(resultSet.getString("createdby"));
			if (resultSet.getTimestamp("modifieddate") != null) {
				order.setModifiedDate(resultSet.getTimestamp("modifieddate"));
			}
			if (resultSet.getString("modifiedby") != null) {
				order.setModifiedBy(resultSet.getString("modifiedby"));
			}
			return order;
		} catch (Exception e) {
			return null;
		}
	}

}
