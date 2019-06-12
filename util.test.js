const util = require('./util');

// Test getLivingNeighbours
test('has 0 alive neighbours', () => {
    expect(getLivingNeighbours([0, 0])).toBe(0);
});

test('has 1 alive neighbour', () => {
    expect(getLivingNeighbours([0, 1])).toBe(1);
});

test('has 2 alive neighbours', () => {
    expect(getLivingNeighbours([0, 1, 1])).toBe(2);
});

// Test shouldCellLive

// - Any live cell with fewer than two live neighbours dies, as if by underpopulation.
test('is alive and has 0 alive neighbours', () => {
    expect(shouldCellLive(true, 0)).toBe(false);
});

test('is alive and has 1 alive neighbours', () => {
    expect(shouldCellLive(true, 1)).toBe(false);
});

// - Any live cell with two or three live neighbours lives on to the next generation.

test('is alive and has 2 alive neighbours', () => {
    expect(shouldCellLive(true, 2)).toBe(true);
});

test('is alive and has 3 alive neighbours', () => {
    expect(shouldCellLive(true, 3)).toBe(true);
});

// - Any live cell with more than three live neighbours dies, as if by overpopulation.
