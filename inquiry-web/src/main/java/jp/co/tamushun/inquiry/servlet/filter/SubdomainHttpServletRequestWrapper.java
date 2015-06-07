package jp.co.tamushun.inquiry.servlet.filter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class SubdomainHttpServletRequestWrapper extends HttpServletRequestWrapper {

	private Map<String, String> headers = new HashMap<String, String>();

	public SubdomainHttpServletRequestWrapper(HttpServletRequest request) {
		super(request);
	}

	public Enumeration<String> getHeaderNames() {

		HttpServletRequest request = (HttpServletRequest) getRequest();

		List<String> headerNames = new ArrayList<String>();

		Enumeration<String> enumeration = request.getHeaderNames();
		while (enumeration.hasMoreElements())
			headerNames.add(enumeration.nextElement().toString());

		Iterator<String> iterator = headers.keySet().iterator();
		while (iterator.hasNext())
			headerNames.add(iterator.next());

		return Collections.enumeration(headerNames);

	}

	public void addHeader(String name, String value) {
		headers.put(name, new String(value));
	}

	public String getHeader(String name) {

		if (headers.containsKey(name))
			return headers.get(name);

		return ((HttpServletRequest) getRequest()).getHeader(name);

	}

}
