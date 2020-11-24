/*
| NPM           | Name                            |
| ------------- |-------------------------------- |
| 140810190013  | Syakira Rahma Fauziah           |
| 140810190021  | Mochammad Ghifari Eka Narayana  |
| 140810190031  | Mochamad Arya Bima Agfian       |
| 140810190051  | Salma Tri Audryani              |
*/
package src;

import java.util.Random;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Puzzle extends JPanel {
  // Ukuran game Puzzle. e.g. size = 4; berarti 4x4
  private int size;
  // Jumlah tiles yang akan ada di game
  private int nbTiles;
  // Ukuran dimensi grid UI
  private int dimension;
  // Warna foreground
  private static final Color FOREGROUND_COLOR = new Color(239, 83, 80); // we use arbitrary color
  // Objek random untuk mengacak puzzle
  private static final Random RANDOM = new Random();
  // Menyimpan tile di array 1 dimensi
  private int[] tiles;
  // Ukuran masing-masing tile
  private int tileSize;
  // Tempat <blank> harus berada
  private int blankPos;
  // Jarak dari ujung board ke grid puzzle
  private int margin;
  // Ukuran grid UI untuk puzzle
  private int gridSize;
  private boolean gameOver; // Bernilai true jika game berakhir, false sebaliknya
  private boolean custom; // Mengecek apakah user menggunakan default puzzle atau tidak
  private String mode; // Mode game yang akan dimainkan user jika diinput

  public Puzzle(int size, int dim, int mar, String mode){
    if (mode != "") {
        custom = true;
    } else {
        custom = false;   
    }
    
    this.size = size;
    dimension = dim;
    margin = mar;
    this.mode = mode;

    // Menghitung jumlah tile
    nbTiles = size * size - 1; // Jumlah tile tidak termasuk bagian <blank>
    tiles = new int[size * size];

    // Menghitung ukuran grid puzzle dan tile puzzle
    gridSize = (dimension - 2 * margin);
    tileSize = gridSize / size;
  }
}