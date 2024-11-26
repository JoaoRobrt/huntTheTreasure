package main.game;

import main.game.map.GameMap;
import main.game.map.Point;
import main.game.map.TreasureChest;
import main.strategies.FewerObstacles;
import main.strategies.Voting;

public class Game {
	private GameMap gameMap;
	private Player player;
	public Game() {
		this.gameMap = new GameMap(8, 8);
		this.player = new Player(new Voting());
	}
	
	public void run() {
		this.gameMap.print();
		System.out.println();
		while(true) {
			Point nextPoint = this.player.evaluatePossbileNextStep(gameMap);
			if (nextPoint == null) {
				break;
			} else {
				String space = this.gameMap.get(nextPoint);
				if (space != null && space.equals(TreasureChest.CHARACTER)) {
					this.gameMap.openTreasureChest(nextPoint);
					this.gameMap.print();
					break;
				} else {
					this.gameMap.moveRobot(nextPoint);
				}
			}
			this.gameMap.print();
			System.out.println();
		}
	}

}
