package dev.vitortux.domain.game.state;

import dev.vitortux.domain.game.Game;
import dev.vitortux.domain.input.InputType;
import dev.vitortux.domain.input.UserCommand;

public class FirstMove implements GameState {

    @Override
    public void run(Game game) {
        game.getSoundtrack().play("running.wav", true);
        game.printBoard();

        UserCommand command = game.readCommand();

        if (command.getType() != InputType.REVEAL) {
            return;
        }

        game.firstMove(command.getCol(), command.getRow());
        game.printBoard();
        game.setState(new Playing());
    }
}
