package dev.vitortux.domain.game.state;

import dev.vitortux.domain.game.Game;
import dev.vitortux.domain.game.GameException;
import dev.vitortux.domain.input.UserCommand;

public class Playing implements GameState {

    @Override
    public void run(Game game) {
        game.printBoard();

        try {
            UserCommand command = game.readCommand();
            command.getType().execute(game.getBoard(), command.getCol(), command.getRow());

            if (game.getBoard().isCleared()) {
                System.out.println("🎉 Você venceu!");
                game.setState(new Victory());
            }
        } catch (GameException e) {
            System.out.println(e.getMessage());
            game.setState(new GameOver());
        }
    }

}
