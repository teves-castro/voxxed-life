const initSeed = [[0, 1], [0, 0]];
module.exports = {
    // Receives array of neighbours and returns how many of them are alive
    beginGameOfLife: () => {
        generateBoard(initSeed);
    },
    generateBoard: board => {
        return board;
    }
};
