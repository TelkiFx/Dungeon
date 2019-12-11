package dungeon.board;

public class CoordinateSystem {

    private Board board;
    private int x;
    private int y;
    private int width;
    private int height;

    public CoordinateSystem(Board board) {
        this.board = board;
        this.width = this.board.getWidth();
        this.height = this.board.getHeight();
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
            }
        }
        board.build();
        board.getBoard()[y][x] = "@";
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
