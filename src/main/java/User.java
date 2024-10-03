public class User {
    private int currentFloor;

    public User(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void requestElevator(Elevator elevator, int destinationFloor) {
        System.out.println("User at Floor" + currentFloor + " " + "requesting floor to" + " " + destinationFloor);
        elevator.moveToFloor(destinationFloor);
        currentFloor = destinationFloor;

    }
}

    //    private int currentFloor;
//
//    public User(int currentFloor) {
//        this.currentFloor = currentFloor;
//    }
//
//    public void requestElevator(Elevator elevator, int destinationFloor) {
//        System.out.println("User at floor " + currentFloor + " requesting elevator to floor " + destinationFloor);
//        elevator.moveToFloor(destinationFloor);
//        currentFloor = destinationFloor; // Update current floor to the destination
//    }
//
//    public int getCurrentFloor() {
//        return currentFloor;
//    }
