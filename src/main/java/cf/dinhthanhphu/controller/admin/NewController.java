package cf.dinhthanhphu.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cf.dinhthanhphu.model.NewsModel;
import cf.dinhthanhphu.service.INewService;

@WebServlet(urlPatterns =  {"/admin-new"})
public class NewController  extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private  INewService newsServive;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		NewsModel news = new  NewsModel();
		news.setListResult(newsServive.findAll());
		req.setAttribute("model", news);
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/new/list.jsp");
		rd.forward(req, resp);
	}
}
