package dungeon.board;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class CoordinateSystem {

    private Points playerPoint;

    private int x;
    private int y;
    private int width;
    private int height;
    private int numVampires;

    private Random random = new Random();
    private Set<Points> vampireLocations = new HashSet<Points>();
    private Board board;

    public CoordinateSystem(Board board, int numVampires) {
        this.board = board;
        this.width = this.board.getWidth();
        this.height = this.board.getHeight();
        this.numVampires = numVampires;

        placePlayer("");
        placeVampires();
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
        playerPoint = new Points(x, y);
    }

    public void placeVampires() {
        vampireLocations.clear();
        while (vampireLocations.size() < numVampires) {
            int vampireX = random.nextInt(10);
            int vampireY = random.nextInt(10);
            Points vampirePoint = new Points(vampireX, vampireY);
            if (!vampirePoint.equals(playerPoint)) {
                vampireLocations.add(vampirePoint);
                board.getBoard()[vampireY][vampireX] = "v";
            }
        }
    }

    public Set<Points> getVampireLocations() {
        return vampireLocations;
    }

    public Points getPlayerCoords() {
        return playerPoint;
    }

    public int getPlayerX() {
        return x;
    }

    public int getPlayerY() {
        return y;
    }

}
