package cf.dinhthanhphu.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import cf.dinhthanhphu.model.NewsModel;
import cf.dinhthanhphu.service.INewService;
import cf.dinhthanhphu.utils.HttpUtil;

@WebServlet(urlPatterns = { "/admin-new-list" })
public class NewAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private INewService newService;

	// doget dùng để select
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/new/list.jsp");
		rd.forward(req, resp);
	}

	// doPost dùng để insert
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		NewsModel newModel = HttpUtil.of(req.getReader()).toModel(NewsModel.class);
		newModel = newService.save(newModel);
		mapper.writeValue(resp.getOutputStream(), newModel);
	}

	// doPut dùng để update
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		NewsModel updateNews = HttpUtil.of(req.getReader()).toModel(NewsModel.class);
		updateNews = newService.update(updateNews);
		mapper.writeValue(resp.getOutputStream(), updateNews);
	}

	// doDelete dùng để delete
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		NewsModel deleteNews = HttpUtil.of(req.getReader()).toModel(NewsModel.class);
		newService.delete(deleteNews.getIds());
		mapper.writeValue(resp.getOutputStream(), "{}");
	}
}
