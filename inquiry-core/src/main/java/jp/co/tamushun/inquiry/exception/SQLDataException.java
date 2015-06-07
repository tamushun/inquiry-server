package jp.co.tamushun.inquiry.exception;

public class SQLDataException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private int code = 0;

	public static final int UNKNOWN = -1;

	public SQLDataException() {
		super();
	}

	public SQLDataException(String message, Throwable e, int code) {
		super(message, e);
		setCode(code);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}
