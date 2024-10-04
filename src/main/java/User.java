public class User {
    private int currentFloor;
    private int destinationFloor;
    private String name;

    public User(String name, int currentFloor, int destinationFloor) {
        this.name = name;
        this.currentFloor = currentFloor;
        this.destinationFloor = destinationFloor;
    }

    public void requestElevator(Elevator elevator) {
        System.out.println(name + " at floor " + currentFloor + " requests elevator to floor " + destinationFloor);
        elevator.requestFloor(currentFloor, destinationFloor, this);
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " (Floor " + currentFloor + " to " + destinationFloor + ")";
    }
}