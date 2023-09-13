import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Graph {
    public ArrayList<Vertex> vlist;
    public int graphWeight;
    int vertices;
    int counter;

    public Graph() {

        this.vlist = new ArrayList<>();
    }

    public void addVertex(String name) {
        Vertex V = new Vertex(name);
        this.vlist.add(V);

    }

    public Vertex getVertex(String name) {
        for(int i = 0; i < vlist.size(); i++)
        {
            if(vlist.get(i).name.equals(name))
            {
                return vlist.get(i);
            }

        }
        return null;
    }
    public void addEdge(String from, String to, int weight) {
        Vertex vFrom;
        Vertex vTo;

         vFrom = getVertex(from);
         vTo = getVertex(to);
         /*if(vFrom == null||vTo == null){
             return;
         }*/
        if(vFrom != null && vTo != null)
        {
            Edge eOne = new Edge(vFrom,vTo,weight);
            vFrom.adjlist.add(eOne);
            vTo.adjlist.add(eOne);
            if(!vFrom.equals(vTo))
            {
                Edge ex = new Edge(vTo, vFrom,weight);
                vFrom.adjlist.add(ex);
                vTo.adjlist.add(ex);
            }

        }
         /*Edge e = new Edge(vFrom,vTo,weight);

         vFrom.adjlist.add(e);
         vTo.adjlist.add(e);*/

         /*if(!vFrom.equals(vTo))
         {
             Edge ex = new Edge(vTo, vFrom,weight);
             vFrom.adjlist.add(ex);
             vTo.adjlist.add(ex);
         }*/
    }

    public Edge getEdge(String from, String to) {
        Vertex vFrom;
        Vertex vTo;

        vFrom = getVertex(from);
        vTo = getVertex(to);

        if(!getVertex(from).adjlist.isEmpty())
        {
            for(Edge e: vFrom.adjlist)
            {
                if(e.from.name.equals(from) && e.to.name.equals(to))
                {
                    return e;
                }
            }
        }
        return null;
    }

    public int MSTCost() {
        Graph lst = this;
        lst = lst.MST();

        if(lst == null)
        {
            return 0;
        }
        else{
            return lst.graphWeight;
        }

    }

    public Edge smallestEdge(ArrayList<Vertex> vlist)
    {
        Vertex v1 = new Vertex("code1");
        Edge small = new Edge(v1,v1,1000000);
        for(Vertex vet: vlist)
        {
            for(Edge e1: vet.adjlist)
            {
                if(e1.weight < small.weight && !vlist.contains(e1.to)){
                    small = e1;
                }
            }
        }
        return small;
    }

    public Graph MST() {
         Graph g = new Graph();
         if(vlist.size() > 0)
         {
             g.vlist.add(vlist.get(0));

         }
         else{
             return null;
         }

         Edge testEdge;
         while(g.vlist.size() < vlist.size())
         {
             testEdge = smallestEdge(g.vlist);
             g.vlist.add(testEdge.to);
             g.graphWeight += testEdge.weight;
         }
         return g;


    }

    public int SPCost(String from, String to) {
        return 0;
    }

    public Graph SP(String from, String to) {
        return null;
    }

    public String toString()
    {
        StringBuilder str = new StringBuilder(" ");
        for(Vertex v: vlist)
        {
            str.append(v.name).append(": ");

            for(Edge e: v.adjlist)
            {
                str.append(e);
            }
            str.append(" \n");
        }
        return str.toString();
    }
}
