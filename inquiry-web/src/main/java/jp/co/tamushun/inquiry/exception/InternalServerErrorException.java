package jp.co.tamushun.inquiry.exception;

public class InternalServerErrorException extends HttpException {

	private static final long serialVersionUID = 1L;

	public InternalServerErrorException() {
		super();
	}

	public InternalServerErrorException(String arg0) {
		super(arg0);
	}

	public InternalServerErrorException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public InternalServerErrorException(Throwable arg0) {
		super(arg0);
	}

}
