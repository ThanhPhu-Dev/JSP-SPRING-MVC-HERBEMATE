package cf.dinhthanhphu.service;

import java.util.List;

import cf.dinhthanhphu.model.NewsModel;
import cf.dinhthanhphu.paging.pageble;

public interface INewService {
	List<NewsModel> findByCategoryId(Long categoryId);
	NewsModel save (NewsModel newModel);
	NewsModel update (NewsModel updateNews);
	void delete(long[] ids);
	List<NewsModel> findAll(pageble pageble);
	int getTotalItem();
}
