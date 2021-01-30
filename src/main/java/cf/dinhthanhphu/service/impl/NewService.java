package cf.dinhthanhphu.service.impl;

import java.sql.Date;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.inject.Inject;

import cf.dinhthanhphu.dao.INewDAO;
import cf.dinhthanhphu.model.NewsModel;
import cf.dinhthanhphu.service.INewService;

@ManagedBean
public class NewService implements INewService {

	@Inject
	private INewDAO newsDAO;

	@Override
	public List<NewsModel> findByCategoryId(Long categoryId) {
		return newsDAO.findByCategoryID(categoryId);
	}

	@Override
	public NewsModel save(NewsModel newModel) {
		newModel.setCreateDate(new Date(System.currentTimeMillis()));
		newModel.setCreateBy("");
		Long newId = newsDAO.save(newModel);
		return newsDAO.finOne(newId);
	}

	@Override
	public NewsModel update(NewsModel updateNews) {
		NewsModel oldNew = newsDAO.finOne(updateNews.getId());
		updateNews.setCreateBy(oldNew.getCreateBy());
		updateNews.setCreateDate(oldNew.getCreateDate());
		updateNews.setModifiedBy("");
		updateNews.setModifiedDate(new Date(System.currentTimeMillis()));
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
	public List<NewsModel> findAll() {
		return newsDAO.findAll();
	}

}
