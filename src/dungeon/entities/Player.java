package dungeon.entities;

import dungeon.board.Board;
import dungeon.board.CoordinateSystem;
import dungeon.board.Points;

public class Player {

    private int turns;

    private Board board;
    private CoordinateSystem coordinateSystem;

    public Player(int turns, Board board, CoordinateSystem coordinateSystem) {
        this.turns = turns;
        this.board = board;
        this.coordinateSystem = coordinateSystem;
        takeTurn(false);
    }

    public void takeTurn(boolean move) {
        if (move) {
            turns--;
        }
        System.out.println(turns + "\n");
        printCoordinates();
        for (Points points : coordinateSystem.getVampireLocations()) {
            System.out.print("v " + points.getX() + " " + points.getY());
            System.out.println();
        }
        System.out.println();
        board.draw();
    }

    public void printCoordinates() {
        System.out.println("@ " + coordinateSystem.getPlayerX() + " " + coordinateSystem.getPlayerY());
    }

}
