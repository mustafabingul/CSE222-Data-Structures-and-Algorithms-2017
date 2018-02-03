import java.util.*;


public class FamilyTree extends BinaryTree<String> implements Iterable<Object> {

    public FamilyTree(String data){
        root = (Node) new Node<String>(data);
    }
    public String add(String name,String parentName,String nickname){
        try {
            Node newroot = root;
            Node parent;
            String relation = relationSelect(0,nickname);
            if(relation.equals("true")){
                if(relationSelect(1,nickname).toString().equals(name)){
                    parent = findFunc(newroot,parentName);
                    Node node = new Node(name);
                    addLeft(parent,node);
                }else{
                    parent = findSelf(newroot,name,parentName,relationSelect(1,nickname));
                    if(parent == null){
                        return null;
                    }
                    Node node = new Node(name);
                    addRight(parent,node);
                }
            }else if(relation.equals("false")){
                parent = IBNfind(newroot,name,parentName,relationSelect(1,nickname));
                if(parent == null){
                    return null;
                }
                Node node = new Node(name);
                if(parent.left == null)
                    addLeft(parent,node);
                else
                    addRight(parent.left,node);
            }
            return null;
        }catch (Exception e){
            throw new NullPointerException();
        }
    }

    //**********************************************************************************
    /**
     * yer bulma işlemi.
     * @param tnode
     * @param ttarget
     * @return
     */
    private Node searchLocation(Node tnode, String ttarget){
        if(tnode == null){
            return null;
        }
        if(tnode.data.toString().equals(ttarget.toString())){
            return tnode;
        }else {
            return searchLocation(tnode.right,ttarget);
        }
    }

    /**
     * root u ve aranıcak olan ismi arayan find funci.
     * @param lroot
     * @param serched
     * @return
     */
    private Node findFunc(Node lroot, String serched) {
        if (lroot == null) {
            return null;
        }
        if( serched.toString().equals(lroot.toString())){
            return lroot;
        }
        Node temp = findFunc(lroot.left,serched);
        if(temp != null)
            return temp;
        temp = findFunc(lroot.right,serched);
        if(temp != null)
            return temp;
        return null;
    }

    /**
     * IBN-** bulma islemi.
     * @param Iroot
     * @param Iname
     * @param IparentName
     * @param nickname
     * @return
     */
    private Node IBNfind(Node Iroot, String Iname, String IparentName, String nickname){
        if(Iroot == null) {
            return null;
        }
        Node parent = findFunc(Iroot,nickname);
        Node node = searchLocation(parent.left,IparentName);
        if(node == null){
            Node t = findSelf(parent.left, Iname,IparentName,nickname);
            if(t != null) {
                return t;
            }
            t = findSelf(parent.right, Iname,IparentName,nickname);
            if(t != null){
                return t;
            }
        }else{
            return node;
        }
        return null;
    }

    /**
     * verilen root name ve paretn name ve nickname ili arama işlemi.
     * @param troot
     * @param tname
     * @param tparentName
     * @param nickname
     * @return
     */
    private Node findSelf(Node troot, String tname, String tparentName, String nickname){
        if(troot == null)
            return null;
        Node parent = findFunc(troot,tparentName);
        Node node = searchLocation(parent.left,nickname);
        if(node == null){
            Node t = findSelf(parent.left, tname,tparentName,nickname);
            if(t != null) {
                return t;
            }
            t = findSelf(parent.right, tname,tparentName,nickname);
            if(t != null)
                return t;
        }else{
            return node;
        }
        return null;
    }


    /**
     * sag tarafa ekleme kardeş ekleme işin yapar.
     * @param rroot
     * @param rnode
     * @return
     */
    private String addRight(Node rroot, Node rnode){
        if(rroot.right == null) {

            rroot.right = rnode;
            return (String) rnode.data;
        }else {
            return addRight(rroot.right,rnode);
        }
    }

    /**
     * sol tarafa ekleme yani cocuk ekeleme işini yapar.
     * @param lroot
     * @param lnode
     * @return
     */
    private String addLeft(Node lroot, Node lnode){
        if(lroot.left == null) {
            lroot.left = lnode;
            return (String) lnode.data;
        }else if(lroot.left != null){
            return addLeft(lroot.left,lnode);
        }
        return null;
    }

    /**
     * ilişki seçer.
     * @param ind
     * @param str
     * @return
     */
    private String relationSelect(int ind,String str){
        String[] str1;
        String com="-";
        str1 = str.split(com);
        if(ind == 0){
            if(str1[0].toString().equals("ebu"))
                return "true";
            return "false";
        }else{
            return str1[1];
        }
    }

    /**
     * Iterator methodu.
     * @return
     */
    @Override
    public Iterator<Object> iterator() {
        return new IteratorFamily(root);
    }
    private class IteratorFamily implements Iterator{
        Node rIter;
        Stack<Node<String>> stack = new Stack<Node<String>>();
        public IteratorFamily(Node nroot){
            rIter = nroot;
            if(stack.isEmpty()){
                stack.push(rIter);
            }
        }
        @Override
        public String next() {
            Node node = stack.pop();
            if(node.right != null) {
                stack.push(node.right);
            }
            if(node.left != null) {
                stack.push(node.left);
            }
            if(stack.isEmpty()) {
                rIter = null;
            }
            return (String) node.data;
        }
        @Override
        public boolean hasNext() {
            return rIter != null;
        }
    }

    public Iterator<Object> iterator2() {
        return new leverOrderIterator();
    }
    private class leverOrderIterator implements Iterator{

        /**
         *  Nodeların tutulduğu yer.
         */
        private final Queue<Node<String>> quu;

        /**
         * Constructer.
         */
        private leverOrderIterator(){
            quu=new LinkedList<>();
            quu.add(root);
        }

        /**
         * Queue nun sonuna gelip gelmediğini kontrol eder.
         * @return
         */
        @Override
        public boolean hasNext() {
            return !quu.isEmpty();
        }

        /**
         * SearchTree üzerinde sonaraki elemanı return eder.
         * @return
         */
        @Override
        public String next() {
            if(!hasNext())throw new NoSuchElementException("Not NODE");

            final Node<String> node = quu.poll();

            if(node.left!=null){quu.add(node.left);}
            if(node.right!=null){quu.add(node.right);}

            return node.data;
        }
    }
}
