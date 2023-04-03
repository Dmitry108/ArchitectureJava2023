package ru.home.aglar.architecture.webserver;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class RequestHandler implements Runnable {
    private final SocketService socketService;
    private final Logger logger;
    private final RequestParser parser;
    private final ResponseSerializer serializer;

    public RequestHandler(SocketService socketService, RequestParser parser, ResponseSerializer serializer, Logger logger) {
        this.socketService = socketService;
        this.logger = logger;
        this.parser = parser;
        this.serializer = serializer;
    }

    @Override
    public void run() {
        HttpRequest httpRequest = parser.parse(socketService.readRequest());
        Path path = Paths.get(httpRequest.getPath(), httpRequest.getBody());
        if (!Files.exists(path)) {
            HttpResponse httpResponse = new HttpResponse(404, "NOT_FOUND",
                    HttpResponse.HEADER_STANDARD, "<h1>Файл не найден!</h1>");
            socketService.writeResponse(serializer.serialize(httpResponse),
                    new StringReader(httpResponse.getBody()));
            return;
        }

        try {
            HttpResponse httpResponse = new HttpResponse(200, "OK",
                    HttpResponse.HEADER_STANDARD, null);
            socketService.writeResponse(serializer.serialize(httpResponse), Files.newBufferedReader(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        logger.info("Client disconnected!");
    }
}