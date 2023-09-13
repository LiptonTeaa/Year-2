import java.util.ArrayList;

public class Vertex {
    public String name;
    public ArrayList<Edge> adjlist;

    public Vertex(String _name) {
        this.name = _name;
        adjlist = new ArrayList<Edge>();
    }
}

