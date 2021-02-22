package cf.dinhthanhphu.dao.impl;

import java.util.List;

import javax.annotation.ManagedBean;

import cf.dinhthanhphu.dao.INewDAO;
import cf.dinhthanhphu.mapper.NewMapper;
import cf.dinhthanhphu.model.NewsModel;
import cf.dinhthanhphu.paging.pageble;

@ManagedBean
public class NewDao extends AbstractDAO<NewsModel> implements INewDAO{

	@Override
	public List<NewsModel> findByCategoryID(Long categoryId) {
		String sql = "SELECT * FROM news WHERE categoryid=?";
		return query(sql, new NewMapper(), categoryId);
	}

	@Override
	public Long save(NewsModel newModel) {
		String sql = "INSERT INTO news (title,thumbnail,shortdescription, content, categoryid, createddate, createdby) VALUES(?,?,?,?,?,?,?)";
		return Insert(sql, newModel.getTitle(),newModel.getThumbnail(),newModel.getShortDescription(),
		              newModel.getContent(),newModel.getCategoryId(),
		              newModel.getCreateDate(),newModel.getCreateBy());
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
		sql.append("createdby = ?,  createddate= ?, modifieddate = ?, modifiedby = ? WHERE id = ?");
		
		Update(sql.toString(), updateNews.getTitle(),updateNews.getThumbnail(),updateNews.getShortDescription(), updateNews.getContent(),
		        updateNews.getCategoryId(),updateNews.getCreateBy(), updateNews.getCreateDate(),updateNews.getModifiedDate(),
		        updateNews.getModifiedBy(), updateNews.getId());
		
	}

	@Override
	public void delete(long id) {
		String sql = "DELETE FROM news WHERE id = ?";
		// xóa cmt trước rồi mới xóa news được, hiện tại chưa có cmt nên tạm thời xóa dc news
		//update cũng thực hiện được cho xóa
		Update(sql,id);
	}

	@Override
	public List<NewsModel> findAll(pageble pageble) {
//		String sql = "SELECT *  FROM news  ORDER BY id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
		StringBuilder sql = new StringBuilder("SELECT * FROM news");
		if(pageble.getSorter() != null)
		{
			sql.append(" ORDER BY " +pageble.getSorter().getSortName()+ " "+ pageble.getSorter().getSortBy());
		}
		else {
			sql.append(" ORDER BY id");
		}
		if(pageble.getOffset() != null && pageble.getLimit() != null)//nếu để null vào câu query thì chổ set parameter sẽ bị lổi vì k có kiệu null
		{
			
			sql.append(" OFFSET "+pageble.getOffset()+" ROWS FETCH NEXT "+pageble.getLimit()+" ROWS ONLY");
		}
		return query(sql.toString(), new NewMapper());
	}

	@Override
	public int getTotalItem() {
		String sql ="SELECT COUNT(*) FROM news";
		return count(sql);
	}

	

	

}
