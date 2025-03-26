package dev.vitortux.domain.board;

import dev.vitortux.domain.game.GameException;

public class Node {
    private NodeType type;

    public Node(NodeType type) {
        this.type = type;
    }

    public void reveal() throws GameException {
        this.type.reveal();
    }
}
