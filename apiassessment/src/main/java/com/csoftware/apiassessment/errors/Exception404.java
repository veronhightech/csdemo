package com.csoftware.apiassessment.errors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

@Component
@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Sorry, resource not found.")
public class Exception404  extends BasicException{
	private static final long serialVersionUID =3935230281455340039L;
}
