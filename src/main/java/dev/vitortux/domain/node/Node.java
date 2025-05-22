package dev.vitortux.domain.node;

import dev.vitortux.domain.node.state.ClosedNodeState;
import dev.vitortux.domain.node.state.INodeState;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node {
    private INodeState state;
    private int mines;

    public Node() {
        this.state = new ClosedNodeState();
    }

    public void reveal() {
        this.state.reveal(this);
    }

    public void flag() {
        this.state.flag(this);
    }

    public void unflag() {
        this.state.unflag(this);
    }

    public void print() {
        this.state.print(mines);
    }
}
