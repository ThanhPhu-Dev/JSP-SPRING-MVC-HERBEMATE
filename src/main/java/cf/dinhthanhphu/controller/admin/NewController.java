package cf.dinhthanhphu.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cf.dinhthanhphu.constant.SystemConstant;
import cf.dinhthanhphu.model.NewsModel;
import cf.dinhthanhphu.paging.PageRequest;
import cf.dinhthanhphu.paging.pageble;
import cf.dinhthanhphu.service.INewService;
import cf.dinhthanhphu.sort.Sorter;
import cf.dinhthanhphu.utils.FormUtil;

@WebServlet(urlPatterns = { "/admin-new" })
public class NewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private INewService newsServive;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		NewsModel news = FormUtil.toModel(NewsModel.class, req);
		pageble pageble = new PageRequest(news.getPage(), news.getMaxPageItem(), 
																		new Sorter(news.getSortName(), news.getSortBy()));
		news.setListResult(newsServive.findAll(pageble));
		//đếm số sượng item trong db.
		news.setTotalItem(newsServive.getTotalItem());
		//tính tổng số trang.
		news.setTotalPage((int) Math.ceil((double) news.getTotalItem() /  news.getMaxPageItem()));
		req.setAttribute(SystemConstant.MODEL, news);
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/new/list.jsp");
		rd.forward(req, resp);

	}
}
