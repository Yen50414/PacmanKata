Instructions:

mvn package
java -cp target/java_audition-1.0-SNAPSHOT.jar com.audition.PacmanMain


Controls:

w, a, s, d keys for Up, Left, Down, and Right.

Press the enter key to submit the command.

Entering the q key will exit the game.


Pacman Grid:

The grid is 28x31, the same size counted from the original Pacman game.  The board is a much simpler design, with walls on all sides and no maze like design at all.

Implementation wise the constructor can specify the size of the grid, though a minimum grid size of 4x4 is required.


Pacman Character:

Pacman is set to spawn at 14, 23, roughly where he'd spawn in the original Pacman game.

Pacman's spawn point can be specified to the constructor to allow testing as well as more complex grid designs.


Monsters:

Monsters spawn at the 4 corners of the grid.  They move according to randomly generated commands and have the ability to move through walls.