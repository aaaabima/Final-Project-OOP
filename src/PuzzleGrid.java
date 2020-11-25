/*
| NPM           | Name                            |
| ------------- |-------------------------------- |
| 140810190013  | Syakira Rahma Fauziah           |
| 140810190021  | Mochammad Ghifari Eka Narayana  |
| 140810190031  | Mochamad Arya Bima Agfian       |
| 140810190051  | Salma Tri Audryani              |
*/

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.Container;

public class PuzzleGrid extends JPanel{
    private JFrame frame;
    private int size;
    private String name;

    public PuzzleGrid(int size, String name){
        super();
        this.size = size;
        this.name = name;
        createComponents();
    }

    private void createComponents(){
        JLabel[] pieces = new JLabel[(size * size) -1];

        //memasukkan semua piece puzzle
        for(int i=0; i<size*size-1; i++){
            pieces[i] = new JLabel(new ImageIcon("img/" + String.valueOf(size) + "/" + name + "/" + String.valueOf(i + 1) + ".png"));
        }

        JLabel blank = new JLabel(new ImageIcon("img/" + String.valueOf(size) + "/" + name + "/blank.png"));
        for(int i=0; i<size*size-1; i++){
            add(pieces[i]);
        }
        add(blank);
    }
}