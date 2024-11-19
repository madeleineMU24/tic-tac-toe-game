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
        while (running){
        int[] move = inputHandler.getMoveFromPlayer();
        int row = move[0];
        int column = move[1];

        if (moveIsValid (row, column)){
            board.getBoard()[row][column] = currentPlayer.getMarker();
            board.printBoard();
        }if (gameOver()){
                System.out.println("Game over! Player " + currentPlayer.getMarker() + "wins!");
            }

        else {
            System.out.println("Not a valid move, choose a different number");
    }
    }
    private boolean moveIsValid(int row, int column){
        char[][] currentBoard = board.getBoard();
        return row >= 0 && row < 3 && column >= 0 && column < 3 && currentBoard[row][column] == '-';
    }

}