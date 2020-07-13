package bottles;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Bottle {

    private int capacity, fillLevel, id;
    private static int nextId = 1;

    private Bottle(int capacity) {
        setCapacity(capacity);
        setId();
    }

    private void setId() {
        id = nextId;
        nextId++;
    }

    private void setCapacity(int capacity) {
        if ((capacity <= 10) && (capacity >= 0)) {
            this.capacity = capacity;
        }
        else if (capacity < 0) {
            this.capacity = 0;
        }
        else {
            this.capacity = 10;
        }
    }

    private void setFillLevel(int fillLevel) {
        this.fillLevel = fillLevel;
    }

    private int getCapacity() {
        return this.capacity;
    }
    private int getFillLevel() {
        return this.fillLevel;
    }
    private int getId() {
        return this.id;
    }


    private static int randomCapacity() {
        double x = Math.random()*13;
        int tempCapacity = (int)x-1;
        return tempCapacity;
    }

    private void randomFillLevel(int capacity) {
        if (capacity == 0) {
            setFillLevel(0);
        }
        else {
            double x = Math.random() * capacity + 0.6;
            int fillLevel = (int) x;
            setFillLevel(fillLevel);
        }
    }

    static Bottle[] createFillBottle(int howManyBottles) {
        Bottle[] bottle = new Bottle[howManyBottles];
        for (int i = 0; i < howManyBottles; i++) {
            bottle[i] = new Bottle(Bottle.randomCapacity());
            bottle[i].randomFillLevel(bottle[i].getCapacity()) ;
            System.out.println("Bottle no " + bottle[i].getId() + ", capacity: " + bottle[i].getCapacity() + " l, Fill level: " + bottle[i].getFillLevel() + " l");
        }
        return bottle;
    }

    static void bottleSettings(int howManyBottles, Bottle[] arrayName) {
        for (int i = 0; i < howManyBottles; i++) {
            System.out.println("Bottle no " + arrayName[i].getId() + ", capacity: " + arrayName[i].getCapacity() + " l, Fill level: " + arrayName[i].getFillLevel() + " l");
        }
    }

    static void pourIn(Bottle bottle, int amountOfLiquid) {
        int freeCapacity = bottle.getCapacity() - bottle.getFillLevel();
        if (amountOfLiquid == freeCapacity){
            bottle.setFillLevel(bottle.getCapacity());
            System.out.println("Added " + freeCapacity + " l to bottle no " + bottle.getId());
        }
        else if (amountOfLiquid < freeCapacity) {
            bottle.setFillLevel(bottle.getFillLevel() + amountOfLiquid);
            System.out.println("Added " + amountOfLiquid + " l to bottle no " + bottle.getId());
        }
        else {
            bottle.setFillLevel(bottle.getCapacity());
            System.out.println("Added " + freeCapacity + " l to bottle no " + bottle.getId());
        }

    }

    static void pourOut(Bottle bottle, int amountOfLiquid) {

        if (amountOfLiquid == bottle.getFillLevel()){
            bottle.setFillLevel(0);
            System.out.println("Subtracted " + amountOfLiquid + " l from bottle no " + bottle.getId());
        }
        else if (amountOfLiquid < bottle.getFillLevel()) {
            bottle.setFillLevel(bottle.getFillLevel() - amountOfLiquid);
            System.out.println("Subtracted " + amountOfLiquid + " l from bottle no " + bottle.getId());
        }
        else {
            int pouredOut = bottle.getFillLevel();
            bottle.setFillLevel(0);
            System.out.println("Subtracted " + pouredOut + " l from bottle no " + bottle.getId());
        }

    }

    static void transfer(Bottle bottleOut, Bottle bottleIn, int amountOfLiquid) {
        int possibleToPourOut = bottleOut.getFillLevel();
        int possibleToPourIn = bottleIn.getCapacity() - bottleIn.getFillLevel();
        int transferAmount = Math.min(amountOfLiquid, Math.min(possibleToPourOut, possibleToPourIn));

        pourOut(bottleOut, transferAmount);
        pourIn(bottleIn,transferAmount);

        System.out.println("Transfered " + transferAmount + " l from bottle no " + bottleOut.getId() + " to bottle no " + bottleIn.getId());
    }

    static int whichBottle(Bottle[] bottle) {
        int bottleId = 0;
        boolean isValid;
        do {
            try {
                System.out.print("Enter the bottle number: ");
                Scanner botId = new Scanner(System.in);
                bottleId = botId.nextInt();
            }
            catch (InputMismatchException e) {}

            isValid = bottleId > 0 && bottleId <= bottle.length;
            if (!isValid) {
                System.out.println("Invalid number specified, please choose from 1 to " + bottle.length);
            }
        }
        while (!isValid);
        return bottleId;
    }

    static int howManyLiters(String operation) {
        int amountOfLiters = -1;
        boolean isValid;
        do {
            try {
                System.out.print("How many liters to " + operation + ": ");
                Scanner liters = new Scanner(System.in);
                amountOfLiters = liters.nextInt();
            }
            catch (InputMismatchException e) {}

            isValid = amountOfLiters >= 0;
            if (!isValid) {
                System.out.println("Invalid number specified, please choose non-negative number");
            }
        }
        while (!isValid);
        return amountOfLiters;
    }
}
