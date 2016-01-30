package com.saltwebsites.rover;

public enum Direction {

    N(0, 0, 1), E(1, 1, 0), S(2, 0, -1), W(3, -1, 0);

    public static int maxOrder = 3;

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

    public int getOrder() {
        return order;
    }

    public int getXIncreaseOfForwardMovement() {
        return xIncreaseOfForwardMovement;
    }

    public int getYIncreaseOfForwardMovement() {
        return yIncreaseOfForwardMovement;
    }
}
