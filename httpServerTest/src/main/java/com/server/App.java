package com.server;

import java.io.IOException;

public class App {
    public static void main(String[] args) {
        try {
            HttpServer.startServer(8080);  // 启动服务器，端口 8080
            System.out.println("http server servering on http://localhost:8080");
        } catch (IOException e) {
            System.err.println("Failed to start server: " + e.getMessage());
        }
    }
}

