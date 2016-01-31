package com.saltwebsites.rover;

/**
 * A direction which can be faced while navigating a grid.
 */
public enum Direction {

    N(0, 0, 1), E(1, 1, 0), S(2, 0, -1), W(3, -1, 0);

    private int order;

    private int xIncreaseOfForwardMovement;

    private int yIncreaseOfForwardMovement;

    private Direction(int order, int xIncreaseOfForwardMovement, int yIncreaseOfForwardMovement) {
        this.order = order;
        this.xIncreaseOfForwardMovement = xIncreaseOfForwardMovement;
        this.yIncreaseOfForwardMovement = yIncreaseOfForwardMovement;
    }

    public static Direction fromOrder(int order) {
        for (Direction direction : Direction.values()) {
            if (direction.getOrder() == order) {
                return direction;
            }
        }
        throw new IllegalArgumentException(String.valueOf(order) + " is not a valid value of order");
    }

    /**
     * This Direction's order on the compass, starting with 0 at North and counting clockwise.
     */
    public int getOrder() {
        return order;
    }

    /**
     * How much moving in this direction would increase one's position on the X-plane of the grid.
     */
    public int getXIncreaseOfForwardMovement() {
        return xIncreaseOfForwardMovement;
    }

    /**
     * How much moving in this direction would increase one's position on the Y-plane of the grid.
     */
    public int getYIncreaseOfForwardMovement() {
        return yIncreaseOfForwardMovement;
    }
}
