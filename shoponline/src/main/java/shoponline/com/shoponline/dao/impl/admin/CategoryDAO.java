package shoponline.com.shoponline.dao.impl.admin;

import java.util.List;

import shoponline.com.shoponline.dao.admin.ICategoryDAO;
import shoponline.com.shoponline.dao.impl.AbstractDAO;
import shoponline.com.shoponline.mapper.CategoryMapper;
import shoponline.com.shoponline.model.CategoryModel;


public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {

	@Override
	public List<CategoryModel> findAll() {
		String sql = "SELECT * FROM category";
		return query(sql, new CategoryMapper());
	}

	@Override
	public CategoryModel findOne(long id) {
		String sql = "SELECT DISTINCT * FROM category WHERE id = ?";
		List<CategoryModel> category = query(sql, new CategoryMapper(), id);
		return category.isEmpty() ? null : category.get(0);
	}

    @Override
    public CategoryModel findOneByCode(String code) {
		String sql = "SELECT * FROM category WHERE code = ?";
		List<CategoryModel> category = query(sql, new CategoryMapper(), code);
		return category.isEmpty() ? null : category.get(0);
    }

}
