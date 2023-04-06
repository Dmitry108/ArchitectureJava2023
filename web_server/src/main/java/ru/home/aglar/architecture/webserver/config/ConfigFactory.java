package ru.home.aglar.architecture.webserver.config;

public class ConfigFactory {
    public static Config create(String[] args) {
        Config config;
        config = args.length == 2 ?
                new ConfigFromCli(args) :
                new ConfigFromFile("server.properties");
        return config;
    }
}
