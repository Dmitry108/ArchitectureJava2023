package ru.home.aglar.architecture.webserver;

public class HttpResponse {
    public static final String HEADER_STANDARD = "Content-Type: text/html; charset=utf-8";

    private int statusCode;
    private String statusString;
    private String headers;
    private String body;

    public HttpResponse(int statusCode, String statusString, String headers, String body) {
        this.statusCode = statusCode;
        this.statusString = statusString;
        this.headers = headers;
        this.body = body;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusString() {
        return statusString;
    }

    public void setStatusString(String statusString) {
        this.statusString = statusString;
    }

    public String getHeaders() {
        return headers;
    }

    public void setHeaders(String headers) {
        this.headers = headers;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}