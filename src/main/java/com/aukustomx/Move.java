package com.aukustomx;

public enum Move {

    LEFT(-1),
    RIGHT(1),
    STOP(1);

    private final int move;

    Move(int move) {
        this.move = move;
    }

    public int getMove() {
        return move;
    }
}
