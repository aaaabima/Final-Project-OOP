/*
| NPM           | Name                            |
| ------------- |-------------------------------- |
| 140810190013  | Syakira Rahma Fauziah           |
| 140810190021  | Mochammad Ghifari Eka Narayana  |
| 140810190031  | Mochamad Arya Bima Agfian       |
| 140810190051  | Salma Tri Audryani              |
*/
package src;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

public class UserInterface implements Runnable{
    private JFrame frame;
    private int size;
    private String name;
    private PuzzleGrid pg;

    public UserInterface(int size, String name){
        this.size = size;
        this.name = name;
        this.pg = new PuzzleGrid(size, name);
    }

    public void run(){
        frame = new JFrame("Puzzle-15");
        frame.setPreferredSize(new Dimension(850, 900));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container){
        container.add(pg, BorderLayout.CENTER);
        container.addMouseListener(new ClickListener());
    }

    public JFrame getFrame(){
        return frame;
    }
}