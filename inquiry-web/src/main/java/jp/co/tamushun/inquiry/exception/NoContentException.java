package jp.co.tamushun.inquiry.exception;

public class NoContentException extends HttpException {

	private static final long serialVersionUID = 1L;

	public NoContentException() {
		super();
	}

	public NoContentException(String arg0) {
		super(arg0);
	}

	public NoContentException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public NoContentException(Throwable arg0) {
		super(arg0);
	}

}
