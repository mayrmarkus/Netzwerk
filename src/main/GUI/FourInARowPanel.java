package main.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FourInARowPanel extends JPanel {

    int[][] field;

    //Buttons for selection
    JButton[] buttons = new JButton[6];

    //Just the field
    JLabel [][] guiField = new JLabel[6][7];

    //Used to add buttons
    GridBagConstraints gbc = new GridBagConstraints();

    public FourInARowPanel(int[][] field) {
        this.setLayout(new GridBagLayout());
        gbc.fill = 1;



        for (int i = 0; i < guiField.length; i++) {
            gbc.gridx=0;

            for (int i1 = 0; i1 < guiField[i].length; i1++) {
                System.out.println(guiField.length);
                gbc.gridx++;

                guiField[i][i1] = new JLabel("" + field[i][i1]);

                this.add(guiField[i][i1], gbc);

            }
            gbc.gridy++;
        }


    }

    private class listener extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {


            super.mousePressed(e);
        }
    }
}
