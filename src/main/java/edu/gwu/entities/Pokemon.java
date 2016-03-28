package edu.gwu.entities;

import edu.gwu.CannotAddNewMoveException;

import java.util.ArrayList;
import java.util.List;

public class Pokemon {

    final public String name;
    final public Type type;
    final public int maxHp;

    private int hp;
    private int attack;
    private int defense;
    private int speed;

    private List<Move> moves;

    public Pokemon(String name, Type type, int maxHp) {
        this.name = name;
        this.type = type;
        this.maxHp = maxHp;
        this.hp = maxHp;
    }

    public boolean fasterThan(Pokemon other) {
        return this.speed > other.getSpeed();
    }

    public void addMove(Move move) throws CannotAddNewMoveException {
        if (moves == null) {
            moves = new ArrayList<Move>();
        }
        if (moves.size() == 4) {
            throw new CannotAddNewMoveException();
        } else {
            moves.add(move);
        }
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public int getLevel() { return 10; }
}
