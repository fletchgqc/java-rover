package com.saltwebsites.rover;

import org.junit.Test;

public class PointTest {

    @Test
    public void createPointConstructorSetsCoordinates() {
        Point point = new Point(4, 9);

        assert(point.getX() == 4);
        assert(point.getY() == 9);
    }

}
