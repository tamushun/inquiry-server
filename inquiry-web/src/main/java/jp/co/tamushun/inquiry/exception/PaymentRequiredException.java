package jp.co.tamushun.inquiry.exception;

public class PaymentRequiredException extends HttpException {

	private static final long serialVersionUID = 1L;

	public PaymentRequiredException() {
		super();
	}

	public PaymentRequiredException(String arg0) {
		super(arg0);
	}

	public PaymentRequiredException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public PaymentRequiredException(Throwable arg0) {
		super(arg0);
	}

}
