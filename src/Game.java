public class Game {

    private Board board;
    private Player[] players;
    private Player currentPlayer;

    public Game() {
        board = new Board();
        players = Player.initializePlayers();
        currentPlayer = Player.choosePlayer(players);
        System.out.println("Player " + currentPlayer.getMarker() + " starts:");
        board.printBoard();
        gameTurn();
    }

    public void gameTurn(){
        InputHandler inputHandler = new InputHandler();
        boolean running = true;
        while (running) {
            int[] move = inputHandler.getMoveFromPlayer();
            int row = move[0];
            int column = move[1];

            if (moveIsValid(row, column)) {
                board.getBoard()[row][column] = currentPlayer.getMarker();
                board.printBoard();
                if (gameOver()) {
                    System.out.println("Game over! Player " + currentPlayer.getMarker() + " wins!");
                    running = false;
                } else {
                    currentPlayer = changePlayer();
                }
            } else {
                System.out.println("Not a valid move, choose a different number");
            }
        }
    }
    private boolean moveIsValid(int row, int column){
        char[][] currentBoard = board.getBoard();
        return row >= 0 && row < 3 && column >= 0 && column < 3 && currentBoard[row][column] == '-';
    }

    private boolean gameOver() {
        char[][] cb = board.getBoard();
        for (int i = 0; i < cb.length; i++) {
            if ((cb[i][0] == cb[i][1] && cb[i][1] == cb[i][2] && cb[0][i] != '-') ||
                    (cb[0][i] == cb[1][i] && cb[1][i] == cb[2][i] &&
                            cb[0][i] != '-')) {
                return true;
            }
        }
        if ((cb[0][0] == cb[1][1] && cb[1][1] == cb[2][2] && cb[0][0] != '-') ||
                (cb[0][2] == cb[1][1] && cb[1][1] == cb[2][0] && cb[0][2] != '-')){
            return true;
        }
        return false;
    }


    private Player changePlayer(){
        return currentPlayer == players[0] ? players[1] : players [0];
    }

}