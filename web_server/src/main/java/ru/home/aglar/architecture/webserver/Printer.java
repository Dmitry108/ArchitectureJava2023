package ru.home.aglar.architecture.webserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Printer {
    private static String WWW = "web_server\\repo\\";

    public static void sendPage(BufferedReader input, PrintWriter output) throws IOException {
        Path file = Paths.get(WWW, getFilename(input));
        if (!Files.exists(file)) {
            output.println("HTTP/1.1 404 NOT_FOUND");
            output.println("Content-Type: text/html; charset=utf-8");
            output.println();
            output.println("<h1>Файл не найден!</h1>");
            output.flush();
            return;
        }
        output.println("HTTP/1.1 200 OK");
        output.println("Content-Type: text/html; charset=utf-8");
        output.println();

        Files.newBufferedReader(file).transferTo(output);
    }

    public static String getFilename(BufferedReader input) throws IOException {
        String firstLine = input.readLine();
        String[] parts = firstLine.split(" ");
        System.out.println(firstLine);
        while (input.ready()) {
            System.out.println(input.readLine());
        }
        return parts[1];
    }
}