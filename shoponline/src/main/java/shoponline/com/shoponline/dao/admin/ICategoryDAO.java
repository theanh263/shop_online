package shoponline.com.shoponline.dao.admin;

import java.util.List;

import shoponline.com.shoponline.dao.GenericDAO;
import shoponline.com.shoponline.model.CategoryModel;


public interface ICategoryDAO extends GenericDAO<CategoryModel> {
	List<CategoryModel> findAll();
	CategoryModel findOne(long id);
	CategoryModel findOneByCode(String code);
}
