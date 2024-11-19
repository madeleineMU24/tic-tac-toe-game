import java.util.Scanner;

public class InputHandler {
   private Scanner scanner;

    public InputHandler() {
        scanner = new Scanner(System.in);
    }

    public int[] getMoveFromPlayer(){
        int choice = scanner.nextInt();
        int row = (choice - 1) / 3;
        int column = (choice - 1) % 3;
        return new int[]{row, column};
    }
}
