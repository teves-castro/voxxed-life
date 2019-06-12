module.exports = {
    // Receives board of neighbours and returns how many of them are alive
    getLivingNeighboursSum: cells => cells.length,
    getArrayOfZeros: (m, n) => [...Array(m)].map(e => Array(n).fill(0)),
    shouldExpandGrid: board => {
        return board.some((line, x) => {
            return line.some((cell, y) => {
                return (
                    +(
                        x == 0 ||
                        y == 0 ||
                        x == board.length - 1 ||
                        y == board.length - 1
                    ) && board[x][y]
                );
            });
        });
    },
    getExpandedGrid: board => {
        const arr = module.exports.getArrayOfZeros(
            board.length + 2,
            board.length + 2
        );
        return arr.map((line, x) => {
            return line.map((cell, y) => {
                return +(
                    x > 0 &&
                    y > 0 &&
                    x < arr.length - 1 &&
                    y < arr.length - 1 &&
                    board[x - 1][y - 1]
                );
            });
        });
    },
    shouldCellLive: (isAlive, livingNeighbours) =>
        (isAlive && livingNeighbours == 2) || livingNeighbours == 3,
    getLivingNeighbours: (pos, board) =>
        [
            pos.x > 0 && pos.y > 0 && board[pos.x - 1][pos.y - 1],
            pos.x > 0 && board[pos.x - 1][pos.y],
            pos.x > 0 &&
                pos.y < board[0].length - 1 &&
                board[pos.x - 1][pos.y + 1],
            pos.y > 0 && board[pos.x][pos.y - 1],
            pos.y < board[0].length - 1 && board[pos.x][pos.y + 1],
            pos.x < board[0].length - 1 &&
                pos.y > 0 &&
                board[pos.x + 1][pos.y - 1],
            pos.x < board[0].length - 1 && board[pos.x + 1][pos.y],
            pos.x < board[0].length - 1 &&
                pos.y < board[0].length - 1 &&
                board[pos.x + 1][pos.y + 1]
        ].filter(cell => cell > 0)
};
