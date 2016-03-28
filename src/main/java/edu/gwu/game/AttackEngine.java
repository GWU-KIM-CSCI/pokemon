package edu.gwu.game;

import edu.gwu.entities.Category;
import edu.gwu.entities.Move;
import edu.gwu.entities.Pokemon;

import java.util.Random;

public class AttackEngine {

    public static String attack(Pokemon issuer, Move move, Pokemon receiver, Random rng) {
        StringBuilder msg = new StringBuilder();
        msg.append(issuer.name).append(" used ").append(move.name).append(".\n");

        if (move.category == Category.PHYSICAL) {
            double stab = (move.type == issuer.type) ? 1.5 : 1.0;
            double effectiveness = move.getEffectiveness(receiver);

            if (effectiveness > 1) msg.append("It was supper effective!\n");
            else if (effectiveness < 1) msg.append("Not very effective.\n");

            double criticalHit = rng.nextInt(512) < issuer.getSpeed() ? 2.0 : 1.0;

            if (criticalHit > 1) msg.append("Critical HIT!\n");

            double modifier = stab * effectiveness * criticalHit * (1 - (rng.nextDouble() * 0.15));
            int damage = (int) (((2.0 * issuer.getLevel() + 10.0) / 250.0) * ((double) issuer.getAttack() / (double) receiver.getDefense()) * move.power * modifier);

            msg.append(receiver.name).append(" took ").append(damage).append(" damage.\n");

            int hp = receiver.getHp() - damage;
            receiver.setHp(hp < 0 ? 0 : hp);
        } else if (move.category == Category.STATUS) {
            msg.append(move.applyStatus(issuer, receiver)).append("\n");
        } else {
            throw new IllegalStateException("Undefined Move Category" + move.category);
        }

        return msg.toString();
    }
}
