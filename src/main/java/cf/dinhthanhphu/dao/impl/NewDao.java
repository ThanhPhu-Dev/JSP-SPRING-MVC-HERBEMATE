package cf.dinhthanhphu.dao.impl;

import java.util.List;

import javax.annotation.ManagedBean;

import cf.dinhthanhphu.dao.INewDAO;
import cf.dinhthanhphu.mapper.NewMapper;
import cf.dinhthanhphu.model.NewsModel;

@ManagedBean
public class NewDao extends AbstractDAO<NewsModel> implements INewDAO{

	@Override
	public List<NewsModel> findByCategoryID(Long categoryId) {
		String sql = "SELECT * FROM news WHERE categoryid=?";
		return query(sql, new NewMapper(), categoryId);
	}

	@Override
	public Long save(NewsModel newModel) {
		String sql = "INSERT INTO news (title, content, categoryid) VALUES(?,?,?)";
		return Insert(sql, newModel.getTitle(),newModel.getContent(),newModel.getCategoryId());
	}

	@Override
	public NewsModel finOne(Long id) {
		String sql = "SELECT * FROM news WHERE id=?";
		List<NewsModel> news =  query(sql, new NewMapper(), id);
		return news.isEmpty() ? null : news.get(0);
	}

	@Override
	public void update(NewsModel updateNews) {
		StringBuilder sql = new StringBuilder( "UPDATE  news SET title = ?, thumbnail = ?,");
		sql.append("shortdescription = ?, content = ?, categoryid = ?,");
		sql.append("createdby = ?,  createddate= ? WHERE id = ?");
		
		Update(sql.toString(), updateNews.getTitle(),updateNews.getThumbnail(),updateNews.getShortDescription(), updateNews.getContent(), updateNews.getCategoryId(),
				updateNews.getCreateBy(), updateNews.getCreateDate(), updateNews.getId());
		
	}

	@Override
	public void delete(long id) {
		String sql = "DELETE FROM news WHERE id = ?";
		// xóa cmt trước rồi mới xóa news được, hiện tại chưa có cmt nên tạm thời xóa dc news
		//update cũng thực hiện được cho xóa
		Update(sql,id);
	}

	

	

}
