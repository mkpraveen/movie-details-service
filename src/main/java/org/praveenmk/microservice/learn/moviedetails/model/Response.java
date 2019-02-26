package org.praveenmk.microservice.learn.moviedetails.model;

public class Response {
    private long id;
    private String statusMessage;

    public Response() {
    }

    public Response(long id, String statusMessage) {
        this.id = id;
        this.statusMessage = statusMessage;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }
}
