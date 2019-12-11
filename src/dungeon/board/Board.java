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

    public void placePlayer(String moves) {
        for (char move : moves.toCharArray()) {
            switch (move) {
                case 'w':
                    if (y - 1 >= 0) {
                        y -= 1;
                    }
                    break;
                case 'a':
                    if (x - 1 >= 0) {
                        x -= 1;
                    }
                    break;
                case 's':
                    if (y + 1 < height) {
                        y += 1;
                    }
                    break;
                case 'd':
                    if (x + 1 < width) {
                        x += 1;
                    }
                    break;
                default:
                    System.out.println("Not a valid move");
            }
        }
        build();
        board[y][x] = "@";
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
