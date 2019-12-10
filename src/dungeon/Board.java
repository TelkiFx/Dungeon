package dungeon;

public class Board {

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
    }

    public String[][] getBoard() {
        return board;
    }

}
