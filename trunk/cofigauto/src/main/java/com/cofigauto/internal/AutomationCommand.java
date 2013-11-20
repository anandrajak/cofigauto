/**
 * 
 */
package com.cofigauto.internal;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


/**
 * @author Vinay Sharma
 *
 * @version $Revision: 1.0 $
 */
@Documented
@Retention(value=RetentionPolicy.RUNTIME)
public @interface AutomationCommand {
	/**
	 * Method name.
	 * @return String
	 */
	String name();
}
