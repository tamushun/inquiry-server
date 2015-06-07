package jp.co.tamushun.inquiry.exception;

public class NotImplementedException extends HttpException {

	private static final long serialVersionUID = 1L;

	public NotImplementedException() {
		super();
	}

	public NotImplementedException(String arg0) {
		super(arg0);
	}

	public NotImplementedException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public NotImplementedException(Throwable arg0) {
		super(arg0);
	}

}
