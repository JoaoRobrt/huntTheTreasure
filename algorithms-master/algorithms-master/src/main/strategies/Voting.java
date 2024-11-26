

package main.strategies;

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import main.game.map.GameMap;
import main.game.map.Point;

public class Voting implements Strategy {
    
    @Override
    public Point evaluatePossbileNextStep(List<Point> possibleNextSteps, GameMap gameMap) {
        Sort sort = new Sort(); 
        FewerObstacles fewerObstacles = new FewerObstacles();
        ShortestDistance shortestDistance = new ShortestDistance();
        
        Point sortPoint = sort.evaluatePossbileNextStep(possibleNextSteps, gameMap);
        Point fewerObstaclesPoint = fewerObstacles.evaluatePossbileNextStep(possibleNextSteps, gameMap);
        Point shortestDistancePoint = shortestDistance.evaluatePossbileNextStep(possibleNextSteps, gameMap);
        
        List<Point> points = new LinkedList<Point>();
        points.add(sortPoint);
        points.add(fewerObstaclesPoint);
        points.add(shortestDistancePoint);
        
       Map<Point, Integer> voting = new HashMap<>();
        for(int i = 0; i < points.size(); i++){
            Point p = points.get(i);
            if(voting.get(p) == null){
                voting.put(p, 1);
                }else {
                voting.put(p, voting.get(p) + 1);
            }
            
        }
       return getMostVotedPoint(voting);
    }
    
    private Point getMostVotedPoint(Map<Point, Integer> voting){
        Integer biggestValues = Integer.MIN_VALUE;
        Point point = null;
        for (Map.Entry<Point, Integer> entry : voting.entrySet()){
            if (entry.getValue() > biggestValues && entry.getKey() != null) {
                biggestValues = entry.getValue();
                point = entry.getKey();
            }else{
                
            }
        }
        return point;
    }
}

