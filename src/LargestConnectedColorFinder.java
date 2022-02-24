import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LargestConnectedColorFinder {
    private final int maxRow;
    private final int maxColumn;
    private final Node[][]grid;

    public LargestConnectedColorFinder(int maxRow, int maxColumn, Node[][] grid) {
        this.maxRow = maxRow;
        this.maxColumn = maxColumn;
        this.grid = grid;
    }

    public List<Node> find(){
        int index =0;
        Map<Integer,List<Node>> indexVsNodeList = new HashMap<>();
        for (int i = 0; i < maxColumn; i++) {
            for (int j = 0; j < maxRow; j++) {
                Node node = grid[i][j];
                List<Node> nodeList = new ArrayList<>();
                indexVsNodeList.put(index++, nodeList);
                node.setTraversed(true);
                nodeList.add(node);
                traverse(node, nodeList);
            }
        }

        int maxSize = 0;
        int maxSizeKey = 0;
        for (Map.Entry<Integer, List<Node>> integerListEntry : indexVsNodeList.entrySet()) {
            int temSize = integerListEntry.getValue().size();
            if(maxSize < temSize){
                maxSize = temSize;
                maxSizeKey = integerListEntry.getKey();
            }

        }
        return indexVsNodeList.get(maxSizeKey);
    }

    private void traverse( Node node, List<Node> nodeList ){
        //goUp
        if (isWithInGrid( node.getRow()-1, node.getColumn())) {
            Node wentUp = goUp(node);
            move(node, wentUp, nodeList);
        }

        //goDown
        if (isWithInGrid( node.getRow()+1, node.getColumn())) {
            Node wentDown = goDown(node);
            move(node, wentDown, nodeList);
        }

        //goRight
        if (isWithInGrid(node.getRow(), node.getColumn()+1)) {
            Node wentRight = goRight(node);
            move(node, wentRight, nodeList);
        }

        //goLeft
        if (isWithInGrid(node.getRow(), node.getColumn()-1)) {
            Node wentLeft = goLeft(node);
            move(node, wentLeft, nodeList);
        }
    }

    private void move(Node node, Node moved, List<Node> nodeList) {
        if (!moved.isTraversed() && moved.getColor() == node.getColor()) {
            moved.setTraversed(true);
            nodeList.add(moved);
            traverse(moved, nodeList);
        }
    }

    private boolean isWithInGrid(int row, int column){
        return maxRow > row && 0 <= row && maxColumn > column && 0 <= column;
    }

    private Node goUp(Node node){
        return grid[node.getRow()-1][node.getColumn()];
    }

    private Node goDown(Node node){
        return grid[node.getRow()+1][node.getColumn()];
    }

    private Node goRight(Node node){
        return grid[node.getRow()][node.getColumn()+1];
    }

    private Node goLeft(Node node){
        return grid[node.getRow()][node.getColumn()-1];
    }
}
