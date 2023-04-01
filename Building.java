/**
 * Course: CSC 120 (section 2)
 * @author Seyeon Lim
 * @version April 4, 2023
 *          Description: A class that creates a building with a certain name, address, and number of floors.
 *          Allows access to the name, address, and number of floors of the building. Allows a person to enter or 
 *          exit a building and move to another floor. 
 *          another floor
 */
public class Building {

    protected String name;
    protected String address;
    protected int nFloors;
    protected int activeFloor = -1; // Default value indicating we are not inside this building

    /**
     * Constructs a 1 floor building with its name and address unknown
     */
    public Building() {
        this("<Name Unknown>", "<Address Unknown>", 1);
    }

    /**
     * Constructs a building with address only 
     * @param address address of the building
     */
    public Building(String address) {
        this(); 
        this.address = address; 
    }

    /**
     * Constructs a 1 floor building with name and address only 
     * @param name name of the building
     * @param address of the building
     */
    public Building(String name, String address) {
        this(name, address, 1); 
    }

    /**
     * Constructs a building with name, address, and number of floors
     * @param name name of the builiding
     * @param address of the building
     * @param number of floors of the building
     * @throws RuntimeException when the building has less than 1 floor 
     */
    public Building(String name, String address, int nFloors) {
        if (name != null) { this.name = name; }
        if (address != null) { this.address = address; } 
        if (nFloors < 1) {
            throw new RuntimeException("Cannot construct a building with fewer than 1 floor.");
        }
        this.nFloors = nFloors;
    }

    /**
     * Accessor for getting the name of the building
     * @return name of the building 
     */
    public String getName() {
        return this.name;
    }

    /**
     * Accessor for getting the address of the building 
     * @return address of the building
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Accessor for getting the number of floors of the building 
     * @return number of floors of the building
     */
    public int getFloors() {
        return this.nFloors;
    }

    /**
     * A method that allows a person to enter the building
     * @return the building that the person is in
     * @throws RuntimeException when the person is already inside the building
     */
    public Building enter() {
        if (activeFloor != -1) {
            throw new RuntimeException("You are already inside this Building.");
        }
        this.activeFloor = 1;
        System.out.println("You are now inside " + this.name + " on the ground floor.");
        return this; // Return a pointer to the current building
    }

    /**
     * A method that allows a person to exit the building
     * @return null as the person is not in a building anymore
     * @throws RuntimeException when the person is already outsode the building
     * @throws RuntimeException when the active floor is larger than 1
     */
    public Building exit() {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before exit().");
        }
        if (this.activeFloor > 1) {
            throw new RuntimeException("You have fallen out a window from floor #" +this.activeFloor + "!");
        }
        System.out.println("You have left " + this.name + ".");
        this.activeFloor = -1; 
        return null; 
    }

    /**
     * A method that allows a person to move to another floor 
     * @param floorNum the number of the floor that the person is trying to access
     * @throws RuntimeException when the person is not inside the building
     * @throws RuntimeException when the person tries to access and invalid floor number
     */
    public void goToFloor(int floorNum) {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
        }
        if (floorNum < 1 || floorNum > this.nFloors) {
            throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
        }
        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
        this.activeFloor = floorNum;
    }

    /**
     * Am method that allows a person to go up 1 floor
     */
    public void goUp() {
        this.goToFloor(this.activeFloor + 1);
    }

    /**
     * Am method that allows a person to go down 1 floor
     */
    public void goDown() {
        this.goToFloor(this.activeFloor - 1);
    }

    /**
     * A method that prints out all the available options of the building
     */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)");
    }

    /**
     * A method that prints out the information of the building made
     * @return building information
     */
    public String toString() {
        return this.name + " is a " + this.nFloors + "-story building located at " + this.address + ".";
    }

    /**
     * A demonstration of constructing a building and using methods, including moving up and down the floors,
     * entering and exiting a building, and showing options of the building.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("------------------------------------");
        System.out.println("Test of Building constructor/methods");
        System.out.println("------------------------------------");
        
        Building fordHall = new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4);
        System.out.println(fordHall);
        fordHall.showOptions();

        System.out.println("-----------------------------------");
        System.out.println("Demonstrating enter/exit/navigation");
        System.out.println("-----------------------------------");
        fordHall.enter();
        fordHall.goUp();
        fordHall.goDown();
        fordHall.exit();
    }

}
