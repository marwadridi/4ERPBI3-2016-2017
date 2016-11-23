package edu.esprit.filtres;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.esprit.mb.LoginBean;
import tn.esprit.persistance.Technicien;

/**
 * Servlet Filter implementation class TechnicienFilter
 */

@WebFilter("/pages/technicien/*")
public class TechnicienFilter implements Filter {

    /**
     * Default constructor. 
     */
    public TechnicienFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse resp=(HttpServletResponse) response;
		
		LoginBean logBean = (LoginBean) 
				req.getSession().getAttribute("loginBean");
		
		
		if(logBean!=null && 
				logBean.isLoggedIn() && 
					logBean.getEmploye().getClass()==Technicien.class)
			
			
		chain.doFilter(req, resp);
		
		else
			resp.sendRedirect(req.getContextPath()+"/login.jsf");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
