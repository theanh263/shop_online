package shoponline.com.shoponline.service.admin;

import java.util.List;

import shoponline.com.shoponline.model.CategoryModel;


public interface ICategoryService {
	List<CategoryModel> findAll();
	CategoryModel findOne(Long id);
}
