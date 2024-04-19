package homeworks.hw1.scooter;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages a fleet of scooters for a rental company.
 */
public class RentalCompany {
    
    // A counter to generate unique IDs for scooters
     private int uid = 0;


    // List to hold all scooters managed by the rental company
    List<Scooter> scooters = new ArrayList<>();

    // Returns a list of scooters that are currently available for rent.
    public List<Scooter> availableScooters() {

    //Create a list to store available scooters
        List<Scooter> result = new ArrayList<>();
        for (Scooter scooter: scooters) {

    //if the scooter is available,add it to the result list
            if (scooter.isAvailable()) {
                result.add(scooter);
            }
        }
        return result; // returm the list of available scooters
    }

    public void addScooter(Scooter scooter) {
         scooter.setId(uid++); // Assign a unique ID to the new scooter
         scooters.add(scooter); // Add the new scooter to the list of scooters
    }

 /**
     * Removes a scooter with the specified ID from the company's fleet.
     * @param id The ID of the scooter to be removed.
     * @return True if the scooter was removed successfully, false otherwise.
     */
    public boolean removeScooter(int id) {
        // Initialize a flag to indicate whether the scooter was removed
        boolean removed = false;
        for (Scooter scooter: scooters) {
             // Check if the current scooter's ID matches the given ID
            if (scooter.getId() == id) {
                 // Remove the scooter from the list
                scooters.remove(scooter);
                // Set the removed flag to true
                removed = true;
                break; // Break out of the loop since the scooter is found and removed
            }
        }
        return removed; // Return whether the scooter was removed
    }

  /**
     * Rents a scooter with the specified ID.
     * @param id The ID of the scooter to be rented.
     */
    public void rentScooter(int id) {
        for (Scooter scooter : scooters) {
            if (scooter.getId() == id) { // Check if the current scooter's ID matches the given ID
                // If the scooter is available, rent it
                if (scooter.isAvailable()) { 
                    scooter.setAvailable(false);
                    System.out.println("Scooter with ID " + id + " has been rented.");
                } else {
                    // Print a message indicating the scooter is already rented
                    System.out.println("Scooter with ID " + id + " is already rented.");
                }
                return;  // Return since the operation is complete
            }
        }
        // Print a message indicating the scooter was not found
        System.out.println("Scooter with ID " + id + " not found.");
    }

 /**
     * Returns a scooter with the specified ID to the company and updates its location.
     * @param id The ID of the scooter to be returned.
     * @param x The X-coordinate of the scooter's return location.
     * @param y The Y-coordinate of the scooter's return location.
     */
    public void returnScooter(int id, double x, double y) {
        for (Scooter scooter : scooters) {
            // Check if the current scooter's ID matches the given ID
            if (scooter.getId() == id) {
                // If the scooter is not available, return it
                if (!scooter.isAvailable()) {
                    scooter.setAvailable(true);
                    scooter.setX(x);
                    scooter.setY(y);
                    System.out.println("Scooter with ID " + id + " has been returned.");
                } else {
                    // Print a message indicating the scooter is already available
                    System.out.println("Scooter with ID " + id + " is already available.");
                }
                return;   // Return since the operation is complete
            }
        }
         // Print a message indicating the scooter was not found
        System.out.println("Scooter with ID " + id + " not found.");
    }

    /**
     * Displays details of all scooters in the company's fleet.
     */
    public void displayAllScooters() {
        // Iterate through the list of scooters
        for (Scooter scooter : scooters) {
            // Print the details of the current scooter
            System.out.println(scooter.toString());
        }
    }
}

