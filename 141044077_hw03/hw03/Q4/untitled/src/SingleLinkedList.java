import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.Iterator;

/**
 * SingleLinkedList for reuses deleted nodes.
 * @param <E>
 */
public class SingleLinkedList<E> {
    /**
     * İnner Class.
     * @param <E>
     */
    /*İnner class.*/
    private class Node<E>{
        /**
         * Node datafield.
         */
        private E data;
        /**
         * Node nextreferans.
         */
        private Node<E> next;

        /**
         * Node Constructer.
         * @param dataItem
         */
        private Node(E dataItem){
            data = dataItem;
            next = null;
        }

        /**
         * Node constructer.
         * @param dataItem
         * @param nodeRef
         */
        private Node(E dataItem, Node<E> nodeRef){
            data = dataItem;
            next = nodeRef;
        }
    }

    /**
     * Node.
     */
    private Node<E> head = null;
    /**
     * Node size.
     */
    private int size;

    ArrayList<Node<E>> array = new ArrayList<Node<E>>();

    /**
     * Silinenler arasında olup olmadığına bakar.
     * @param item
     * @return
     */
    public boolean find(E item){
        for (int i=0; i<array.size();++i)
        {
            if(item.toString().equals(array.get(i).data.toString())){

                return true;
            }
        }
        return false;
    }

    /**
     * Verilen E itemine göre index i dündürür.
     * @param item
     * @return
     */
    public int finIndex(E item){
        for (int i=0; i<array.size();++i)
        {
            if((array.get(i).data.toString().equals(item.toString()))){

                return i;
            }
        }
        return -1;
    }

    /**
     * Verilen item i ekler.
     * @param item
     */
    public void add(E item){

        if(find(item)){
            Node<E> n = head;
            while(n.next!=null){
                n=n.next;
            }
            n.next=new Node<E>(item,null);
            size++;
            array.remove(finIndex(item));
        }
        else {
            if (head == null) {
                addFirst(item);
            } else {
                Node<E> node = head;
                while (node.next != null) {
                    node = node.next;
                }
                node.next = new Node<E>(item, null);
            }
            size++;
        }
    }

    /**
     * Verilen indexi siler.
     * @param index
     */
    public void delete(int index){
        if(index<0 || index >= size){
            return ;
        }
        Node<E> p=getNode(index-1);
        Node<E> s=getNode(index+1);
        Node<E> n=getNode(index);
        array.add(n);
        p.next=s;
        if(index == 0)
            head = head.next;
        size--;
    }

    /**
     * Silinen node ları gösterir.
     */
    public void deletedToString(){
        for(int i=0; i<array.size();++i){
            System.out.print(array.get(i).data+" ");
        }
        System.out.println("");
    }
    /**
     *  Verilen index e göre node döndürür.
     * @param index
     * @return
     */
    private Node<E> getNode(int index){

        if(index>size()){
            throw new IllegalArgumentException("İndex is high from size");
        }
        Node<E> current = head;
        for(int i=0;i<index;++i){
            current=current.next;
        }

        return current;
    }
    /**
     * ilk node a ekler.
     * * @param item
     */
    public void addFirst(E item){
        head = new Node<E>(item,head);
        size++;
    }
    /**
     * Verilen herhangi bir node dan sonra data yi ekler.
     * @param node
     * @param item
     */
    public void addAfter(Node<E> node,E item){
        node.next=new Node<E>(item,node.next);
        size++;
    }

    /**
     * Node sayısınıreturn eder.
     * @return
     */
    public int size(){
        return size;
    }
    /**
     * Verilen index teki node un datasını alır.
     * @param index node index i.
     * @return node data sı.
     */
    public E get(int index){

        if(index<0||index>=size){
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNode(index);
        return node.data;
    }

    /**
     * Single Linked List in iterator().
     * Referans : http://codereview.stackexchange.com/questions/66938/self-made-linked-list-iterator
     */
    public Iterator<E> iterator() {

        return new Iterator<E>() {

            private Node<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E result = null;
                if (current != null) {
                    result = current.data;
                    current = current.next;
                }
                return result;
            }
        };
    }

    /**
     * SingleLinkedList toString() Methodu.
     * @return
     */
    public String toString(){
        String str=new String();

        Node<E> nodeRef = head;
        while(nodeRef!=null){
            str+=nodeRef.data+" ";
            nodeRef=nodeRef.next;
        }
        return str.toString();
    }
}