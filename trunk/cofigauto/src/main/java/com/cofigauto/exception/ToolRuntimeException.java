/**
 * 
 */
package com.cofigauto.exception;

/**
 * @author vsha28
 *
 * @version $Revision: 1.0 $
 */
public class ToolRuntimeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * @param message
	 */
	public ToolRuntimeException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * @param message
	 * @param cause
	 */
	public ToolRuntimeException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
}
