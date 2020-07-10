package bottles;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Operation {
    public static void main(String[] args) {

        int numOfBottles = 1;
        Bottle[] bottles;
        boolean isNumOfBottlesRight;

        do {
            try {
                System.out.print("Enter number of bottles: ");
                Scanner sc = new Scanner(System.in);
                numOfBottles = sc.nextInt();
                isNumOfBottlesRight = true;

            }
            catch (InputMismatchException e) {
                System.out.println("Invalid quantity specified");
                isNumOfBottlesRight = false;
            }

            if (numOfBottles <= 0) {
                System.out.println("Invalid quantity specified");
                isNumOfBottlesRight = false;
                numOfBottles = 1;
            }

        }
        while (!isNumOfBottlesRight);

        // random capacity and fill level of bottles
        bottles = Bottle.createFillBottle(numOfBottles);

        System.out.printf("%s%n%s%n%s%n%s%n%s%n%s%n", "Choose operation:", "1. Pour in", "2. Pour out", "3. Transfer", "4. Show bottles data", "5. Exit");

        // to delete one row below
        int choiceOperation = 1;

        try {
            Scanner sc = new Scanner(System.in);
            choiceOperation = sc.nextInt();
        }
        catch (InputMismatchException e) {
            System.out.println("error");
        }

        // case 1 - in proggress
        // which bottle

        // how much liquid to pour in

        //method
        Bottle.pourIn(bottles[0], choiceOperation);





        // case 4 - done
        Bottle.bottleSettings(numOfBottles, bottles);

        /* to add:
         * choice operation in switch:case
         * body of rest of methods
         */


    }
}
