package ru.home.aglar.architecture.webserver;

public interface ResponseSerializer {
    String serialize(HttpResponse httpResponse);
}