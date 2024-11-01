
package main.strategies;

import java.util.List;

import main.game.map.Map;
import main.game.map.Point;
import main.game.map.TreasureChest;

public class ShortestDistance implements Strategy {

	@Override
	public Point evaluatePossbileNextStep(List<Point> possibleNextStep, Map map) {
		String[][] scenario = map.getScenario();
		Point treasureLocation = null;
		Point currentPoint = map.getRobotLocation();

		for(int x = 0; x < scenario.length; x++) {
			for(int y = 0; y < scenario[x].length; y++) {
				if(scenario[x][y].equals(TreasureChest.CHARACTER)) {
					treasureLocation = new Point(x, y);
					break;
				}
			}
		}
		if(treasureLocation == null) {
			return null;
		}
		Point closestPoint = null;

		for(int i =0; i <possibleNextStep.size(); i++) {
			Point nextPoint = possibleNextStep.get(i);
			if(isMovingCloser(currentPoint, nextPoint, treasureLocation)){
				closestPoint = nextPoint;
			}
		}
		return closestPoint;
	}

	private boolean isMovingCloser(Point current, Point next, Point target) {

		return next.getPositionX() <= target.getPositionX() &&
				next.getPositionY() <= target.getPositionY() &&
				next.getPositionX() >= current.getPositionX() &&
				next.getPositionY() >= current.getPositionY();
	}
}

