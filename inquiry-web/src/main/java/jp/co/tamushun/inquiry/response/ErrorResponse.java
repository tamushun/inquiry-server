package jp.co.tamushun.inquiry.response;

import jp.co.tamushun.inquiry.domain.Error;

public class ErrorResponse {

	private Error error;

	public ErrorResponse(Error error) {
		this.error = error;
	}

	public String getMessage() {
		return error.getMessage();
	}

	public Integer getCode() {
		return error.getCode();
	}

}
