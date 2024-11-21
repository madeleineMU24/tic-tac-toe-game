import java.util.Random;

public class Player {
    private char playerMarker; //en medlemsvariabel, privat så kan bara nås här

    public Player(char playerMarker){
        this.playerMarker = playerMarker; //konstuktor som tar in en char som heter marker
    }

    public char getPlayerMarker() {
        return playerMarker;// en getter, som gör att jag kan hämta värdet härifrån även fast det är privat
    }
    public static Player[] initializePlayers() { //Array Player-objekt som ger spelarna varsin spelpjäs
        Player player1 = new Player('X'); // '' är markeringar att det är en char
        Player player2 = new Player('O'); //även fast jag tycker det påminner om String

        return new Player[]{player1, player2};//skickar en array
    }

    public static Player choosePlayer(Player[] players) {
        Random rng = new Random(); //en metod som slumpar vem som startar
        return rng.nextBoolean() ? players[0]: players[1];
    }
}


