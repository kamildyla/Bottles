package bottles;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Bottle {

    private int capacity, fillLevel, id;
    static int nextId = 1;

    Bottle(int capacity) {
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

    public int getCapacity() {
        return this.capacity;
    }
    public int getFillLevel() {
        return this.fillLevel;
    }
    public int getId() {
        return this.id;
    }


    static int randomCapacity() {
        double x = Math.random()*13;
        int tempCapacity = (int)x-1;
        return tempCapacity;
    }

    void randomFillLevel(int capacity) {
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
        System.out.printf("%n");
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
            System.out.println("Added " + freeCapacity + " l to bottle no " + bottle.getId() + "\n");
        }
        if (amountOfLiquid < freeCapacity) {
            bottle.setFillLevel(bottle.getFillLevel() + amountOfLiquid);
            System.out.println("Added " + amountOfLiquid + " l to bottle no " + bottle.getId() + "\n");
        }
        if (amountOfLiquid > freeCapacity) {
            bottle.setFillLevel(bottle.getCapacity());
            System.out.println("Added " + freeCapacity + " l to bottle no " + bottle.getId() + "\n");
        }

    }

    void pourOut() {

    }

    void transfer() {

    }

    static int whichBottle(Bottle[] bottle) {
        int bottleId = 0;
        boolean isValid;
        do {
            try {
                System.out.print("Enter the bottle number: ");
                Scanner botId = new Scanner(System.in);
                bottleId = botId.nextInt();
            } catch (InputMismatchException e) {
            }

            isValid = bottleId > 0 && bottleId <= bottle.length;
            if (!isValid) {
                System.out.println("Invalid number specified, please choose from 1 to " + bottle.length);
            }
        }
        while (!isValid);
        return bottleId;
    }

    static int howManyLiters() {
        int amountOfLiters = -1;
        boolean isValid;
        do {
            try {
                System.out.print("How many liters to pour in: ");
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
