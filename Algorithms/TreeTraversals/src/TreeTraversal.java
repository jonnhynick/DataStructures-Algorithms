import java.util.Iterator;
import java.util.LinkedList;

public class TreeTraversal {

    public void breadthFirstSearch(Graph graph, int value) {
        boolean visited[] = new boolean[graph.getVerticeSize()];

        for(int i = 0; i < graph.getVerticeSize(); i++)
            visited[i] = false;

        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[value]=true;
        queue.add(value);

        while (queue.size() != 0)
        {
            // Dequeue a vertex from queue and print it
            value = queue.poll();
            System.out.print(value+ " ");

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = graph.getAdj()[value].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    //start is where the traversal starts.
    public void depthFirstSearch(Graph graph, int start){

        boolean visited[] = new boolean[graph.getVerticeSize()];

        DFSUtil(visited, start, graph);
    }

    private void DFSUtil(boolean visited[], int start, Graph graph){
        visited[start] = true;
        System.out.print(start + " ");

        Iterator<Integer> i = graph.getAdj()[start].listIterator();
        while(i.hasNext()){
            int num = i.next();
            if(!visited[num])
                DFSUtil(visited, num, graph);
        }
    }

    //Graph represented as an adjacency list.
    public class Graph {
        private int V;   // No. of vertices
        private LinkedList<Integer> adj[]; //Adjacency Lists

        // Constructor
        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i)
                adj[i] = new LinkedList();
        }

        // Function to add an edge into the graph
        void addEdge(int source, int destination) {
            //if undirected then you also need to add from the destination -> source as well.
            //in this case it is a directed graph. 
            adj[source].add(destination);

        }

        public int getVerticeSize() { return this.V; }

        public LinkedList<Integer>[] getAdj(){return adj;}
    }
}
