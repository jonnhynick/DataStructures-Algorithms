import java.util.LinkedList;
/*
*Graphs can be represented in either adjacency lists
* or adjacency matrices.
* In this example we will use adjacency lists which take less space than a matrix.
* */
public class Graph {
    private int vertices;
    private LinkedList<Integer> adjacencyList[];

    public Graph(int vertices){
        this.vertices = vertices;

        adjacencyList = new LinkedList[vertices];
        //Initialize all LinkedLists inside the array.
        for(int i = 0; i < vertices; i++){
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination){
        //check if either source or destination is an invalid vertex
        if(source > vertices - 1 || destination > vertices -1)
            return;
        else{
            //add from source to destination
            adjacencyList[source].add(destination);

            //if graph is undirected then add from destination to source.
            adjacencyList[destination].add(source);
        }
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        for(int i =0; i < vertices; i++){
            str.append("Vertex " + i + ": ");
            for(Integer val : adjacencyList[i]){
                str.append(val + " ");
            }
            str.append("\n");
        }

        return str.toString();
    }
}
