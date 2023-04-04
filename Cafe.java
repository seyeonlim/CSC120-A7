/**
 * Course: CSC 120 (section 2)
 * @author Seyeon Lim
 * @version April 4, 2023
 * Description: A class that creates a cafe with a certain name, address, and number of floors.
 *              Allows us to sell coffee, restock inventory, and prints out the inventory.
 */
/* This is a stub for the Cafe class */
public class Cafe extends Building {

    /**
     * private integers for recording the amount of coffee, sugar packets, creams, and cups 
     * the cafe has
     */
    private int nCoffeeOunces; 
    private int nSugarPackets; 
    private int nCreams; 
    private int nCups; 

    /**
     * Constructs a 1 floor cafe with its name and address unknown
     */
    public Cafe() {
        this("<Name Unknown>", "<Address Unknown>", 1);
    }

    /**
     * Constructs a cafe with its address only
     * @param address address of the cafe
     */
    public Cafe(String address) {
        this(); // Call default constructor
        this.address = address; // Override address
    }

    /**
     * Constructs a 1 floor cafe with is name and address only
     * @param name name of the cafe
     * @param address address of the cafe
     */
    public Cafe(String name, String address) {
        this(name, address, 1); // Call full constructor with hard-coded # floors
    }

    /**
     * Creates a cafe with a certain name, address, and number of floors, and initializes
     * the items in the inventory.
     * @param name the name of the cafe
     * @param address the address of the cafe
     * @param nFloors the number of floors of the cafe
     */
    public Cafe(String name, String address, int nFloors) {
        super(name, address, nFloors);
        this.nCoffeeOunces = 100;
        this.nSugarPackets = 100;
        this.nCreams = 100;
        this.nCups = 100;
    }

    /**
     * A method that sells coffee and restocks when the inventory needs more 
     * coffee, sugar packets, creams, or cups. 
     * @param size the size of the coffee
     * @param nSugarPackets the number of sugar packets needed for the coffee
     * @param nCreams the number of creams needed for the coffee
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if (this.nCoffeeOunces < size) {
            restock(50, 0, 0,0);
        } 
        if (this.nSugarPackets < nSugarPackets) {
            restock(0, 50, 0,0);
        } 
        if (this.nCreams < nCreams) {
            restock(0, 0, 50,0);
        } 
        if (this.nCups <= 0) {
            restock(0, 0, 0,50);
        }
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
    }
    
    /**
     * A method that restocks the inventory.
     * @param nCoffeeOunces the amount of coffee to be added
     * @param nSugarPackets the number of sugar packets to be added
     * @param nCreams the number of creams to be added
     * @param nCups the number of cups to be added
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }

    /**
     * A method that prints out the inventory. 
     */
    public void printInventory() {
        System.out.println("Current Inventory: ");
        System.out.println("Coffee Ounces: " + this.nCoffeeOunces);
        System.out.println("Sugar Packets: " + this.nSugarPackets);
        System.out.println("Creams: " + this.nCreams);
        System.out.println("Cups: " + this.nCups);
    }

    /**
     * A method that prints out all the available options of the building
     */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + sellCoffee() \n + restock() \n + printInventory() \n");
    }

    /**
     * A method that prints out a message that one cannot access other floors  
     */
    public void goToFloor(int floorNum) {
          System.out.println("You cannot access other floors.");
        }

    /**
     * Demonstration of making a cafe and using printInventory(), sellCoffee(...), 
     * and restock(...) methods. 
     * @param args
     */
    public static void main(String[] args) {
        Cafe compass = new Cafe("Compass Cafe", "Blah Blah Street", 1);
        compass.showOptions();

    }
    
}
