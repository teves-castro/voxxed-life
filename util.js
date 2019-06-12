module.exports = {
    // Receives board of neighbours and returns how many of them are alive
    getLivingNeighboursSum: cells => cells.length,
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
