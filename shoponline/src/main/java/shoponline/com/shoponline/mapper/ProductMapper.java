package shoponline.com.shoponline.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import shoponline.com.shoponline.model.ProductModel;


public class ProductMapper implements RowMapper<ProductModel> {

	@Override
	public ProductModel mapRow(ResultSet resultSet) {
		try {
			ProductModel product = new ProductModel();
			product.setId(resultSet.getLong("id"));
			product.setTitle(resultSet.getString("title"));
			product.setThumbnail(resultSet.getString("thumbnail"));
			product.setShortDescription(resultSet.getString("shortdescription"));
			product.setDescription(resultSet.getString("description"));
			product.setPrice(resultSet.getLong("price"));
			product.setStock(resultSet.getInt("stock"));
			product.setCategoryId(resultSet.getLong("categoryid"));
			product.setCategoryCode(resultSet.getString("categoryCode"));			
			product.setProducer(resultSet.getString("producer"));
			product.setCreatedDate(resultSet.getTimestamp("createddate"));
			product.setCreatedBy(resultSet.getString("createdby"));
			product.setProducer(resultSet.getString("producer"));
			if (resultSet.getTimestamp("modifieddate") != null) {
				product.setModifiedDate(resultSet.getTimestamp("modifieddate"));
			}
			if (resultSet.getString("modifiedby") != null) {
				product.setModifiedBy(resultSet.getString("modifiedby"));
			}
			return product;
		} catch (SQLException e) {
			return null;
		}	
	}
}
