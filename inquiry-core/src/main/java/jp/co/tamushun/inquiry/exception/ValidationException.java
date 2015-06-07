package jp.co.tamushun.inquiry.exception;

public class ValidationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ValidationException() {
		super();
	}

	public ValidationException(String arg0) {
		super(arg0);
	}

	public ValidationException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
