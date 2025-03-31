import app.controllers;

public class MainMenu {

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@SpringBootApplication
public class MenuApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(MenuApplication.class);
    private final Scanner scanner = new Scanner(System.in);
    private final Map<String, String> users = new HashMap<>();  // Simulated user database (email, password)
    private String authenticatedUser = null;  // Stores the logged-in user's email

    public static void main(String[] args) {
        SpringApplication.run(MenuApplication.class, args);
    }

    @Override
    public void run(String... args) {
        while (true) {
            if (authenticatedUser == null) {
                showInitialMenu();
                int option = readOption();
                processInitialOption(option);
            } else {
                showMainMenu();
                int option = readOption();
                processMainOption(option);
            }
        }
    }

    private void showInitialMenu() {
        System.out.println("\n=== INITIAL MENU ===");
        System.out.println("1. Register");
        System.out.println("2. Log in");
        System.out.println("3. Exit");
        System.out.print("Select an option: ");
    }

    private void showMainMenu() {
        System.out.println("\n=== MAIN MENU === (User: " + authenticatedUser + ")");
        System.out.println("1. Register pet");
        System.out.println("2. Request medication");
        System.out.println("3. Log out");
        System.out.print("Select an option: ");
    }

    private int readOption() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            logger.warn("Invalid input, please enter a number.");
            return -1;
        }
    }

    private void processInitialOption(int option) {
        switch (option) {
            case 1 -> registerUser();
            case 2 -> logIn();
            case 3 -> {
                logger.info("Exiting system.");
                System.exit(0);
            }
            default -> logger.warn("Invalid option. Please try again.");
        }
    }

    private void processMainOption(int option) {
        switch (option) {
            case 1 -> registerPet();
            case 2 -> requestMedication();
            case 3 -> logOut();
            default -> logger.warn("Invalid option. Please try again.");
        }
    }

    private void registerUser() {
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        if (users.containsKey(email)) {
            System.out.println("User already registered.");
            return;
        }
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();
        users.put(email, password);
        logger.info("New user registered: {}", email);
        System.out.println("Registration successful. You can now log in.");
    }

    private void logIn() {
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        
        if (users.containsKey(email) && users.get(email).equals(password)) {
            authenticatedUser = email;
            logger.info("User logged in: {}", email);
            System.out.println("Login successful. Welcome.");
        } else {
            logger.warn("Failed login attempt for {}", email);
            System.out.println("Incorrect email or password.");
        }
    }

    private void registerPet() {
        System.out.print("Enter pet's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter pet's species: ");
        String species = scanner.nextLine();
        logger.info("Pet registered: User={}, Name={}, Species={}", authenticatedUser, name, species);
        System.out.println("Pet registered successfully.");
    }

    private void requestMedication() {
        System.out.print("Enter pet's name: ");
        String petName = scanner.nextLine();
        System.out.print("Enter the medication name: ");
        String medication = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity;

        try {
            quantity = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            logger.warn("Invalid quantity, must be a number.");
            System.out.println("Error: Quantity must be a number.");
            return;
        }

        logger.info("Medication request: User={}, Pet={}, Medication={}, Quantity={}",
                authenticatedUser, petName, medication, quantity);
        System.out.println("Request registered successfully.");
    }

    private void logOut() {
        logger.info("User logged out: {}", authenticatedUser);
        System.out.println("Session closed. See you soon.");
        authenticatedUser = null;
    }
}