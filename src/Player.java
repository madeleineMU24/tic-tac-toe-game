import java.util.Random;

public class Player {
    private char marker;

    public Player(char marker){
        this.marker = marker;
    }

    public char getMarker() {
        return marker;
    }
    public static Player[] initializePlayers() {
        Player player1 = new Player('X'); // '' är markeringar att det är en char
        Player player2 = new Player('O'); //även fast man kan tro att det är en string
    return new Player[]{player1, player2};
    }

    public static Player choosePlayer(Player[] players) {
        Random rng = new Random();
        return rng.nextBoolean() ? players[0]: players[1];

    }
}


