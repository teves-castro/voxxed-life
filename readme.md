# Solution

Solution for https://github.com/equalexperts/voxxed-life challenge

## Instructions

## Getting started

Install the necessary packages (Jest for testing and as-table for displaying the grid) with `npm install` to get started.

Start the game with `npm run start` and watch the game of life come to life in your console.

Run the tests with `npm run test`

## Description

You can run the game with the default initial seed or replace the seed in `index.js` with your own.

The game executes a new step every second and simulates an "infinite" (up to the maximum size of an array allowed in javascript) grid by expanding the grid when a grid has a living cell on it's border. In exchange for keeping things simple, this implementation is very memory consuming as it uses a 2d array to store both dead and living cells as 0 and 1.

I used the `as-table` (https://www.npmjs.com/package/as-table) package for displaying the table since the focus of the challenge was not on visualisation.
