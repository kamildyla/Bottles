package bottles;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Operation {
    public static void main(String[] args) {

        int numOfBottles = 0, choiceAction = 0;
        Bottle[] bottles;
        boolean isValid;
        String menu = ("Choose operation:\n1. Pour in\n2. Pour out\n3. Transfer\n4. Show bottles data\n5. Exit");

        do {
            try {
                System.out.print("Enter number of bottles: ");
                Scanner sc = new Scanner(System.in);
                numOfBottles = sc.nextInt();
            }
            catch (InputMismatchException e) {}

            isValid = numOfBottles > 0;
            if (!isValid) {
                System.out.println("Invalid quantity specified");
            }

        }
        while (!isValid);

        // random capacity and fill level of bottles
        bottles = Bottle.createFillBottle(numOfBottles);






        do {
            System.out.println(menu);
            try {
                Scanner sc = new Scanner(System.in);
                choiceAction = sc.nextInt();
            } catch (InputMismatchException e) {
                choiceAction = 0;
            }

            if (choiceAction > 0 && choiceAction <=5) {
                switch (choiceAction) {
                    case 1:
                        // case 1 - in proggress
                        // which bottle

                        // how Many liters to pour in
                        int howManyLiters = 0;

                        //method
                        Bottle.pourIn(bottles[0], howManyLiters);
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        Bottle.bottleSettings(numOfBottles, bottles);
                        break;
                    case 5:
                        break;
                }
            }
            else {
                System.out.println("Invalid value. Enter number from 1 to 5 to select desire operation.");
            }

        }
        while (choiceAction != 5);




        /* to add:
         * body of rest of methods
         */


    }
}
