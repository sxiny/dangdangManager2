package src.com.baizhi.manager.util.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import src.com.baizhi.manager.entity.User;

public class MyFiler implements Filter {
	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();
		String uri = httpRequest.getRequestURI();
		String path = httpRequest.getContextPath();
		User u = (User) session.getAttribute("user");
		if (u != null || (path + "/index.jsp").equals(uri)|| (path + "/file.jsp").equals(uri)) {
			chain.doFilter(request, response);
		} else {
			System.out.println(path);
			httpResponse.sendRedirect(path + "/index.jsp");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
