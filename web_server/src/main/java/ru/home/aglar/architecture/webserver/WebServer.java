package ru.home.aglar.architecture.webserver;

import ru.home.aglar.architecture.webserver.config.Config;
import ru.home.aglar.architecture.webserver.config.ConfigFactory;

public class WebServer {

    public static void main(String[] args) {
        Config config = ConfigFactory.create(args);
        Logger logger = new ConsoleLogger();
        Network network = new Network(logger, config);
        network.start();
    }
}