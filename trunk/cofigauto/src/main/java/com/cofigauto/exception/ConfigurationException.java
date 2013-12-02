package com.cofigauto.exception;

/**
 * @author vsha28
 * 
 * @version $Revision: 1.0 $
 */
public class ConfigurationException extends Exception {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    /**
     * @param message exception message
     */
    public ConfigurationException(final String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param message
     * @param cause
     */
    public ConfigurationException(final String message, final Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

}
