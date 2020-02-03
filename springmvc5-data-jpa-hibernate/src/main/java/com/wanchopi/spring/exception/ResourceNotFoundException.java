package com.wanchopi.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Handle exceptions
 * @author Wanchopi
 *
 */
@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long resourceId;
	
	
	public ResourceNotFoundException(long resourceId) {
		this.resourceId = resourceId;
	}
	
	public long getResourceId() {
		return resourceId;
	}

}
