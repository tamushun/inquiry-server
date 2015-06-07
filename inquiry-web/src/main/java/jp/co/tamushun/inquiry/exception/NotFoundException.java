package jp.co.tamushun.inquiry.exception;

public class NotFoundException extends HttpException {

	private static final long serialVersionUID = 1L;

	public NotFoundException() {
		super();
	}

	public NotFoundException(String arg0) {
		super(arg0);
	}

	public NotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public NotFoundException(Throwable arg0) {
		super(arg0);
	}

}
