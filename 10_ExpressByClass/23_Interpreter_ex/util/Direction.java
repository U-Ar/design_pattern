package util;

public enum Direction {
    NORTH(0, -1),
    EAST(1, 0),
    WEST(-1, 0),
    SOUTH(0, 1);

    private int dx;
    private int dy;

    private Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    public static Direction turnRight(Direction d) {
        if (d == NORTH) return EAST;
        else if (d == EAST) return SOUTH;
        else if (d == SOUTH) return WEST;
        else return NORTH;
    }

    public static Direction turnLeft(Direction d) {
        if (d == NORTH) return WEST;
        else if (d == WEST) return SOUTH;
        else if (d == SOUTH) return EAST;
        else return NORTH;
    }

}
