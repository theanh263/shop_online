package shoponline.com.shoponline.service.impl.admin;

import java.util.List;

import javax.inject.Inject;

import shoponline.com.shoponline.dao.admin.ICategoryDAO;
import shoponline.com.shoponline.model.CategoryModel;
import shoponline.com.shoponline.service.admin.ICategoryService;


public class CategoryService implements ICategoryService {
	
	@Inject
	private ICategoryDAO categoryDao;

	@Override
	public List<CategoryModel> findAll() {
		return categoryDao.findAll();
	}

	@Override
	public CategoryModel findOne(Long id) {
		return categoryDao.findOne(id);
	}
}
