package main;

import java.net.ServerSocket;
import java.net.Socket;

public class Player {
    private Socket socket;
    String name;

    public Player(Socket socket, String name) {
        this.socket = socket;
        this.name = name;
    }
}
