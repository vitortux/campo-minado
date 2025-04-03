package dev.vitortux.domain.node;

public interface NodeState {
    void reveal(NodeStrategy node);

    void flag(NodeStrategy node);

    void unflag(NodeStrategy node);

    void print(NodeStrategy node);
}
