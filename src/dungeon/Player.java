package dungeon;

public class Player {

    private int x;
    private int y;
    private int turns;
    private Board board;
    String[][] builtBoard;

    public Player(int turns, Board board) {
        x = 0;
        y = 0;
        this.turns = turns;
        this.board = board;
        board.build();
        builtBoard = board.getBoard();
        builtBoard[y][x] = "@";
    }

    public void setPosition(int x, int y) {

        try {
            builtBoard[y][x] = "@";
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Coordinates not found on board. Default position set.");
            builtBoard[0][0] = "@";
        }
    }

    public void draw() {
        board.draw();
        setPosition(2,1);
        board.draw();
    }

}
