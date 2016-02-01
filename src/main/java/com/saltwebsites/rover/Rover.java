package com.saltwebsites.rover;

/**
 * Controls a vehicle driving around a grid on a spherical planet. The vehicle must be created with an initial position
 * on the grid and direction, then it can be manoeuvred by issuing command strings.
 * 
 * <p>
 * The grid is similar to latitude/longitude on Earth. It is assumed that the rover implements Mercator projection to
 * map this grid onto the spherical planet in order to implement the actual movement.
 * 
 * <p>
 * While all longitude (Y) lines cross the poles, no grid point is exactly on the tip of the true North or South pole,
 * as that would require some special edge case handling for turning the rover on that point which I choose not to
 * implement.
 */
public class Rover {

    private Position position;

    private Direction direction;

    private final static char FORWARD_COMMAND = 'F';
    private final static char BACKWARD_COMMAND = 'B';
    private final static char LEFT_TURN_COMMAND = 'L';
    private final static char RIGHT_TURN_COMMAND = 'R';

    /**
     * Creates a rover with an initial position on the grid and facing an initial direction.
     * 
     * @throws IllegalArgumentException
     *             if the initialPosition is not within the bounds of the grid.
     */
    public Rover(Position initialPosition, Direction initialDirection) {
        if (initialPosition.getX() >= Grid.width || initialPosition.getY() >= Grid.height) {
            throw new IllegalArgumentException("Initial position would not be within grid bounds");
        }

        position = initialPosition;
        direction = initialDirection;
    }

    /**
     * Executes each command in the String in order, with no pause between commands. Valid commands are:
     * <ul>
     * <li>F - Moves rover forward one point on the grid.
     * <li>B - Move rover backward one point on the grid.
     * <li>L - Turn rover 90 degrees to the left.
     * <li>R - Turn rover 90 degrees to the right.
     * </ul>
     * 
     * @param commands
     *            A case-insensitive String of commands without any separator.
     * @exception IllegalArgumentException
     *                if a character in the String is not in the list of valid commands. However, all commands before
     *                the illegal character will be executed.
     */
    public void executeConsecutiveCommands(String commands) {
        for (char command : commands.toCharArray()) {
            executeCommand(command);
        }
    }

    private void executeCommand(char command) {
        switch (Character.toUpperCase(command)) {
        case FORWARD_COMMAND:
            moveForward();
            break;
        case BACKWARD_COMMAND:
            moveBackward();
            break;
        case LEFT_TURN_COMMAND:
            turnLeft();
            break;
        case RIGHT_TURN_COMMAND:
            turnRight();
            break;
        default:
            throw new IllegalArgumentException("Command '" + command + "' is invalid.");
        }
    }

    /**
     * Maps a given value onto the range 0 - maxValue, by wrapping values outside this range.
     * 
     * @return the value which is equivalent to the given value, but inside the permitted range.
     */
    private int mapValueOntoRange(int value, int maxValue) {
        return (maxValue + value) % maxValue;
    }

    /**
     * Sets the X-position of the rover, implementing any necessary wrapping adjustments.
     */
    private void setXPosition(int xValue) {
        position.setX(mapValueOntoRange(xValue, Grid.width));
    }

    /**
     * Sets the Y-position of the rover, implementing any necessary changes to the rover due to Y-axis wrapping.
     */
    private void setYPosition(int yValue) {
        if (yValue == -1 || yValue == Grid.height) {
            adjustRoverForYWrapping();
        } else {
            position.setY(yValue);
        }
    }

    /**
     * Rover moved over a pole. It now should be on the same Y-latitude as before, but facing the opposite direction and
     * on the opposite X-longitude.
     */
    private void adjustRoverForYWrapping() {
        setXPosition(position.getX() + Grid.width / 2);
        direction = Direction.fromOrder(
                mapValueOntoRange(direction.getOrder() + Direction.values().length / 2, Direction.values().length));
    }

    private void moveForward() {
        setXPosition(position.getX() + direction.getXIncreaseOfForwardMovement());
        setYPosition(position.getY() + direction.getYIncreaseOfForwardMovement());
    }

    private void moveBackward() {
        setXPosition(position.getX() - direction.getXIncreaseOfForwardMovement());
        setYPosition(position.getY() - direction.getYIncreaseOfForwardMovement());
    }

    private void turnLeft() {
        direction = Direction.fromOrder(mapValueOntoRange(direction.getOrder() - 1, Direction.values().length));
    }

    private void turnRight() {
        direction = Direction.fromOrder(mapValueOntoRange(direction.getOrder() + 1, Direction.values().length));
    }

    public Direction getDirection() {
        return direction;
    }

    public Position getPosition() {
        return position;
    }
}
