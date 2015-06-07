package jp.co.tamushun.inquiry.exception;

public class ForbiddenException extends HttpException {

	private static final long serialVersionUID = 1L;

	public ForbiddenException() {
		super();
	}

	public ForbiddenException(String arg0) {
		super(arg0);
	}

	public ForbiddenException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public ForbiddenException(Throwable arg0) {
		super(arg0);
	}

}
