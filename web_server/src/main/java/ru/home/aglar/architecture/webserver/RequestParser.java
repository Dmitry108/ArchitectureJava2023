package ru.home.aglar.architecture.webserver;

import java.util.List;

public interface RequestParser {
    HttpRequest parse(List<String> rawRequest);
}
