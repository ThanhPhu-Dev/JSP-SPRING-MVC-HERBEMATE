package cf.dinhthanhphu.controller.user;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cf.dinhthanhphu.model.UserModel;
import cf.dinhthanhphu.service.ICategoryService;
import cf.dinhthanhphu.service.IUserService;
import cf.dinhthanhphu.utils.FormUtil;
import cf.dinhthanhphu.utils.MessageUtil;
import cf.dinhthanhphu.utils.SessionUtil;

@WebServlet(urlPatterns = { "/trang-chu", "/dang-nhap","/thoat" })
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private ICategoryService categoryService;

	@Inject
	private IUserService userService;

	//đi từ url vào trang chủ
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action != null && action.equals("login")) {
		    MessageUtil.showMessage(req);
			RequestDispatcher rd = req.getRequestDispatcher("/views/login.jsp");
			rd.forward(req, resp);
		} else if (action != null && action.equals("logout")) {
		    SessionUtil.getInstance().removeValue(req, "USERMODEL");
		    resp.sendRedirect(req.getContextPath()+"/trang-chu");
		} else {
			req.setAttribute("category", categoryService.fillAll());
			RequestDispatcher rd = req.getRequestDispatcher("/views/user/Home.jsp");
			rd.forward(req, resp);
		}

	}

	//đi từ trang đăng nhập vào nên dopost sẽ nhận
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action != null && action.equals("login")) {
			UserModel model = FormUtil.toModel(UserModel.class, req);
			model = userService.findUserNameAndPasswordAndStatus(model.getUserName(), model.getPassword(), 1);
			if (model != null) {
			    SessionUtil.getInstance().putValue(req, "USERMODEL", model);
				if (model.getRole().getCode().equals("USER")) {
					resp.sendRedirect(req.getContextPath() + "/trang-chu");
				} else if (model.getRole().getCode().equals("ADMIN")) {
					resp.sendRedirect(req.getContextPath() + "/admin-home");
				}
			} else {
				resp.sendRedirect(req.getContextPath() + "/dang-nhap?action=login&message=username_password_invalid&alter=danger");
			}
		}
	}

}
