package me.jake.rover.object.components;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

/**
 * @author Jake Lucas - 01/04/2025
 */
@Getter
public final class Position {
    private Direction direction;
    private int x, y;

    public Position(int x, int y, @NotNull String direction) {
        this.x = x;
        this.y = y;
        this.direction = Direction.valueOf(direction);
    }

    public void moveLeft() {
        switch (direction) {
            case N -> direction = Direction.W;
            case E -> direction = Direction.N;
            case S -> direction = Direction.E;
            case W -> direction = Direction.S;
        }
    }

    public void moveRight() {
        switch (direction) {
            case N -> direction = Direction.E;
            case E -> direction = Direction.S;
            case S -> direction = Direction.W;
            case W -> direction = Direction.N;
        }
    }

    public void moveForward() {
        switch (direction) {
            case N -> y++;
            case E -> x++;
            case S -> y--;
            case W -> x--;
        }
    }

    public enum Direction {
        N, E, S, W;
    }
}
