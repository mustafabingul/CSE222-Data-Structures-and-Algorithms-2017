import java.util.EmptyStackException;

/**
 * Node inner class olarak implement edilmiş olran stack yapısı.
 * @param <E>
 */
public class StackC<E> implements StackInterface<E> {

    /**
     * İnner Node classı.
     * @param <E>
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
     * Get methodu.
     * @param index
     * @return Node return eder.
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
     * Stack in push methodu.
     * Stack e eleman ekler.
     * @param obj
     * @return
     */
    @Override
    public E push(E obj) {
        if(size==0){
            head=new Node<E>(obj);
        }else {
            Node<E> node = head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node<E>(obj, null);
        }
        size++;
        return obj;
    }

    /**
     * Stack in pop methodu.
     * Stack yapısının sonundan eleman siler.
     * @return
     */
    @Override
    public E pop() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        E tdata;
        if(size==1){
            tdata=head.data;
            head=null;
        }else {
            Node<E> t;
            t = getNode(size -1);
            tdata = t.next.data;
            t.next = null;
        }
        size--;
        return tdata;
    }

    /**
     * Stack in size methodu.
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Stack in isEmpty Methodu.
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size()==0;
    }

    /**
     * get Methodu.
     * Node dan index e göre data return eder.
     * @param index
     * @return data.
     */
    public E get(int index){
        Node<E> node=head;
        for (int i=0; i<index; ++i){
            node=node.next;
        }
        return node.data;
    }

    /**
     * Stack in toString methodu.
     * Veriyi string olarak return eder.
     * @return
     */
    public String toString(){
        String str=new String();
        int i=0;
        Node<E> nodeRef = head;
        while(nodeRef!=null){
            str+=nodeRef.data;
            if(i<size()-1){
                str+=",";
            }
            ++i;
            nodeRef=nodeRef.next;
        }
        return str.toString();
    }
}
