import java.util.ArrayList;
import java.util.HashMap;

public class Vertex {
    @Override
    public String toString() {
        return name;
    }

    public String name;
    public ArrayList<Edge> adjlist;


    public Vertex(String _name) {
        this.name = _name;
        this.adjlist = new ArrayList<Edge>();
    }

}