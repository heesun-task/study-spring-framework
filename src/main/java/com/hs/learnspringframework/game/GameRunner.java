package com.hs.learnspringframework.game;

import org.springframework.stereotype.Component;

@Component
public class GameRunner {
    GamingConsole game;

    public GameRunner(GamingConsole game) {
        this.game = game;
    }

    public void run() {
        System.out.println("Running game: " + game);

        game.down();
        game.up();
        game.left();
        game.right();
    }
}
