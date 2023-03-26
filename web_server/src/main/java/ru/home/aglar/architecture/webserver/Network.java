package ru.home.aglar.architecture.webserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Network {
    private RequestHandler handler;

    public Network(RequestHandler handler) {
        this.handler = handler;
    }

    public void start() {
        try (
            ServerSocket serverSocket = new ServerSocket(9090)) {
            System.out.println("Server started!");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected!");

                new Thread(() -> {
                    handler.handleRequest(socket);
                    System.out.println("Client disconnected!");
                }).start();
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}