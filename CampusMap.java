/**
 * Course: CSC 120 (section 2)
 * @author Seyeon Lim
 * @version April 4, 2023
 *          Description: A campus map class that allows us to add or remove a building from the map
 */
import java.util.ArrayList;

public class CampusMap {

    /**
     * 
     */
    ArrayList<Building> buildings;

    /**
     * Default constructor that initializes empty ArrayList 
     */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    /**
     * A method that prints out the directory of buildings
     * @return mapString list of buildings created
     */
    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    /**
     * Demonstration of constructing buildings, cafes, houses, and libraries.
     * @param args
     */
    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new House("Duckett House", "41 Elm Street", 4, true));
        myMap.addBuilding(new House("Chase House", "Elm Street"));
        myMap.addBuilding(new Library("Neilson Library", "7 Neilson Drive", 4));
        myMap.addBuilding(new Library("Hillyer Art Library", "20 Elm Street"));
        myMap.addBuilding(new Cafe("Campus Cafe", "100 Elm Street", 1));
        myMap.addBuilding(new Cafe("Compass Cafe", "7 Neilson Drive", 1));
        myMap.addBuilding(new House("Lawrence House", "78 Green Street"));
        myMap.addBuilding(new Building("Seelye", "4 Seelye Drive"));
        myMap.addBuilding(new Library("Werner Josten Library", "122 Green Street"));
        myMap.addBuilding(new Building("Sage Hall", "144 Green Street"));
        System.out.println(myMap);
    }
    
}
