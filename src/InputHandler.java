import java.util.Scanner;

public class InputHandler {
   private Scanner scanner;

    public InputHandler() {
        scanner = new Scanner(System.in);
    }

    public int[] getMoveFromPlayer() { //metod för att ta in spelarens val
        int choice = -1; //kollar att spelaren gör ett giltigt val(1-9), här skulle man kunna ha ett annat värde
                        //men om man till exempel har 12 och sen vil ha en större spelbräda så skulle ett av valen man
                        //vill ha vara upptagen. -1 kommer inte behövas och är därför bra som val
        boolean validInput = false;

        while (!validInput) {
            System.out.println("Enter you choice (1-9):");
            if (scanner.hasNextInt()) { //kollar om inmatningen är en int
                choice = scanner.nextInt();//choice ändras till det som spelaren valt
                if (choice >= 1 && choice <= 9) {
                    validInput = true;// och om det är ett nummer som är större eller lika med 1 och mindre
                } else {               //eller lika med 9 så kommer validInput ändras till true.
                    System.out.println("Enter a number between 1-9");//om du har skrivit ett nummer som inte är 1-9
                scanner.nextLine();//tömmer scannern
                }}else {
                    System.out.println("Invalid choice! Choose a number between 1-9");
                scanner.nextLine();//Om du har skrivit någon annat än en siffra och här töms scannern
                }
            }
                int row = (choice - 1) / 3; //räknar ut valet till platserna i raderna
                int column = (choice - 1) % 3;//räknar ut valet till platserna i kolumnerna
                return new int[]{row, column};//här skapar en array som skickas tillbaka till mitt rutnät
            }

        public boolean yesOrNo(){ //loop som kollar om man vill spela igen
        scanner.nextLine(); //tömmer scannern innan vi går in i loopen
        while(true){
            System.out.println("Do you want to play again? Yes/no?");
            String input = scanner.nextLine();
            if (input.toLowerCase().startsWith("y")){ //bryr sig inte om det är stora eller små bokstäver
                return true;
            }if (input.toLowerCase().startsWith("n")){//det går skriva vad som helst så länge det börjar med "y" eller "n"
                return false;
            }else{
                System.out.println("Please give a answer of Yes or No.");//om man skriver något annat så kommer det här
            }
        }
        }



}