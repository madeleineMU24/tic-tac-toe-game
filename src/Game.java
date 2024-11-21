public class Game {

    private Board board;
    private Player[] players;
    private Player currentPlayer;
    private InputHandler inputHandler;//medlemsvariabler som refererar till andra objekt i andra klasser.
                                //dom är beroende av som andra klasserna för att fungera korrekt
                                //därför det är bra att ha tydliga namn så det är lättare att läsa och förstå

    public Game() { //konstruktor som sätter ihop allt som behövs för att starta det här spelet
        inputHandler = new InputHandler(); //objekt initieras, här skapas en inputHandler för att ta emot inmatningar
        players = Player.initializePlayers(); //och lagring för spelare
        gameStart();                    //anropar metoden
    }

    public void gameStart(){
        boolean oneMoreGame = true;
        while (oneMoreGame){
            board = new Board();  //ny spelplan, som nollställs varje runda
            currentPlayer = Player.choosePlayer(players); //slumpar vem som startar
            System.out.println("Player   " + currentPlayer.getPlayerMarker() + "   starts:"); //skriver ut vem som börjar
            board.printBoard(); //anropar metoden att skriva ut spelplan
            gameTurn(); //anropar metoden som håller koll på vems tur det är
            oneMoreGame = inputHandler.yesOrNo(); //inmatning om man vill fortsätta spela eller om man är klar

        }
    }

    public void gameTurn(){
        boolean running = true;
        while (running) { //eftersom running är true körs den här loopen tills den blir false
            int[] move = inputHandler.getMoveFromPlayer();//tar in spelarens drag inmatning
            int row = move[0];
            int column = move[1];//dessa räknar ut vart man valt att hamna

            if (moveIsValid(row, column)) { //anropar metoden som kollar att ens drag är giltigt
                board.getBoard()[row][column] = currentPlayer.getPlayerMarker();//om draget gick uppdateras brädan med spelaren X/O
                board.printBoard();
                if (gameOver()) {
                    System.out.println("Game over! Player " + currentPlayer.getPlayerMarker() + " wins!\n"); //vem som vann
                    running = false;
                } else if(endingWithDraw()){ //om det blir lika skrivs det ut
                    System.out.println("Game over! It's a draw!\n");
                    running = false;
                } else {
                    currentPlayer = changePlayer();//växlar mellan spelare, så man spelar varannan gång
                }
            } else {
                System.out.println("That one is taken, choose a different number");// om draget man valde redan är taget
            }
        }
    }
    private boolean moveIsValid(int row, int column){ //kollar att ett drag går att göra, att rutan är "tom"
        char[][] cb = board.getBoard(); //hämtar spelplanen och lagrar det i cb
        return row >= 0 && row < 3 && column >= 0 && column < 3 && cb[row][column] == '-';
    }//först kollas att raden är rätt med storlek, sen att det är rätt med storlek på kolumnen, sen att det är en plats som är tom
// att man inte försöker ta en upptagen plats. om allt stämmer skickar det tillbaka som true

    private boolean endingWithDraw(){//metod för om det blir oavgjort
        char [][] cb = board.getBoard(); //hämtar spelplanen och lagrar det i cb
        for (int i = 0; i < cb.length; i++){//loopar igenom listan för att se att den är fullt. i för raden
            for (int j = 0; j < cb[i].length; j++){//j för kolumnerna
                if (cb[i][j] == '-'){ //kollar om det finns lediga platser, lediga är alltså -
                    return false;//om det finns lediga rutor skickar den tillbaka falsk
                }
            }
        }return true;//om det inte finns lediga rutor ändras det till true
    }

    private boolean gameOver() {//metod för att kolla om någon vinner
        char[][] cb = board.getBoard();//hämtar spelplanen
        for (int i = 0; i < cb.length; i++) {//loopar igenom längden på listan och kontrollerar rader och kolumner
            if ((cb[i][0] == cb[i][1] && cb[i][1] == cb[i][2] && cb[i][0] != '-') ||
                    (cb[0][i] == cb[1][i] && cb[1][i] == cb[2][i] &&
                            cb[0][i] != '-')) {//det kollas efter - eftersom om det finns sånna är den rutan inte använd
                return true;//rutorna på rad ett är [0][0] och [0][1] och [0][2] men om man är i ruta 3 och får 3 i rad rakt ner så
                //är det [0][2] och [1][2] och [2][2].
            }
        }//här nere kontrolleras det diagonala
        if ((cb[0][0] == cb[1][1] && cb[1][1] == cb[2][2] && cb[0][0] != '-') ||//[0][0] = övre vänstra hörnet, plats 0 och 0
                                                                                //[2][2] = nedre högra hörnet, plats 2 och 2
                (cb[0][2] == cb[1][1] && cb[1][1] == cb[2][0] && cb[0][2] != '-')){
            return true;
        }
        return false;//om inget är true kan spelet blivit till exempel oavgjort, annars retuneras true och vi får en vinnare
    }


    private Player changePlayer(){ //metod att spelarna spelar varannan gång i spelet
    if(currentPlayer == players[0]) {
        currentPlayer = players[1];//om currentPlayer är [0] från början, blir den [1]
    }else{
        currentPlayer = players[0];//annars blir currentPlayer [0]
    }
        return currentPlayer;
    }

}