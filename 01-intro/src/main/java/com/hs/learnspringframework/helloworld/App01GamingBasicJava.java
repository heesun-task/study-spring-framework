package com.hs.learnspringframework.helloworld;

import com.hs.learnspringframework.game.GameRunner;
import com.hs.learnspringframework.game.MarioGame;
import com.hs.learnspringframework.game.SuperContraGame;

public class App01GamingBasicJava {

	public static void main(String[] args) {
//		 var game = new MarioGame();
//		 var game = new SuperContraGame();
		
		 var game = new MarioGame(); // 1. Object Creation
		 
		 var gameRunner = new GameRunner(game); // 2. Object Creation + Wiring of dependencies
		 	// game is a dependency of GameRunner
		 gameRunner.run();
	}

}
