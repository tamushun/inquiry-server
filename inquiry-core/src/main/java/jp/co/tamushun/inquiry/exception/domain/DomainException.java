package jp.co.tamushun.inquiry.exception.domain;

import jp.co.tamushun.inquiry.domain.Error;

public abstract class DomainException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public static final int UNKNOWN_ERROR = 99;

	private static final int UNIT_SIZE = 100;

	private int code = 0;

	public DomainException() {
		super();
	}

	public DomainException(int arg0) {
		super();
		setCode(code);
	}

	public DomainException(Throwable arg0, int arg1) {
		super(arg0);
		setCode(arg1);
	}

	public DomainException(String arg0) {
		super(arg0);
	}

	public DomainException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public DomainException(Throwable arg0) {
		super(arg0);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getDomainCode() {
		String domainName = this.getClass().getSimpleName().replace("Exception", "");
		Domain domain = Domain.valueOf(domainName);
		return domain.getCode();
	}

	public Error getError() {
		return generateError(500, "Unexpected error.");
	}

	protected Error generateError(int status, String message) {
		return new Error(status, message, getDomainCode() * UNIT_SIZE + getCode());
	}

	public enum Domain {

		Account(10);

		private int code;

		Domain(int code) {
			this.code = code;
		}

		public int getCode() {
			return code;
		}
	}

}
