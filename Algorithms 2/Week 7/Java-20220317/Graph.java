import java.util.ArrayList;

public class Graph {
    public ArrayList<Vertex> vlist;
    int cnt;

    public Graph() {
        this.vlist = new ArrayList<Vertex>();
    }

    public void addVertex(String name) {
        Vertex ver = new Vertex(name);
        vlist.add(ver);
    }

    public Vertex getVertex(String name) {
        for (int i = 0; i < vlist.size(); i++)
        {
            if (vlist.get(i).name.equals(name))
            {
                return vlist.get(i);
            }
        }
	return null;
    }

    public void addEdge(String from, String to, int weight) {
        Vertex v1 = getVertex(from);
        Vertex v2 = getVertex(to);
        Edge ed = new Edge(v1,v2,weight);

        v1.adjlist.add(ed);

        if (!v1.name.equals(v2.name))
        {
            v2.adjlist.add(new Edge(v2,v1,weight));
        }
    }

    public Edge getEdge(String from, String to) {
        Vertex v1 = getVertex(from);
        Vertex v2 = getVertex(to);

        for (int i = 0; i < v1.adjlist.size(); i++)
        {
            if (v1.adjlist.get(i).from.name.equals(from) && v1.adjlist.get(i).to.name.equals(to))
            {
                return v1.adjlist.get(i);
            }
        }
	return null;
    }
    
    public int MSTCost() {
        MST();
        return cnt;
    }

    public Graph MST() {

//        // This should work in theory
//        // Attempt 1 --------------------
//        ArrayList<Vertex> graphList = new ArrayList<Vertex>();
//        int tempWeight;
//        int tempCount;
//        for (int i = 0; i < vlist.size(); i++)
//        {
//            //graphList.add(vlist.get(i));
//            Vertex tempVer = new Vertex((vlist.get(i).name));
//            graphList.add(tempVer);
//            tempWeight = -10000;
//            tempCount = -10000;
//            for (int j = 0; j < vlist.get(i).adjlist.size(); j++)  //vlist.get(i).adjlist.get(j)
//            {
//                if (vlist.get(i).adjlist.get(j).weight > tempWeight)
//                {
//                    tempWeight = vlist.get(i).adjlist.get(j).weight;
//                    tempCount = j;
//                }
//            }
//            // using this method doesn't quiet seem correct
//            addEdge(vlist.get(i).adjlist.get(tempCount).from.name,
//                    vlist.get(i).adjlist.get(tempCount).to.name,
//                    vlist.get(i).adjlist.get(tempCount).weight);
//        }

//        // Attempt 2 --------------
//        Graph g = new Graph();
//        int tempWeight;
//        int tempCount;
//        for (int i = 0; i < vlist.size(); i++)
//        {
//            g.addVertex(vlist.get(i).name); //I'm doing all this assuming it can differentiate the two vlists
//            tempWeight = 10000;
//            tempCount = 10000;
//            for (int j = 0; j < vlist.get(i).adjlist.size(); j++)
//            {
//                if (vlist.get(i).adjlist.get(j).weight < tempWeight)
//                {
//                    tempWeight = vlist.get(i).adjlist.get(j).weight;
//                    tempCount = j;
//                }
//            }
//            // using this method doesn't quiet seem correct
//            addEdge(vlist.get(i).adjlist.get(tempCount).from.name,
//                    vlist.get(i).adjlist.get(tempCount).to.name,
//                    vlist.get(i).adjlist.get(tempCount).weight);
//        }

//        // Attempt 3 ---------------
//        Graph g = new Graph();
//        int tempWeight;
//        int tempCount;
//        while (g.vlist.size() < vlist.size())
//        {
//            for (int i = 0; i < vlist.size(); i++)
//            {
//                g.addVertex(vlist.get(i).name); //I'm doing all this assuming it can differentiate the two vlists
//                tempWeight = 10000;
//                tempCount = 10000;
//                for (int j = 0; j < vlist.get(i).adjlist.size(); j++)
//                {
//                    if (vlist.get(i).adjlist.get(j).weight < tempWeight && !vlist.contains(vlist.get(i).adjlist.get(j).to))
//                    {
//                        tempWeight = vlist.get(i).adjlist.get(j).weight;
//                        tempCount = j;
//                    }
//                }
//            // using this method doesn't quiet seem correct
//                addEdge(vlist.get(i).adjlist.get(tempCount).from.name,
//                        vlist.get(i).adjlist.get(tempCount).to.name,
//                        vlist.get(i).adjlist.get(tempCount).weight);
//            }
//        }

        // Attempt 4 ------------------
        if (this.vlist.isEmpty()){
            return this;
        }
        Graph t = new Graph();
        cnt = 0; // change

        t.addVertex(vlist.get(0).name);
        ArrayList<Edge> L = new ArrayList<Edge>();
        getEdges(vlist.get(0), L); // It retrieves the edges for this node and sticks them in the array list
        while (vlist.size() > t.vlist.size()) {
            Edge minEdge = getMinE(L); // Gotten done
            Vertex v = minEdge.to;
            if (!containsV(v, t)){ // If the vertex v does not exist in our tree
                System.out.println(minEdge);
                cnt += minEdge.weight;
                t.addVertex(minEdge.to.name);
                t.addEdge(minEdge.from.name, minEdge.to.name, minEdge.weight);
                updateL(L, v, minEdge); // Adds new edges for the next vertex that was just added to the list
            }
            else {
                removeFromL(L, minEdge); //??
            }
        }
        System.out.println(t.vlist.toString());
        return t;
        //return g;
    }

    // Methods to make MST work
    public void getEdges(Vertex vert, ArrayList<Edge> list)
    {
        Vertex v1 = getVertex(vert.name);

        for (int i = 0; i < v1.adjlist.size(); i++)
        {
            for (int j = 0; j < vlist.size(); j++)
            {
                if (v1.adjlist.get(i).from.name.equals(vert.name) &&  // select a link that start at a node already in a tree
                        v1.adjlist.get(i).to.name.equals(vlist.get(j).name))   // and ends at a node in graph g
                {
                    list.add(v1.adjlist.get(i));
                }
            }
        }
    }

    public Edge getMinE (ArrayList<Edge> list) {
        int tempWeight = 10000;
        int tempCount = 10000;
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i).weight < tempWeight) {
                tempWeight = list.get(i).weight;
                tempCount = i;
            }
        }
        return list.get(tempCount);
    }

    public boolean containsV(Vertex vert, Graph graph)
    {
        for (int i = 0; i < graph.vlist.size(); i++)
        {
            if (graph.vlist.get(i).name.equals(vert.name))
            {
                return true;
            }
        }
        return false;
    }

    public void updateL(ArrayList<Edge> list, Vertex vert, Edge ed)
    {
//        for (int i = 0; i < vert.adjlist.size(); i++)
//        {
//            if (vert.adjlist.get(i).weight != ed.weight)
//            {
//                list.set(i, vert.adjlist.get(i));
//            }
//        }
        getEdges(vert, list);

        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i) == ed)
            {
                list.remove(i);
            }
        }
    }

    public void removeFromL (ArrayList<Edge> list, Edge ed)
    {
        int e = list.indexOf(ed);
        list.remove(e);
    }

    public int SPCost(String from, String to) {
	return 0;
    }

    public Graph SP(String from, String to) {
	return null;
    }

}
