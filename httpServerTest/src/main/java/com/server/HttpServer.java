package com.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
// import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Executors;

public class HttpServer {

    public static void startServer(int port) throws IOException {
        // 创建 HTTP 服务器并绑定端口
        com.sun.net.httpserver.HttpServer server = com.sun.net.httpserver.HttpServer.create(new InetSocketAddress(port), 0);

        // 配置路由处理器
        server.createContext("/", new RootHandler());
        server.createContext("/hello", new HelloHandler());
        
        // 设置线程池（可选）
        server.setExecutor(Executors.newFixedThreadPool(10));
        
        server.start();
        System.out.println("Server started on port " + port);
    }

    // 根路径处理器
    static class RootHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = "<h1>Welcome to Simple HTTP Server</h1>";
            sendResponse(exchange, response, 200);
        }
    }

    // /hello 路径处理器
    static class HelloHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if ("GET".equalsIgnoreCase(exchange.getRequestMethod())) {
                String jsonResponse = "{\"message\":\"Hello World\", \"status\":200}";
                exchange.getResponseHeaders().set("Content-Type", "application/json");
                sendResponse(exchange, jsonResponse, 200);
            } else {
                sendResponse(exchange, "Method Not Allowed", 405);
            }
        }
    }

    // 通用响应方法
    private static void sendResponse(HttpExchange exchange, String response, int statusCode) throws IOException {
        byte[] bytes = response.getBytes(StandardCharsets.UTF_8);
        exchange.sendResponseHeaders(statusCode, bytes.length);
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(bytes);
        }
    }
}
