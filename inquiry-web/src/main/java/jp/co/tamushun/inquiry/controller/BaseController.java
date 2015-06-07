package jp.co.tamushun.inquiry.controller;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import javax.naming.ServiceUnavailableException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.core.NoContentException;

import jp.co.tamushun.inquiry.converter.ConvertOptions;
import jp.co.tamushun.inquiry.converter.ErrorConverter;
import jp.co.tamushun.inquiry.domain.Error;
import jp.co.tamushun.inquiry.exception.NotFoundException;
import jp.co.tamushun.inquiry.exception.NotImplementedException;
import jp.co.tamushun.inquiry.exception.PaymentRequiredException;
import jp.co.tamushun.inquiry.exception.ServiceTemporarilyUnavailableException;
import jp.co.tamushun.inquiry.exception.UnauthorizedException;
import jp.co.tamushun.inquiry.exception.ValidationException;
import jp.co.tamushun.inquiry.exception.domain.DomainException;
import jp.co.tamushun.inquiry.response.ErrorResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

@Controller
@ResponseStatus(HttpStatus.OK)
public class BaseController {

	protected Logger logger;

	@Autowired
	ErrorConverter errorConverter;

	public BaseController() {
		super();
		logger = LoggerFactory.getLogger(this.getClass());
	}

	@ExceptionHandler
	public ModelAndView handleException(DomainException e, HttpServletRequest request, HttpServletResponse response) {
		if (e.getError().getStatus() == 500)
			logger.error("", e);
		else
			logger.debug("", e);
		return showError(e.getError(), request, response);
	}

	@ExceptionHandler
	public ModelAndView handleException(NoContentException e, HttpServletRequest request, HttpServletResponse response) {
		return showError(204, e.getMessage(), request, response);
	}

	@ExceptionHandler
	public ModelAndView handleException(BadRequestException e, HttpServletRequest request, HttpServletResponse response) {
		logger.debug("", e);
		return showError(400, e.getMessage(), request, response);
	}

	@ExceptionHandler
	public ModelAndView handleException(ValidationException e, HttpServletRequest request, HttpServletResponse response) {
		logger.debug("", e);
		return showError(400, e.getMessage(), request, response);
	}

	@ExceptionHandler
	public ModelAndView handleException(MissingServletRequestParameterException e, HttpServletRequest request, HttpServletResponse response) {
		logger.debug("", e);
		return showError(400, request, response);
	}

	@ExceptionHandler
	public ModelAndView handleException(TypeMismatchException e, HttpServletRequest request, HttpServletResponse response) {
		logger.debug("", e);
		return showError(400, request, response);
	}

	@ExceptionHandler
	public ModelAndView handleException(HttpMessageNotReadableException e, HttpServletRequest request, HttpServletResponse response) {
		logger.debug("", e);
		return showError(400, request, response);
	}

	@ExceptionHandler
	public ModelAndView handleException(MethodArgumentNotValidException e, HttpServletRequest request, HttpServletResponse response) {
		logger.debug("", e);
		return showError(400, request, response);
	}

	@ExceptionHandler
	public ModelAndView handleException(MissingServletRequestPartException e, HttpServletRequest request, HttpServletResponse response) {
		logger.debug("", e);
		return showError(400, request, response);
	}

	@ExceptionHandler
	public ModelAndView handleException(ServletRequestBindingException e, HttpServletRequest request, HttpServletResponse response) {
		logger.debug("", e);
		return showError(400, request, response);
	}

	@ExceptionHandler
	public ModelAndView handleException(BindException e, HttpServletRequest request, HttpServletResponse response) {
		logger.debug("", e);
		return showError(400, request, response);
	}

	@ExceptionHandler
	public ModelAndView handleException(UnauthorizedException e, HttpServletRequest request, HttpServletResponse response) {
		logger.debug("", e);
		return showError(401, e.getMessage(), request, response);
	}

	@ExceptionHandler
	public ModelAndView handleException(PaymentRequiredException e, HttpServletRequest request, HttpServletResponse response) {
		logger.debug("", e);
		return showError(402, e.getMessage(), request, response);
	}

	@ExceptionHandler
	public ModelAndView handleException(ForbiddenException e, HttpServletRequest request, HttpServletResponse response) {
		logger.debug("", e);
		return showError(403, e.getMessage(), request, response);
	}

	@ExceptionHandler
	public ModelAndView handleException(NotFoundException e, HttpServletRequest request, HttpServletResponse response) {
		return showError(404, e.getMessage(), request, response);
	}

	@ExceptionHandler
	public ModelAndView handleException(NoSuchRequestHandlingMethodException e, HttpServletRequest request, HttpServletResponse response) {
		return showError(404, request, response);
	}

	@ExceptionHandler
	public ModelAndView handleException(HttpMediaTypeNotAcceptableException e, HttpServletRequest request, HttpServletResponse response) {
		logger.debug("", e);
		return showError(406, request, response);
	}

	@ExceptionHandler
	public ModelAndView handleException(HttpMediaTypeNotSupportedException e, HttpServletRequest request, HttpServletResponse response) {
		logger.debug("", e);
		return showError(415, request, response);
	}

	@ExceptionHandler
	public ModelAndView handleException(Exception e, HttpServletRequest request, HttpServletResponse response) {
		logger.error("", e);
		return showError(500, request, response);
	}

	@ExceptionHandler
	public ModelAndView handleException(NotImplementedException e, HttpServletRequest request, HttpServletResponse response) {
		logger.debug("", e);
		return showError(501, request, response);
	}

	@ExceptionHandler
	public ModelAndView handleException(ServiceUnavailableException e, HttpServletRequest request, HttpServletResponse response) {
		logger.debug("", e);
		return showError(503, request, response);
	}

	@ExceptionHandler
	public ModelAndView handleException(ServiceTemporarilyUnavailableException e, HttpServletRequest request, HttpServletResponse response) {
		logger.debug("", e);
		return showError(503, request, response);
	}

	protected ModelAndView showError(int status, HttpServletRequest request, HttpServletResponse response) {
		return showError(status, null, request, response);
	}

	protected ModelAndView showError(int status, String message, HttpServletRequest request, HttpServletResponse response) {
		if (message == null)
			message = getDefaultMessage(status);
		return showError(new Error(status, message), request, response);
	}

	protected ModelAndView showError(Error error, HttpServletRequest request, HttpServletResponse response) {

		response.setStatus(error.getStatus());

		ErrorResponse errorResponse = errorConverter.convert(error, EnumSet.noneOf(ConvertOptions.class));

		if (request.getPathInfo().matches("^/\\d+/.*")) {
			try {
				new MappingJackson2HttpMessageConverter().write(errorResponse, MediaType.APPLICATION_JSON, new ServletServerHttpResponse(
						response));
			} catch (Exception e) {
				response.setStatus(500);
			}
			return null;
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("error", errorResponse);
			return new ModelAndView("page/error", map);
		}

	}

	private String getDefaultMessage(int status) {

		switch (status) {
		case 200:
			return "OK";
		case 400:
			return "Bad Request";
		case 401:
			return "Unauthorized";
		case 403:
			return "Forbidden";
		case 404:
			return "Not Found";
		case 406:
			return "Not Acceptable";
		case 415:
			return "Unsupprted Media Type";
		case 500:
			return "Internal server error";
		case 501:
			return "Not Implemented";
		case 503:
			return "Service temprary unavailable.";
		default:
			return null;
		}

	}
}
