const {
    getLivingNeighbours,
    getLivingNeighboursSum,
    shouldCellLive,
    getExpandedGrid,
    shouldExpandGrid
} = require('./util');

asTable = require('as-table');
module.exports = {
    generateBoard: board =>
        board.map((line, x) => {
            return line.map((cell, y) => {
                const livingNeighbours = getLivingNeighbours({ x, y }, board);
                const livingNeighboursSum = getLivingNeighboursSum(
                    livingNeighbours
                );
                return +shouldCellLive(!!cell, livingNeighboursSum);
            });
        }),
    // Receives array of neighbours and returns how many of them are alive
    beginGameOfLife: initSeed => {
        let newBoard = module.exports.generateBoard(initSeed);

        var interval = setInterval(() => {
            console.log('-----------------------');
            console.log(asTable(newBoard));
            newBoard = module.exports.generateBoard(
                (shouldExpandGrid(newBoard) && getExpandedGrid(newBoard)) ||
                    newBoard
            );
        }, 1000);
    }
};
