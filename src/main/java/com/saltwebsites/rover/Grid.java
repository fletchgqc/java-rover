package com.saltwebsites.rover;

/**
 * Holds constants related to an X-Y Grid.
 */
public class Grid {

    /**
     * Width must be even in order to support correct wrapping behaviour when crossing a pole
     */
    public static final int width = 250;

    // Width and height values were chosen for the entertainment of the person who gave me this task
    public static final int height = 254;

    /**
     * Prevent instantiation of this class.
     */
    private Grid() {
    }
}
