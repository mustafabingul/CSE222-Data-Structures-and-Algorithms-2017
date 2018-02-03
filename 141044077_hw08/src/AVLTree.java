/**
 * Mustafa Bingül 10.05.2017
 * AVLTree class.
 */

public class AVLTree < E
    extends Comparable < E >>
    extends BinarySearchTreeWithRotate < E > {

  // Data Fields
    private boolean increase;

  // Data Fields
  private boolean decrease;

  /**
   * Inner class. for Node.
   * @param <E>
   */
  private static class AVLNode < E > extends Node < E > {

    // Data Fields
    public static final int LEFT_HEAVY = -1;
    public static final int BALANCED = 0;
    public static final int RIGHT_HEAVY = 1;
    private int balance;

    /**
     * Constructer.
     * @param item
     */
    public AVLNode(E item) {
      super(item);
      balance = BALANCED;
    }

    /**
     * toString() methodu.
     * @return
     */
    public String toString() {
      return balance + ": " + super.toString();
    }
  }

  /**
   * add merhodu item ekler aynı varsa eklemez.
   * @param item The object being inserted
   * @return
   */
  public boolean add(E item) {
    increase = false;
    root = add( (AVLNode < E > ) root, item);
    return addReturn;
  }

  /**
   * Node return eden add methodu wrapper helper method.
   * @param localRoot
   * @param item
   * @return
   */
  private AVLNode < E > add(AVLNode < E > localRoot, E item) {
    if (localRoot == null) {
      addReturn = true;
      increase = true;
      return new AVLNode < E > (item);
    }
    if (item.compareTo(localRoot.data) == 0) {
      increase = false;
      addReturn = false;
      return localRoot;
    }

    else if (item.compareTo(localRoot.data) < 0) {
      localRoot.left = add( (AVLNode < E > ) localRoot.left, item);

      if (increase) {
        decrementBalance(localRoot);
        if (localRoot.balance < AVLNode.LEFT_HEAVY) {
          increase = false;
          return rebalanceLeft(localRoot);
        }
      }
      return localRoot;
    }
    else {
      localRoot.right = add( (AVLNode < E > ) localRoot.right, item);
      if (increase) {
        incrementBalance(localRoot);
        if (localRoot.balance > AVLNode.RIGHT_HEAVY) {
          return rebalanceRight(localRoot);
        }
        else {
          return localRoot;
        }
      }
      else {
        return localRoot;
      }
    }

  }
  /**
   * Node un yerleşeceği yeni yeri bulur.
   */
  private AVLNode < E > findReplacementNode(AVLNode < E > node) {
    if (node.left == null) {
      decrease = true;
      return (AVLNode < E > ) node.right;
    }
    else if (node.right == null) {
      decrease = true;
      return (AVLNode < E > ) node.left;
    }
    else {
      if (node.left.right == null) {
        node.data = node.left.data;
        node.left = node.left.left;
        incrementBalance(node);
        return node;
      }
      else {
        node.data = findLargestChild( (AVLNode < E > ) node.left);
        if ( ( (AVLNode < E > ) node.left).balance < AVLNode.LEFT_HEAVY) {
          node.left = rebalanceLeft( (AVLNode < E > ) node.left);
        }
        if (decrease) {
          incrementBalance(node);
        }
        return node;
      }
    }
  }

  /**
   * En büyükcocuuu bulur.
   * @param parent
   * @return
   */
  private E findLargestChild(AVLNode < E > parent) {
    if (parent.right.right == null) {
      E returnValue = parent.right.data;
      parent.right = parent.right.left;
      decrementBalance(parent);
      return returnValue;
    }
    else {
      E returnValue = findLargestChild( (AVLNode < E > ) parent.right);
      if ( ( (AVLNode < E > ) parent.right).balance < AVLNode.LEFT_HEAVY) {
        parent.right = rebalanceLeft( (AVLNode < E > ) parent.right);
      }
      if (decrease) {
        decrementBalance(parent);
      }
      return returnValue;
    }
  }

  /**
   * increamnt balance.
   * @param node
   */
  private void incrementBalance(AVLNode < E > node) {
    node.balance++;
    if (node.balance > AVLNode.BALANCED) {

      increase = true;
      decrease = false;
    }
    else {

      increase = false;
      decrease = true;
    }
  }

  /**
   * rebalance right. yapar.
   */
  private AVLNode < E > rebalanceRight(AVLNode < E > localRoot) {

    AVLNode < E > rightChild = (AVLNode < E > ) localRoot.right;

    if (rightChild.balance < AVLNode.BALANCED) {

      AVLNode < E > rightLeftChild = (AVLNode < E > ) rightChild.left;

      if (rightLeftChild.balance > AVLNode.BALANCED) {
        rightChild.balance = AVLNode.BALANCED;
        rightLeftChild.balance = AVLNode.BALANCED;
        localRoot.balance = AVLNode.LEFT_HEAVY;
      }
      else if (rightLeftChild.balance < AVLNode.BALANCED) {
        rightChild.balance = AVLNode.RIGHT_HEAVY;
        rightLeftChild.balance = AVLNode.BALANCED;
        localRoot.balance = AVLNode.BALANCED;
      }
      else {
        rightChild.balance = AVLNode.BALANCED;
        rightLeftChild.balance = AVLNode.BALANCED;
        localRoot.balance = AVLNode.BALANCED;
      }

      increase = false;
      decrease = true;

      localRoot.right = rotateRight(rightChild);
      return (AVLNode < E > ) rotateLeft(localRoot);
    }
    else {

      rightChild.balance = AVLNode.BALANCED;
      localRoot.balance = AVLNode.BALANCED;
      increase = false;
      decrease = true;

      return (AVLNode < E > ) rotateLeft(localRoot);
    }
  }

  /**
   * leftright rebalanclar.
   * @param localRoot
   * @return
   */
  private AVLNode < E > rebalanceLeftR(AVLNode < E > localRoot) {

    AVLNode < E > leftChild = (AVLNode < E > ) localRoot.left;

    if (leftChild.balance > AVLNode.BALANCED) {

      AVLNode < E > leftRightChild = (AVLNode < E > ) leftChild.right;

      if (leftRightChild.balance < AVLNode.BALANCED) {
        leftChild.balance = AVLNode.LEFT_HEAVY;
        leftRightChild.balance = AVLNode.BALANCED;
        localRoot.balance = AVLNode.BALANCED;
      }
      else if (leftRightChild.balance > AVLNode.BALANCED) {
        leftChild.balance = AVLNode.BALANCED;
        leftRightChild.balance = AVLNode.BALANCED;
        localRoot.balance = AVLNode.RIGHT_HEAVY;
      }
      else {
        leftChild.balance = AVLNode.BALANCED;
        localRoot.balance = AVLNode.BALANCED;
      }

      increase = false;
      decrease = true;

      localRoot.left = rotateLeft(leftChild);
      return (AVLNode < E > ) rotateRight(localRoot);
    }
    if (leftChild.balance < AVLNode.BALANCED) {

      leftChild.balance = AVLNode.BALANCED;
      localRoot.balance = AVLNode.BALANCED;
      increase = false;
      decrease = true;
    }
    else {

      leftChild.balance = AVLNode.RIGHT_HEAVY;
      localRoot.balance = AVLNode.LEFT_HEAVY;
    }

    return (AVLNode < E > ) rotateRight(localRoot);
  }

  /**
   * Rightleft rebalancler.
   * @param localRoot
   * @return
   */
  private AVLNode < E > rebalanceRightL(AVLNode < E > localRoot) {

    AVLNode < E > rightChild = (AVLNode < E > ) localRoot.right;

    if (rightChild.balance < AVLNode.BALANCED) {

      AVLNode < E > rightLeftChild = (AVLNode < E > ) rightChild.left;

      if (rightLeftChild.balance > AVLNode.BALANCED) {
        rightChild.balance = AVLNode.RIGHT_HEAVY;
        rightLeftChild.balance = AVLNode.BALANCED;
        localRoot.balance = AVLNode.BALANCED;
      }
      else if (rightLeftChild.balance < AVLNode.BALANCED) {
        rightChild.balance = AVLNode.BALANCED;
        rightLeftChild.balance = AVLNode.BALANCED;
        localRoot.balance = AVLNode.LEFT_HEAVY;
      }
      else {
        rightChild.balance = AVLNode.BALANCED;
        localRoot.balance = AVLNode.BALANCED;
      }

      increase = false;
      decrease = true;

      localRoot.right = rotateRight(rightChild);
      return (AVLNode < E > ) rotateLeft(localRoot);
    }
    if (rightChild.balance > AVLNode.BALANCED) {

      rightChild.balance = AVLNode.BALANCED;
      localRoot.balance = AVLNode.BALANCED;
      increase = false;
      decrease = true;
    }
    else {

      rightChild.balance = AVLNode.LEFT_HEAVY;
      localRoot.balance = AVLNode.RIGHT_HEAVY;
    }

    return (AVLNode < E > ) rotateLeft(localRoot);
  }

  /**
   * Solarebalance yapar.
   * @param localRoot
   * @return
   */
  private AVLNode < E > rebalanceLeft(AVLNode < E > localRoot) {

    AVLNode < E > leftChild = (AVLNode < E > ) localRoot.left;

    if (leftChild.balance > AVLNode.BALANCED) {

      AVLNode < E > leftRightChild = (AVLNode < E > ) leftChild.right;

      if (leftRightChild.balance < AVLNode.BALANCED) {
        leftChild.balance = AVLNode.BALANCED;
        leftRightChild.balance = AVLNode.BALANCED;
        localRoot.balance = AVLNode.RIGHT_HEAVY;
      }
      else {
        leftChild.balance = AVLNode.LEFT_HEAVY;
        leftRightChild.balance = AVLNode.BALANCED;
        localRoot.balance = AVLNode.BALANCED;
      }

      localRoot.left = rotateLeft(leftChild);
    }
    else {
      leftChild.balance = AVLNode.BALANCED;
      localRoot.balance = AVLNode.BALANCED;
    }

    return (AVLNode < E > ) rotateRight(localRoot);
  }

  private void decrementBalance(AVLNode < E > node) {

    node.balance--;
    if (node.balance == AVLNode.BALANCED) {

      increase = false;
    }
  }


  /**
   * delete methodu.
   * treedeki elemani siler.
   * @param delItem silinen eleman.
   * @return
   */
  public E delete(E delItem) {
    decrease = false;
    root = delete( (AVLNode < E > ) root, delItem);
    return deleteReturn;
  }


  /**
   * Verilen item item i tree den siler. Ve sildikte sonra gerekli balance ayarlarını yapar.
   * @param lRoot
   * @param delItem
   * @return
   */
  //https://rosettacode.org/wiki/AVL_tree#Java
  /*Yaparken yukarıda ki siteden bazen yardım aldım. Referans olarak ekledim.*/
  private AVLNode < E > delete(AVLNode < E > lRoot, E delItem) {
    if (lRoot == null) {
      deleteReturn = null;
      return lRoot;
    }
    int res=delItem.compareTo(lRoot.data);
    if (res == 0) {
      deleteReturn = lRoot.data;
      return findReplacementNode(lRoot);
    }
    else if (res < 0) {
      lRoot.left = delete( (AVLNode < E > ) lRoot.left, delItem);
      if (decrease) {

        incrementBalance(lRoot);
        if (lRoot.balance > AVLNode.RIGHT_HEAVY)
          return rebalanceRightL(lRoot);
        else
          return lRoot;
      }
      else
        return lRoot;
    }
    else {
      //res > 0
      lRoot.right = delete( (AVLNode < E > ) lRoot.right, delItem);
      if (decrease) {

        decrementBalance(lRoot);
        if (lRoot.balance < AVLNode.LEFT_HEAVY)
          return rebalanceLeftR(lRoot);
        else
          return lRoot;
      }
      else
        return lRoot;
    }
  }


}
