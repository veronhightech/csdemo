package com.csoftware.apiassessment.errors;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.csoftware.apiassessment.dto.ProductsDTO;

//@ControllerAdvice 
@ControllerAdvice("com.csoftware.apiassessment")
@RequestMapping(produces = "application/vnd.error+json")
public class GlobalErrorControllerAdvice {

	@ExceptionHandler(NotFoundException.class) 
	public ResponseEntity < ? > notFoundException(final NotFoundException e) {
		System.out.println("woooooooooooooooooooy 1");
        return error(e, HttpStatus.NOT_FOUND, e.getMessage());
    }
	
	@ExceptionHandler(Exception400.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity < ? > processException400(Exception e){
		return error(e, HttpStatus.BAD_REQUEST, e.getMessage());
	}
	
	@ExceptionHandler(Exception404.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity < ? > processException404(Exception e){
		System.out.println("woooooooooooooooooooy 2");
		return error(e, HttpStatus.NOT_FOUND, e.getMessage());
	}
	
	@ExceptionHandler(Exception403.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public ResponseEntity < ? > processException403(Exception e){
		return error(e, HttpStatus.FORBIDDEN, e.getMessage());
	}
	
		
	@ExceptionHandler(Exception500.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity < ? > processException500(Exception e){
		return error(e, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
	}
	
	/*@ExceptionHandler(NoResultException.class)
    public ResponseEntity<Exception> handleNoResultException(
            NoResultException e) {
        //log.error("> handleNoResultException");
        //log.error("- NoResultException: ", e);
        //log.error("< handleNoResultException");
        //return new ResponseEntity<Exception>(HttpStatus.NOT_FOUND);
        return error(e, HttpStatus.NOT_FOUND, e.getMessage());
    }*/
	
	
	/*@ExceptionHandler(BadRequest.class) 
	public ResponseEntity < ? > notFoundException(final NotFoundException e) {
        return error(e, HttpStatus.NOT_FOUND, e.getMessage());
    }
	
	@ExceptionHandler(NotFoundException.class) 
	public ResponseEntity < ? > notFoundException(final NotFoundException e) {
        return error(e, HttpStatus.NOT_FOUND, e.getMessage());
    }
	
	@ExceptionHandler(NotFoundException.class) 
	public ResponseEntity < ? > notFoundException(final NotFoundException e) {
        return error(e, HttpStatus.NOT_FOUND, e.getMessage());
    }*/
    
	/*private ResponseEntity < ? > error(final Exception exception, final HttpStatus httpStatus, final String logRef) {
        final String message = Optional.of(exception.getMessage()).orElse(exception.getClass().getSimpleName());
        return new ResponseEntity < > (new VndErrors(logRef, message), httpStatus);
    }*/
	
    @ExceptionHandler(IllegalArgumentException.class) 
    public ResponseEntity < ? > assertionException(final IllegalArgumentException e) {
        return error(e, HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
    }
    @ExceptionHandler(Exception.class) 
	public ResponseEntity <?> notFoundException(final Exception e) {
    	System.out.println("woooooooooooooooooooy 3");
        return error(e, HttpStatus.NOT_FOUND, e.getMessage()); 
    }
    
    
    private ResponseEntity<?> error(Exception exception, HttpStatus errorCode, String message){
    	Map<String, Object> myErrorInfo = new HashMap<>();
    	myErrorInfo.put("timestamp", new Date());
    	myErrorInfo.put("status", errorCode);
    	myErrorInfo.put("errCode", errorCode);
    	myErrorInfo.put("errMsg", message);
    	myErrorInfo.put("error", message);
    	myErrorInfo.put("message", message);
    	
    	System.out.println("woooooooooooooooooooy ");
    	exception.printStackTrace();
		
        //return error(e, HttpStatus.NOT_FOUND, e.getMessage());
    	//return new ResponseEntity<List<ProductsDTO>>(listProductsx, HttpStatus.OK);
    	//return new ResponseEntity<String>(HttpStatus.OK);
    	//return new ResponseEntity<String>(myErrorInfo, errorCode);
    	return new ResponseEntity<Map<String, Object>>(myErrorInfo, errorCode);
    }
}
