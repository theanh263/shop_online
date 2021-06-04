package shoponline.com.shoponline.dao.impl.admin;

import java.io.File;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import shoponline.com.shoponline.dao.admin.IProductDAO;
import shoponline.com.shoponline.dao.impl.AbstractDAO;
import shoponline.com.shoponline.mapper.ProductMapper;
import shoponline.com.shoponline.model.ProductModel;
import shoponline.com.shoponline.paging.Pageble;

public class ProductDAO extends AbstractDAO<ProductModel> implements IProductDAO {

	@Override
	public List<ProductModel> findAll(Pageble pageble) {
		StringBuilder sql = new StringBuilder("SELECT * FROM product");
		if (pageble.getSorter() != null && StringUtils.isNotBlank(pageble.getSorter().getSortName())
				&& StringUtils.isNotBlank(pageble.getSorter().getSortBy())) {
			sql.append(" ORDER BY " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy() + "");
		}
		if (pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append(" LIMIT " + pageble.getOffset() + ", " + pageble.getLimit() + "");
		}
		return query(sql.toString(), new ProductMapper());
	}

	@Override
	public int getTotalItem() {
		String sql = "SELECT count(*) FROM product";
		return count(sql);
	}

	@Override
	public ProductModel findOne(Long id) {
		String sql = "SELECT * FROM product WHERE id = ?";
		List<ProductModel> proruducts = query(sql, new ProductMapper(), id);
		return proruducts.isEmpty() ? null : proruducts.get(0);
	}

	@Override
	public Long save(ProductModel productModel) {
		StringBuilder sql = new StringBuilder("INSERT INTO product (title,");
		sql.append(
				" shortdescription, price, stock, categoryid,categorycode,producer, description,createddate,createdby)");
		sql.append(" VALUES(?, ?, ?, ?, ?, ?,?,?,?,?)");
		return insert(sql.toString(), productModel.getTitle(), productModel.getShortDescription(),
				productModel.getPrice(), productModel.getStock(), productModel.getCategoryId(),
				productModel.getCategoryCode(), productModel.getProducer(), productModel.getDescription(),
				productModel.getCreatedDate(), productModel.getCreatedBy());
	}

	@Override
	public void update(ProductModel updateProduct) {
		StringBuilder sql = new StringBuilder("UPDATE product SET title = ?,");
		sql.append(" shortdescription = ?, price = ?,");
		sql.append(
				" stock = ?, categoryid = ?, categorycode = ?, producer = ?,description=?,createddate = ?, createdby = ?, modifieddate = ?, modifiedby = ? WHERE id = ?");
		update(sql.toString(), updateProduct.getTitle(), updateProduct.getShortDescription(), updateProduct.getPrice(),
				updateProduct.getStock(), updateProduct.getCategoryId(), updateProduct.getCategoryCode(),
				updateProduct.getProducer(), updateProduct.getDescription(), updateProduct.getCreatedDate(),
				updateProduct.getCreatedBy(), updateProduct.getModifiedDate(), updateProduct.getModifiedBy(),
				updateProduct.getId());
	}

	@Override
	public void delete(long id) {
		String sql = "DELETE FROM product WHERE id = ?";
		String sql1 = "DELETE FROM orderdetail WHERE productId = ?";
		update(sql1, id);
		update(sql, id);
	}

	@Override
	public List<ProductModel> findAll() {
		StringBuilder sql = new StringBuilder("SELECT * FROM product");
		return query(sql.toString(), new ProductMapper());
	}

	@Override
	public void saveImage(String path, Long id) {
		StringBuilder sql = new StringBuilder("UPDATE product SET thumbnail = ? WHERE id=?");
		update(sql.toString(), path, id);

	}

}
