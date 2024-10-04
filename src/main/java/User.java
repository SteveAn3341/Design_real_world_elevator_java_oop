public class User {
    private int currentFloor;

    public User(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public void requestElevator(Elevator elevator, int destinationFloor, boolean isUpRequest) {
        System.out.println("User at floor " + currentFloor + " requesting elevator to floor " + destinationFloor);
        elevator.requestFloor(destinationFloor, isUpRequest); // Request the floor from the elevator
    }

    public int getCurrentFloor() {
        return currentFloor;
    }
}