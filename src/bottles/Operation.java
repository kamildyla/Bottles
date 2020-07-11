package bottles;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Operation {
    public static void main(String[] args) {

        int numOfBottles = 0, bottleId = 0, howManyLiters = -1;
        Bottle[] bottles;
        boolean isValid;
        String choiceAction;
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
            Scanner sc = new Scanner(System.in);
            choiceAction = sc.nextLine();

            switch (choiceAction) {
                case "1":
                    // which bottle
                    do {
                        try {
                            System.out.print("Enter the bottle number: ");
                            Scanner botId = new Scanner(System.in);
                            bottleId = botId.nextInt();
                        }
                        catch (InputMismatchException e) {}

                        isValid = bottleId > 0 && bottleId <= bottles.length;
                        if (!isValid) {
                            System.out.println("Invalid number specified, please choose from 1 to " + bottles.length );
                        }
                    }
                    while (!isValid);

                    // how many liters to pour in
                    do {
                        try {
                            System.out.print("How many liters to pour in: ");
                            Scanner liters = new Scanner(System.in);
                            howManyLiters = liters.nextInt();
                        }
                        catch (InputMismatchException e) {}

                        isValid = howManyLiters >= 0;
                        if (!isValid) {
                            System.out.println("Invalid number specified, please choose non-negative number");
                        }
                    }
                    while (!isValid);

                    // pouring in
                    Bottle.pourIn(bottles[bottleId - 1], howManyLiters);
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    Bottle.bottleSettings(numOfBottles, bottles);
                    break;
                case "5":
                    System.out.println("Thank You!!!");
                    break;
                default:
                    System.out.println("Invalid value. Enter number from 1 to 5 to select desire operation.");
            }
        }
        while (!choiceAction.equals("5"));


        /* to add:
         * body of rest of methods
         * to simplify getting data from user -> create a method
         * make another class to keep "pouring" methods
         */
    }
}
