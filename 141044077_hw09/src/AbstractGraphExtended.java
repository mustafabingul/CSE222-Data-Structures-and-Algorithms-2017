import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by mustafa on 17.05.2017.
 */
public abstract class AbstractGraphExtended extends AbstractGraph {

    /**
     * Construct a graph with the specified number of vertices
     * and the directed flag. If the directed flag is true,
     * this is a directed graph.
     *
     * @param numV     The number of vertices
     * @param directed The directed flag
     */
    public AbstractGraphExtended(int numV, boolean directed) {
        super(numV, directed);
    }

    /**
     * Verilen edgeLimiti arasında bir random sayı alır ve o kadar edge ekler graph objesine.
     * @param edgeLimit
     * @return
     */
    public int addRandomEdgesToGraph (int edgeLimit){
        HashSet<Edge> newEdges = new HashSet<>();
        if(edgeLimit<=getNumV()) {

            Random rand = new Random();
            int source, dest;
            int edgeNumber = rand.nextInt(edgeLimit);

            for (int i = 0; i < edgeNumber; ++i) {
                source = rand.nextInt(edgeLimit);
                dest = rand.nextInt(edgeLimit);
                if(!this.isEdge(source,dest)){
                    newEdges.add(new Edge(source, dest));
                    //System.out.println(source+" "+dest);
                }
            }

            Iterator itr = newEdges.iterator();
            while (itr.hasNext()) {
                insert((Edge) itr.next());
                //System.out.print(newEdges.size());
            }
        }
        return newEdges.size();
    }

    /** Perform a breadth-first search of a graph.
     post: The array parent will contain the predecessor
     of each vertex in the breadth-first
     search tree.
     @param start The start vertex
     @return The array of parents
     */
    public int [] breadthFirstSearch (int start){

        Queue < Integer > theQueue = new LinkedList < Integer > ();
        // Declare array parent and initialize its elements to 1.
        int[] parent = new int[getNumV()];
        for (int i = 0; i < getNumV(); i++) {
            parent[i] = -1;
        }
        // Declare array identified and
        // initialize its elements to false.
        boolean[] identified = new boolean[getNumV()];
    /* Mark the start vertex as identified and insert it
       into the queue */
        identified[start] = true;
        theQueue.offer(start);
    /* While the queue is not empty */
        while (!theQueue.isEmpty()) {
      /* Take a vertex, current, out of the queue.
       (Begin visiting current). */
            int current = theQueue.remove();
      /* Examine each vertex, neighbor, adjacent to current. */
            Iterator < Edge > itr = edgeIterator(current);
            while (itr.hasNext()) {
                Edge edge = itr.next();
                int neighbor = edge.getDest();
                // If neighbor has not been identified
                if (!identified[neighbor]) {
                    // Mark it identified.
                    identified[neighbor] = true;
                    // Place it into the queue.
                    theQueue.offer(neighbor);
          /* Insert the edge (current, neighbor)
             into the tree. */
                    parent[neighbor] = current;
                }
            }
            // Finished visiting current.
        }
        return parent;
    }


    /**
     * Obje üzerindeki edge leri dosyaya yazar.
     * @param fileName
     * @throws IOException
     */

    public void writeGraphToFile (String fileName) throws IOException {
        HashSet<Edge> theSeet = new HashSet<>();

        Boolean[] visitArr = new Boolean[getNumV()];
        int V=0;
        FileWriter fw = new FileWriter(new File(fileName));
        StringBuilder sb = new StringBuilder();
        MatrixGraph[] MGraph = null;
        ListGraph[] LGraph = null;
        for(int i=0; i<getNumV(); ++i){
            visitArr[i]=true;
        }
        for(int i=0; i<getNumV(); ++i){
            if(visitArr[i]==true){
                theSeet = (HashSet<Edge>) helperConnected(i,visitArr);
                V++;
            }
        }
        int c=0;
        if(this instanceof MatrixGraph){
            MGraph = new MatrixGraph[V];
            sb.append(getNumV());
            sb.append('\n');
            for(int i=0; i<getNumV(); ++i){
                if(visitArr[i]){
                    Iterator itr2 = theSeet.iterator();
                    theSeet= (HashSet<Edge>) helperConnected(i,visitArr);
                    MGraph[c] = new MatrixGraph(getNumV(),isDirected());
                    Iterator itr = theSeet.iterator();
                    while(itr.hasNext()){
                        MGraph[c].insert((Edge) itr.next());
                        /*Edge tt = (Edge) itr.next();
                        System.out.println(tt.getSource()+" " +tt.getDest());*/
                    }
                    while(itr2.hasNext()){
                        Edge write = (Edge) itr2.next();
                        sb.append(write.getSource()+" "+write.getDest());
                        sb.append('\n');
                    }
                    //System.out.println("***********");
                    c++;
                }
            }

        }
        else {
            LGraph = new ListGraph[V];
            sb.append(getNumV());
            sb.append('\n');
            for(int i=0; i<getNumV(); ++i){
                if(visitArr[i]){
                    Iterator itr2 = theSeet.iterator();
                    theSeet= (HashSet<Edge>) helperConnected(i,visitArr);
                    LGraph[c] = new ListGraph(getNumV(),isDirected());
                    Iterator itr = theSeet.iterator();
                    while(itr.hasNext()){
                        LGraph[c].insert((Edge) itr.next());
                        /*Edge tt = (Edge) itr.next();
                        System.out.println(tt.getSource()+" " +tt.getDest());*/
                    }
                    while(itr2.hasNext()){
                        Edge write = (Edge) itr2.next();
                        sb.append(write.getSource()+" "+write.getDest());
                        sb.append('\n');
                    }
                    //System.out.println("**********");
                    c++;
                }
            }


        }
        fw.write(sb.toString());
        fw.close();

    }
    /**
     * Verilen vertexe bağlı vertexleri gezen helper function.
     * @param start
     * @param visited
     * @return
     */
    private Set helperConnected (int start, Boolean[] visited){

        Queue < Integer > theQueue = new LinkedList < Integer > ();
        HashSet<Edge> theSet = new HashSet<>();

        int[] parent = new int[getNumV()];
        for (int i = 0; i < getNumV(); i++) {
            parent[i] = -1;
        }

        boolean[] identified = new boolean[getNumV()];

        identified[start] = true;
        theQueue.offer(start);

        while (!theQueue.isEmpty()) {
            int current = theQueue.remove();
            Iterator < Edge > itr = edgeIterator(current);
            while (itr.hasNext()) {
                Edge edge = itr.next();
                Edge tmp = new Edge(edge.getDest(),edge.getSource());
                if(!theSet.contains(tmp)){
                    theSet.add(edge);
                }
                int neighbor = edge.getDest();

                if (!identified[neighbor]) {
                    visited[neighbor]=false;
                    identified[neighbor] = true;
                    theQueue.offer(neighbor);
                    parent[neighbor] = current;
                }
            }
        }
        return theSet;
    }

    /**
     * Obje üzerinde ki connected olmayan graphları döndürür.
     * @return
     */
    public Graph [] getConnectedComponentUndirectedGraph (){
        HashSet<Edge> theSeet = new HashSet<>();
        Boolean[] visitArr = new Boolean[getNumV()];
        int V=0;
        MatrixGraph[] MGraph = null;
        ListGraph[] LGraph = null;
        for(int i=0; i<getNumV(); ++i){
            visitArr[i]=true;
        }
        for(int i=0; i<getNumV(); ++i){
            if(visitArr[i]==true){
                theSeet = (HashSet<Edge>) helperConnected(i,visitArr);
                V++;
            }
        }
        int c=0;
        if(this instanceof MatrixGraph){
            MGraph = new MatrixGraph[V];
            for(int i=0; i<getNumV(); ++i){
                if(visitArr[i]){
                    theSeet= (HashSet<Edge>) helperConnected(i,visitArr);
                    MGraph[c] = new MatrixGraph(getNumV(),isDirected());
                    Iterator itr = theSeet.iterator();
                    while(itr.hasNext()){
                        MGraph[c].insert((Edge) itr.next());
                        /*Edge tt = (Edge) itr.next();
                        System.out.println(tt.getSource()+" " +tt.getDest());*/
                    }
                    //System.out.println("***********");
                    c++;
                }
            }

        }
        else {
            LGraph = new ListGraph[V];
            for(int i=0; i<getNumV(); ++i){
                if(visitArr[i]){
                    theSeet= (HashSet<Edge>) helperConnected(i,visitArr);
                    LGraph[c] = new ListGraph(getNumV(),isDirected());
                    Iterator itr = theSeet.iterator();
                    while(itr.hasNext()){
                        LGraph[c].insert((Edge) itr.next());
                        /*Edge tt = (Edge) itr.next();
                        System.out.println(tt.getSource()+" " +tt.getDest());*/
                    }
                    //System.out.println("**********");
                    c++;
                }
            }

        }

        if(this instanceof MatrixGraph){
            return MGraph;
        }
        else{
            return LGraph;
        }

    }


}
