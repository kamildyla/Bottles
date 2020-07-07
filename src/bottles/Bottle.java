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

    void pourIn(Bottle bottle, int amountOfLiquid) {
        int freeCapacity = bottle.getCapacity() - bottle.getFillLevel();
        if (amountOfLiquid > freeCapacity){
            bottle.setFillLevel(bottle.getCapacity());
            System.out.println("Dolano " + freeCapacity + " litrów");
        }
        // add other cases
    }

    void pourOut() {

    }

    void transfer() {

    }
}
