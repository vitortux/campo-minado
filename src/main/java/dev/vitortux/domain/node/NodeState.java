package dev.vitortux.domain.node;

public interface NodeState {
    void reveal(Node node);

    void flag(Node node);

    void unflag(Node node);

    void print(int minesAround);
}
