import java.util.*;

public class MazeSolver
{
    public MazeSolver() {};

    public void solveMaze(Graph graph, char[][] grid) {
        List<Node> path = findShortestPath(graph, grid);
        if (path != null) {
            System.out.println("Path found:");
            for (Node node : path) {
                System.out.println("(" + node.getRow() + ", " + node.getCol() + ")");
            }
        } else {
            System.out.println("No path found.");
        }
    }

    public List<Node> findShortestPath(Graph graph, char[][] grid) {
        int startRow = -1, startCol = -1;
        int goalRow = -1, goalCol = -1;
        int rows = grid.length, cols = grid[0].length;

        // Find the starting point 'S' and the goal 'G'
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 'S') {
                    startRow = i;
                    startCol = j;
                } else if (grid[i][j] == 'G') {
                    goalRow = i;
                    goalCol = j;
                }
            }
        }

        // If starting or goal point is not found, return null
        if (startRow == -1 || startCol == -1 || goalRow == -1 || goalCol == -1) {
            return null;
        }

        Node startNode = graph.getNode(startRow, startCol);
        Node goalNode = graph.getNode(goalRow, goalCol);
        List<Node> path = new ArrayList<>();
        Set<Node> visited = new HashSet<>();

        // Perform DFS
        if (dfs(startNode, goalNode, visited, path)) {
            return path;
        } else {
            return null;
        }
    }

    private static boolean dfs(Node current, Node goal, Set<Node> visited, List<Node> path) {
        if (current == null) return false;
        if (current.equals(goal)) {
            path.add(current);
            return true;
        }

        visited.add(current);
        path.add(current);

        for (Node neighbor : current.getNeighbors()) {
            if (!visited.contains(neighbor)) {
                if (dfs(neighbor, goal, visited, path)) {
                    return true;
                }
            }
        }

        path.remove(path.size() - 1);
        return false;
    }

}
