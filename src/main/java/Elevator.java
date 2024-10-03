import java.util.ArrayList;

public class Elevator{
    private int currentFloor;
    private int totalFloor;

    public Elevator(int totalFloor) {
        this.currentFloor = 0;
        this.totalFloor = totalFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getTotalFloor() {
        return totalFloor;
    }



    public void moveUp(){
        if(currentFloor < totalFloor -1){
            currentFloor ++;
        }
        System.out.println("Current Floor: " + currentFloor);
    }

    public void moveDown(){
        if(currentFloor > 0){
            currentFloor--;
        }
        System.out.println("Current Floor: " + currentFloor);
    }


    public void moveToFloor(int floor){
        if(floor >= 0 & floor < totalFloor){
            while(currentFloor < floor){
                moveUp();

            }
            while(currentFloor > floor){
                moveDown();
            }
            System.out.println("Current Floor: " + currentFloor);
        }
        else{
            System.out.println("Invalid Floor");
        }
    }
}



    //    private int currentFloor;
//    private int totalFloors;
//    private ArrayList<Integer> floors; // Represents available floors
//
//    public Elevator(int totalFloors) {
//        this.totalFloors = totalFloors;
//        this.currentFloor = 0; // Start at ground floor
//        floors = new ArrayList<>();
//        for (int i = 0; i < totalFloors; i++) {
//            floors.add(i);
//        }
//    }
//
//    public void moveToFloor(int floor) {
//        if (floor >= 0 && floor < totalFloors) {
//            while (currentFloor < floor) {
//                moveUp();
//            }
//            while (currentFloor > floor) {
//                moveDown();
//            }
//            System.out.println("Elevator arrived at floor " + currentFloor);
//        } else {
//            System.out.println("Invalid floor number.");
//        }
//    }
//
//    public void moveUp() {
//        if (currentFloor < totalFloors - 1) {
//            currentFloor++;
//            System.out.println("Elevator moved up to floor " + currentFloor);
//        }
//    }
//
//    public void moveDown() {
//        if (currentFloor > 0) {
//            currentFloor--;
//            System.out.println("Elevator moved down to floor " + currentFloor);
//        }
//    }
//
//    public int getCurrentFloor() {
//        return currentFloor;
//    }
