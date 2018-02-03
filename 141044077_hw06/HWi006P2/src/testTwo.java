
public class testTwo {

    public static void main(String args[]){

        HuffmanTree hufmanTre = new HuffmanTree();

        hufmanTre.readFreq("freq.txt");
        //System.out.print(s1);

        String code2="mustafaaaaaaa";
        String newEncode = hufmanTre.encode(code2,hufmanTre);
        String newDecode = hufmanTre.decode(newEncode);

        System.out.println(newEncode);
        System.out.println(newDecode);

        String code3="bingul";
        String newwEncode = hufmanTre.encode(code3,hufmanTre);
        String newwDecode = hufmanTre.decode(newwEncode);

        System.out.println(newwEncode);
        System.out.println(newwDecode);
    }
}
