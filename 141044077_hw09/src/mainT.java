import java.io.*;
import java.util.Scanner;

/**
 * Created by mustafa on 19.05.2017.
 */
public class mainT {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new FileReader("test1.txt"));
        Scanner scann = new Scanner(bf);
        //ListGraph objL = (ListGraph) AbstractGraphExtended.createGraph(scann,false,"List");
        MatrixGraph objM = (MatrixGraph) AbstractGraphExtended.createGraph(scann,false,"Matrix");
        //System.out.println("Eklenen EDGE NUMBER: "+objM.addRandomEdgesToGraph(6));
        objM.getConnectedComponentUndirectedGraph();
        objM.writeGraphToFile("RExample.txt");



        /*int[] ar = new int[objM.getNumV()];
        ar=objM.breadthFirstSearch(0);
        for(int i=0; i<ar.length; ++i){
            System.out.println(i+"  > "+ar[i]);
        }*/
    }
}
