package cf.dinhthanhphu.service.impl;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.inject.Inject;

import cf.dinhthanhphu.dao.ICategoryDAO;
import cf.dinhthanhphu.model.CategoryModel;
import cf.dinhthanhphu.service.ICategoryService;

@ManagedBean
public class CategoryService implements ICategoryService{
	
	@Inject
	private ICategoryDAO categoryDao;
	@Override
	public List<CategoryModel> fillAll() {
		
		return categoryDao.findAll();
	}
	
}
