package bottles;


public class Bottle {
    // atributes
    private int capacity, fillLevel, id;
    static int nextId = 1;

    // constructor
    Bottle(int capacity) {
        setCapacity(capacity);
        setId();
    }

    // setter
    private void setId() {
        id = nextId;
        nextId++;
    }

    // setters
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

    // getters
    public int getCapacity() {
        return this.capacity;
    }
    public int getFillLevel() {
        return this.fillLevel;
    }
    public int getId() {
        return this.id;
    }

    // methods
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
        return bottle;
    }

    // to improve
    //static void bottleSettings() {
    //    System.out.println("Bottle no " + bottle[i].getId() + ", capacity: " + bottle[i].getCapacity() + " l, Fill level: " + bottle[i].getFillLevel() + " l");
    //}

    void pourIn(Bottle bottle, int amountOfLiquid) {
        int freeCapacity = bottle.getCapacity() - bottle.getFillLevel();
        if (amountOfLiquid > freeCapacity){
            bottle.setFillLevel(bottle.getCapacity());
            System.out.println("Added " + freeCapacity + " l");
        }
        // add other cases
    }

    void pourOut() {

    }

    void transfer() {

    }
}
