import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Elevator elevator = new Elevator(8);
        User user = new User(0);
        Scanner in = new Scanner(System.in);




        while (true) {

            System.out.println("welcome to the elevator simulation" );
            System.out.println("please enter a number to go to the destination floor");
            System.out.println("your current floor is" + "  " + elevator.getCurrentFloor());
            System.out.println("1.moveUp");
            System.out.println("2.moveDown");
            System.out.println("3.moveToDestination");
            System.out.println("4.exit");
            String n = in.nextLine();

            switch (n) {
                case "1":
                    elevator.moveUp();
                    user.requestElevator(elevator, elevator.getCurrentFloor());
                    break;
                case "2":
                    elevator.moveDown();
                    user.requestElevator(elevator, elevator.getCurrentFloor());
                    break;
                case "3":
                    System.out.print("Enter the floor you want to go to (1-8): ");
                    int desiredFloor = Integer.parseInt(in.nextLine()) - 1;
                    if (desiredFloor >= 0 && desiredFloor < 8) { // Check range
                        user.requestElevator(elevator, desiredFloor);
                    } else {
                        System.out.println("Invalid floor number. Please enter a floor between 1 and 8.");
                    }
                    break;
                case "4":
                    System.out.println("Exiting the Elevator Simulation. Goodbye!");
                    in.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }


        }
    }
}
