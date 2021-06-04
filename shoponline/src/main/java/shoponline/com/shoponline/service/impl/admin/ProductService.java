package shoponline.com.shoponline.service.impl.admin;

import java.io.File;
import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import shoponline.com.shoponline.dao.admin.ICategoryDAO;
import shoponline.com.shoponline.dao.admin.IProductDAO;
import shoponline.com.shoponline.model.CategoryModel;
import shoponline.com.shoponline.model.ProductModel;
import shoponline.com.shoponline.paging.Pageble;
import shoponline.com.shoponline.service.admin.IProductService;

public class ProductService implements IProductService {

	@Inject
	private IProductDAO productDAO;
	@Inject
	private ICategoryDAO categoryDAO;

	@Override
	public List<ProductModel> findAll(Pageble pageble) {
		return productDAO.findAll(pageble);
	}

	@Override
	public int getTotalItem() {
		return productDAO.getTotalItem();
	}

	@Override
	public ProductModel findOne(Long id) {
		return productDAO.findOne(id);
	}

	@Override
	public ProductModel save(ProductModel productModel) {
		productModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		CategoryModel category = categoryDAO.findOneByCode(productModel.getCategoryCode());
		productModel.setCategoryId(category.getId());
		Long productId = productDAO.save(productModel);
		return productDAO.findOne(productId);
	}

	@Override
	public ProductModel update(ProductModel updateProduct) {
		ProductModel oldNew = productDAO.findOne(updateProduct.getId());
		updateProduct.setCreatedDate(oldNew.getCreatedDate());
		updateProduct.setCreatedBy(oldNew.getCreatedBy());
		updateProduct.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		CategoryModel category = categoryDAO.findOneByCode(updateProduct.getCategoryCode());
		updateProduct.setCategoryId(category.getId());
		productDAO.update(updateProduct);
		return productDAO.findOne(updateProduct.getId());
	}

	@Override
	public void delete(long[] ids) {
		for (long id: ids) {
			//1.delete comment (khoa ngoai new_id)
			//2.delete news
			productDAO.delete(id);
		}
	}

	@Override
	public List<ProductModel> findAll() {
		return productDAO.findAll();
	}

	@Override
	public void saveImage(String path, Long id) {
		productDAO.saveImage(path, id);	
	}

}
