package cybersoft.javabackend.gamedoanso.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.javabackend.gamedoanso.util.UrlConst;

@WebFilter(filterName = "authFilter", urlPatterns = UrlConst.GLOBAL)
public class AuthFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		// code xử lý request trước khi vào servlet
		String path = req.getServletPath();
		if(!(path.startsWith(UrlConst.PLAYER_LOGIN) || path.startsWith(UrlConst.PLAYER_REGISTER))) {
			Object player = req.getSession().getAttribute("player");
			if(player == null) {
				resp.sendRedirect(req.getContextPath() + UrlConst.PLAYER_LOGIN);
			} else {
				chain.doFilter(request, response);
			}
		} else {
			chain.doFilter(request, response);
		}
		// code xử lý response trước khi trả về client
	}

}
