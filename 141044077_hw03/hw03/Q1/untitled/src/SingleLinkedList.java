import java.util.IllegalFormatCodePointException;
import java.util.Iterator;

/**
 * SingleLinkedList class im.
 */

public class SingleLinkedList<E> {

    /**
     * Node-İnner class.
     */
    private class Node<E>{
        /**
         * Node data fields.
         */
        private E data;
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
         * Node Constructer.
         * @param dataItem
         * @param nodeRef
         */
        private Node(E dataItem, Node<E> nodeRef){

            data = dataItem;
            next = nodeRef;

        }

    }

    /*Mynewclass*/

    /**
     * Node
     */
    private Node<E> head = null;
    /**
     * Node size.
     */
    private int size=0;


    /**
     *  Verilen index e göre node döndürür.
     * @param index
     * @return
     */
    public Node<E> getNode(int index){
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
     * Aldigi datayı node olarak ekler.
     * @param item data.
     */
    public void add(E item){

        if(head==null){
            addFirst(item);
        }
        else
        {
            Node<E> node = head;
            while(node.next!=null)
            {
                node=node.next;
            }
            node.next = new Node<E>(item,null);
        }
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
     * Linked Listin toString() Methodu
     *
     */
    public String toString3(){
        String str=new String();

        Node<E> nodeRef = head;
        while(nodeRef!=null){
            str+=nodeRef.data;
            nodeRef=nodeRef.next;
        }

        return str.toString();
    }

    /*Q2---------------------Q2------------------Q2*/
    /**
     * reversToString() methodu verilen Node ların sırasını değiştirir.
     */
    public String reverseToString(){

        return rvr(head);

    }
    public String rvr(Node<E> node){

        if (node.next==null) {

            return (String) node.data+",";

        }

        return rvr(node.next)+node.data+",";

    }

}
