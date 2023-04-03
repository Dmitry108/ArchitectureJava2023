package ru.home.aglar.architecture.webserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Network {
    private Logger logger;

    public Network(Logger logger) {
        this.logger = logger;
    }

    public void start() {
        try (
            ServerSocket serverSocket = new ServerSocket(9090)) {
            logger.info("Server started!");

            while (true) {
                Socket socket = serverSocket.accept();
                logger.info("New client connected!");

                RequestHandler handler = new RequestHandler(new SocketService(socket), logger);
                new Thread(handler).start();
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}