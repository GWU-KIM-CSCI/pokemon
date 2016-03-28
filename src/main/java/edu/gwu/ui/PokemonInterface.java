package edu.gwu.ui;

import edu.gwu.entities.Move;
import edu.gwu.entities.Pokemon;

public interface PokemonInterface {
    public Move getMove(Pokemon issuer);
    public void showMessage(String message);
    public void showStatus(Pokemon player, Pokemon cpu);
}