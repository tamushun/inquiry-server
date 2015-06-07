package jp.co.tamushun.inquiry.exception;

public abstract class HttpException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public HttpException() {
		super();
	}

	public HttpException(String arg0) {
		super(arg0);
	}

	public HttpException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public HttpException(Throwable arg0) {
		super(arg0);
	}

}
