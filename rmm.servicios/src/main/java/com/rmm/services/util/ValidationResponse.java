package com.rmm.services.util;

import org.springframework.http.HttpStatus;

public class ValidationResponse {
    boolean Successful;
    String Information;
    HttpStatus httpStatus;

    public ValidationResponse(boolean successful, String information) {
        Successful = successful;
        Information = information;
    }

    public ValidationResponse(boolean successful) {
        Successful = successful;
    }

    public ValidationResponse(boolean successful, String information, HttpStatus httpStatus) {
        Successful = successful;
        Information = information;
        this.httpStatus = httpStatus;
    }

    public boolean isSuccessful() {
        return Successful;
    }

    public void setSuccessful(boolean successful) {
        Successful = successful;
    }

    public String getInformation() {
        return Information;
    }

    public void setInformation(String information) {
        Information = information;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
