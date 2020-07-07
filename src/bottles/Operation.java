package bottles;

import java.util.Scanner;

public class Operation {
    public static void main(String[] args) {

        int numOfBottles = 0;
        boolean flagNumOfBottles = true;

        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Podaj ilość butelek: ");
            numOfBottles = sc.nextInt();
            if (numOfBottles < 0) {
                flagNumOfBottles = false;
                System.out.println("Podano nieprawidłową ilość");
            }
            else {
                flagNumOfBottles = true;
            }
        }
        while (!flagNumOfBottles);

        // random capacity and fill level of bottles
        Bottle[] bottle = new Bottle[numOfBottles];
        for (int i = 0; i < numOfBottles; i++) {
            bottle[i] = new Bottle(Bottle.randomCapacity());
            bottle[i].randomFillLevel(bottle[i].getCapacity()) ;
            System.out.println("Butelka nr " + bottle[i].getId() + ", pojemność: " + bottle[i].getCapacity() + " l, Napełniono: " + bottle[i].getFillLevel() + " l");
        }

        System.out.println("\nCo chcesz zrobić: \n1. Nalej\n2. Wylej \n3. Przelej \n4. Zakończ");

        int choiceOperation = sc.nextInt();

        /* to add:
         * choice operation in switch:case
         * exceptions for inputs
         * body oof rest of methods
         */


    }
}
