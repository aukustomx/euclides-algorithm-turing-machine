package com.aukustomx;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class EuclidAlgorithmTuringMachine {

    static int execute(int a, int b) {

        List<Character> tape = inputToTape(a, b);

        //Partimos de la posición 0 de la cinta.
        int position = 0;

        //Partimos con el estado A
        State state = State.A;

        //Miramos cómo está la cinta al iniciar
        printMovement(state, tape, position);

        //Fuera del ciclo para evaluar la condición del do-while.
        Move move;

        do {

            //Determinamos la regla que aplica al state y al caracter en la cinta en la position.
            final Rule rule = RulesDictionary.of(state, tape.get(position));

            //Se determina el nuevo estado
            state = rule.getNewState();

            //Se determina cuántas posiciones avanzar/retroceder
            move = rule.getMove();

            //Susutituir caracter actual en la position en la cinta, con el que está definido en la regla
            tape.set(position, rule.getNewChar());

            //Si el movimiento no es STOP
            if (!move.equals(Move.STOP)) {

                //Mover los movimiento indicados en la regla.
                position += move.getMove();
            } else {
                //Se ha terminado la ejecución
                System.out.println("Movimiento a STOP");
                //Se ajusta la posición del ^
                position += 1;
            }

            //Cuando la cabeza se mueve una posición detrás de la primera en la cinta
            // la 0 (cero) se rellena la cinta con 0s al inicio. La máquina de Turing
            // se mueve a través de la cinta a derecha o izquierda, teóricamente de
            // forma infinita, aunque el conjunto de reglas de la máquina debe ser finito.
            while (position < 0) {
                tape.add(0, '0');
                position += 1;
            }

            //Cuando la cabeza se mueve más allá de la última posición de la cinta,
            // llenamos con 0 (cero) dicha posición en la cinta.
            while (position >= tape.size()) {
                tape.add('0');
            }

            //Miramos cómo está la cinta tras cada iteración
            printMovement(state, tape, position);

        } while (!move.equals(Move.STOP));

        return tape.stream()
                .mapToInt(Character::getNumericValue)
                .sum();
    }

    /**
     * Para efectos de ir visualizando el estado, la cinta y la posición de la cabeza.
     *
     * @param state    Estado actual de la máquina de Turing
     * @param tape     Cinta
     * @param position Posición de la cabeza.
     */
    private static void printMovement(State state, List<Character> tape, int position) {
        System.out.println(state + " " + tape.stream()
                .map(String::valueOf)
                .collect(Collectors.joining()));

        System.out.print(" ");
        for (int i = 0; i <= position; i++) {
            System.out.print(" ");
        }
        System.out.println("^");
    }

    /**
     * Convertir enteros de entrada a representación unaria y colocarlos en
     * una cinta/tape (ArrayList) para ser procesados
     *
     * @param a A
     * @param b B
     * @return Cinta con A y B en representación unaria.
     */
    private static List<Character> inputToTape(int a, int b) {
        List<Character> tape = new ArrayList<>();
        IntStream.range(0, a)
                .forEach(e -> tape.add('1'));
        tape.add('0');
        IntStream.range(0, b)
                .forEach(e -> tape.add('1'));
        return tape;
    }
}
