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

public class AuthorizationFilter implements Filter{

    private ServletContext context;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       this.context = filterConfig.getServletContext();
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        
    }

}
