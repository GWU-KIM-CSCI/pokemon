package edu.gwu.game;

import edu.gwu.entities.Move;
import edu.gwu.entities.Pokemon;
import edu.gwu.ui.PokemonInterface;

import java.util.Random;

public class GameEngine {

    public Random rng = new Random();

    private PokemonInterface ui;

    public GameEngine(PokemonInterface ui) {
        this.ui = ui;
    }

    public void run(Pokemon player, Pokemon cpu) {
        while (!endcondition(player, cpu)) {
            ui.showStatus(player, cpu);
            Move cpuMove = PokemonAI.selectMove(cpu, rng);
            Move playerMove = ui.getMove(player);

            String message1 = "";
            String message2 = "";

            if (cpu.fasterThan(player)) {
                message1 = AttackEngine.attack(cpu, cpuMove, player, rng);
                if (!endcondition(player, cpu))
                    message2 = AttackEngine.attack(player, playerMove, cpu, rng);
            } else {
                message1 = AttackEngine.attack(player, playerMove, cpu, rng);
                if (!endcondition(player, cpu))
                    message2 = AttackEngine.attack(cpu, cpuMove, player, rng);
            }

            ui.showMessage(message1);
            ui.showMessage(message2);
        }

        if (player.getHp() == 0) {
            ui.showMessage(player.name + " fainted. You've lost.");
        } else {
            ui.showMessage(cpu.name + " fainted. You've won!");
        }
    }


    private boolean endcondition(Pokemon player, Pokemon cpu) {
        return (player.getHp() == 0 || cpu.getHp() == 0);
    }

}
