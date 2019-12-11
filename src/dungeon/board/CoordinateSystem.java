package dungeon.board;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class CoordinateSystem {

    private Points playerPoint;

    private int playerX;
    private int playerY;
    private int width;
    private int height;
    private int numVampires;

    private boolean vampiresMove;

    private Random random = new Random();
    private Set<Points> vampireLocations = new HashSet<Points>();
    private Board board;

    public CoordinateSystem(Board board, int numVampires, boolean vampiresMove) {
        this.board = board;
        this.width = this.board.getWidth();
        this.height = this.board.getHeight();
        this.numVampires = numVampires;
        this.vampiresMove = vampiresMove;

        placePlayer("");
        placeVampires();
    }

    public void placePlayer(String moves) {
        for (char move : moves.toCharArray()) {
            switch (move) {
                case 'w':
                    if (playerY - 1 >= 0) {
                        playerY -= 1;
                    }
                    break;
                case 'a':
                    if (playerX - 1 >= 0) {
                        playerX -= 1;
                    }
                    break;
                case 's':
                    if (playerY + 1 < height) {
                        playerY += 1;
                    }
                    break;
                case 'd':
                    if (playerX + 1 < width) {
                        playerX += 1;
                    }
                    break;
            }
        }
        board.build();
        board.getBoard()[playerY][playerX] = "@";
        playerPoint = new Points(playerX, playerY);

        List<Points> killed = new ArrayList<Points>();
        for (Points vampire : vampireLocations) {
            if (playerPoint.equals(vampire)) {
                killed.add(vampire);
                numVampires--;
            }
        }
        vampireLocations.removeAll(killed);
    }

    public void placeVampires() {
        if (vampiresMove) {
            vampireLocations.clear();
        }
        while (vampireLocations.size() < numVampires) {
            int vampireX = random.nextInt(width);
            int vampireY = random.nextInt(height);
            Points vampirePoint = new Points(vampireX, vampireY);
            if (!vampirePoint.equals(playerPoint)) {
                vampireLocations.add(vampirePoint);
                board.getBoard()[vampireY][vampireX] = "v";
            }
        }

        if (!vampiresMove) {
            for (Points point : vampireLocations) {
                board.getBoard()[point.getY()][point.getX()] = "v";
            }
        }
    }

    public Set<Points> getVampireLocations() {
        return vampireLocations;
    }

    public Points getPlayerPoint() {
        return playerPoint;
    }

    public void print() {
        Set<Points> vampireLocations = getVampireLocations();
        Points playerPoint = getPlayerPoint();
        System.out.println("@ " + playerPoint);
        for (Points point : vampireLocations) {
            System.out.println("v " + point);
        }
    }

}
