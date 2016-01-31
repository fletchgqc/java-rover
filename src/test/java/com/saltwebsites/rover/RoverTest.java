package com.saltwebsites.rover;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.experimental.categories.Categories.ExcludeCategory;

/**
 * Test data assumes minimum grid height and width of 4
 */
public class RoverTest {

    private final static String FORWARD_COMMAND = "F";
    private final static String BACKWARD_COMMAND = "B";
    private final static String LEFT_TURN_COMMAND = "L";
    private final static String RIGHT_TURN_COMMAND = "R";

    @Test
    public void createRoverArgumentConstructorSetsInitialPosition() {
        Rover rover = new Rover(new Point(3, 4), Direction.S);

        assertThat(rover.getPosition().getX(), is(3));
        assertThat(rover.getPosition().getY(), is(4));
    }

    @Test
    public void createRoverArgumentConstructorSetsInitialDirection() {
        Rover rover = new Rover(new Point(3, 4), Direction.S);

        assertThat(rover.getDirection(), is(Direction.S));
    }

    @Test(expected = IllegalArgumentException.class)
    public void createRoverOutsideGridThrowsException() {
        new Rover(new Point(3, Grid.height + 3), Direction.S);
    }

    @Test
    public void moveForward() {
        Rover rover = new Rover(new Point(2, 2), Direction.N);
        rover.executeConsecutiveCommands(FORWARD_COMMAND);

        assertThat(rover.getPosition().getY(), is(3));
    }

    @Test
    public void moveForwardOverGridXBoundary() {
        Rover rover = new Rover(new Point(Grid.width - 1, 2), Direction.E);
        rover.executeConsecutiveCommands(FORWARD_COMMAND);

        assertThat(rover.getPosition().getX(), is(0));
        assertThat(rover.getDirection(), is(Direction.E));
    }

    @Test
    public void moveForwardOverNorthPole() {
        int xStartPosition = 2;
        Rover rover = new Rover(new Point(xStartPosition, Grid.height - 1), Direction.N);
        rover.executeConsecutiveCommands(FORWARD_COMMAND);

        assertThat(rover.getPosition().getY(), is(Grid.height - 1));

        int correctXFinishPosition = (xStartPosition + (Grid.width / 2)) % Grid.width;

        assertThat(rover.getPosition().getX(), is(correctXFinishPosition));
        assertThat(rover.getDirection(), is(Direction.S));
    }

    @Test
    public void moveBackwardOverSouthPole() {
        int xStartPosition = 2;
        Rover rover = new Rover(new Point(xStartPosition, 0), Direction.N);
        rover.executeConsecutiveCommands(BACKWARD_COMMAND);

        assertThat(rover.getPosition().getY(), is(0));

        int correctXFinishPosition = (xStartPosition + (Grid.width / 2)) % Grid.width;

        assertThat(rover.getPosition().getX(), is(correctXFinishPosition));
        assertThat(rover.getDirection(), is(Direction.S));
    }

    @Test
    public void moveBackward() {
        Rover rover = new Rover(new Point(2, 2), Direction.N);
        rover.executeConsecutiveCommands(BACKWARD_COMMAND);

        assertThat(rover.getPosition().getY(), is(1));
    }

    @Test
    public void turnLeft() {
        Rover rover = new Rover(new Point(2, 2), Direction.N);
        rover.executeConsecutiveCommands(LEFT_TURN_COMMAND);

        assertThat(rover.getDirection(), is(Direction.W));
    }

    @Test
    public void turnLeftToWest() {
        Rover rover = new Rover(new Point(2, 2), Direction.N);
        rover.executeConsecutiveCommands(LEFT_TURN_COMMAND);

        assertThat(rover.getDirection(), is(Direction.W));
    }

    @Test
    public void turnRight() {
        Rover rover = new Rover(new Point(2, 2), Direction.N);
        rover.executeConsecutiveCommands(RIGHT_TURN_COMMAND);

        assertThat(rover.getDirection(), is(Direction.E));
    }

    @Test
    public void turnRightToNorth() {
        Rover rover = new Rover(new Point(2, 2), Direction.W);
        rover.executeConsecutiveCommands(RIGHT_TURN_COMMAND);

        assertThat(rover.getDirection(), is(Direction.N));
    }
}
