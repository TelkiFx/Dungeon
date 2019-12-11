package dungeon.entities;

import dungeon.board.Board;

public class Player {

    private Board board;
    private int turns;

    public Player(int turns, Board board) {
        this.turns = turns;
        this.board = board;
        this.board.placePlayer("");
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
        System.out.println("@ " + board.getX() + " " + board.getY());
    }

}
