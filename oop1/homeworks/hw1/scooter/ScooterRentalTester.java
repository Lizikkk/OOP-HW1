package homeworks.hw1.scooter;

import java.util.concurrent.TimeUnit;

public class ScooterRentalTester {
    // Coordinates of your home
    double[] homeCoordinates = {41.7036863, 44.7796022};
    // Coordinates near your home
    double[] nearHomeCoordinates = {41.7096517, 44.7969197};
    // Coordinates of the university
    double[] universityCoordinates = {41.7121106, 44.7489232};

    // RentalCompany instance to manage the scooter rentals
    RentalCompany rentalCompany = new RentalCompany();

    // Method to simulate renting a scooter
    /**
     * 
     */
    public void rentScooter() {
        // Rent a scooter with a specified ID 
        int scooterIdToRent = 0; 
        rentalCompany.rentScooter(scooterIdToRent);
        
        // Look through the list of scooters to find the rented one
        for (Scooter scooter : rentalCompany.scooters) {
            // Check if the current scooter matches the ID and is not available 
            if (scooter.getId() == scooterIdToRent && !scooter.isAvailable()) {
                // Print the details of the rented scooter
                System.out.println("Scooter rented: " + scooter.toString());
                return; // Exit the loop as the rented scooter is found
            }
        }
        // If the loop completes without finding a rented scooter with the given ID
        System.out.println("Failed to rent scooter with ID " + scooterIdToRent);
    }
    
    

    // Method to simulate returning a scooter
    public void returnScooter(double x, double y) {
        rentalCompany.returnScooter(0, x, y);
        System.out.println("Scooter returned to location (" + x + ", " + y + ").");
    }

    // Method to simulate the journey from home to university
    public void goToUniversity() {
        System.out.println("Traveling from home coordinates: " + homeCoordinates[0] + ", " + homeCoordinates[1]);
        System.out.println("Arrived at university coordinates: " + universityCoordinates[0] + ", " + universityCoordinates[1]);
    }

    // Method to simulate the journey from university back to home
    public void goHome() {
        System.out.println("Traveling from university coordinates: " + universityCoordinates[0] + ", " + universityCoordinates[1]);
        System.out.println("Arrived at home coordinates: " + homeCoordinates[0] + ", " + homeCoordinates[1]);
    }

    // Main method to perform the scooter rental test
    public static void main(String[] args) {
        ScooterRentalTester tester = new ScooterRentalTester();

        // Rent a scooter
        tester.rentScooter();

        // Travel to the university
        tester.goToUniversity();
        // Return the scooter at the university
        tester.returnScooter(tester.universityCoordinates[0], tester.universityCoordinates[1]);

        // Wait for one hour 
        try {
            System.out.println("Waiting for one hour...");
            TimeUnit.HOURS.sleep(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Rent the scooter again
        tester.rentScooter();

        // Travel back home
        tester.goHome();

        // Return the scooter near home
        tester.returnScooter(tester.nearHomeCoordinates[0], tester.nearHomeCoordinates[1]);
    }
}
