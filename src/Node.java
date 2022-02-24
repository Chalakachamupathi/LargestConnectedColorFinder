public class Node {
    private int color;
    private boolean isTraversed;
    private final int row;
    private final int column;

    public Node(int color, boolean isTraversed, int row, int column) {
        this.color = color;
        this.isTraversed = isTraversed;
        this.row = row;
        this.column = column;
    }

    public int getColor() {
        return color;
    }

    public boolean isTraversed() {
        return isTraversed;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void setTraversed(boolean traversed) {
        isTraversed = traversed;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
