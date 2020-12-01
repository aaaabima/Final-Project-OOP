/*
| NPM           | Name                            |
| ------------- |-------------------------------- |
| 140810190013  | Syakira Rahma Fauziyah          |
| 140810190021  | Mochammad Ghifari Eka Narayana  |
| 140810190031  | Mochamad Arya Bima Agfian       |
| 140810190051  | Salma Tri Audryani              |
*/

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.RenderingHints;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Dimension;
import java.util.Random;

public class PuzzleGrid extends JPanel{
    private int size; // Ukuran game puzzle
    private int nbTiles; // Jumlah tiles yang akan ada di games
    private int dimension; // Ukuran dimensi grid UI
    private static final Color FOREGROUND_COLOR = new Color(214, 103, 59); // Warna foreground
    private static final Random RANDOM = new Random(); // Objek random untuk mengacak puzzle
    private int[] tiles; // Menyimpan tile di array 1 dimensi
    private int tileSize; // Ukuran masing-masung tile
    private int blankPos; // Tempat blank harus berada
    private int margin; // Jarak dari ujung board ke grid puzzle
    private int gridSize; // Ukuran grid UI untuk puzzle
    private boolean gameOver; // Bernilai true jika game berakhir
    private boolean custom; // Mengecek apakah user menggunakan default puzzle atau tidak
    private String mode; // Mode game yang akan dimainkan
    private Logic logic; // Objek Logix game puzzle
    private ClickListener cl; // ActionListener menggunakan mouse alias MouseListener

    public PuzzleGrid(int size, int dim, int mar, String mode){
        // Mengaktifkan custom jika 'mode' bukanlah sebuah string kosong
        if(mode != ""){
            this.custom = true;
        }else{
            this.custom = false;
        }

        this.size = size;
        this.dimension = dim;
        this.margin = mar;
        this.mode = mode;

        // Menghitung jumlah tile
        this.nbTiles = size * size - 1; // Jumlah tile tidak termasuk bagian <blank>
        this.tiles = new int[size * size];

        // Menghitung ukuran grid puzzle dan tile puzzle
        this.gridSize = (dimension - 2 * margin);
        this.tileSize = gridSize / size;

        // Instansiasi Logic dan ClickListener
        this.logic = new Logic();
        this.cl = new ClickListener(this);

        // Mengatur ukuran PuzzleGrid berdasarkan dimension
        setPreferredSize(new Dimension(dimension, dimension + margin));
        setBackground(Color.WHITE);
        setForeground(FOREGROUND_COLOR);
        setFont(new Font("Courier New", Font.BOLD, 50));

        // Set gameOver di construct agar game dapat dimainkan
        gameOver = true;

        // Menambah MouseListener menggunakan class ClickListener
        addMouseListener(cl);

        // Reset Button
        JButton reset = new JButton("Reset");
        add(reset);
        reset.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                newGame();
                repaint();
            }
        });

        // Memulai game
        newGame();
    }

    // Menampilan tulisan untuk memulai game ketika gameOver
    public void drawStart(Graphics2D g){
        if(gameOver){
            g.setFont(getFont().deriveFont(Font.BOLD, 18));
            g.setColor(FOREGROUND_COLOR);
            String s = "Klik di mana saja untuk memulai game.";
            g.drawString(s, (getWidth() - g.getFontMetrics().stringWidth(s)) / 2, 
                            getHeight() - margin);
        }
    }

    // Menggambar sebuah angka di tengah objeknya berdasarkan (x, y)
    public void drawNumber(Graphics2D g, String s, int x, int y){
        FontMetrics fm = g.getFontMetrics();
        int asc = fm.getAscent();
        int desc = fm.getDescent();
        g.drawString(s, x + (tileSize - fm.stringWidth(s)) /2,
                        y + (asc +(tileSize - (asc + desc)) / 2));
    }

    // Menggambar keseluruhan grid berdasarkan size
    public void drawGrid(Graphics2D g){
        for(int i = 0; i < tiles.length; i++){
            // Menentukan row & column untuk setiap tile puzzle
            int row = i / size;
            int col = i % size;

            // Memasukkan koordinat ke UI
            int x = margin + col * tileSize;
            int y = margin + row * tileSize;

            // Tiles kosong yang akan disimpan di posisi terakhir
            if(tiles[i] == 0){
                if(gameOver){
                    g.setColor(FOREGROUND_COLOR);
                    drawNumber(g, "Done!", x, y);
                    // Ketika custom aktif, dalam kata lain "mode" memiliki isi parameter,
                    // maka angka di atas akan di-overwrite menggunakan mode gambar yang diinput
                    if(custom)
                    g.drawImage(new ImageIcon("../img/" + String.valueOf(size) + "/" + mode + "/" + String.valueOf(size * size) + ".png").getImage(),
                    x, y, new ImageIcon("../img/4/rem/" + String.valueOf(tiles[i]) + ".png").getImageObserver());
                }
                continue;
            }

            // Menggambar tile lain atau tile normal
            g.setColor(getForeground());
            g.fillRoundRect(x, y, tileSize, tileSize, 25, 25);
            g.setColor(Color.BLACK);
            g.drawRoundRect(x, y, tileSize, tileSize, 25, 25);
            g.setColor(Color.WHITE);

            // By Default, tile akan diisi menggunakan angka yang menjadi value tiles[i]
            drawNumber(g, String.valueOf(tiles[i]), x, y);
            // Ketika custom aktif, dalam kata lain "mode" memiliki isi parameter,
            // maka angka di atas akam di-overwrite menggunakan mode gambar yang diinput
            if(custom){
                g.drawImage(new ImageIcon("../img/" + String.valueOf(size) + "/" + mode + "/" + String.valueOf(tiles[i]) + ".png").getImage(),
                x, y, new ImageIcon("../img/" + String.valueOf(size) + "/" + mode + "/" + String.valueOf(tiles[i]) + ".png").getImageObserver());
            }
        }
    }

    public void newGame(){
        do{
            reset(); // Mengembalikan semua tile seperti semula
            shuffle(); // Mengacak tile
        } while(!logic.isSolvable(this)); // Looping dilakukan selama Puzzle tidak bisa diselesaikan

        gameOver = false;
    }

    public void reset(){
        for(int i = 0; i < tiles.length; i++){
            tiles[i] = (i + 1) % tiles.length;
        }

        // Menyimpan blankPos di posisi teralhir dari array
        blankPos = tiles.length - 1;
    }

    public void shuffle(){
        // Mengacak semua tiles tanpa blankPos
        int n = nbTiles;

        while(n > 1){
            int r = RANDOM.nextInt(n--);
            int tmp = tiles[r];
            tiles[r] = tiles[n];
            tiles[n] = tmp;
        }
    }

    public int getDimension(){
        return this.dimension;
    }
    public int getMargin(){
        return this.margin;
    }
    public int getGridSize(){
        return this.size;
    }
    public int[] getTiles(){
        return this.tiles;
    }
    public boolean getGameStatus(){
        return this.gameOver;
    }
    public void setGameOver(){
        this.gameOver = true;
    }

    // Paint panel menggunakan method ini
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D gtd = (Graphics2D) g;
        gtd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        drawGrid(gtd);
        drawStart(gtd);
    }
}