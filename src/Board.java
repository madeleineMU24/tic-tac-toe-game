public class Board {

    private char[][] board; //en deklaration av min array som är ett objekt som innehåller objekt

    public Board() {
        board = new char[3][3]; //här skapas en 2D array som är spelets spelbräda. Ett rutnät
        for (int i = 0; i < 3; i++) { //raderna
            for (int j = 0; j < 3; j++) { //kolumnerna, utgår från i och ger varje i 3 stycken j
                                // 3 i i rad, så blir det alltså 3st j och som är 3 stycken i längd
                board[i][j] = '-'; //markerar att platsen är "ledig", en tom plats i arrayen
            }
        }
    }

        public char[][] getBoard() {
            return board; //en getter för board
        }

    public void printBoard() { //skriver ut spelbrädan
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + board[i][j] + " "); //board[i][j] lägger ut '-' för att markera tomma rutor
                if (j < 2) { //när det är mindre än 2 skriver man ut | i kolumn, därför blir det inte på den tredje
                    System.out.print(" | "); //mycket av de andra är mer design, tex | och ---+--
                }
            }
            System.out.println();
            if (i < 2) { //om det är mindre än 2 skriver man ut ----+ på raden, därför blir det inte på den tredje
                System.out.println("----+-----+-----");
            }

        }
    }
}
