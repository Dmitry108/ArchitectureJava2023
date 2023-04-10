package ru.home.aglar.architecture.webserver;

public class RequestHandlerProxy implements RequestHandler {
    private RequestHandler requestHandler;
    private Logger logger;

    public RequestHandlerProxy(SocketService socketService, RequestParser parser, ResponseSerializer serializer, Logger logger) {
        this.requestHandler = new RequestHandlerImpl(socketService, parser, serializer);
        this.logger = logger;
    }

    @Override
    public void run() {
        handle();

    }

    @Override
    public void handle() {
        requestHandler.handle();
        logger.info("Client disconnected!");
    }
}