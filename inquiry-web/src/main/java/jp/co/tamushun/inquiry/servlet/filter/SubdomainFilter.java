package jp.co.tamushun.inquiry.servlet.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.filter.GenericFilterBean;

public class SubdomainFilter extends GenericFilterBean {

	private String subdomains;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws ServletException, IOException {

		SubdomainHttpServletRequestWrapper httpRequest = new SubdomainHttpServletRequestWrapper((HttpServletRequest) request);

		String subdomain = getSubdomain(httpRequest);
		if (subdomain != null)
			httpRequest.addHeader("X-Subdomain", subdomain);

		filterChain.doFilter(httpRequest, response);

	}

	private String getSubdomain(HttpServletRequest httpRequest) {

		List<String> subdomains = new ArrayList<String>();
		if (this.subdomains != null) {
			subdomains = Arrays.asList(this.subdomains.split("\\s*,\\s*"));
		}

		for (String subdomain : subdomains) {
			if (httpRequest.getServerName().startsWith(subdomain + "."))
				return subdomain;
		}

		return null;

	}

	public String getSubdomains() {
		return subdomains;
	}

	public void setSubdomains(String subdomains) {
		this.subdomains = subdomains;
	}

}