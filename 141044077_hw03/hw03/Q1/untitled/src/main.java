import java.io.*;

public class main {

    private static final String FILENAME = "numbers.txt";
    private static final String FILENAME1 = "result1.txt";
    private static final String FILENAME2 = "result2.txt";
    private static final String FILENAME3 = "result3.txt";

    public static void main(String args[]) {

        SingleLinkedList l = new SingleLinkedList();
        l.add("1");
        l.add("2");
        l.add("5");
        l.add("3");
        System.out.println(l.reverseToString());
        /*writeNumbers();
        toStringResult1();
        toStringResult2();
        toStringResult3();*/

    }
    /*MAİN END.*/

    /**
     * toString1();
     * Indexes ve get methodu ile yazılmıs toString() ile dosyaya yazar.
     */
    public static void toStringResult1()
    {
        myStringBuilder mb = new myStringBuilder();

        try
        {
            BufferedReader br = new BufferedReader(new FileReader(FILENAME));
            String line = br.readLine();

            while (line != null) {
                mb.append(line);
                mb.append("\n");

                line = br.readLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        FileWriter fw = null;

        try {
            fw = new FileWriter(FILENAME1);
            for(int i=0; i<1; ++i){

                fw.write(mb.toString1());
                fw.write('\n');
            }
            fw.close();
            System.out.println("toString1() Done");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println(mb.toString1());
    }

    /**
     * toString2();
     * Iterator toString() i ile dosyaya yazar.
     */
    public static void toStringResult2()
    {
        myStringBuilder mb = new myStringBuilder();

        try
        {
            BufferedReader br = new BufferedReader(new FileReader(FILENAME));
            String line = br.readLine();

            while (line != null) {
                mb.append(line);
                mb.append("\n");

                line = br.readLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        FileWriter fw = null;

        try {
            fw = new FileWriter(FILENAME2);
            for(int i=0; i<1; ++i){

                fw.write(mb.toString2());
                fw.write('\n');
            }
            fw.close();
            System.out.println("toString2() Done");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println(mb.toString2());
    }

    /**
     * toString3();
     * LinkedList toString() ile dosyaya yazar.
     */
    public static void toStringResult3()
    {
        myStringBuilder mb = new myStringBuilder();

        try
        {
            BufferedReader br = new BufferedReader(new FileReader(FILENAME));
            String line = br.readLine();

            while (line != null) {
                mb.append(line);
                mb.append("\n");

                line = br.readLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        FileWriter fw = null;

        try {
            fw = new FileWriter(FILENAME3);
            for(int i=0; i<1; ++i){

                fw.write(mb.toString3());
                fw.write('\n');
            }
            fw.close();
            System.out.println("toString3() Done");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println(mb.toString3());
    }

    /**
     * 100.000 adet sayıyı numbers.txt ye yazar.
     */
    public static void writeNumbers(){
        FileWriter fw = null;

        try {
            fw = new FileWriter(FILENAME);
            for(int i=0; i<100000; ++i){

                fw.write(new Integer(i).toString());
                fw.write('\n');
            }
            fw.close();
            System.out.println("Writing Done");

        }
        catch (IOException e) {

            e.printStackTrace();

        }

    }

}
