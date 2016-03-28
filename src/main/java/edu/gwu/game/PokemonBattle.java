package edu.gwu.game;

import edu.gwu.CannotAddNewMoveException;
import edu.gwu.entities.Category;
import edu.gwu.entities.Move;
import edu.gwu.entities.Pokemon;
import edu.gwu.entities.Type;
import edu.gwu.ui.CommandLineInterface;
import edu.gwu.ui.PokemonInterface;

public class PokemonBattle {
    public static void main(String[] args) throws CannotAddNewMoveException {
        PokemonInterface ui = new CommandLineInterface();
        GameEngine game = new GameEngine(ui);

        Pokemon player = new Pokemon("Pikachu", Type.ELECTRIC, 35);
        player.setAttack(55);
        player.setDefense(30);
        player.setSpeed(90);
        player.addMove(new Move("ThunderShock", Type.ELECTRIC, Category.PHYSICAL, 40, 100, 30));
        player.addMove(new Move("Growl", Type.NORMAL, Category.STATUS, 0, 100, 40));

        Pokemon cpu = new Pokemon("Charmander", Type.FIRE, 39);
        cpu.setAttack(52);
        cpu.setDefense(43);
        cpu.setSpeed(65);
        cpu.addMove(new Move("Scratch", Type.NORMAL, Category.PHYSICAL, 40, 100, 35));
        cpu.addMove(new Move("Growl", Type.NORMAL, Category.STATUS, 0, 100, 40));

        game.run(player, cpu);
    }

}
