package com.saltwebsites.rover;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class RoverTest {

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
        rover.moveForward();

        assertThat(rover.getPosition().getY(), is(3));
    }

    @Test
    public void moveBackward() {
        Rover rover = new Rover(new Point(2, 2), Direction.N);
        rover.moveBackward();

        assertThat(rover.getPosition().getY(), is(1));
    }

    @Test
    public void turnLeft() {
        Rover rover = new Rover(new Point(2, 2), Direction.N);
        rover.turnLeft();

        assertThat(rover.getDirection(), is(Direction.W));
    }

    @Test
    public void turnLeftToWest() {
        Rover rover = new Rover(new Point(2, 2), Direction.N);
        rover.turnLeft();

        assertThat(rover.getDirection(), is(Direction.W));
    }

    @Test
    public void turnRight() {
        Rover rover = new Rover(new Point(2, 2), Direction.N);
        rover.turnRight();

        assertThat(rover.getDirection(), is(Direction.E));
    }

    @Test
    public void turnRightToNorth() {
        Rover rover = new Rover(new Point(2, 2), Direction.W);
        rover.turnRight();

        assertThat(rover.getDirection(), is(Direction.N));
    }
}
