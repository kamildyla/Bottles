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

        //Bottle.bottleSettings();



        //void bottleSettings() {
//
        //}





        System.out.println("\nChoose operation: \n1. Sour in\n2. Sour out \n3. Transfer\n4. Show bottles data \n5. Exit");

        try {
            Scanner sc = new Scanner(System.in);
            int choiceOperation = sc.nextInt();
        }
        catch (InputMismatchException e) {
            System.out.println("error");
        }




        /* to add:
         * choice operation in switch:case
         * exceptions for inputs
         * body of rest of methods
         */


    }
}
