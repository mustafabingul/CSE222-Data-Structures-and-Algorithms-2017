import com.intellij.ide.a.k.E;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;

/**
 *  Kitaptan alınmış olan BinaryTree methodu.
 *  Gerekli olan method implmenet edilmiştir.
 * @param <E>
 */
public class BinaryTree<E> implements Iterable<E>, Serializable {

    /** Class to encapsulate a tree node. */
    protected static class Node < E >
            implements Serializable {
        // Data Fields
        /** The information stored in this node. */
        protected E data;

        /** Reference to the left child. */
        protected Node < E > left;

        /** Reference to the right child. */
        protected Node < E > right;

        // Constructors
        /** Construct a node with given data and no children.
         @param data The data to store in this node
         */
        public Node(E data) {
            this.data = data;
            left = null;
            right = null;
        }

        // Methods
        /** Return a string representation of the node.
         @return A string representation of the data fields
         */
        public String toString() {
            return data.toString();
        }
    }


    // Data Field
    /** The root of the binary tree */
    protected Node < E > root;

    public BinaryTree() {
        root = null;
    }

    protected BinaryTree(Node < E > root) {
        this.root = root;
    }

    /** Constructs a new binary tree with data in its root,leftTree
     as its left subtree and rightTree as its right subtree.
     */
    public BinaryTree(E data, BinaryTree < E > leftTree,
                      BinaryTree < E > rightTree) {
        root = new Node < E > (data);
        if (leftTree != null) {
            root.left = leftTree.root;
        }
        else {
            root.left = null;
        }
        if (rightTree != null) {
            root.right = rightTree.root;
        }
        else {
            root.right = null;
        }
    }

    /** Return the left subtree.
     @return The left subtree or null if either the root or
     the left subtree is null
     */
    public BinaryTree < E > getLeftSubtree() {
        if (root != null && root.left != null) {
            return new BinaryTree < E > (root.left);
        }
        else {
            return null;
        }
    }

    /** Return the right sub-tree
     @return the right sub-tree or
     null if either the root or the
     right subtree is null.
     */
    public BinaryTree<E> getRightSubtree() {
        if (root != null && root.right != null) {
            return new BinaryTree<E>(root.right);
        } else {
            return null;
        }
    }

    /**
     * Wrapper method binaryTree yi doldurmak için.
     * @param scanner
     * @return
     */
    private BinaryTree<String> readPrivate(Scanner scanner){

        if(!scanner.hasNext()){
            return null;
        }

        String d = scanner.next();

        if(d.equals("null")){
            return null;
        }
        else{

            BinaryTree<String> leftTree = readPrivate(scanner);

            BinaryTree<String> rightTree = readPrivate(scanner);
            return new BinaryTree<String>(d,leftTree,rightTree);
        }
    }

    /**
     * BinaryTree yi doldurmak için yazılan method.
     * @param scan
     * @return
     */
    public BinaryTree<String> readBinaryTree(Scanner scan){
        BinaryTree<String> tree= readPrivate(scan);
        root = (Node<E>) tree.root;
        return tree;
    }

    /**
     * Iterator methodu return eden method.
     * @return
     */
    @Override
    public Iterator<E> iterator() {
        return new preOrderIterator();
    }

    /**
     * Inner class for preOrderIterator iterator methodu.
     */
    private class preOrderIterator implements Iterator<E>{

        private final Stack<Node<E>> stack;

        private preOrderIterator(){
            stack=new Stack<Node<E>>();
            stack.add(root);
        }

        /**
         * Iteartor un sonraki elemanının olup olmadıüğını kontrol eder.
         * @return
         */
        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /**
         * Iteartor un sonraki elemannını return eder.
         * @return
         */
        @Override
        public E next() {
            if(!hasNext())throw new NoSuchElementException("Not NODE");

            final Node<E> node = stack.pop();

            if(node.right!=null){
                stack.push(node.right);}
            if(node.left !=null){
                stack.push(node.left);}
            return node.data;
        }
    }
}
