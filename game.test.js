const { beginGameOfLife, generateBoard } = require('./game');
describe('util tests', () => {
    beforeEach(() => {
        //do something
    });
    afterAll(() => {
        //do something
    });
    test('[[0,0], [0,0]] gives [[0,0], [0,0]]', () => {
        expect(generateBoard([[0, 0], [0, 0]])).toEqual([[0, 0], [0, 0]]);
    });

    test('[[1,0], [0,0]] gives [[0,0], [0,0]]', () => {
        expect(generateBoard([[1, 0], [0, 0]])).toEqual([[0, 0], [0, 0]]);
    });

    test('[[1,1], [1,1]] gives [[1,1], [1,1]]', () => {
        expect(generateBoard([[1, 1], [1, 1]])).toEqual([[1, 1], [1, 1]]);
    });

    test('[[1,1,1], [1,1,0], [0,0,0]] gives [[1,0,1], [1,0,1], [0,0,0]]', () => {
        expect(generateBoard([[1, 1, 1], [1, 1, 0], [0, 0, 0]])).toEqual([
            [1, 0, 1],
            [1, 0, 1],
            [0, 0, 0]
        ]);
    });
});
