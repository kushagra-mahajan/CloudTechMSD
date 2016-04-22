package org.cloud.utilities;

public class BaseException {
	// This variable contains the class name where the exception occurred
	private Class<?> className;

	// This variable contains the method name where the exception occurred
	private String methodName;

	// This variable contains the exception error code
	private int errorCode;

	// Hold the time stamp when the exception is created
	private long exceptionTime;

	public BaseException() {
		super();
		exceptionTime = System.currentTimeMillis();
	}

	/**
	 * Constructor with error code and messages
	 *
	 * @param parentException
	 *            - The parent exception
	 * @param errorCode
	 *            - The error code
	 * @param className
	 *            - The class where the exception occurred
	 * @param methodName
	 *            - The class method name where the exception occurred
	 */
	public BaseException(Exception parentException, int errorCode, Class<?> className, String methodName) {
		super();
		this.errorCode = errorCode;
		this.className = className;
		this.methodName = methodName;
		this.exceptionTime = System.currentTimeMillis();
	}

	/**
	 * Constructor with error code and messages
	 *
	 * @param parentException
	 *            - The parent exception
	 * @param errorCode
	 *            - The error code
	 * @param className
	 *            - The class where the exception occurred
	 * @param methodName
	 *            - The class method name where the exception occurred
	 */
	public BaseException(Exception parentException, int errorCode, Class<?> className, String methodName,
			long exceptionTime) {
		super();
		this.errorCode = errorCode;
		this.className = className;
		this.methodName = methodName;
		this.exceptionTime = exceptionTime;
	}

	/**
	 * Constructor with error code and messages
	 *
	 * @param parentException
	 *            - The BaseException
	 */
	public BaseException(BaseException baseException) {
		super();
		this.errorCode = baseException.getErrorCode();
		this.className = baseException.getClassName();
		this.methodName = baseException.getMethodName();
		this.exceptionTime = baseException.getExceptionTime();
	}

	/**
	 * This method returns the error code
	 *
	 * @return the error code
	 */
	public int getErrorCode() {
		return this.errorCode;
	}

	/**
	 * This method return the class name where the exception occurred
	 *
	 * @return the class name where the exception occurred
	 */
	public Class<?> getClassName() {
		return this.className;
	}

	/**
	 * This method return the method name where the exception occurred
	 *
	 * @return the method name where the exception occurred
	 */
	public String getMethodName() {
		return this.methodName;
	}

	/**
	 * This method return the exception created time stamp
	 *
	 * @return the exception time when it was raised
	 */
	public long getExceptionTime() {
		return exceptionTime;
	}

	/**
	 * Sets passed exception time passed as exception raised timestamp
	 * 
	 */
	public void setExceptionTime(long exceptionTime) {
		this.exceptionTime = exceptionTime;
	}

	@Override
	public String toString() {
		return "BaseException [className=" + className + ", methodName=" + methodName + ", errorCode=" + errorCode
				+ ", exceptionTime=" + ApplicationUtil.convertTimeWithTimeZome(exceptionTime) + "]";
	}

}
