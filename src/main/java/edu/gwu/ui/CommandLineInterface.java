package edu.gwu.ui;

import edu.gwu.entities.Move;
import edu.gwu.entities.Pokemon;
import edu.gwu.game.AttackEngine;

import java.util.Scanner;

public class CommandLineInterface implements PokemonInterface {
//    public AttackEngine getCommand(Pokemon issuer, Pokemon receiver) {
//        Scanner in = new Scanner(System.in);
//        do {
//            System.out.println("What would you like to do? [A]ttack | [S]witch Pokemon ");
//            String choice = in.nextLine().toLowerCase();
//            if (choice.startsWith("a")) {
//                return new AttackEngine(issuer, receiver);
//            } else if (choice.startsWith("s")){
//                System.out.println("You can't switch Pokemon.");
//            } else {
//                System.out.println("Bad input.");
//            }
//        } while (true);
//    }

    public Move getMove(Pokemon issuer) {
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("Choose an attack:");
            int i = 1;
            for (Move move : issuer.getMoves()) {
                System.out.print(i + ". ");
                System.out.println(move.name);
                i++;
            }

            int choice = in.nextInt();
            if (choice > 0 && choice < issuer.getMoves().size()) {
                return issuer.getMoves().get(choice - 1);
            }

            System.out.print("Invalid choice.");
        } while (true);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    private String showHp(Pokemon p) {
        String sp1 = "";
        if (p.getHp() < 10) sp1 = "  ";
        else if (p.getHp() < 100) sp1 = " ";
        String sp2 = "";
        if (p.maxHp < 10) sp2 = "  ";
        else if (p.maxHp < 100) sp2 = " ";
        return "HP [" + sp1 + p.getHp() + "/" + sp2 + p.maxHp + "]";
    }

    public void showStatus(Pokemon player, Pokemon cpu) {
        System.out.println("Your Pokemon: " + showHp(player) + " " + player.name);
        System.out.println("CPU  Pokemon: " + showHp(cpu) + " " + cpu.name);
    }
}
