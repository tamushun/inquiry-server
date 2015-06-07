package jp.co.tamushun.inquiry.exception;

public class ServiceTemporarilyUnavailableException extends HttpException {

	private static final long serialVersionUID = 1L;

	public ServiceTemporarilyUnavailableException() {
		super();
	}

	public ServiceTemporarilyUnavailableException(String arg0) {
		super(arg0);
	}

	public ServiceTemporarilyUnavailableException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public ServiceTemporarilyUnavailableException(Throwable arg0) {
		super(arg0);
	}

}
