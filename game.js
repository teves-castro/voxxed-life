const {
    getLivingNeighbours,
    getLivingNeighboursSum,
    shouldCellLive
} = require('./util');

asTable = require('as-table');
const initSeed = [
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 1, 1, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 1, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 1, 1, 0, 0, 0, 0, 0],
    [0, 0, 1, 1, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 1, 0, 0, 0, 0],
    [0, 0, 0, 0, 1, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
];
module.exports = {
    generateBoard: board => {
        const newBoard = [];
        board.forEach((line, x) => {
            newBoard.push(
                line.map((cell, y) => {
                    const livingNeighbours = getLivingNeighbours(
                        { x, y },
                        board
                    );
                    const livingNeighboursSum = getLivingNeighboursSum(
                        livingNeighbours
                    );
                    return +shouldCellLive(!!cell, livingNeighboursSum);
                })
            );
        });
        return newBoard;
    },
    // Receives array of neighbours and returns how many of them are alive
    beginGameOfLife: () => {
        console.log(asTable(initSeed));
        let newBoard = module.exports.generateBoard(initSeed);

        var interval = setInterval(function(str1, str2) {
            console.log('-----------------------');
            console.log(asTable(newBoard));
            newBoard = module.exports.generateBoard(newBoard);
        }, 1000);
    }
};
