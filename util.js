asTable = require('as-table');

getArrayOfZeros = (x, y) => [...Array(x)].map(e => Array(y).fill(0));

const Utils = {
    // Receives board of neighbours and returns how many of them are alive
    getLivingNeighboursSum: cells => cells.length,
    shouldExpandGrid: board =>
        board.some((row, x) =>
            row.some(
                (cell, y) =>
                    +(
                        x == 0 ||
                        y == 0 ||
                        x == board.length - 1 ||
                        y == board.length - 1
                    ) && board[x][y]
            )
        ),
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
    shouldCellLive: (isAlive, livingNeighbours) =>
        (isAlive && livingNeighbours == 2) || livingNeighbours == 3,
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
    printBoard: board => {
        const newBoard = board.map(row =>
            row.map(cell => (cell == 1 && '*') || ' ')
        );

        console.log('\x1b[36m', '-----------------------');
        console.log('\x1b[31m', asTable(newBoard));
    }
};

module.exports = Utils;
