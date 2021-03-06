/*
| NPM           | Name                            |
| ------------- |-------------------------------- |
| 140810190013  | Syakira Rahma Fauziyah          |
| 140810190021  | Mochammad Ghifari Eka Narayana  |
| 140810190031  | Mochamad Arya Bima Agfian       |
| 140810190051  | Salma Tri Audryani              |
*/

import javax.swing.SwingUtilities;

public class Puzzle {
  public static void main(String[] args) {
    // Mengolah variabel berdasarkan args yang diinput
    int playSize;
    String playMode;
    if(args.length == 0) {
      playSize = 4;
      playMode = "";
    } else if(args.length == 1) {
      playSize = Integer.parseInt(args[0]);
      playMode = "";
    } else {
      playSize = Integer.parseInt(args[0]);
      playMode = args[1].toLowerCase();
    }
    // Construct UI(size, dimension, margin, mode)
    UserInterface ui = new UserInterface(playSize, 700, 50, playMode);
    SwingUtilities.invokeLater(ui);
  }
}