public class Main {
    public static void main(String[] args)
    {
        ReadingFromFile r = new ReadingFromFile();
        MazeSolver m = new MazeSolver();

        char[][]maze = r.readFileToCharArray("./testmaze.txt");

        Graph graph = createGraphFromGrid(maze);

       /* char[][] maze = {
                {'+','+','+','+','+','+','+','+','+','+','+','+','+','+','+','+','+','+','+','+','+','+'},
                {'+',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','+'},
                {'+','S',' ','+','+','+',' ',' ','+','+','+','+','+','+','+',' ','+','+','+','+','+','+'},
                {'+',' ',' ',' ','+','+','+',' ',' ','+','+',' ',' ',' ',' ',' ',' ','+','+','+','+','+'},
                {'+',' ',' ',' ',' ','+','+',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','+','+','+','+'},
                {'+','+','+','+',' ',' ','+',' ',' ',' ',' ','+',' ',' ',' ',' ',' ',' ',' ',' ','G','+'},
                {'+','+','+',' ',' ',' ',' ',' ',' ','+','+','+','+','+','+','+',' ',' ',' ','+','+','+'},
                {'+',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','+'},
                {'+','+','+','+','+','+','+','+','+','+','+','+','+','+','+','+','+','+','+','+','+','+'}
        };*/

        m.solveMaze(graph, maze);
    }

    private static Graph createGraphFromGrid(char[][] grid) {
        final int[] rowDirection = {-1, 1, 0, 0};   //Wert für jedes Feld drumherum
        final int[] colDirection = {0, 0, -1, 1};   //Wert für jedes Feld drumherum
        Graph graph = new Graph();
        int rows = grid.length;
        int cols = grid[0].length;

        // Add nodes for all walkable cells
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] != '+') {
                    graph.addNode(i, j);
                }
            }
        }

        // Add edges for all adjacent walkable cells
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] != '+') {
                    for (int k = 0; k < 4; k++) {
                        int newRow = i + rowDirection[k];
                        int newCol = j + colDirection[k];
                        if (isValid(grid, newRow, newCol)) {
                            graph.addEdge(i, j, newRow, newCol);
                        }
                    }
                }
            }
        }
        return graph;
    }

    private static boolean isValid(char[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;
        return row >= 0 && row < rows && col >= 0 && col < cols && grid[row][col] != '+';
    }
}