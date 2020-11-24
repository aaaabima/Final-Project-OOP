/*
| NPM           | Name                            |
| ------------- |-------------------------------- |
| 140810190013  | Syakira Rahma Fauziah           |
| 140810190021  | Mochammad Ghifari Eka Narayana  |
| 140810190031  | Mochamad Arya Bima Agfian       |
| 140810190051  | Salma Tri Audryani              |
*/
package src;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

public class ClickListener extends MouseAdapter{
    private int tileSize; // ukuran || dimensi tiles di UI
    private int[] tiles; // tiles itu sendiri yang memiliki nilai index unique
    private int blankPos;   // posisi tiles kosong
    private int size;   // ukuran board game yang dimainkan
    private int gridSize;   // ukuran grid UI
    private int margin; // margin grid dari frame
    private JFrame frame;

    public ClickListener(){
        System.out.println("CilckListener Implemented.");
    }
    
    @Override
    public void mousePressed(MouseEvent e){
        //get position of the click
        int ex = e.getX() - margin;
        int ey = e.getY() - margin;

        System.out.println("x : " + ex + " & y : " + ey);

        //click in the grid
        if(ex < 0 || ex > gridSize || ey < 0 || ey > gridSize)
        return;

        //get position in the grid
        int c1 = ex / tileSize;
        int r1 = ey / tileSize;

        //get position of the blank cell
        int c2 = blankPos % size;
        int r2 = blankPos / size;


        int clikPos = r1 * size + c1;

        int dir = 0;

        
        if(c1 == c2 && Math.abs(r1 - r2) > 0)
        dir = (r1 - r2) > 0 ? size : -size;
        else if(r1 == r2 && Math.abs(c1 - c2) > 0)
        dir = (c1 - c2) > 0 ? 1 : -1;

        if(dir != 0){
            //we move tiles in the direction
            do{
                int newBlankPos = blankPos + dir;
                tiles[blankPos] = tiles[newBlankPos];
                blankPos = newBlankPos;
            }
            while(blankPos != clikPos);
            tiles[blankPos] = 0;
        }
        frame.repaint();
    }
}