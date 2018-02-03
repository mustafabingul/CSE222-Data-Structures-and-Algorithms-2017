import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;


public class main {

    public static void main(String args[]) throws FileNotFoundException {


        BinaryTree<String> BT = new BinaryTree<>();
        BinarySearchTree<Integer> BST = new BinarySearchTree<>();

        File file = new File("test.txt");
        try{
            Scanner ss = new Scanner(file);

            /*while(ss.hasNext()){
                Integer v = ss.nextInt();

                BST.add(v);

            }

            Iterator it = BST.iterator();
            while(it.hasNext()){
                System.out.println(it.next());
            }*/
            BT.readBinaryTree(ss);

        }
        catch(FileNotFoundException e){
            System.out.println("Not FILE");
        }


        Iterator itr = BT.iterator();

        while(itr.hasNext()){
            System.out.println(itr.next());
        }




    }
}
