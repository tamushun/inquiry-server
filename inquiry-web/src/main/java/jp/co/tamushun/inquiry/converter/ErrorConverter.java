package jp.co.tamushun.inquiry.converter;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import jp.co.tamushun.inquiry.domain.Error;
import jp.co.tamushun.inquiry.response.ErrorResponse;

import org.springframework.stereotype.Component;

@Component
public class ErrorConverter extends BaseConverter {

	public ErrorResponse convert(Error error, EnumSet<ConvertOptions> options) {

		if (error == null)
			return null;

		return new ErrorResponse(error);

	}

	public List<ErrorResponse> convert(List<Error> errors, EnumSet<ConvertOptions> options) {

		List<ErrorResponse> errorResponses = new ArrayList<ErrorResponse>();

		for (Error error : errors)
			errorResponses.add(convert(error, options));

		return errorResponses;

	}

}
