import java.util.HashMap;
import java.util.Map;

public class Graph
{
    Map<String, Node> _nodes;

    public Graph()
    {
        _nodes = new HashMap<String, Node>();
    }

    Node getNode(int row, int col) {
        return _nodes.get(row + "," + col);
    }

    void addNode(int row, int col) {
        _nodes.put(row + "," + col, new Node(row, col));
    }

    void addEdge(int row1, int col1, int row2, int col2) {
        Node node1 = getNode(row1, col1);
        Node node2 = getNode(row2, col2);
        if (node1 != null && node2 != null) {
            node1.getNeighbors().add(node2);
            node2.getNeighbors().add(node1);
        }
    }
}
