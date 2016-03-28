package edu.gwu.entities;

public class Move {
    public final String name;
    public final Type type;
    public final Category category;
    public final int power;
    public final int accuracy;
    public final int pp;

    public Move(String name, Type type, Category category, int power, int accuracy, int pp) {
        this.name = name;
        this.type = type;
        this.category = category;
        this.power = power;
        this.accuracy = accuracy;
        this.pp = pp;
    }

    public double getEffectiveness(Pokemon pokemon) {
        return 1.0;
    }

    public String applyStatus(Pokemon issuer, Pokemon receiver) {
        if (category == Category.PHYSICAL) return "";
        if (name.equals("Growl") && receiver.getAttack() > 10) {
            receiver.setAttack(receiver.getAttack() - 1);
            return receiver.name + "'s attack fell.";
        } else {
            return name + " has no effect.";
        }
    }
}
