package com.janvier;

import java.util.ArrayDeque;
import java.util.Scanner;

// Container ADT Class
class Container {
    private String id;
    private String description;
    private String weight;
    
    public Container(String id, String description, String weight) {
        this.id = id;
        this.description = description;
        this.weight = weight;
    }
    
    @Override
    public String toString() {
        return String.format("%s | %-11s | %s", id, description, weight);
    }
}

// Ship ADT Class
class Ship {
    private String name;
    private String captain;
    
    public Ship(String name, String captain) {
        this.name = name;
        this.captain = captain;
    }
    
    @Override
    public String toString() {
        return String.format("%s | %s", name, captain);
    }
}

public class PortContainerManagementSystem {
    private ArrayDeque<Container> containerStack;
    private ArrayDeque<Ship> shipQueue;
    private Scanner scanner;
    
    public PortContainerManagementSystem() {
        containerStack = new ArrayDeque<>();
        shipQueue = new ArrayDeque<>();
        scanner = new Scanner(System.in);
    }
    
    public void run() {
        int choice;
        do {
            displayMenu();
            choice = getIntInput("Enter choice: ");
            System.out.println();
            
            switch (choice) {
                case 1:
                    storeContainer();
                    break;
                case 2:
                    viewPortContainers();
                    break;
                case 3:
                    registerShip();
                    break;
                case 4:
                    viewWaitingShips();
                    break;
                case 5:
                    loadNextShip();
                    break;
                case 0:
                    System.out.println("Exiting Port Container Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        } while (choice != 0);
    }
    
    private void displayMenu() {
        System.out.println("=== Port Container Management System ===");
        System.out.println("[1] Store container (push)");
        System.out.println("[2] View port containers");
        System.out.println("[3] Register arriving ship (enqueue)");
        System.out.println("[4] View waiting ships");
        System.out.println("[5] Load next ship (pop container + poll ship)");
        System.out.println("[0] Exit");
    }
    
    private void storeContainer() {
        System.out.print("Enter container ID: ");
        String id = scanner.nextLine().trim();
        
        System.out.print("Enter description: ");
        String description = scanner.nextLine().trim();
        
        System.out.print("Enter weight (e.g., 500kg): ");
        String weight = scanner.nextLine().trim();
        
        Container container = new Container(id, description, weight);
        containerStack.push(container);
        
        System.out.println("\nStored: " + container);
    }
    
    private void viewPortContainers() {
        if (containerStack.isEmpty()) {
            System.out.println("No containers at the port.");
            return;
        }
        
        System.out.println("TOP →");
        for (Container container : containerStack) {
            System.out.println(container);
        }
        System.out.println("← BOTTOM");
    }
    
    private void registerShip() {
        System.out.print("Enter ship name: ");
        String name = scanner.nextLine().trim();
        
        System.out.print("Enter captain name: ");
        String captain = scanner.nextLine().trim();
        
        Ship ship = new Ship(name, captain);
        shipQueue.offer(ship);
        
        System.out.println("\nRegistered: " + ship);
    }
    
    private void viewWaitingShips() {
        if (shipQueue.isEmpty()) {
            System.out.println("No ships waiting.");
            return;
        }
        
        System.out.println("FRONT →");
        for (Ship ship : shipQueue) {
            System.out.println(ship);
        }
        System.out.println("← REAR");
    }
    
    private void loadNextShip() {
        if (containerStack.isEmpty()) {
            System.out.println("No containers available to load.");
            return;
        }
        
        if (shipQueue.isEmpty()) {
            System.out.println("No ships waiting to be loaded.");
            return;
        }
        
        Container container = containerStack.pop();
        Ship ship = shipQueue.poll();
        
        System.out.println("Loaded: " + container + " → " + ship);
        System.out.println("Remaining containers: " + containerStack.size());
        System.out.println("Remaining ships waiting: " + shipQueue.size());
    }
    
    private int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.print("Invalid input. " + prompt);
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // consume newline
        return value;
    }
    
    public static void main(String[] args) {
        PortContainerManagementSystem system = new PortContainerManagementSystem();
        system.run();
    }
}