package dungeon.board;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class CoordinateSystem {

    private int x;
    private int y;
    private int width;
    private int height;
    private int numVampires;

    private List<Integer> playerCoords = new ArrayList<Integer>();

    private Random random = new Random();
    private Set<List<Integer>> vampireLocations = new HashSet<List<Integer>>();
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
        playerCoords.clear();
        playerCoords.add(x);
        playerCoords.add(y);
    }

    public void placeVampires() {
        vampireLocations.clear();
        while (vampireLocations.size() < numVampires) {
            int vampireX = random.nextInt(10);
            int vampireY = random.nextInt(10);
            List<Integer> vampireCoords = new ArrayList<Integer>();
            vampireCoords.add(vampireX);
            vampireCoords.add(vampireY);
            vampireLocations.add(vampireCoords);

            if (!vampireLocations.contains(playerCoords)) {
                vampireLocations.add(vampireCoords);
                board.getBoard()[vampireY][vampireX] = "v";
            }
        }
    }

    public Set<List<Integer>> getVampireLocations() {
        return vampireLocations;
    }

    public List<Integer> getPlayerCoords() {
        return playerCoords;
    }

    public int getPlayerX() {
        return x;
    }

    public int getPlayerY() {
        return y;
    }

}
