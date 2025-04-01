package me.jake.rover.object;

import lombok.Getter;
import me.jake.rover.object.components.Plateau;
import me.jake.rover.object.components.Position;
import org.jetbrains.annotations.NotNull;

/**
 * @author Jake Lucas - 01/04/2025
 */
@Getter
public final class Rover {
    private final Plateau plateau;
    private final Position position;

    public Rover(@NotNull Plateau plateau, @NotNull Position position) {
        this.plateau = plateau;
        this.position = position;
    }

    public void move(@NotNull String instructions) {
        for (char instruction : instructions.toCharArray()) {
            switch (instruction) {
                case 'L' -> this.position.moveLeft();
                case 'R' -> this.position.moveRight();
                case 'M' -> this.position.moveForward();
            }
        }
    }
}
