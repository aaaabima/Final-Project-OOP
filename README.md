# Puzzle15

This repository is a final project (Java GUI) from Object-Oriented Programming Class, Teknik Informatika Universitas Padjadjaran. 

[Challenge Guidelines](challenge-guideline.md)

**Puzzle 15 adalah sebuah game puzzle geser yang terdiri dari beberapa *tile* bernomor yang tersusun secara acak. Terdapat 1 *tile* yang hilang sebagai space untuk menggeser *tile*s bernomor. Game ini bertujuan untuk menyusun *tile* bernomor acak menjadi berurutan. Ukuran puzzle ini 4x4 dengan 1 *tile* kosong sehingga berjumlah 15 sehingga disebut puzzle 15.**

## Credits
| NPM           | Name                            |
| ------------- |-------------------------------- |
| 140810190013  | Syakira Rahma Fauziyah          |
| 140810190021  | Mochammad Ghifari Eka Narayana  |
| 140810190031  | Mochamad Arya Bima Agfian       |
| 140810190051  | Salma Tri Audryani              |

## Change log
- **[Sprint Planning](changelog/sprint-planning.md) - (19 November 2020)** 
   - Diskusi awal, penyusunan sprint backlog, mencari referensi.

- **[Sprint 1](changelog/sprint-1.md) - (18 November 2020 - 24 November 2020)** 
   - Implementasi OOP Dasar
   - Pembuatan Class UI JFrame
   - Pembuatan Class ClickListener
   - Pembuatan Main Object Puzzle
   
- **[Sprint 2](changelog/sprint-2.md) - (25 November 2020 - 1 December 2020)** 
   - Pembuatan Logic Game
   - Reset Button
   - Implementasi Reset Button di UI
   
- **[Sprint 3](changelog/sprint-3.md) - (2 December 2020 - 8 December 2020)** 
   - Implementasi Main
   - Error Handling
   - Trial Challenge
   - Finishing

## Running The App

Main file `Puzzle.java` atau Puzzle 15 kami dapat dijalankan dengan tiga cara : 

 ### 1.Menjalankan tanpa parameter 

 ``` 
 java Puzzle 
 ``` 

 Ketika dijalankan seperti ini, puzzle akan berupa grid dengan angka 1-15 yang harus disusun berurutan untuk menyelesaikannya.

 ### 2. Menjalankan dengan sebuah int sebagai parameter

 ```
 java Puzzle 5
 ```

 Ketika dijalankan seperti ini, puzzle akan membentuk grid 5x5 dengan masing-masing *tile* berisi angka 1-24. User harus mengurutkan angka 1-24 untuk menyelesaikannya.

 ### 3. Menjalankan dengan dua parameter (int dan String)

 ```
 java Puzzle 3 rem
 ```

 Ketika dijalankan seperti ini, puzzle akan membentuk grid 3x3 dengan isi *tile* berupa potongan gambar dari mode "rem". User harus mengurutkan puzzle berdasarkan gambar yang dipecah ini. Untuk mode yang dapat dimainkan akan dicantumkan di **[Notable Assumption and Design App Details]**. User juga akan disajikan oleh gambar sudah jadi dari mode yang dipilih. 
## Classes Used

1. **Puzzle (Main program)** - `Puzzle.java` 
   - Main program di mana Puzzle15 berjalan berdasarkan UI. 

2. **UserInterface** - `UserInterface.java` 
   - Objek yang menjadi frame Puzzle15. 

3. **PuzzleGrid** - `PuzzleGrid.java` 
   - Objek yang mengekstensi `JPanel` dan menjadi kanvas untuk seluruh *tile* puzzle. 

4. **ClickListener** - `ClickListener.java` 
   - Objek yang mengekstensi `MouseAdapter` dan menjadi responden untuk pergerakan serta semua *click* di UserInterface. 

5. **Logic** - `Logic.java` 
   - Objek yang menyimpan logika memulai dan mengakhiri game Puzzle15. 

![UML](/img/UML.png)

## Notable Assumption and Design App Details 

- Desain Aplikasi 
   - Rekomendasi ukuran game adalah 3x3, 4x4, dan 5x5. 
   - Resolusi PuzzleGrid paling optimal untuk penggunaan 2 argumen adalah 600x600. 
   - Untuk *Running the App* poin ke-3. Argumen int yang mungkin digunakan adalah 3, 4, dan 5. 
   - Untuk *Running the App* poin ke-3. Argumen String yang mungkin digunakan untuk saat ini berjumlah 8 : 
      1. `rem` 
      2. `miku` 
      3. `hina` 
      4. `astolfo` 
      5. `inanis` 
      6. `watson` 
      7. `yunyun` 
      8. `eriri` 
   - Game memiliki fitur **number of clicks** dan **high score** sebagai tambahan. **High score** adalah **number of clicks** paling sedikit yang dibutuhkan untuk menyelesaikan puzzle tersebut selama satu sesi.
   - Ketika puzzle dimainkan dengan mode *custom*, akan ada **example** yang merupakan hasil akhir ketika puzzle tersusun dengan rapih. 
   - Jika ingin mengganti mode, user harus memulai ulang program dan mengetikkan mode yang ingin dimainkan. 
   - Terdapat tombol **Reset** yang dapat digunakan untuk mengacak puzzle. Reset hanya akan berfungsi ketika blankPos berada di posisi paling kanan bawah. Jika user melakukan reset ketika blankPos tidak di tempat seharusnya, akan muncul warning popup. 
