package com.aukustomx;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class EuclidAlgorithmTuringMachineTest {

    @ParameterizedTest
    @CsvSource({"2,6,2", "6,4,2", "6,9,3", "5,2,1", "9,5,1"})
    void execute(int a, int b, int expected) {
        int actual = EuclidAlgorithmTuringMachine.execute(a, b);
        Assertions.assertEquals(expected, actual);
    }
}