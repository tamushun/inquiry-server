package jp.co.tamushun.inquiry.exception;

public class BadRequestException extends HttpException {

	private static final long serialVersionUID = 1L;

	public BadRequestException() {
		super();
	}

	public BadRequestException(String arg0) {
		super(arg0);
	}

	public BadRequestException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public BadRequestException(Throwable arg0) {
		super(arg0);
	}

}
