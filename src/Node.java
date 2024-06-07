import java.util.ArrayList;
import java.util.List;

public class Node
{
    private int _row;
    private int _col;
    List<Node> _neighbors;

    public Node(int row, int col)
    {
        _row = row;
        _col = col;
        _neighbors = new ArrayList<Node>();
    }

    public int getRow()
    {
        return _row;
    }

    public int getCol()
    {
        return _col;
    }

    public List<Node> getNeighbors()
    {
        return _neighbors;
    }
}
