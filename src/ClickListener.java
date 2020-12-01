/*
| NPM           | Name                            |
| ------------- |-------------------------------- |
| 140810190013  | Syakira Rahma Fauziyah          |
| 140810190021  | Mochammad Ghifari Eka Narayana  |
| 140810190031  | Mochamad Arya Bima Agfian       |
| 140810190051  | Salma Tri Audryani              |
*/

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClickListener extends MouseAdapter{
    private int tileSize;       //ukuran || dimensi tiles di UI
    private int[] tiles;        //tiles itu sendiri yang memiliki nilai index unique
    private int blankPos;       //posisi tiles kosong
    private int size;           //ukuran board game yang dimainkan
    private int gridSize;       //ukuran grid UI
    private int margin;         //margin grid dari fram
    private int dimension;      //dimension grid dari frame
    private boolean gameOver;   //gameover
    private PuzzleGrid pg;      //objek PuzzleGrid
    private Logic logic;        //objek Logic

    public ClickListener(PuzzleGrid pg){
        this.pg = pg;
        this.logic = new Logic();
        this.size = pg.getGridSize();
        this.margin = pg.getMargin();
        this.dimension = pg.getDimension();

        //menghitung jumlah tile
        this.tiles = pg.getTiles();

        //menghitung ukuran grid dan tile puzzle
        this.gridSize = (dimension - 2 * margin);
        this.tileSize = gridSize / size;

        this.blankPos = tiles.length - 1;
    }

    @Override
    public void mousePressed(MouseEvent e){
        //menyesuaikan gameStatus di PuzzleGrid
        gameOver = pg.getGameStatus();
        if(gameOver){
            pg.newGame();
        }else{
            //posisi ketika cursor melakakukan 'click'
            int ex = e.getX() - margin;
            int ey = e.getY() - margin;

            //jika di luar grid (bernilai negatif) atau melebihi ukuran grid
            //maka tidak akan ada yang dijalankan
            if(ex < 0 || ex > gridSize || ey < 0 || ey > gridSize)
            return;

            //mengambil posisi grid
            int c1 = ex / tileSize;
            int r1 = ey / tileSize;

            //mengambil posisi blankPos
            int c2 = blankPos % size;
            int r2 = blankPos / size;

            int clickPos = r1 * size + c1;

            //arah pergerakan
            int dir = 0;

            //membandingkan grid yang diklik dengan posisi blankPos
            if(c1 == c2 && Math.abs(r1 - r2) > 0)
            dir = (r1 - r2) > 0 ? size : -size;
            else if(r1 == r2 && Math.abs(c1 - c2) > 0)
            dir = (c1 - c2) > 0 ? 1 : -1;

            if(dir != 0){
                //memindahkan tiles
                do{
                    int newBlankPos = blankPos + dir;
                    tiles[blankPos] = tiles[newBlankPos];
                    blankPos = newBlankPos;
                }
                while(blankPos != clickPos);
                tiles[blankPos] = 0;
                }

                //jika semua tiles berada di tempat yang seharusnya, maka gameOver
                if(logic.isSolved(this.tiles)){
                    pg.setGameOver();
                    this.gameOver = true;
                }
            }
        //paint ulang ketika grid mengalami perubahan di sini
        pg.repaint();
    }
}