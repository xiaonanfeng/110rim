package com.zxit.interceptor;

import java.util.Map;

/**
 * @author ming
 */
public class ApiErrorResponse {

    private int status;
    private int code;
    private String message;
    private String requestPath;
    private Map<String,String[]> paramsMap;

    public ApiErrorResponse(int status, int code, String message, String requestPath, Map<String,String[]> paramsMap) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.requestPath = requestPath;
        this.paramsMap = paramsMap;
    }

    public int getStatus() {
        return status;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getRequestPath() {
        return requestPath;
    }

    public void setRequestPath(String requestPath) {
        this.requestPath = requestPath;
    }

    public Map<String, String[]> getParamsMap() {
        return paramsMap;
    }

    public void setParamsMap(Map<String, String[]> paramsMap) {
        this.paramsMap = paramsMap;
    }

    @Override
    public String toString() {
        return "ApiErrorResponse{" +
                "status=" + status +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", requestPath='" + requestPath + '\'' +
                ", paramsMap=" + paramsMap +
                '}';
    }
}