package cf.dinhthanhphu.dao;

import java.util.List;

import cf.dinhthanhphu.model.CategoryModel;

public interface ICategoryDAO extends GenericDAO<CategoryModel>{
	List<CategoryModel> findAll();
}