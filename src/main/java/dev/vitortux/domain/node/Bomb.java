package dev.vitortux.domain.node;

import dev.vitortux.domain.game.GameException;

public class Bomb implements NodeStrategy {
    private NodeState state;
    private int minesAround;

    public Bomb() {
        this.state = new Closed();
    }

    @Override
    public void reveal() {
        this.state.reveal(this);
        throw new GameException("💥 BOOM! Você clicou em uma mina!");
    }

    public void flag() {
        this.state.flag(this);
    }

    public void unflag() {
        this.state.unflag(this);
    }

    public void setState(NodeState state) {
        this.state = state;
    }

    public int getMinesAround() {
        return minesAround;
    }

    public void setMinesAround(int minesAround) {
        this.minesAround = minesAround;
    }

    public void print(NodeStrategy node) {
        // this.state.print(this);
        System.out.print("💣 ");
    }

    @Override
    public NodeState getState() {
        return state;
    }
}
