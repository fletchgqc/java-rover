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
}
