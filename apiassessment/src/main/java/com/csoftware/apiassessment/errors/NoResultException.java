package com.csoftware.apiassessment.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Unfortunately no results found from the data base.")
public class NoResultException  extends RuntimeException{
	private static final long serialVersionUID =3935230281455340039L;
}
