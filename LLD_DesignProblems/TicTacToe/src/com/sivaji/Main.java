package com.sivaji;

public class Main {
    public static void main(String[] args) {

        Game game = GameFactory.createGame(GameType.STANDARD, 3);

        // Add players
        game.addPlayer(new Player(1, "Alice", new Symbol('X')));
        game.addPlayer(new Player(2, "Bob", new Symbol('O')));

        // Add observer
        game.addObserver(new ConsoleNotifier());

        // Start game
        game.play();
    }
}
