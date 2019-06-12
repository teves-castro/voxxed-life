const {
    getLivingNeighbours,
    getLivingNeighboursSum,
    shouldCellLive
} = require('./util');

describe('util tests', () => {
    beforeAll(() => {});
    afterAll(() => {
        //do something
    });
    const board = [[0, 0, 0], [1, 0, 0], [1, 0, 0]];
    // Test getLivingNeighbours
    test('[0,0] neighbours are [1]', () => {
        expect(getLivingNeighbours({ x: 0, y: 0 }, board)).toEqual([1]);
    });

    test('[1, 1] neighbours are [1,1]', () => {
        expect(getLivingNeighbours({ x: 1, y: 1 }, board)).toEqual([1, 1]);
    });

    test('[0, 2] neighbours are []', () => {
        expect(getLivingNeighbours({ x: 0, y: 2 }, board)).toEqual([]);
    });
    // Test getLivingNeighboursSum
    test('[0,0] contains 0 alive neighbours', () => {
        expect(getLivingNeighboursSum([0, 0])).toBe(0);
    });

    test('[0, 1] contains 1 alive neighbour', () => {
        expect(getLivingNeighboursSum([0, 1])).toBe(1);
    });

    test('[0, 1, 1] contains 2 alive neighbours', () => {
        expect(getLivingNeighboursSum([0, 1, 1])).toBe(2);
    });

    // Test shouldCellLive

    // - Any live cell with fewer than two live neighbours dies, as if by underpopulation.
    test('is alive and has 0 alive neighbours: dead', () => {
        expect(shouldCellLive(true, 0)).toBe(false);
    });

    test('is alive and has 1 alive neighbours: dead', () => {
        expect(shouldCellLive(true, 1)).toBe(false);
    });

    // - Any live cell with two or three live neighbours lives on to the next generation.

    test('is alive and has 2 alive neighbours: alive', () => {
        expect(shouldCellLive(true, 2)).toBe(true);
    });

    test('is alive and has 3 alive neighbours: alive', () => {
        expect(shouldCellLive(true, 3)).toBe(true);
    });

    // - Any live cell with more than three live neighbours dies, as if by overpopulation.
    test('is alive and has 4 alive neighbours: dead', () => {
        expect(shouldCellLive(true, 4)).toBe(false);
    });

    // - Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
    test('is dead and has 3 alive neighbours: alive', () => {
        expect(shouldCellLive(false, 3)).toBe(true);
    });

    test('is dead and has 5 alive neighbours: true', () => {
        expect(shouldCellLive(false, 5)).toBe(false);
    });
});
