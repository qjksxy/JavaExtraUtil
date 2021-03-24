package main;

public class BaseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7606560193037767948L;

	public BaseException() {}

	public BaseException(String message) {
		super(message);
	}

	public BaseException(Throwable cause) {
		super(cause);
	}

	public BaseException(String message, Throwable cause) {
		super(message, cause);
	}

	public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
}
