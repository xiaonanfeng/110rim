package com.zxit.interceptor;//package com.xyz.interceptor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.Map;

/**
 * 异常统一处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @Resource
    private HttpServletRequest request;

    @ResponseBody
    @ExceptionHandler(value = {ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrorResponse constraintViolationException(ConstraintViolationException ex) {
        String requestPath = request.getRequestURL().toString();
        Map<String,String[]> parameterMap =  request.getParameterMap();
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(500, 5001, ex.getMessage(),requestPath,parameterMap);
        return apiErrorResponse;
    }

    @ResponseBody
    @ExceptionHandler(value = {IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrorResponse IllegalArgumentException(IllegalArgumentException ex) {
        String requestPath = request.getRequestURL().toString();
        Map<String,String[]> parameterMap =  request.getParameterMap();
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(500, 5002, ex.getMessage(),requestPath,parameterMap);
        return apiErrorResponse;
    }

    @ResponseBody
    @ExceptionHandler(value = {NoHandlerFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrorResponse noHandlerFoundException(Exception ex) {
        String requestPath = request.getRequestURL().toString();
        Map<String,String[]> parameterMap =  request.getParameterMap();
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(400, 4001, ex.getMessage(),requestPath,parameterMap);
        return apiErrorResponse;
    }


    @ResponseBody
    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiErrorResponse unknownException(Exception ex) {
        String requestPath = request.getRequestURL().toString();
        Map<String,String[]> parameterMap =  request.getParameterMap();
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(500, 5002, ex.getMessage(),requestPath,parameterMap);
        return apiErrorResponse;
    }

}
