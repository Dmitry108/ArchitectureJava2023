package ru.home.aglar.architecture.webserver;

public class WebServer {

    public static void main(String[] args) {
        Logger logger = new ConsoleLogger();
        Network network = new Network(logger);
        network.start();
    }
}