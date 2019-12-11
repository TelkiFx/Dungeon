package dungeon.board;

public class Board {

    private int x;
    private int y;
    private int width;
    private int height;
    private String[][] board;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        board = new String[this.height][this.width];
    }

    public void build() {
        for (int y = 0; y < height; ++y) {
            for (int x = 0; x < width; ++x) {
                board[y][x] = ".";
            }
        }
    }

    public void draw() {
        for (String[] strings : board) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean placePlayer(int x, int y) {
        build();

        try {
            board[y][x] = "@";
            this.x = x;
            this.y = y;
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            board[this.y][this.x] = "@";
            return false;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
