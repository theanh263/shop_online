package shoponline.com.shoponline.dao.admin;

import java.io.File;
import java.util.List;

import shoponline.com.shoponline.dao.GenericDAO;
import shoponline.com.shoponline.model.ProductModel;
import shoponline.com.shoponline.paging.Pageble;

public interface IProductDAO extends GenericDAO<ProductModel>{
	List<ProductModel> findAll(Pageble pageble);
	List<ProductModel> findAll();
	int getTotalItem();
	ProductModel findOne(Long id);
	Long save(ProductModel productModel);
	void update(ProductModel updateProduct);
	void delete(long id);
	void saveImage(String path, Long id);
}
