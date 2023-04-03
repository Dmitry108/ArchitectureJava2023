package ru.home.aglar.architecture.webserver;

import java.util.List;

public class RequestParserImpl implements RequestParser {
    private static final String WWW = "web_server\\repo\\";

    @Override
    public HttpRequest parse(List<String> rawRequest) {
        String[] parts = rawRequest.get(0).split(" ");
        return new HttpRequest("GET", WWW, null, parts[1]);
    }
}
