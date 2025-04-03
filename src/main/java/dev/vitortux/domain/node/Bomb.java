package dev.vitortux.domain.node;

import dev.vitortux.domain.game.GameException;

public class Bomb extends Node {
    public Bomb() {
        super();
    }

    @Override
    public void reveal() {
        throw new GameException("💥 BOOM! Você clicou em uma mina!");
    }

    @Override
    public void print() {
        System.out.print("💣 ");
    }
}
