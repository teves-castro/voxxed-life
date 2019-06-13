asTable = require('as-table');

getArrayOfZeros = (x, y) => [...Array(x)].map(e => Array(y).fill(0));

const Utils = {
    /**
     * Receives a 1D array of living neighbours and returns their number
     * @param  {Array} cells
     * @return {Number} Living neighbours
     */
    getLivingNeighboursSum: cells => cells.length,
    /**
     * Calculates if the grid should be expanded
     * @param  {Array} board A 2D array that represents the board
     * @return {Boolean}
     */
    shouldExpandGrid: board =>
        board.some((row, x) =>
            row.some(
                (cell, y) =>
                    +(
                        x == 0 ||
                        y == 0 ||
                        x == board.length - 1 ||
                        y == board.length - 1
                    ) && !!board[x][y]
            )
        ),
    /**
     * Pads the old grid in order to expand it and allow for a simulation of an infinite grid
     * @param  {Array} board A 2D array that represents the board
     * @return {Array}       A 2D array that is an expansion of the original board
     */
    getExpandedGrid: board => {
        const arr = getArrayOfZeros(board.length + 2, board.length + 2);

        return arr.map((row, x) =>
            row.map(
                (cell, y) =>
                    +(
                        x > 0 &&
                        y > 0 &&
                        x < arr.length - 1 &&
                        y < arr.length - 1 &&
                        board[x - 1][y - 1]
                    )
            )
        );
    },
    /**
     * Calculates if a cell should live depending on the rules of the game
     * @param  {Boolean} isAlive
     * @param  {Number} livingNeighbours
     * @return {Boolean}
     */
    shouldCellLive: (isAlive, livingNeighbours) =>
        (isAlive && livingNeighbours == 2) || livingNeighbours == 3,
    /**
     * Find the living neighbours of a cell
     * @param  {Object} pos Contains coordinates of cell in board
     * @param  {Array} board A 2D array that represents the board
     * @return {Array}       A 1D array that contains living neighbours
     */
    getLivingNeighbours: (pos, board) => {
        const x = pos.x;
        const y = pos.y;
        const maxIndex = board[0].length - 1;

        return [
            x > 0 && y > 0 && board[x - 1][y - 1],
            x > 0 && board[x - 1][y],
            x > 0 && y < maxIndex && board[x - 1][y + 1],
            y > 0 && board[x][y - 1],
            y < maxIndex && board[x][y + 1],
            x < maxIndex && y > 0 && board[x + 1][y - 1],
            x < maxIndex && board[x + 1][y],
            x < maxIndex && y < maxIndex && board[x + 1][y + 1]
        ].filter(cell => cell == 1);
    },
    /**
     * Pretty prints the array as a table.
     */
    printBoard: board => {
        const newBoard = board.map(row =>
            row.map(cell => (cell == 1 && '*') || ' ')
        );

        console.log('\x1b[36m', '-----------------------');
        console.log('\x1b[31m', asTable(newBoard));
    }
};

module.exports = Utils;
