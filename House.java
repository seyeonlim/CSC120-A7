/**
 * Course: CSC 120 (section 2)
 * @author Seyeon Lim
 * @version April 4, 2023
 * Description: A class that creates a house with a certain name, address, and number of floors. 
 *              The house may or may not have a dining room. Allows residents to move in or out of the
 *              house, print out house description, and return the number of residents, whether a particular
 *              person is a resident of the house, and whether the house has a dining room or not. Allows a person to move to another floor. 
 */
import java.util.ArrayList;

/* This is a stub for the House class */
public class House extends Building {

  /**
   * private ArrayList for saving resident names
   * private boolean for checking whether the house has a dining hall or not
   */
  private ArrayList<String> residents; 
  private boolean hasDiningRoom;

  /**
   * Construcs a 1 floor house with its name and address unknown
   */
  public House() {
    this("<Name Unknown>", "<Address Unknown>", 1, false);
  }

  /**
   * Constructs a house with its address only
   * @param address address of the house
   */
  public House(String address) {
    this(); 
    this.address = address; 
  }

  /**
   * Construcs a house with its name and address only
   * @param name name of the house
   * @param address address of the house
   */
  public House(String name, String address) {
    this(name, address, 1, false); 
  }

  /**
   * Creates a house with a certain name, address, and number of floors, which may or may not have a dining hall.
   * Creates an ArrayList for saving the residents' names.
   * @param name the name of the house
   * @param address the address of the house
   * @param nFloors the number of floors of the house
   * @param hasDiningRoom whether the house has a dining hall or not
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
  }

  /**
   * An accessor for hasDiningRoom, which tells us whether the house has a dining hall or not.
   * @return a boolean that tells us whether the house has a dining hall or not
   */
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }

  /**
   * An accessor for accessing the number of residents in the house.
   * @return the number of residents in the house
   */
  public int nResidents() {
    return this.residents.size();
  }

  /**
   * A method that allows a person with a certain name to move into the house.
   * @param name the name of the person moving into the house
   * @throws RuntimeException when the person is already a resident of the house.
   */
  public void moveIn(String name) {
    if (this.residents.contains(name)) {
      throw new RuntimeException(name + " is already a resident of " + this.name);
    }
    this.residents.add(name);
    System.out.println(name + " has just moved into " + this.name + "! Go say hello :-)");
  }

  /**
   * A method that allows a person with a certain name to move out of the house.
   * @param name the name of the person moving out of the house
   * @return the name of the person who moved out
   * @throws RuntimeException when the person is not a resident of the house.
   */
  public String moveOut(String name) {
    if (!this.residents.contains(name)) {
      throw new RuntimeException(name + " is not in " + this.name);
    }
    this.residents.remove(name);
    System.out.println(name + " moved out. Goodbye :(");
    return name;
  }

  /**
   * A method that tells us if a certain person is a resident of the house.
   * @param person the name of the person
   * @return a boolean that tells if the person is a resident or not
   */
  public boolean isResident(String person) {
    if (this.residents.contains(name)) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * A method that prints out the information of the hosue.
   * @return the description of the house
   */
  public String toString() {
    String description = super.toString();
    description += " There are currently " + this.nResidents() + " people living in this house.";
    description += " This house ";
    if (this.hasDiningRoom) {
      description += "has";
    } else {
      description += "does not have";
    }
    description += " an active dining room.";
    return description;
  }

  /**
   * A method that prints out all the available options of the house
   */
  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + hasDiningRoom() \n + nResidents() \n + moveIn() \n + moveOut() \n + isResident() \n + toString() \n");
  }
  
  /**
   * A method that allows a person to move to another floor when there is an elevator in the house
   * @param floorNum the number of the floor that the person is trying to access
   * @throws RuntimeException when the house does not have an elevator.
   */
  public void goToFloor(int floorNum) {
    if (this.nFloors > 1) {
      super.goToFloor(floorNum);
    } else {
      throw new RuntimeException (this.name + " does not have an elevator.");
    }
  }

  /**
   * Demonstration of making a house and using enter(...) and goToFloor(...) methods 
   * @param args
   */
  public static void main(String[] args) {
    House morrow = new House("Morrow", "The Quad", 4, false);
    morrow.enter();
    morrow.goToFloor(2);
    morrow.goDown();

  }

}