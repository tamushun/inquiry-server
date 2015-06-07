package jp.co.tamushun.inquiry.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.tamushun.inquiry.domain.Context;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ResponseStatus(HttpStatus.OK)
public class PageController extends BaseController {

	@RequestMapping(value = "/", method = RequestMethod.GET, headers = "!X-Subdomain")
	public String index(Model model, Context context, HttpServletRequest request) {
		return "page/top";
	}

	@RequestMapping(value = "/error/{status}", method = RequestMethod.GET, headers = "!X-Subdomain")
	public ModelAndView badRequest(@PathVariable int status, Model model, Context context, HttpServletRequest request,
			HttpServletResponse response) {
		return showError(status, request, response);
	}

}
