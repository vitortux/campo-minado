package dev.vitortux.domain.input;

public class UserCommand {
    private final InputType type;
    private final int col;
    private final int row;

    public UserCommand(InputType type, int col, int row) {
        this.type = type;
        this.col = col;
        this.row = row;
    }

    public InputType getType() {
        return type;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }
}
