# Simple python Game of Life implementation

## Usage

Initialize the Game with a board - a list of coordinate tuples. After that, all you have to do is `play` the game by selecting the iterations of the simulation.

```python
In [1]: from game_of_life.game import Game

In [2]: my_game = Game([(-1, 0), (0, 0), (1, 0)])

In [3]: my_game.play(iterations=3)
Generation: 3
Board:
{(0, 1), (0, -1), (0, 0)}

In [4]: my_game.play(iterations=1)
Generation: 4
Board:
{(1, 0), (0, 0), (-1, 0)}
```

## Tests

To run the tests, just run `pytest`.

## Implementation Notes

### Board representation
In order to support an infinite board, the whole game is represented by a set of coordinate tuples containing only the alive cells.

### Scope of each tick
On each tick, we create a new set which represents the next generation. We examine and update the status of all alive cells and their neighbours as follows.

### Status decision
For each cell under examination, we get the sum of the 3x3 grid which surrounds it. If the sum is three, the cell state for the next generation will be life. If the sum is four, the cell retains its current state. Every other sum sets the cell to death.
