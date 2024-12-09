package main;

import main.game.Game;
import main.game.map.GameMap;

public class Execute {
	public static void main(String[] args) {

		int totalNumMoves = 0;
		int runs = 100;
		int runsWithMoves = 0;
		int cantFindPath = 0;

		int totalTreasuresFound = 0;
		int totalTrapsFound = 0;
		int totalEmptyFound = 0;

		for (int i = 0; i < runs; i++) {
			Game g = new Game();
			GameMap gm = g.getGameMap();
			int moves = g.run();

			if (moves > 0) {
				totalNumMoves += moves;
				runsWithMoves++;
			}
			if (moves == 0){
				cantFindPath++;
			}
			totalTreasuresFound += gm.getTreasuresChestsFound();
			totalTrapsFound += gm.getTrapsChestsFound();
			totalEmptyFound += gm.getEmptyChestsFound();
		}

			double averageNumMoves = (double) totalNumMoves / runsWithMoves;
			System.out.println("Total de partidas:  " + runs);
			System.out.println("Média de jogadas por partida: " + averageNumMoves);
			System.out.println("Partidas sem caminho aparente: " + cantFindPath);
			System.out.println("Total de tesouros encontrados: " + totalTreasuresFound);
			System.out.println("Total de armadilhas encontradas: " + totalTrapsFound);
			System.out.println("Total de baús vazios encontrados: " + totalEmptyFound);

	}
}
