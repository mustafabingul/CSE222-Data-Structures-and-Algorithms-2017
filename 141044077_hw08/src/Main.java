/**
 * Created by mustafa on 10.05.2017.
 */
public class Main {
    public static void main(String[] args){


        AVLTree<Integer> avele = new AVLTree<Integer>();
        AVLTree<String> avele2 = new AVLTree<String>();

        avele.add(1);
        avele.add(2);
        avele.add(3);
        avele.add(4);
        avele.add(5);
        avele.add(6);
        //System.out.println(avele.toString());

        avele.delete(5);
        avele.delete(6);

        System.out.println(avele.toString());
        System.out.println();

        avele2.add("Nush");
        avele2.add("ile");
        avele2.add("uslanmayani");
        avele2.add("etmeli");
        avele2.add("tekdir");
        avele2.add("tekdir");
        avele2.add("ile");
        avele2.add("uslanmayanin");
        avele2.add("hakki");
        avele2.add("kotektir");

        System.out.println(avele2.toString());
        System.out.println();

        avele2.add("edille");
        avele2.add("dakik");
        avele2.add("ferc");

        System.out.println(avele2.toString());
        System.out.println();

        avele2.delete("Nush");
        avele2.delete("ile");
        avele2.delete("uslanmayani");

        System.out.println(avele2.toString());
        System.out.println();


    }
}
