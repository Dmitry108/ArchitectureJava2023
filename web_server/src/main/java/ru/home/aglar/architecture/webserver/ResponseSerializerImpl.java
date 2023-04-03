package ru.home.aglar.architecture.webserver;

public class ResponseSerializerImpl implements ResponseSerializer {

    @Override
    public String serialize(HttpResponse httpResponse) {
        StringBuilder sb = new StringBuilder("HTTP/1.1")
                .append(" ").append(httpResponse.getStatusCode())
                .append(" ").append(httpResponse.getStatusString()).append("/n")
                .append(httpResponse.getHeaders()).append("/n")
                .append("/n");
        return sb.toString();
    }
}