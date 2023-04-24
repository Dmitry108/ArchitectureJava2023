package ru.home.aglar.architecture.webserver;

import ru.home.aglar.architecture.webserver.config.Config;

import java.util.List;

public class RequestParserImpl implements RequestParser {
    private Config config;

    public RequestParserImpl(Config config) {
        this.config = config;
    }

    @Override
    public HttpRequest parse(List<String> rawRequest) {
        String[] parts = rawRequest.get(0).split(" ");
        return new HttpRequest("GET", config.getWwwHome(), null, parts[1]);
    }
}
