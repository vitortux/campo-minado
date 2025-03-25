package dev.vitortux.domain.game;

public class Node {
    private NodeType type;

    public Node(NodeType type) {
        this.type = type;
    }

    public void reveal() {
        this.type.reveal();
    }
}
