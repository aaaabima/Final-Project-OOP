/*
| NPM           | Name                            |
| ------------- |-------------------------------- |
| 140810190013  | Syakira Rahma Fauziyah          |
| 140810190021  | Mochammad Ghifari Eka Narayana  |
| 140810190031  | Mochamad Arya Bima Agfian       |
| 140810190051  | Salma Tri Audryani              |
*/

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

public class UserInterface implements Runnable{
    private JFrame frame; // Frame untuk game
    private PuzzleGrid pg; // PuzzleGrid berisi grid, logic, dan listener
    private int dim; // Resolusi windows game
    private int mar; // Margin, self-explanatory

    public UserInterface(int size, int dim, int mar, String mode){
        this.pg = new PuzzleGrid(size, dim, mar, mode);
        this.dim = dim;
        this.mar = mar;
    }

    public void run(){
        frame = new JFrame("Puzzle-15");
        
        frame.setPreferredSize(new Dimension(dim, dim + mar));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container){
        container.add(pg, BorderLayout.CENTER);
    }

    public JFrame getFrame(){
        return frame;
    }
}