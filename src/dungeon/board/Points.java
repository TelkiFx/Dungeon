package dungeon.board;

import java.util.Objects;

public class Points {

    private int x;
    private int y;

    public Points(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (!(o instanceof Points)) {
            return false;
        }
        Points p = (Points) o;
        return this.getX() == p.getX() && this.getY() == p.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

}
