package dungeon;

/*
Player = @
Vampire = v

Win condition:
    Kill all vampires
        Get a kill by running into a vampire during current turn
            i.e. before vampire gets random new position
    Still have gas in lamp
Damage:
    Vampire suck blood in dark
Skills:
    See vampires once per turn
        Counts as one blink of lamp
    Walk as many times and directions per turn
Vampire:
    Random position on board
        Random position * number of steps per turn
            i.e. player moves "wwws" (== 4) then vampire moves 4 random times
        Move does not count, redo:
            Outside board
            On top of another vampire
 */

import dungeon.board.Board;
import dungeon.board.CoordinateSystem;
import dungeon.entities.Player;
import dungeon.entities.Vampire;
import java.util.Scanner;

public class Dungeon {

    private Scanner scanner = new Scanner(System.in);

    private int height;
    private int width;
    private int vampires;
    private int turns;
    private boolean vampiresMove;

    private Board board;
    private CoordinateSystem coordinateSystem;
    private Player player;
    private Vampire vampire;

    public Dungeon(int height, int width, int vampires, int turns, boolean vampiresMove) {
        this.height = height;
        this.width = width;
        this.vampires = vampires;
        this.turns = turns;
        this.vampiresMove = vampiresMove;

        init();
    }

    public void init() {
        board = new Board(width, height);
        coordinateSystem = new CoordinateSystem(board, vampires);
        player = new Player(turns, board, coordinateSystem);
        vampire = new Vampire(vampires, board, coordinateSystem);
    }

    public void run() {
        boolean enoughTurns = true;
        while (enoughTurns) {
            String moves = scanner.nextLine();
            if (moves.equals("q")) {
                break;
            }
            coordinateSystem.placePlayer(moves);
            if (coordinateSystem.getVampireLocations().size() == 0) {
                System.out.println("YOU WIN");
                break;
            }
            coordinateSystem.placeVampires();
            enoughTurns = player.takeTurn(true);
            if (!enoughTurns) {
                System.out.println("YOU LOSE");
            }
        }

    }

}
