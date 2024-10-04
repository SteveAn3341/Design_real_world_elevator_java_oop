import java.util.TreeSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class Elevator {
    private int currentFloor;
    private int totalFloors;
    private boolean movingUp;
    private TreeSet<Integer> upRequests;
    private TreeSet<Integer> downRequests;
    private Map<Integer, User> passengers; // Maps pickup floors to User objects

    public Elevator(int totalFloors) {
        this.totalFloors = totalFloors;
        this.currentFloor = 0;
        this.movingUp = true;
        this.upRequests = new TreeSet<>();
        this.downRequests = new TreeSet<>();
        this.passengers = new HashMap<>();
    }

    public void requestFloor(int pickupFloor, int destinationFloor, User user) {
        if (pickupFloor >= 0 && pickupFloor < totalFloors && destinationFloor >= 0 && destinationFloor < totalFloors) {
            boolean isUpRequest = destinationFloor > pickupFloor;
            if (isUpRequest) {
                upRequests.add(pickupFloor);
                System.out.println(user.getName() + " at floor " + pickupFloor + " requested (up to " + destinationFloor + ").");
            } else {
                downRequests.add(pickupFloor);
                System.out.println(user.getName() + " at floor " + pickupFloor + " requested (down to " + destinationFloor + ").");
            }
            passengers.put(pickupFloor, user);
        } else {
            System.out.println("Invalid floor number.");
        }
    }

    public void processAllRequests() {
        while (!upRequests.isEmpty() || !downRequests.isEmpty()) {
            if (movingUp) {
                processUpRequests();
                if (upRequests.isEmpty()) {
                    movingUp = false;
                }
            } else {
                processDownRequests();
                if (downRequests.isEmpty()) {
                    movingUp = true;
                }
            }
        }
    }

    private void processUpRequests() {
        while (!upRequests.isEmpty()) {
            int targetFloor = upRequests.first();
            if (targetFloor >= currentFloor) {
                moveTo(targetFloor);
                upRequests.remove(targetFloor);

                if (passengers.containsKey(targetFloor)) {
                    User user = passengers.get(targetFloor);
                    if (user.getDestinationFloor() > targetFloor) {
                        System.out.println("Picked up " + user.getName() + " at floor " + targetFloor + " going up.");
                        upRequests.add(user.getDestinationFloor());
                        passengers.remove(targetFloor);
                    }
                }

                // Check if this floor is a destination for any passenger
                Iterator<Map.Entry<Integer, User>> it = passengers.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<Integer, User> entry = it.next();
                    User user = entry.getValue();
                    if (user.getDestinationFloor() == targetFloor && user.getCurrentFloor() < targetFloor) {
                        System.out.println(user.getName() + " from floor " + user.getCurrentFloor() + " arrived at destination floor " + targetFloor);
                        it.remove();
                    }
                }
            } else {
                break;
            }
        }
    }

    private void processDownRequests() {
        while (!downRequests.isEmpty()) {
            int targetFloor = downRequests.last();
            if (targetFloor <= currentFloor) {
                moveTo(targetFloor);
                downRequests.remove(targetFloor);

                if (passengers.containsKey(targetFloor)) {
                    User user = passengers.get(targetFloor);
                    if (user.getDestinationFloor() < targetFloor) {
                        System.out.println("Picked up " + user.getName() + " at floor " + targetFloor + " going down.");
                        downRequests.add(user.getDestinationFloor());
                        passengers.remove(targetFloor);
                    }
                }

                // Check if this floor is a destination for any passenger
                Iterator<Map.Entry<Integer, User>> it = passengers.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<Integer, User> entry = it.next();
                    User user = entry.getValue();
                    if (user.getDestinationFloor() == targetFloor && user.getCurrentFloor() > targetFloor) {
                        System.out.println(user.getName() + " from floor " + user.getCurrentFloor() + " arrived at destination floor " + targetFloor);
                        it.remove();
                    }
                }
            } else {
                break;
            }
        }
    }

    public void moveTo(int floor) {
        System.out.println("Moving to floor " + floor);
        while (currentFloor != floor) {
            if (currentFloor < floor) {
                moveUp();
            } else {
                moveDown();
            }
        }
        System.out.println("Elevator arrived at floor " + currentFloor);
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
