package com.patricknymark;

import java.io.IOException;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        System.out.println("Client: Starting...");

        try {
            Socket socket = new Socket("localhost", 5000);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
