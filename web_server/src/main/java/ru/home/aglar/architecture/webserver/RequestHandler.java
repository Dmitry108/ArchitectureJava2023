package ru.home.aglar.architecture.webserver;

public interface RequestHandler extends Runnable {
    void handle();
}
