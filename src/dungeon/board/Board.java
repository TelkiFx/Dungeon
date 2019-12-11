package dungeon.board;

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
        System.out.print("\033[H\033[2J");
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

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String[][] getBoard() {
        return board;
    }

}
