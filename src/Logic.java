/*
| NPM           | Name                            |
| ------------- |-------------------------------- |
| 140810190013  | Syakira Rahma Fauziyah          |
| 140810190021  | Mochammad Ghifari Eka Narayana  |
| 140810190031  | Mochamad Arya Bima Agfian       |
| 140810190051  | Salma Tri Audryani              |
*/

import java.util.Random;

public class Logic {
    private int nbTiles;        //jumlah tiles yang ada pada game
    private int[] tiles;        //tiles memiliki nilai index unique

    public Logic(){

    }

    // Hanya setengah permutasi puzzle yang dapat diselesaikan
    // Ketika sebuah tile diikuti tile yang melebihi nomernya, maka akan
    // dihitung sebagai inversi. Jika blankTile berada di posisi seharusnya,
    // jumlah inversi haruslah genap agar puzzle dapat diselesaikan
    public boolean isSolvable(PuzzleGrid pg){
        this.tiles = pg.getTiles();
        nbTiles = tiles.length-1;
        int countInversion = 0;

        for (int i = 0; i < nbTiles; i++){
            for (int j = 0; j < i; j++){
                if (tiles[j] > tiles[i])
                countInversion++;
            }
        }
        return countInversion % 2 == 0;
    }

    public boolean isSolved(int tiles[]){               //method yang memeriksa apakah semua tiles berada di posisi seharusnya agar game selesai
        this.tiles = tiles;
        if (tiles[tiles.length - 1] != 0)               //jika blankPos belum ada di posisi terakhir maka belum selesai
            return false;
        
        for (int i = tiles.length - 2; i >= 0; i--){
            if (tiles[i] != i + 1)
                return false;
        }
        return true;

    }
}