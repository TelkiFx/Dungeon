package dungeon;

public class Player {

    private int x;
    private int y;
    private int turns;
    private Board board;


    public Player(int turns, Board board) {
        x = 0;
        y = 0;
        this.turns = turns;
        this.board = board;
    }

    public void setPosition(int x, int y) {
        String[][] builtBoard = board.getBoard();
        board.build();
        try {
            builtBoard[y][x] = "@";
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Coordinates not found on board. Default position set.");
            builtBoard[0][0] = "@";
        }
    }

}
