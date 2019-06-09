from game_of_life.game import Game
from game_of_life.game import neighbourhood


def test_get_neighbours():
    sample_cell = (25, 60)
    neighbours = set([n for n in neighbourhood(sample_cell)])
    expected = set(
        [
            (24, 59),
            (24, 60),
            (24, 61),
            (25, 59),
            (25, 60),
            (25, 61),
            (26, 59),
            (26, 60),
            (26, 61),
        ]
    )
    assert neighbours == expected


def test_block():
    board = [(20, 20), (20, 21), (21, 20), (21, 21)]
    my_game = Game(board)
    my_game.play(100)
    assert my_game.board == set(board)


def test_bee_hive():
    board = [(20, 20), (19, 21), (19, 22), (20, 23), (21, 21), (21, 22)]
    my_game = Game(board)
    my_game.play(100)
    assert my_game.board == set(board)


def test_blinker():
    horizontal_line = [(20, 20), (20, 21), (20, 22)]
    vertical_line = [(19, 21), (20, 21), (21, 21)]
    my_game = Game(horizontal_line)
    my_game.play(1)
    assert my_game.board == set(vertical_line)
    my_game.play(1)
    assert my_game.board == set(horizontal_line)


def test_beacon():
    full_blocks = [
        (20, 20),
        (20, 21),
        (21, 20),
        (21, 21),
        (22, 22),
        (23, 22),
        (22, 23),
        (23, 23),
    ]
    hollow_blocks = [(20, 20), (20, 21), (21, 20), (23, 22), (22, 23), (23, 23)]
    my_game = Game(full_blocks)
    my_game.play(1)
    assert my_game.board == set(hollow_blocks)
    my_game.play(1)
    assert my_game.board == set(full_blocks)


def test_diehard():
    diehard = [(0, 1), (1, 0), (1, 1), (5, 0), (6, 0), (6, 2), (7, 0)]
    my_game = Game(diehard)
    my_game.play(129)
    assert my_game.board != set()
    my_game.play(1)
    assert my_game.board == set()


def test_extinction():
    sparse_board = [(0, 1), (1, 0), (-10, -5), (-20, -7), (-21, -7)]
    my_game = Game(sparse_board)
    my_game.play(1)
    assert my_game.board == set()


def test_ressurection():
    board = [(20, 20), (20, 21), (21, 20)]
    expected = set([(20, 20), (20, 21), (21, 20), (21, 21)])
    my_game = Game(board)
    my_game.play(1)
    assert my_game.board == set(expected)
