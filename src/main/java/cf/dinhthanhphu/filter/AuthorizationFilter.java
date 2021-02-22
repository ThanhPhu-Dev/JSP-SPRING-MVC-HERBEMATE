package cf.dinhthanhphu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cf.dinhthanhphu.constant.SystemConstant;
import cf.dinhthanhphu.model.UserModel;
import cf.dinhthanhphu.utils.SessionUtil;


public class AuthorizationFilter implements Filter{

    private ServletContext context;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       this.context = filterConfig.getServletContext();
        
    }
// kiểm tra quyền hàng để truy cập vào trang, không kiểm tra tài khoản tồn tại hay không(kiểm tra tài khoản tồn tại = authentication)
//requestURI = contextPath + servletPath + pathInfo
//contextPath = file gốc
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String url = req.getServletPath();
//        String url = req.getRequestURI();
        if(url.startsWith("/admin")) {
            UserModel model = (UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL");
            if(model != null) {
                 if(model.getRole().getCode().equals(SystemConstant.ADMIN)) {
                     chain.doFilter(request, response);
                 }else if(model.getRole().getCode().equals(SystemConstant.USER)) {
                     resp.sendRedirect(req.getContextPath()+"/dang-nhap?action=login&message=not_permission&alter=danger");
                 }
            }else {
                resp.sendRedirect(req.getContextPath() + "/dang-nhap?action=login&message=not_login&alter=danger");
            }
        }else {
            chain.doFilter(request, response);
            
        }
        
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        
    }

}
