package cf.dinhthanhphu.dao.impl;

import java.util.List;

import javax.annotation.ManagedBean;

import cf.dinhthanhphu.dao.ICategoryDAO;
import cf.dinhthanhphu.mapper.CategoryMapper;
import cf.dinhthanhphu.model.CategoryModel;

@ManagedBean
public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {
 
	
	@Override
	public List<CategoryModel> findAll() {
		String sql = "SELECT * FROM category";
		return query(sql, new CategoryMapper());
	}
}
