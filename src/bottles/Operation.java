package bottles;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Operation {
    public static void main(String[] args) {

        int numOfBottles = 0, amountOfLiters;
        Bottle bottleOut, bottleIn;
        Bottle[] bottles;
        boolean isValid;
        String choiceAction;
        String menu = ("\nChoose operation:\n1. Pour in\n2. Pour out\n3. Transfer\n4. Show bottles data\n5. Exit");

        do {
            try {
                System.out.print("Enter number of bottles: ");
                Scanner sc = new Scanner(System.in);
                numOfBottles = sc.nextInt();
            }
            catch (InputMismatchException ignore) {}

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
                    amountOfLiters = Bottle.selectLitersAmount("pour in");
                    Bottle.pourIn(Bottle.selectBottle(bottles), amountOfLiters);
                    break;
                case "2":
                    amountOfLiters = Bottle.selectLitersAmount("pour out");
                    Bottle.pourOut(Bottle.selectBottle(bottles), amountOfLiters);
                    break;
                case "3":
                    System.out.print("From which bottle pour the liquid. ");
                    bottleOut = Bottle.selectBottle(bottles);
                    System.out.print("To which bottle pour the liquid. ");
                    bottleIn = Bottle.selectBottle(bottles);
                    amountOfLiters = Bottle.selectLitersAmount("transfer");
                    Bottle.transfer(bottleOut, bottleIn, amountOfLiters);
                    break;
                case "4":
                    Bottle.displayBottlesSettings(bottles);
                    break;
                case "5":
                    System.out.println("Thank You!!!");
                    break;
                default:
                    System.out.println("Invalid value. Enter number from 1 to 5 to select desire operation.");
            }
        }
        while (!choiceAction.equals("5"));
    }
}
