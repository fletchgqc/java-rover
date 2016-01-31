package com.saltwebsites.rover;

public class Grid {

    /**
     * Width must be even in order to support correct wrapping behaviour when crossing a pole
     */
    public static final int width = 250;

    // These numbers were chosen for the amusement of the person who gave me this task
    public static final int height = 254;

    /**
     * Inhibit instantiation of this class.
     */
    private Grid() {
    }
}
