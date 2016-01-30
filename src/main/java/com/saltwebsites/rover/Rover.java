package com.saltwebsites.rover;

public class Rover {

    private Point position;

    private Direction direction;

    public Rover(Point initialPosition, Direction initialDirection) {
        position = initialPosition;
        direction = initialDirection;
    }

    public void moveForward() {

    }

    public void moveBackward() {

    }

    public void turnLeft() {
        int newDirectionOrder = direction.getOrder() - 1;
        int newDirectionOrderAdjustedForEdgeValue = (newDirectionOrder + Direction.maxOrder + 1)
                % (Direction.maxOrder + 1);
        direction = Direction.fromOrder(newDirectionOrderAdjustedForEdgeValue);
    }

    public void turnRight() {
        int newDirectionOrder = direction.getOrder() + 1;
        int newDirectionOrderAdjustedForEdgeValue = newDirectionOrder % (Direction.maxOrder + 1);
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
