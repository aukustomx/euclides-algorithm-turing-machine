package com.aukustomx;

class Rule {

    private final State oldState;
    private final char currentChar;
    private final State newState;
    private final char newChar;
    private final Move move;

    Rule(State oldState, char currentChar, State newState, char newChar, Move move) {
        this.oldState = oldState;
        this.currentChar = currentChar;
        this.newState = newState;
        this.newChar = newChar;
        this.move = move;
    }

    State getOldState() {
        return oldState;
    }

    char getCurrentChar() {
        return currentChar;
    }

    State getNewState() {
        return newState;
    }

    char getNewChar() {
        return newChar;
    }

    Move getMove() {
        return move;
    }
}
