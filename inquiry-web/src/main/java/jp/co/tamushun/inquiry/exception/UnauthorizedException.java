package jp.co.tamushun.inquiry.exception;

public class UnauthorizedException extends HttpException {

	private static final long serialVersionUID = 1L;

	public UnauthorizedException() {
		super();
	}

	public UnauthorizedException(String arg0) {
		super(arg0);
	}

	public UnauthorizedException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public UnauthorizedException(Throwable arg0) {
		super(arg0);
	}

}
