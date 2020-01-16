package com.csoftware.apiassessment.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.FORBIDDEN, reason="Uuuuuuuups! you have no access to this resource.")
public class Exception403  extends RuntimeException{
	private static final long serialVersionUID =3935230281455340039L;
}
