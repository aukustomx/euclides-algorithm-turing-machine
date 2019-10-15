package com.aukustomx;

import java.util.Arrays;
import java.util.List;


class RulesDictionary {

    private static final List<Rule> rules = Arrays.asList(
            new Rule(State.A, '0', State.A, '0', Move.RIGHT),
            new Rule(State.A, '1', State.B, '1', Move.LEFT),
            new Rule(State.B, '0', State.C, '1', Move.RIGHT),
            new Rule(State.B, '1', State.B, '1', Move.LEFT),
            new Rule(State.C, '0', State.K, '0', Move.RIGHT),
            new Rule(State.C, '1', State.D, '0', Move.RIGHT),
            new Rule(State.D, '0', State.E, '0', Move.RIGHT),
            new Rule(State.D, '1', State.D, '1', Move.RIGHT),
            new Rule(State.E, '0', State.E, '0', Move.RIGHT),
            new Rule(State.E, '1', State.F, '0', Move.RIGHT),
            new Rule(State.F, '0', State.H, '0', Move.LEFT),
            new Rule(State.F, '1', State.G, '1', Move.LEFT),
            new Rule(State.G, '0', State.G, '0', Move.LEFT),
            new Rule(State.G, '1', State.B, '1', Move.LEFT),
            new Rule(State.H, '0', State.H, '0', Move.LEFT),
            new Rule(State.H, '1', State.I, '1', Move.LEFT),
            new Rule(State.I, '0', State.J, '0', Move.LEFT),
            new Rule(State.I, '1', State.I, '1', Move.LEFT),
            new Rule(State.J, '0', State.C, '0', Move.RIGHT),
            new Rule(State.J, '1', State.B, '1', Move.LEFT),
            new Rule(State.K, '0', State.A, '0', Move.STOP),
            new Rule(State.K, '1', State.K, '1', Move.RIGHT)
    );

    static Rule of(final State oldState, final char currentChar) {
        return rules.stream()
                .filter(r -> r.getOldState() == oldState)
                .filter(r -> r.getCurrentChar() == currentChar)
                .findFirst()
                .orElse(null);
    }
}
