package cf.dinhthanhphu.service.impl;

import java.sql.Date;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.inject.Inject;

import cf.dinhthanhphu.dao.ICategoryDAO;
import cf.dinhthanhphu.dao.INewDAO;
import cf.dinhthanhphu.model.CategoryModel;
import cf.dinhthanhphu.model.NewsModel;
import cf.dinhthanhphu.paging.pageble;
import cf.dinhthanhphu.service.INewService;

@ManagedBean
public class NewService implements INewService {

	@Inject
	private INewDAO newsDAO;
	
	@Inject
	private ICategoryDAO categoryDAO;

	@Override
	public List<NewsModel> findByCategoryId(Long categoryId) {
		return newsDAO.findByCategoryID(categoryId);
	}

	@Override
	public NewsModel save(NewsModel newModel) {
		newModel.setCreateDate(new Date(System.currentTimeMillis()));
		CategoryModel category = categoryDAO.findOneByCode(newModel.getCategoryCode());
		newModel.setCategoryId(category.getId());
		Long newId = newsDAO.save(newModel);
		return newsDAO.finOne(newId);
	}

	@Override
	public NewsModel update(NewsModel updateNews) {
		NewsModel oldNew = newsDAO.finOne(updateNews.getId());
		updateNews.setCreateBy(oldNew.getCreateBy());
		updateNews.setCreateDate(oldNew.getCreateDate());
		updateNews.setModifiedDate(new Date(System.currentTimeMillis()));
		CategoryModel category = categoryDAO.findOneByCode(updateNews.getCategoryCode());
		updateNews.setCategoryId(category.getId());
		newsDAO.update(updateNews);
		return newsDAO.finOne(updateNews.getId());
	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			newsDAO.delete(id); 
		}
		
	}

	@Override
	public List<NewsModel> findAll(pageble pageble) {
		return newsDAO.findAll(pageble);
	}

	@Override
	public int getTotalItem() {
		return newsDAO.getTotalItem();
	}

    @Override
    public NewsModel findOne(Long id) {
        NewsModel news = newsDAO.finOne(id);
        CategoryModel category = categoryDAO.findOne(news.getCategoryId());
        news.setCategoryCode(category.getCode());
      return news;
    }

}
