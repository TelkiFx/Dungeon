package dungeon;

public class Player {

    private int x;
    private int y;
    private int turns;
    private Board board;


    public Player(int turns, Board board) {
        this.turns = turns;
        this.board = board;
        setPosition(0, 0);
    }

    public void setPosition(int x, int y) {
        String[][] builtBoard = board.getBoard();
        board.build();

        try {
            builtBoard[y][x] = "@";
            this.x = x;
            this.y = y;
        } catch (ArrayIndexOutOfBoundsException e) {
            builtBoard[this.y][this.x] = "@";
        }
    }

}
