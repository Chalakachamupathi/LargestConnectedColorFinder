import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Process {


        public static Node[][] createGame(int row, int column, int colourSize){
            Node [][] out = new Node[column][row];
            for (int i = 0; i < column; i++) {
                for (int i1 = 0; i1 < row; i1++) {
                    out[i][i1] = new Node(ThreadLocalRandom.current().nextInt(1, colourSize + 1),
                                        false,
                                        i,
                                        i1);
                }
            }
            return out;
        }

    public static void main(String[] args) {
            int row =8;
            int column =8;
            int colorSize =3;
            Node [][] grid = createGame(row, column, colorSize );
            LargestConnectedColorFinder largestConnectedColorFinder = new LargestConnectedColorFinder( row,
                                                                                                    column,
                                                                                                    grid);
            printGrid(grid, column, row);
            List<Node> nodeList = largestConnectedColorFinder.find();
            markResultListInTheGrid(grid, nodeList);
            System.out.println("\n");
            printGrid(grid, column, row);

    }

    private static void markResultListInTheGrid(Node[][] grid, List<Node> nodeList) {
        for (Node node : nodeList) {
            grid[node.getRow()][node.getColumn()].setColor(-1);
        }
    }


    private static void printGrid(Node [] [] grid, int maxColumn, int maxRow) {
        for (int i = 0; i < maxColumn; i++) {
            for (int j = 0; j < maxRow; j++) {
                System.out.printf( "%6s",grid[i][j].getColor() + " |");
            }
            System.out.println();
        }
    }

}
