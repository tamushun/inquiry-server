package jp.co.tamushun.inquiry.controller;

import javax.servlet.http.HttpServletRequest;

import jp.co.tamushun.inquiry.domain.Context;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@ResponseStatus(HttpStatus.OK)
public class PageController extends BaseController {

	@RequestMapping(value = "/", method = RequestMethod.GET, headers = "!X-Subdomain")
	public String index(Model model, Context context, HttpServletRequest request) {
		return "page/top";
	}

}
