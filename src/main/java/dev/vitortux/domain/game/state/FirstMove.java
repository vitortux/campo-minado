package dev.vitortux.domain.game.state;

import dev.vitortux.domain.game.Game;
import dev.vitortux.domain.input.InputType;
import dev.vitortux.domain.input.UserCommand;

public class FirstMove implements GameState {

    @Override
    public void run(Game game) {
        game.printBoard();

        UserCommand command = game.readCommand();

        if (command.getType() != InputType.REVEAL ||
                !game.getBoard().isValidPosition(command.getCol(), command.getRow())) {
            return;
        }

        game.firstMove(command.getCol(), command.getRow());
        game.printBoard();
        game.setState(new Playing());
    }
}
