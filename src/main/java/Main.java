import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Elevator elevator = new Elevator(8); // 8 floors
        User user1 = new User(1); // User 1 starts on the 1st floor
        User user2 = new User(3); // User 2 starts on the 3rd floor
        User user3 = new User(5); // User 3 starts on the 5th floor
        Scanner scanner = new Scanner(System.in);

        // Simulating User 1 requesting to go up to floor 4
        user1.requestElevator(elevator, 4, true);

        // Simulating User 2 requesting to go down to floor 2
        user2.requestElevator(elevator, 2, false);

        // Simulating User 3 requesting to go up to floor 6
        user3.requestElevator(elevator, 6, true);

        // Close the scanner
        scanner.close();
    }
}