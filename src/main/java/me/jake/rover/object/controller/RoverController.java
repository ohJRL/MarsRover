package me.jake.rover.object.controller;

import me.jake.rover.Main;
import me.jake.rover.object.Rover;
import me.jake.rover.object.components.Position;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jake Lucas - 01/04/2025
 */
public final class RoverController {

    public void sendInstructions(@NotNull List<String> instructions) {
        final List<Rover> allRovers = new ArrayList<>();
        final int maxX = Main.getPlateau().getMaxX();
        final int maxY = Main.getPlateau().getMaxY();

        // Loop over all rovers, get the initial position and commands
        for (int i = 0; i < instructions.size(); i += 2) {

            // Get the initial position of the rover
            final String[] initialPosition = instructions.get(i).split(" ");

            // Validate the input
            if (!isValidInput(initialPosition, maxX, maxY)) {
                System.out.println("Invalid rover input");
                return;
            }

            // Get the x, y, and direction of the rover
            final int x = Integer.parseInt(initialPosition[0]);
            final int y = Integer.parseInt(initialPosition[1]);
            final String direction = initialPosition[2];

            // Create the rover object
            final Rover rover = new Rover(Main.getPlateau(), new Position(x, y, direction));

            // Get the commands for the rover and send them to the rover object
            final String commands = instructions.get(i + 1);
            rover.move(commands);

            // Add the rover to the list of all rovers
            allRovers.add(rover);
        }

        // Output the final positions of the rovers
        this.outputRoverPositions(allRovers);
    }

    private boolean isValidInput(@NotNull String[] initialPosition, int maxX, int maxY) {
        if (initialPosition.length < 3) {
            return false;
        }

        int x, y;
        String direction = initialPosition[2];

        // Validate the input
        try {
            x = Integer.parseInt(initialPosition[0]);
            y = Integer.parseInt(initialPosition[1]);
        } catch (NumberFormatException e) {
            return false;
        }

        if (x < 0 || x > maxX || y < 0 || y > maxY) {
            return false;
        }

        if (!direction.matches("[NESW]")) {
            return false;
        }

        // If all checks pass, the input is valid
        return true;
    }

    private void outputRoverPositions(@NotNull List<Rover> rovers) {
        for (Rover rover : rovers) {
            if (rover.getPlateau().isWithinGrid(rover.getPosition().getX(), rover.getPosition().getY())) {
                System.out.println(rover.getPosition().getX() + " " + rover.getPosition().getY() + " " + rover.getPosition().getDirection());
            } else {
                System.out.println("This rover has gone out of bounds!");
            }
        }
    }
}
