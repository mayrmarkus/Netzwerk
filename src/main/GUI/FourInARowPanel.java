package main.GUI;

import com.sun.javaws.util.JfxHelper;
import main.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class FourInARowPanel extends JPanel {

    int[][] field;
    private JPanel jp;
    private JFrame f;

    //Buttons for selection
    InARowButtons[] buttons = new InARowButtons[7];

    //Just the field
    JLabel [][] guiField = new JLabel[6][7];

    //Used to add buttons
    GridBagConstraints gbc = new GridBagConstraints();

    public FourInARowPanel(int[][] field) {
        f = new JFrame();
        jp = new JPanel();
        f.add(jp);
        jp.setLayout(new GridBagLayout());

        for (int i = 0; i < 7; i++) {


            buttons[i] = new InARowButtons();
            buttons[i].row=i;
            buttons[i].setSize(50, 50);
            GridBagConstraints con = new GridBagConstraints();
            con.gridx = i;
            con.gridy = 0;
            con.fill = GridBagConstraints.BOTH;
            con.weightx = 1;
            con.weighty = 1;
            jp.add(buttons[i], con);

            buttons[i].addMouseListener(new Listener());

        }

        for (int i = 0; i < guiField.length; i++) {
            for (int j = 0; j < guiField[i].length; j++) {
                System.out.println(guiField.length);
                gbc.gridx++;
                GridBagConstraints con = new GridBagConstraints();
                con.gridx = j;
                con.gridy = i + 1;
                con.fill = GridBagConstraints.BOTH;
                con.weightx = 1;
                con.weighty = 1;
                guiField[i][j] = new JLabel("" + field[i][j]);
                guiField[i][j].setSize(50, 50);
                guiField[i][j].setBackground(Color.green);

                jp.add(guiField[i][j],con);

            }

        }
        f.pack();
        f.setVisible(true);
        jp.setVisible(true);




    }

    private class Listener extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mousePressed(e);
            try {
                Client.sendData(((InARowButtons) e.getSource()).row);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

}
