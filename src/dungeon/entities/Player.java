package dungeon.entities;

import dungeon.board.Board;
import dungeon.board.CoordinateSystem;

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

    public void takeTurn(boolean userMoved) {
        if (userMoved) {
            turns--;
        }
        System.out.println(turns + "\n");
        coordinateSystem.print();
        System.out.println();
        board.draw();
    }

}
