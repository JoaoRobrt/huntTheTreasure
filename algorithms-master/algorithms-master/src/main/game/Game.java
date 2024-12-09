package main.game;

import main.game.map.GameMap;
import main.game.map.Point;
import main.game.map.TreasureChest;

import main.strategies.FewerObstacles;
import main.strategies.ShortestDistance;
import main.strategies.Sort;
import main.strategies.Voting;
import main.strategies.binaryTree.BinaryTree;

public class Game {
	private GameMap gameMap;
	private Player player;
	public Game() {
		this.gameMap = new GameMap(8, 8);
		this.player = new Player(new FewerObstacles());
	}

	public int run() {
		int num_moves = 0;

		this.gameMap.print();
		System.out.println();

		while(true) {
			Point nextPoint = this.player.evaluatePossibleNextStep(gameMap);
			if(num_moves == 300){
				num_moves = 0;
				break;
			}
			if (nextPoint == null) {
				num_moves = 0;
				break;
			} else {
				String space = this.gameMap.get(nextPoint);

				if (space != null && space.equals(TreasureChest.CHARACTER)) {
					this.gameMap.openTreasureChest(nextPoint);

					this.gameMap.print();
					System.out.println();
					break;
				} else {
					this.gameMap.moveRobot(nextPoint);
					num_moves++;

				}
			}
			this.gameMap.print();
		}
			return num_moves;
	}

	public GameMap getGameMap() {
		return this.gameMap;
	}
}
