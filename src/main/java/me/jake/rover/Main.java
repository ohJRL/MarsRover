package me.jake.rover;

import lombok.Getter;
import me.jake.rover.object.components.Plateau;
import me.jake.rover.object.controller.RoverController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Jake Lucas - 01/04/2025
 */
public class Main {
    @Getter private static Plateau plateau;

    public static void main(String[] args) {
        createPlateau();
    }

    private static void createPlateau() {
        final Scanner plateauScanner = new Scanner(System.in);
        System.out.println("Enter the plateau size (e.g. 5 5): ");

        final String[] plateauGrid = plateauScanner.nextLine().split(" ");
        final int maxX = Integer.parseInt(plateauGrid[0]);
        final int maxY = Integer.parseInt(plateauGrid[1]);

        // Create the plateau
        plateau = new Plateau(maxX, maxY);

        // Handle the rovers
        handleRovers();
    }

    private static void handleRovers() {
        final Scanner roverScanner = new Scanner(System.in);
        System.out.println("Please enter the rover's position and instructions (double enter to finish): ");

        // Get the instructions from the user
        final List<String> userInstructions = new ArrayList<>();

        while (roverScanner.hasNextLine()) {
            final String line = roverScanner.nextLine();
            if (line.isEmpty()) break;

            // Add each instruction to the list
            userInstructions.add(line);
        }

        // Ensures that there is at least one rover
        if (userInstructions.size() < 2) return;

        // Send the instructions to the controller
        final RoverController roverController = new RoverController();
        roverController.sendInstructions(userInstructions);
    }
}