//package main.strategies;
//
//import java.util.List;
//import java.util.Random;
//
//import main.game.Player;
//import main.game.map.Map;
//import main.game.map.Point;
//import main.game.map.TreasureChest;
//
//public class Sort implements Strategy{
//	/**
//	 * N is the next location
//	 * p1 p2 p3
//	 * p4 N p5
//	 * p6 p7 p8
//	 */
//	@Override
//	public Point evaluatePossbileNextStep(List<Point> possibleNextSteps, Map map) {
//		return null;
//	}
//}

package main.strategies;

import java.util.List;
import java.util.Random;

import main.game.Player;
import main.game.map.Map;
import main.game.map.Point;
import main.game.map.TreasureChest;

public class Sort implements Strategy {

	private Random random;

	public Sort() {
		this.random = new Random();
	}

	@Override
	public Point evaluatePossbileNextStep(List<Point> possibleNextSteps, Map map) {
		if (possibleNextSteps.isEmpty()) {
			return null;
		}
		int index = random.nextInt(possibleNextSteps.size());
		return possibleNextSteps.get(index);
	}
}

