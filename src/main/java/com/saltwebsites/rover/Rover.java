package com.saltwebsites.rover;

public class Rover {

    private Point position;

    private Direction direction;

    public Rover() {
    }

    public Rover(Point initialPosition, Direction initialDirection) {
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
