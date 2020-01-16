package com.csoftware.apiassessment.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR, reason="Some internal errors occur on the server, that is why we are unable to handle your request at this time.")
public class Exception500  extends RuntimeException{
	private static final long serialVersionUID =3935230281455340039L;
}
