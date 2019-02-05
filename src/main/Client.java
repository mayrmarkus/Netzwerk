package main;

import main.GUI.FourInARowPanel;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONString;

import javax.swing.*;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * A command line client for the date server. It prompts you, at the console, to enter
 * the IP address of a server, then displays the response from the server on success,
 * otherwise it crashes and dumps the exception trace.
 */
public class Client {
    private boolean player = false;
    private JPanel rootPanel;
    private boolean spieler = true;

    static JFrame frame = new JFrame("4 Gewinnt");

    public static void main(String[] args) throws IOException {
        System.out.println("Enter the IP address of a machine running the date server:");
        String serverAddress = new Scanner(System.in).nextLine();
        Socket socket = new Socket(serverAddress, 9090);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String response = in.readLine();

        JSONObject json = new JSONObject(response);

        int [][] field = toIntegerArray(json, "field");

        System.out.println("Server response: " + response);

        frame.setVisible(true);
        frame.add(new FourInARowPanel(field));



    }

    private static int[][] toIntegerArray(JSONObject json, String key) {

        int[][] field = new int[7][6];

        JSONArray arr = json.getJSONArray(key);


        for (int i = 0; i < arr.length(); i++) {
            JSONArray inner = arr.getJSONArray(i);

            for (int j = 0; j < inner.length(); j++) {
                field[i][j] = Integer.parseInt(inner.get(j).toString());
            }
        }




        return field;
    }

}