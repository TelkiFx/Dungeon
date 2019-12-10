package dungeon;

/*
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

public class Dungeon {

    private int length;
    private int width;
    private int vampires;
    private int moves;
    private boolean vampiresMove;

    public Dungeon(int length, int width, int vampires, int moves, boolean vampiresMove) {
        this.length = length;
        this.width = width;
        this.vampires = vampires;
        this.moves = moves;
        this.vampiresMove = vampiresMove;
    }

    public void run() {
        // starts game
    }

}
