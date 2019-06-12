# Conway's Game of Life in Java

This is a naive implementation of Conway's Game of Life in ``Java`` made for
fun and profit. It is an entry to Equal Experts' *Voxxed Athens* [challenge](https://github.com/teves-castro/voxxed-life).

## Implementation

The code is written in ``Java`` and ``SpringBoot``. There are some
auxiliary libraries used such as ``JUnit`` for testing and ``Lombok`` for getters/setters/etc.
generation.

The application provides a REST interaface for interaction with the user.

Only the alive cells are presented. That way we need to store less cells
and use the memory more efficiently.

An infinite grid is supported.

## Test

From within the `LifeWebService` directory run the following command in Linux:

```bash
./mvnw test
```

In Windows:

```bash
mvnw.cmd test
```

## Execute

To start the REST service run in Linux:

```bash
./mvnw spring-boot:run
```

In Windows:

```bash
mvnw.cmd spring-boot:run
```

When the application has been started, then you may send a POST request
providing the current state of Life and get as a response the next mutation.

By default the application should listen to ``http://localhost:8080``

Below is an example in ``curl``.

```bash
curl -X POST \
  'http://localhost:8080/life/mutate' \
  -H 'Content-Type: application/json' \
  -d '{
    "cells": [
        {
            "position": {
                "x": 0,
                "y": 0
            }
        },
        {
            "position": {
                "x": 0,
                "y": 1
            }
        },
        {
            "position": {
                "x": 1,
                "y": 0
            }
        }
    ]
}'
```
This request should return the below response:

```bash
{"cells":[{"position":{"x":0.0,"y":0.0}},{"position":{"x":0.0,"y":1.0}},{"position":{"x":1.0,"y":0.0}},{"position":{"x":1.0,"y":1.0}}]}
```

The ``json`` object that the application exchanges contains *only* the alive cells.

Optionaly, one may pass the desired number of mutation steps like that: ``https://localhost:8080/life/mutate?iterations=<number-of-iterations>``

Beware that any number less than *1* will cause no mutations to take place.

Below there is the original information of the challenge.

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


Good luck!
