public class Edge {


    @Override
    public String toString() {
        return "Edge{" +
                "from=" + from +
                ", to=" + to +
                ", weight=" + weight +
                '}';
    }

    public Vertex from, to;
    public int weight;


    public Edge(Vertex _from, Vertex _to, int _weight) {
        this.from =  _from;
        this.to = _to;
        this.weight = _weight;
    }


}
