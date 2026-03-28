package com.sivaji;

public class GameFactory {

    public static Game createGame(GameType type, int size) {

        switch (type) {
            case STANDARD:
                return new Game(size, new StandardRules());

            default:
                throw new IllegalArgumentException("Invalid Game Type");
        }
    }

}
