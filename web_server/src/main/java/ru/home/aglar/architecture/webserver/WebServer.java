package ru.home.aglar.architecture.webserver;

public class WebServer {

    public static void main(String[] args) {
        RequestHandler requestHandler = new RequestHandler();
        Network network = new Network(requestHandler);
        network.start();
    }
}