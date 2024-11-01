package main.strategies;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import main.game.map.*;

public class FewerObstacles implements Strategy{

	/**
	 * N is the next location
	 * p1 p2 p3
	 * p4 N p5
	 * p6 p7 p8
	 */

	@Override
	public Point evaluatePossbileNextStep(List<Point> possibleNextStep, Map map) {
		Iterator<Point> iterator = possibleNextStep.iterator();
		int min = Integer.MAX_VALUE;
		Point pointSelected = null;
		while(iterator.hasNext()){
			Point p = iterator.next();
			int count = evaluatePoint(p, map);
			if(count < min){
				min = count;
				pointSelected = p;
			}
		}
		return pointSelected;

	}

	private int evaluatePoint(Point p, Map map) {
		List<Point> points = new ArrayList<>();
		int count = 0;
		points.add( new Point(p.getPositionX() - 1,p.getPositionY() - 1));
		points.add(new Point(p.getPositionX() - 1,p.getPositionY()));
		points.add(new Point(p.getPositionX() - 1,p.getPositionY() + 1));
		points.add(new Point(p.getPositionX(),p.getPositionY() - 1));
		points.add(new Point(p.getPositionX(),p.getPositionY() + 1));
		points.add(new Point(p.getPositionX() + 1,p.getPositionY() - 1));
		points.add(new Point(p.getPositionX() + 1,p.getPositionY()));
		points.add(new Point(p.getPositionX() + 1,p.getPositionY() + 1));

		for (int i = 0; i < points.size(); i++) {
			Point currentPoint = points.get(i);
			int [] scenarioSize = map.getScenarioSize();
			Point w = map.getRobotLocation();
			if(
					(currentPoint.getPositionX() == w.getPositionX()) && (currentPoint.getPositionY() == w.getPositionY()) ||
							currentPoint.getPositionX() < 0 || currentPoint.getPositionX() >= scenarioSize[0] ||
							currentPoint.getPositionY() < 0 || currentPoint.getPositionY() >= scenarioSize[1]
			) {
				continue;
			} else{
				if(map.get(currentPoint).equals(Rock.CHARACTER) || map.get(currentPoint).equals(Monster.CHARACTER)){
					count++;

				} else {
					if(map.get(currentPoint).equals(TreasureChest.CHARACTER)){
						count = 0;
					}

				}

			}
		}
		return count;
	}

}
