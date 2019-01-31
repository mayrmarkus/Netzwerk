package main;// A Java program for a main.Server
import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class Server
{
    //initialize socket and input stream 
    private Socket          socket   = null;
    private ServerSocket    server   = null;
    private DataInputStream in       =  null;

    Game s = new Game();

    ArrayList<Game> games = new ArrayList<Game>();

    Game openGame;

    // constructor with port 
    public Server(int port)
    {
        try (ServerSocket listener = new ServerSocket(9090)) {
            System.out.println("Server is RUNNING   [OK]");


            while (true) {
                int counter=0;
                try (Socket socket = listener.accept()) {
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    openGame = new Game();
                    openGame.addPlayer(new Player(socket, "Player" + counter++));

                    out.println(s.getFieldForJson());




                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[])
    {
        Server server = new Server(5000);
    }
} 