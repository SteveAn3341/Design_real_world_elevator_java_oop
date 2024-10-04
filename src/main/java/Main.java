public class Main {
    public static void main(String[] args) {
        Elevator elevator = new Elevator(10);  // 10-floor building

        // Create users
        User alice = new User("Alice", 5, 8);
        User bob = new User("Bob", 3, 7);
        User charlie = new User("Charlie", 7, 2);
        User david = new User("David", 1, 0);
        User eve = new User("Eve", 8, 9);

        // Scenario: Elevator starts at ground floor (0)
        System.out.println("Initial floor: " + elevator.getCurrentFloor());

        // Users request the elevator
        alice.requestElevator(elevator);
        bob.requestElevator(elevator);
        charlie.requestElevator(elevator);
        david.requestElevator(elevator);
        eve.requestElevator(elevator);

        // Process all requests after they've been queued
        elevator.processAllRequests();
    }
}