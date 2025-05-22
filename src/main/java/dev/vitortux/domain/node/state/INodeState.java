package dev.vitortux.domain.node.state;

import dev.vitortux.domain.node.Node;

public interface INodeState {
    void reveal(Node node);

    void flag(Node node);

    void unflag(Node node);

    void print(int mines);
}
