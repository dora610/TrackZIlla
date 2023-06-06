/**
 * 
 */
package com.karurisuro.springBootMvc.exception;

/**
 * @author surajitkaruri
 *
 */
public class ApplicationNotFoundException extends RuntimeException {
	public ApplicationNotFoundException(String exception) {
		super(exception);
	}
}
