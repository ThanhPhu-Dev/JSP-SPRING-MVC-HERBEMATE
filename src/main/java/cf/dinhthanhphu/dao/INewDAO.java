package cf.dinhthanhphu.dao;

import java.util.List;

import cf.dinhthanhphu.model.NewsModel;

public interface INewDAO extends GenericDAO<NewsModel> {
	NewsModel finOne(Long id);
	List<NewsModel> findByCategoryID(Long categoryId);
	Long save(NewsModel newModel);
	void update(NewsModel updateNews);
	void delete(long id);
	
}
 