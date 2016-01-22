package com.saltwebsites.rover;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class RoverTest {

    @Test
    public void testOk() {
        assertThat("hello", is("hello"));
    }

}
