package com.saltwebsites.rover;

public class Rover {

    private Point position;

    private Direction direction;

    public Rover(Point initialPosition, Direction initialDirection) {
        position = initialPosition;
        direction = initialDirection;
    }

    /**
     * Returns a value equivalent to the given value mapped onto X's permitted domain values
     */
    private int normaliseForGridXWrapping(int xValue) {
        return (Grid.width + xValue) % Grid.width;
    }

    /**
     * Returns a value equivalent to the given value mapped onto X's permitted domain values
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

    public void moveForward() {
        position.setX(normaliseForGridXWrapping(position.getX() + direction.getXIncreaseOfForwardMovement()));
        normaliseForGridYWrapping(position.getY() + direction.getYIncreaseOfForwardMovement());
    }

    public void moveBackward() {
        position.setX(normaliseForGridXWrapping(position.getX() - direction.getXIncreaseOfForwardMovement()));
        position.setY(position.getY() - direction.getYIncreaseOfForwardMovement());
    }

    public void turnLeft() {
        int newDirectionOrder = direction.getOrder() - 1;
        int newDirectionOrderAdjustedForEdgeValue = (newDirectionOrder + Direction.values().length)
                % (Direction.values().length);
        direction = Direction.fromOrder(newDirectionOrderAdjustedForEdgeValue);
    }

    public void turnRight() {
        int newDirectionOrder = direction.getOrder() + 1;
        int newDirectionOrderAdjustedForEdgeValue = newDirectionOrder % (Direction.values().length);
        direction = Direction.fromOrder(newDirectionOrderAdjustedForEdgeValue);
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }
}
