A simplified version of the Mars Rover kata, written in Java

A rover navigates a grid, which is mapped onto a spherical planet. The code only covers the simple grid navigation and wrapping from one side of the grid to the other (since a planet is spherical).

### Some important comments
... for NASA, Mars One, Matt Damon & team, and the myriad of other organisations about to use this code for their vehicles.

Your rover will need to implement Mercator Projection, or something similar, to implement the actual commands, because the length of one grid movement on the X-axis depends on which latitude you are at.

One particular point of interest is the Y-wrapping logic when the rover crosses a pole. I chose that there should be no point exactly on the tip of either of the poles, because this would make for confusing direction and turn handling (every direction is South from the North pole; a right or left turn changes your longitude in a strange way). So the min and max Y-values are assumed to be close to, but not on, the poles.
