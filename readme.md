# Challenge

This challenge involves submitting an implementation for the Game of Life in the form of a pull request to this GitHub repo. A prize will be awarded to the "best" solution (according to the challenge's rules further down).
Start by forking this repo [voxxed-life](https://github.com/equalexperts/voxxed-life) and then submit a PR with your solution in a branch name after your GitHub handle.

## Prize

We'll be offering a [noise cancelling wireless headset](https://en-us.sennheiser.com/wireless-headphones-bluetooth-noise-cancelling-hd-4-50-btnc) to the highest scoring submission

## Challenge rules

1. To be eligible you must include an email address where we can reach you about handing over the prize.
1. This challenge is a pure algorithmic challenge, so although we'll accept solutions with visualisations, no points will be awarded to the visuals part of the solution.
1. Regarding language selection the are no hard rules, although to be judged fairly try to stick to more mainstream languages. Some suggestions
   + Javascript/Typescript
   + Python
   + Java
   + Scala
   + C#
   + F#
1. Point awards
   + Correctness: 10 points
   + Using no if statements: 2 point
   + Infinite grid solution: 2 points
   + No mutation: 2 points
   + Test driven: 2 points
   + Code cleanness : 2 point
   + Simplicity: 2 points

# Game of Life

The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970.

## Automaton Rules

The universe of the "Game of Life" is an infinite, two-dimensional orthogonal grid of square "cells", each of which is in one of two possible states, "alive" or "dead", (or "populated" and "unpopulated", respectively). Every cell interacts with its eight "neighbours", which are the cells that are horizontally, vertically, or diagonally adjacent. At each step in time, the following transitions occur:

- Any live cell with fewer than two live neighbours dies, as if by underpopulation.
- Any live cell with two or three live neighbours lives on to the next generation.
- Any live cell with more than three live neighbours dies, as if by overpopulation.
- Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

The initial pattern constitutes the "seed" of the system. The first generation is created by applying the above rules simultaneously to every cell in the seed; births and deaths occur simultaneously, and the discrete moment at which this happens is sometimes called a "tick". Each generation is a "pure function" of the preceding one. The rules continue to be applied repeatedly to create further generations.

For more information check [Game of Life](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life) in wikipedia.


## Contacts
mayshmaz@gmail.com

## Description
In RoundUtils class use Set<Point> getNextGeneration(Set<Point> pointsSeeded)
pointsSeeded: set of Points with x and y coordinates which represent initially live cells
output: set of Points with x and y coordinates which represent survived and new cells after one round
   
examples of usage are present in unit tests and Application.java
   
   
