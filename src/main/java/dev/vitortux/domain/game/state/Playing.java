package dev.vitortux.domain.game.state;

import dev.vitortux.domain.game.Game;
import dev.vitortux.domain.input.UserCommand;

public class Playing implements GameState {

    @Override
    public void run(Game game) {
        game.printBoard();

        UserCommand command = game.readCommand();

        if (!game.getBoard().isValidPosition(command.getCol(), command.getRow())) {
            return;
        }

        command.getType().execute(game.getBoard(), command.getCol(), command.getRow());
    }
}
