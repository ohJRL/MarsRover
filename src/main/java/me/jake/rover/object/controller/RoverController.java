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
        // List to store all the rovers
        final List<Rover> allRovers = new ArrayList<>();

        // Loop over all rovers, get the initial position and commands
        for (int i = 0; i < instructions.size(); i += 2) {

            // Get the initial position of the rover
            final String[] initialPosition = instructions.get(i).split(" ");
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

    private void outputRoverPositions(@NotNull List<Rover> rovers) {
        for (Rover rover : rovers) {
            System.out.println(rover.getPosition().getX() + " " + rover.getPosition().getY() + " " + rover.getPosition().getDirection());
        }
    }
}
