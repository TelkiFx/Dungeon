package dungeon.entities;

import dungeon.board.Board;
import dungeon.board.CoordinateSystem;

public class Player {

    private Board board;
    private CoordinateSystem coordinateSystem;
    private int turns;

    public Player(int turns, Board board, CoordinateSystem coordinateSystem) {
        this.turns = turns;
        this.board = board;
        this.coordinateSystem = coordinateSystem;
        this.coordinateSystem.placePlayer("");
        takeTurn(false);
    }

    public void takeTurn(boolean move) {
        if (move) {
            turns--;
        }
        System.out.println(turns + "\n");
        coordinates();
        System.out.println();
        board.draw();
    }

    public void coordinates() {
        System.out.println("@ " + coordinateSystem.getX() + " " + coordinateSystem.getY());
    }

}
