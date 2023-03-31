package com.yayangchun.traditionalchinesemedicinemuseum.unit;

/**
 * 作者：崖洋春
 * 时间：2023/3/11 14:10
 **/

import java.io.*;
import java.net.*;

public class TCPTool {

    public static void send(String message, String ipAddress, int port) throws IOException {
        Socket socket = new Socket(ipAddress, port);
        OutputStream out = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(out);
        writer.println(message);
        writer.flush();
        socket.close();
    }

    public static String receive(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket = serverSocket.accept();
        InputStream in = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String message = reader.readLine();
        socket.close();
        serverSocket.close();
        return message;
    }
}