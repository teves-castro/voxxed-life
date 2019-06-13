const {
    getLivingNeighbours,
    getLivingNeighboursSum,
    shouldCellLive,
    getExpandedGrid,
    shouldExpandGrid,
    printBoard
} = require('./util');

const Game = {
    /**
     * Process and generate the next step in game of life
     * @param  {Array} board A 2D array that represents the board
     * @return {Array} The new board
     */
    generateBoard: board => {
        const expandedBoard =
            (shouldExpandGrid(board) && getExpandedGrid(board)) || board;

        return expandedBoard.map((line, x) =>
            line.map((cell, y) => {
                const livingNeighbours = getLivingNeighbours(
                    { x, y },
                    expandedBoard
                );
                const livingNeighboursSum = getLivingNeighboursSum(
                    livingNeighbours
                );

                return +shouldCellLive(!!cell, livingNeighboursSum);
            })
        );
    },
    /**
     * Initialize the game of life
     * @param  {Array} initSeed A 2D array that represents the board
     */
    beginGameOfLife: initSeed => {
        let newBoard = Game.generateBoard(initSeed);

        const interval = setInterval(() => {
            printBoard(newBoard);
            newBoard = Game.generateBoard(newBoard);
        }, 1000);
    }
};

module.exports = Game;
