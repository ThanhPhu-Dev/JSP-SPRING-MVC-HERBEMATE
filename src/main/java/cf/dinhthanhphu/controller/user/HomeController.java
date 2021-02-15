package cf.dinhthanhphu.controller.user;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cf.dinhthanhphu.model.NewsModel;
import cf.dinhthanhphu.service.ICategoryService;
import cf.dinhthanhphu.service.INewService;


@WebServlet(urlPatterns = { "/trang-chu","/dang-nhap" })
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ICategoryService categoryService;
	
	@Inject
	private INewService newService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		Long categoryId = 1L;
//		req.setAttribute("news", newService.findByCategoryId(categoryId));
//		NewsModel newModel = new NewsModel();
//		newModel.setCategoryId(1L);
//		newModel.setTitle("Bai Viet 1");
//		newModel.setContent("Bai Viet 1");
//		newService.save(newModel);
		
		String action = req.getParameter("action");
		if(action != null && action.equals("login")) {
			RequestDispatcher rd = req.getRequestDispatcher("/views/login.jsp");
			rd.forward(req, resp);
		}
		else if(action != null && action.equals("logout")){
			
		}else {
			req.setAttribute("category", categoryService.fillAll());
			RequestDispatcher rd = req.getRequestDispatcher("/views/user/Home.jsp");
			rd.forward(req, resp);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/views/user/Home.jsp");
		rd.forward(req, resp);
	}

}
