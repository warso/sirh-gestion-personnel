package dev.sgp.filtre;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import dev.sgp.entite.VisiteWeb;
import dev.sgp.service.VisiteWebService;


@WebFilter(urlPatterns = { "/*" }, description = "filter")
public class FrequentationFilter implements Filter {

	@Inject private VisiteWebService visiteService;
	@Override
	public void init(FilterConfig config) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		String path = ((HttpServletRequest) req).getRequestURI();

		long before = System.currentTimeMillis();
		chain.doFilter(req, resp);
		long after = System.currentTimeMillis();

		visiteService.sauvegarderVisite(new VisiteWeb(path, after - before));

	}

	@Override
	public void destroy() {
	}
}
