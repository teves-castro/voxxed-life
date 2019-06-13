const {
    getLivingNeighbours,
    getLivingNeighboursSum,
    shouldCellLive,
    getExpandedGrid,
    shouldExpandGrid,
    printBoard
} = require('./util');

const Game = {
    generateBoard: board =>
        board.map((line, x) =>
            line.map((cell, y) => {
                const livingNeighbours = getLivingNeighbours({ x, y }, board);
                const livingNeighboursSum = getLivingNeighboursSum(
                    livingNeighbours
                );

                return +shouldCellLive(!!cell, livingNeighboursSum);
            })
        ),
    // Receives array of neighbours and returns how many of them are alive
    beginGameOfLife: initSeed => {
        let newBoard = Game.generateBoard(initSeed);

        const interval = setInterval(() => {
            printBoard(newBoard);
            newBoard = Game.generateBoard(
                (shouldExpandGrid(newBoard) && getExpandedGrid(newBoard)) ||
                    newBoard
            );
        }, 1000);
    }
};

module.exports = Game;
