package cf.dinhthanhphu.service;

import java.util.List;

import cf.dinhthanhphu.model.NewsModel;

public interface INewService {
	List<NewsModel> findByCategoryId(Long categoryId);
	NewsModel save (NewsModel newModel);
	NewsModel update (NewsModel updateNews);
	void delete(long[] ids);
	List<NewsModel> findAll();
}
