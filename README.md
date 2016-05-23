BattleShip
======
**BattleShip Movement tracker** is a tool to track the movement of the ships within the game input.

## How it works
Consider a square board of size N. Each cell can either be empty or be occupied by a ship. The
position of a ship is defined by three parameters: an x-coordinate, a y-coordinate and an
orientation (north, east, south, west).

## Movement Rules
Once the initial state of the board is set up, any number of operations can occur. There are two
types of operations:

* Move a ship
Specified by an initial coordinate and a series of movements which can be move forward (in the
direction that ship is facing), rotate left, rotate right.
A ship can navigate through an occupied cell. However, two ships cannot occupy the same cell at the
end of a move operation.

* Shoot down a ship
Specified by an x- and y-coordinate. If the cell is occupied, that ship is sunk and the cell can
be occupied by another ship. If there is no ship, nothing happens.

## Result
The final state of the board is the position of all ships and it states whether it has sunk or not.
The first line contains the size of the board. The second line contains a list of
coordinate-and-orientation tuples (initial position of the ships). Any subsequent lines are
operations: shoot operations (simply coordinates) and move operations (coordinates to specify
the ship to be considered and a sequence of 'L' (rotate left), 'R' (rotate right) and 'M' (move)).
```
** EXAMPLE **
Input:
  10                      // Size of the board is 10x10
  (0, 0, N) (9, 2, E)     // 2 ships in different locations
  (0, 0) MRMLMM           // move/rotate the ship located at (0, 0)
  (9, 2)                  // shoot at (9, 2) and sink the ship if there is one

Output:
  (1, 3, N)
  (9, 2, E) SUNK

```

##Output File and Assumptions
The output will be displayed on output.txt and states all of the attempts to move a boat to an occupied spot, move to an empty spot or missing shots

**Assumptions**:
* Assuming if the user tries to move a boat to an occupied spot, it has to go back to initial spot since it's unavailable
* Any points that're out of bounds will return an Out of bounds error



