package edu.gwu.game;

import edu.gwu.entities.Move;
import edu.gwu.entities.Pokemon;

import java.util.Random;

public class PokemonAI {

    public static Move selectMove(Pokemon cpu, Random rng) {
        int moveIndex = rng.nextInt(cpu.getMoves().size());
        return cpu.getMoves().get(moveIndex);
    }

}
