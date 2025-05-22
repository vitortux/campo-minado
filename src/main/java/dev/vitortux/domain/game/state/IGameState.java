package dev.vitortux.domain.game.state;

public interface IGameState {
    void run();

    void playMusic();

    default void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
