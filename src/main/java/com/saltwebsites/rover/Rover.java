package com.saltwebsites.rover;

public class Rover {

    private Point position;

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
    public Rover(Point initialPosition, Direction initialDirection) {
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
        case BACKWARD_COMMAND:
            moveBackward();
        case LEFT_TURN_COMMAND:
            turnLeft();
        case RIGHT_TURN_COMMAND:
            turnRight();
        default:
            throw new IllegalArgumentException("Command '" + command + "' is not valid.");
        }
    }

    /**
     * Returns a value equivalent to the given value mapped onto X's permitted domain
     */
    private int normaliseForGridXWrapping(int xValue) {
        return (Grid.width + xValue) % Grid.width;
    }

    /**
     * Returns a value equivalent to the given value mapped onto Y's permitted range
     */
    private void normaliseForGridYWrapping(int yValue) {
        if (yValue == -1 || yValue == Grid.height) {
            /*
             * Rover moved over a pole. It now should be on the same Y-latitude as before, but facing the opposite
             * direction and on the opposite X-longitude.
             */
            position.setX(normaliseForGridXWrapping(position.getX() + Grid.width / 2));
            direction = Direction.fromOrder(direction.getOrder() + Direction.values().length / 2);
        } else {
            position.setY(yValue);
        }
    }

    private void moveForward() {
        position.setX(normaliseForGridXWrapping(position.getX() + direction.getXIncreaseOfForwardMovement()));
        normaliseForGridYWrapping(position.getY() + direction.getYIncreaseOfForwardMovement());
    }

    private void moveBackward() {
        position.setX(normaliseForGridXWrapping(position.getX() - direction.getXIncreaseOfForwardMovement()));
        normaliseForGridYWrapping(position.getY() - direction.getYIncreaseOfForwardMovement());
    }

    private void turnLeft() {
        int newDirectionOrder = direction.getOrder() - 1;
        int newDirectionOrderAdjustedForEdgeValue = (newDirectionOrder + Direction.values().length)
                % (Direction.values().length);
        direction = Direction.fromOrder(newDirectionOrderAdjustedForEdgeValue);
    }

    private void turnRight() {
        int newDirectionOrder = direction.getOrder() + 1;
        int newDirectionOrderAdjustedForEdgeValue = newDirectionOrder % (Direction.values().length);
        direction = Direction.fromOrder(newDirectionOrderAdjustedForEdgeValue);
    }

    public Direction getDirection() {
        return direction;
    }

    public Point getPosition() {
        return position;
    }
}
