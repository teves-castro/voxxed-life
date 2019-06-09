#!/usr/bin/env python
"""
Simple python implementation of the Game of Life
"""
__author__ = "Thanasis Daglis"
__email__ = "ath.daglis@gmail.com"


def neighbourhood(cell):
    """
    Given the coordinates of a cell, create a generator which returns the coords of all
    nine cells - 8 neighbours plus the original center cell
    """
    row, col = cell
    for x_offset in range(3):
        for y_offset in range(3):
            yield row - 1 + x_offset, col - 1 + y_offset


def ignore_cell(*args):
    """
    Placeholder function. Does nothing
    """
    pass


def add_cell(board, cell):
    """
    Add alive cell to board set
    """
    board.add(cell)


class Game:
    def __init__(self, seed):
        self.board = seed
        self.generation = 0

    def __str__(self):
        return f"Generation: {self.generation}\nBoard:\n{self.board}"

    def next_iteration(self):
        """
        Given an existing board, apply the rules of the Game of Life to produce the
        next generation. The board stores only the alive cells. For the next
        generation we only examine alive cells and neighbours of alive cells. For each
        candidate cell, if the sum of all nine neighbour cells is three, the cell state
        for the next generation will be life; if the sum is four, the cell retains its
        current state; and every other sum sets the cell to death.
        """
        new_board = set([])
        candidates = set(n for cell in self.board for n in neighbourhood(cell))
        for cell in candidates:
            alive = {3: True, 4: cell in self.board}.get(
                sum((n in self.board) for n in neighbourhood(cell)), False
            )
            [ignore_cell, add_cell][alive](new_board, cell)
        self.board = new_board

    def play(self, iterations=1):
        """
        Run the N next iterations of the Game of Life
        """
        for _ in range(iterations):
            self.generation += 1
            self.next_iteration()
        print(self)

    def autoplay(self):
        """
        Run 1 iteration per second indefinitely
        """
        import time
        while True:
            time.sleep(1)
            self.generation += 1
            self.next_iteration()
            print(self)
