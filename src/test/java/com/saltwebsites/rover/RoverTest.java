package com.saltwebsites.rover;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Test data assumes minimum grid height and width of 4
 */
public class RoverTest {

    private static char FORWARD_COMMAND = 'F';
    private static char BACKWARD_COMMAND = 'B';
    private static char LEFT_TURN_COMMAND = 'L';
    private static char RIGHT_TURN_COMMAND = 'R';

    @Test
    public void createRoverArgumentConstructorSetsInitialPosition() {
        Rover rover = new Rover(new Point(3, 4), Direction.S);

        assertThat(rover.getPosition().getX(), is(3));
    }

    @Test
    public void createRoverArgumentConstructorSetsInitialDirection() {
        Rover rover = new Rover(new Point(3, 4), Direction.S);

        assertThat(rover.getDirection(), is(Direction.S));
    }

    @Test
    public void moveForward() {
        Rover rover = new Rover(new Point(2, 2), Direction.N);
        rover.executeCommand(FORWARD_COMMAND);

        assertThat(rover.getPosition().getY(), is(3));
    }

    @Test
    public void moveForwardOverGridXBoundary() {
        Rover rover = new Rover(new Point(Grid.width - 1, 2), Direction.E);
        rover.executeCommand(FORWARD_COMMAND);

        assertThat(rover.getPosition().getX(), is(0));
        assertThat(rover.getDirection(), is(Direction.E));
    }

    @Test
    public void moveForwardOverNorthPole() {
        int xStartPosition = 2;
        Rover rover = new Rover(new Point(xStartPosition, Grid.height - 1), Direction.N);
        rover.executeCommand(FORWARD_COMMAND);

        assertThat(rover.getPosition().getY(), is(Grid.height - 1));

        int correctXFinishPosition = (xStartPosition + (Grid.width / 2)) % Grid.width;

        assertThat(rover.getPosition().getX(), is(correctXFinishPosition));
        assertThat(rover.getDirection(), is(Direction.S));
    }

    @Test
    public void moveBackwardOverSouthPole() {
        int xStartPosition = 2;
        Rover rover = new Rover(new Point(xStartPosition, 0), Direction.N);
        rover.executeCommand(BACKWARD_COMMAND);

        assertThat(rover.getPosition().getY(), is(0));

        int correctXFinishPosition = (xStartPosition + (Grid.width / 2)) % Grid.width;

        assertThat(rover.getPosition().getX(), is(correctXFinishPosition));
        assertThat(rover.getDirection(), is(Direction.S));
    }

    @Test
    public void moveBackward() {
        Rover rover = new Rover(new Point(2, 2), Direction.N);
        rover.executeCommand(BACKWARD_COMMAND);

        assertThat(rover.getPosition().getY(), is(1));
    }

    @Test
    public void turnLeft() {
        Rover rover = new Rover(new Point(2, 2), Direction.N);
        rover.executeCommand(LEFT_TURN_COMMAND);

        assertThat(rover.getDirection(), is(Direction.W));
    }

    @Test
    public void turnLeftToWest() {
        Rover rover = new Rover(new Point(2, 2), Direction.N);
        rover.executeCommand(LEFT_TURN_COMMAND);

        assertThat(rover.getDirection(), is(Direction.W));
    }

    @Test
    public void turnRight() {
        Rover rover = new Rover(new Point(2, 2), Direction.N);
        rover.executeCommand(RIGHT_TURN_COMMAND);

        assertThat(rover.getDirection(), is(Direction.E));
    }

    @Test
    public void turnRightToNorth() {
        Rover rover = new Rover(new Point(2, 2), Direction.W);
        rover.executeCommand(RIGHT_TURN_COMMAND);

        assertThat(rover.getDirection(), is(Direction.N));
    }
}
