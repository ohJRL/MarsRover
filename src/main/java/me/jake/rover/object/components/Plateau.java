package me.jake.rover.object.components;

import lombok.Getter;

/**
 * @author Jake Lucas - 01/04/2025
 */
@Getter
public final class Plateau {
    private final int maxX, maxY;

    public Plateau(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }
}
