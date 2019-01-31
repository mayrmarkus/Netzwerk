package main;

import java.net.Socket;
import java.util.logging.Logger;

public class Game {

    /**
     * Used to store current player
     */
    private int player=0;

    Player p1;
    Player p2;

    int participants = 0;


    public Game() {
        for (int i = 0; i < field.length; i++) {
            for (int i1 = 0; i1 < field[i].length; i1++) {
                field[i][i1] = 1;
            }
        }
    }

    Logger log;

    //---> 7  high 6 wide
    int[][] field = new int[7][6];

    void addPlayer(Player p){
        if(p1 == null){
            p1 = p;
        }else if (p2 == null){
            p2 = p;
        }
    }

    boolean readyToStart(){
        return p2 != null;
    }


    public String getFieldForJson() {
        String json = "";
        json+="{\"field\": [";

        for (int i = 0; i < field.length; i++) {
            json+="[";

            for (int i1 = 0; i1 < field[i].length; i1++) {
                json+=" \"" + field[i][i1] + "\"";
                if(i1 != field[i].length-1)
                    json+=",";
            }
            json+="]";
            if(i != field.length-1)
                json+=",";
        }
        json+="]}";


        return json;
    }
}
