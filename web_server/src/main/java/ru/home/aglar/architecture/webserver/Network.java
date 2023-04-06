package ru.home.aglar.architecture.webserver;

import ru.home.aglar.architecture.webserver.config.Config;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Network {
    private Logger logger;
    private Config config;

    public Network(Logger logger, Config config) {
        this.logger = logger;
        this.config = config;
    }

    public void start() {
        try (
            ServerSocket serverSocket = new ServerSocket(config.getPort())) {
            logger.info("Server started at port " + config.getPort());

            while (true) {
                Socket socket = serverSocket.accept();
                logger.info("New client connected!");

                RequestParser parser = new RequestParserImpl(config);
                ResponseSerializer serializer = new ResponseSerializerImpl();
                RequestHandler handler = new RequestHandler(new SocketService(socket),
                        parser, serializer, logger);
                new Thread(handler).start();
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}