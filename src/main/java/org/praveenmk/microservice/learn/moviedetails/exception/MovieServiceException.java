package org.praveenmk.microservice.learn.moviedetails.exception;

public class MovieServiceException extends Exception {
    private static final long serialVersionUID = 1L;
    private String errorMessage;

    public MovieServiceException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;

    }

    public MovieServiceException() {
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
