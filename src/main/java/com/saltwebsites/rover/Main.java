package com.saltwebsites.rover;

public class Main {

    /**
     * This is the main class of the application, which creates the Rover and
     * theoretically could read input from the user to move the rover around and
     * get its position. However, all that is currently implemented is creation
     * of the Rover.
     */
    public static void main(String[] args) {
        new Rover(new Point(0, 0), Direction.N);
    }

}
