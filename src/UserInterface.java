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
  // Frame untuk game
  private JFrame frame; 
  // PuzzleGrid berisi grid, logic, dan listener
  private PuzzleGrid pg; 
  // Resolusi windows game
  private int dimension; 
  // Jarak dari ujung board ke grid puzzle
  private int margin; 

  public UserInterface(int size, int dim, int mar, String mode){
    this.pg = new PuzzleGrid(size, dim, mar, mode);
    this.dimension = dim;
    this.margin = mar;
  }

  public void run(){
    frame = new JFrame("Puzzle-15");
    
    frame.setPreferredSize(new Dimension(dimension, dimension + margin));
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