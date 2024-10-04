import java.util.ArrayList;
import java.util.Collections;

public class Elevator {
    private int currentFloor;
    private int totalFloors;
    private ArrayList<Integer> upRequests;
    private ArrayList<Integer> downRequests;
    private int acceptableDelay = 2; // Define how many floors can be considered "nearby"

    public Elevator(int totalFloors) {
        this.totalFloors = totalFloors;
        this.currentFloor = 0; // Start at the ground floor (0)
        this.upRequests = new ArrayList<>();
        this.downRequests = new ArrayList<>();
    }

    public void requestFloor(int floor, boolean isUpRequest) {
        if (floor >= 0 && floor < totalFloors) {
            if (isUpRequest) {
                upRequests.add(floor); // Add to up requests
                System.out.println("Floor " + floor + " requested (up).");
            } else {
                downRequests.add(floor); // Add to down requests
                System.out.println("Floor " + floor + " requested (down).");
            }
            moveToNextRequest();
        } else {
            System.out.println("Invalid floor number.");
        }
    }

    private void moveToNextRequest() {
        // Handle up requests first
        if (!upRequests.isEmpty()) {
            Collections.sort(upRequests); // Sort the up requests in ascending order
            while (!upRequests.isEmpty()) {
                int nextFloor = upRequests.remove(0); // Get the next requested floor
                // Move to the next requested floor
                moveTo(nextFloor);

                // Check for nearby requests while going up
                checkNearbyRequests(upRequests, true);
            }
        }

        // Handle down requests after serving all up requests
        if (!downRequests.isEmpty()) {
            Collections.sort(downRequests); // Sort down requests
            Collections.reverse(downRequests); // Handle in descending order
            while (!downRequests.isEmpty()) {
                int nextFloor = downRequests.remove(0); // Get the next requested floor
                // Move to the next requested floor
                moveTo(nextFloor);

                // Check for nearby requests while going down
                checkNearbyRequests(downRequests, false);
            }
        }
    }

    private void checkNearbyRequests(ArrayList<Integer> requests, boolean isGoingUp) {
        // Check for nearby requests while going in the current direction
        for (Integer floor : requests) {
            if (isGoingUp && floor - currentFloor <= acceptableDelay) {
                moveTo(floor); // Move to the nearby requested floor
                requests.remove(floor); // Remove the request after serving it
                break; // Exit after serving one nearby request
            } else if (!isGoingUp && currentFloor - floor <= acceptableDelay) {
                moveTo(floor); // Move to the nearby requested floor
                requests.remove(floor); // Remove the request after serving it
                break; // Exit after serving one nearby request
            }
        }
    }

    public void moveTo(int floor) {
        if (floor >= 0 && floor < totalFloors) {
            while (currentFloor < floor) {
                moveUp();
            }
            while (currentFloor > floor) {
                moveDown();
            }
            System.out.println("Elevator arrived at floor " + currentFloor);
        } else {
            System.out.println("Invalid floor number.");
        }
    }

    public void moveUp() {
        if (currentFloor < totalFloors - 1) {
            currentFloor++;
            System.out.println("Elevator moved up to floor " + currentFloor);
        }
    }

    public void moveDown() {
        if (currentFloor > 0) {
            currentFloor--;
            System.out.println("Elevator moved down to floor " + currentFloor);
        }
    }

    public int getCurrentFloor() {
        return currentFloor;
    }
}