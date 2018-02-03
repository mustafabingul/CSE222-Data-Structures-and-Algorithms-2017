import java.util.*;
import java.io.*;

/** Class to represent and build a Huffman tree.
*   @author Koffman and Wolfgang
* */

public class HuffmanTree extends BinaryTree
    implements Serializable {

  // Nested Classes
  /** A datum in the Huffman tree. */
  public static class HuffData
      implements Serializable {
    // Data Fields
    /** The weight or probability assigned to this HuffData. */
    private double weight;

    /** The alphabet symbol if this is a leaf. */
    private Character symbol;

    public HuffData(double weight, Character symbol) {
      this.weight = weight;
      this.symbol = symbol;
    }
    public HuffData(){
        this(-1,null);
    }
    public void setHdata(double w, Character s){
        weight = w;
        symbol = s;
    }
    public Character getSymbol(){return symbol;}
  }

  // Data Fields
  /** A reference to the completed Huffman tree. */
  private BinaryTree < HuffData > huffTree;

  /** A Comparator for Huffman trees; nested class. */
  private static class CompareHuffmanTrees
      implements Comparator < BinaryTree < HuffData >> {
    /** Compare two objects.
        @param treeLeft The left-hand object
        @param treeRight The right-hand object
        @return -1 if left less than right,
                0 if left equals right,
                and +1 if left greater than right
     */
    public int compare(BinaryTree < HuffData > treeLeft,
                       BinaryTree < HuffData > treeRight) {
      double wLeft = treeLeft.getData().weight;
      double wRight = treeRight.getData().weight;
      return Double.compare(wLeft, wRight);
    }
  }

  /** Builds the Huffman tree using the given alphabet and weights.
      post:  huffTree contains a reference to the Huffman tree.
      @param symbols An array of HuffData objects
   */
  public void buildTree(HuffData[] symbols) {
    Queue < BinaryTree < HuffData >> theQueue
        = new PriorityQueue < BinaryTree < HuffData >>
        (symbols.length, new CompareHuffmanTrees());
    // Load the queue with the leaves.
    for (HuffData nextSymbol : symbols) {
      BinaryTree < HuffData > aBinaryTree =
          new BinaryTree < HuffData > (nextSymbol, null, null);
      theQueue.offer(aBinaryTree);
    }

    // Build the tree.
    while (theQueue.size() > 1) {
      BinaryTree < HuffData > left = theQueue.poll();
      BinaryTree < HuffData > right = theQueue.poll();
      double wl = left.getData().weight;
      double wr = right.getData().weight;
      HuffData sum = new HuffData(wl + wr, null);
      BinaryTree < HuffData > newTree =
          new BinaryTree < HuffData > (sum, left, right);
      theQueue.offer(newTree);
    }

    // The queue should now contain only one item.
    huffTree = theQueue.poll();
  }

  /** Outputs the resulting code.
      @param out A PrintStream to write the output to
      @param code The code up to this node
      @param tree The current node in the tree
   */
  private void printCode(PrintStream out, String code,
                         BinaryTree < HuffData > tree) {
    HuffData theData = tree.getData();
    if (theData.symbol != null) {
      if (theData.symbol.equals(" ")) {
        out.println("space: " + code);
      }
      else {
        out.println(theData.symbol + ": " + code);
      }
    }
    else {
      printCode(out, code + "0", tree.getLeftSubtree());
      printCode(out, code + "1", tree.getRightSubtree());
    }
  }

  /** Method to decode a message that is input as a string of
      digit characters '0' and '1'.
      @param codedMessage The input message as a String of
                          zeros and ones.
      @return The decoded message as a String
   */
  public String decode(String codedMessage) {
    StringBuilder result = new StringBuilder();
    BinaryTree < HuffData > currentTree = huffTree;
    for (int i = 0; i < codedMessage.length(); i++) {
      if (codedMessage.charAt(i) == '1') {
        currentTree = currentTree.getRightSubtree();
      }
      else {
        currentTree = currentTree.getLeftSubtree();
      }
      if (currentTree.isLeaf()) {
        HuffData theData = currentTree.getData();
        result.append(theData.symbol);
        currentTree = huffTree;
      }
    }
    return result.toString();
  }

  public String toString(){
    String encode="";
    return encode;
  }

    /**
     * HufTree yi alır. get methodu.
     * @return
     */
  public BinaryTree<HuffData> getHuffTree(){
    return huffTree;
  }

    /**
     * string
     * encode methodu.
     * @param str
     * @param huffman
     * @return
     */
  public String encode(String str, HuffmanTree huffman){
    StringBuilder newstr = new StringBuilder();
    for(char c : str.toCharArray()){
      newstr.append(charEncode(c,huffman.getHuffTree()));
    }
    return newstr.toString();
  }

    /**
     * character i encode layan method.
     * @param c
     * @param huffmanTree
     * @return
     */
  private String charEncode(Character c,BinaryTree<HuffData> huffmanTree){
    if(huffmanTree == null){
      return "";
    }
    if(huffmanTree.isLeaf()){
      if(huffmanTree.getData().getSymbol() == c){
        return "";
      }
      return "-1";
    }
    StringBuilder str= new StringBuilder();
    str.append('0');
    String newStr = charEncode(c,huffmanTree.getLeftSubtree());
    if(newStr == "-1"){
      str.deleteCharAt(str.length()-1);
      str.append('1');
      newStr = charEncode(c,huffmanTree.getRightSubtree());
      if(newStr=="-1"){
        return "-1";
      }
      else{
        str.append(newStr);
      }
    }
    else{
      str.append(newStr);
    }
    return str.toString();
  }

    /**
     * Dosyadan okunan karakterlerin sıklık tekrar sayıları..
     * @param FileName
     */
  public void readFreq(String FileName){
      String spc = " ";
      BufferedReader fReader=null;
      BufferedReader fReader2 = null;
      int c=0;
      int i=0;
      int k=0;
      try{
          String line = "";
          fReader = new BufferedReader(new FileReader(FileName));
          fReader2 = new BufferedReader(new FileReader(FileName));
          while((line = fReader.readLine())!=null){
              ++c;
          }
          HuffData[] data = new HuffData[c];
          while(k<c){
              data[k]=new HuffData();
              ++k;
          }
          while((line = fReader2.readLine())!=null){
              String[] tok = line.split(spc);
              double d = Double.parseDouble(tok[0]);
              data[i].setHdata(d,tok[1].charAt(0));
              ++i;
          }
          buildTree(data);
      }
      catch(FileNotFoundException e){
          System.out.print(e.toString());
      } catch (IOException e) {
          System.out.print(e.toString());
      }


  }


}
