package shoponline.com.shoponline.service.admin;

import java.io.File;
import java.util.List;

import shoponline.com.shoponline.model.ProductModel;
import shoponline.com.shoponline.paging.Pageble;

public interface IProductService {
	List<ProductModel> findAll(Pageble pageble);
	List<ProductModel> findAll();
	int getTotalItem();
	ProductModel findOne(Long id);
	ProductModel save(ProductModel productModel);
	ProductModel update(ProductModel updateProduct);
	void delete(long[] ids);
	void saveImage(String path, Long id);
}
