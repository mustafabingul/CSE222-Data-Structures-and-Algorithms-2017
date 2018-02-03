import javax.sound.sampled.Line;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class test2 {

    private static final String test="test.csv";
    private static final String testResult="testResult_2.csv";

    public static void main(String args[]) throws IOException {


        myQueue mq1 = new myQueue();
        myQueue mq2 = new myQueue();
        myQueue mq3 = new myQueue();
        myQueue mq4 = new myQueue();

        Queue aa = new LinkedList();
        Queue b ;

        fileReadToQ2(aa);
        System.out.print(aa.peek());
        readFileToQ(mq1,mq2,mq3,mq4);

        /*
        mq1.reverseIQueue();
        mq2.reverseIQueue();
        mq3.reverseIQueue();
        mq4.reverseIQueue();

        writeFileToQ(mq1,mq2,mq3,mq4);*/





    }

    public static void fileWriteToQ2(Queue qq){
        
    }
    /**
     * Q2-2 deki recursive Queue parametresi alan dosyadan okuyan method.
     * @param qq
     */
    public static void fileReadToQ2(Queue qq){

        LinkedList lst=new LinkedList();
        Queue t=null;
        String COMMA = ",";
        BufferedReader fileReader = null;

        try {
            String line = "";
            fileReader = new BufferedReader(new FileReader(new File(test)));


            if(line==null){return;}
            String[] toks=line.split(COMMA);


            while ((line = fileReader.readLine()) != null) {
                t=new LinkedList();
                String[] tok = line.split(COMMA);

                for(int i=0; i<tok.length;++i){
                    t.add(tok[i]);
                }
            }
            qq.add(t);

        }
        catch(IOException | NumberFormatException q){
            System.err.println(q.toString());
        }
    }

    /**
     * Dört farklı myQueue objesini dosyaya yazar.
     * @param Q1
     * @param Q2
     * @param Q3
     * @param Q4
     */
    public static void writeFileToQ(myQueue Q1 ,myQueue Q2,myQueue Q3,myQueue Q4){
        FileWriter fileWriter = null;
        try{

            fileWriter = new FileWriter(new File(testResult));

            fileWriter.write(Q4.toString());
            fileWriter.write('\n');
            fileWriter.write(Q3.toString());
            fileWriter.write('\n');
            fileWriter.write(Q2.toString());
            fileWriter.write('\n');
            fileWriter.write(Q1.toString());
            fileWriter.write('\n');


            fileWriter.close();
        }
        catch(IOException | NumberFormatException q){
            System.err.println(q.toString());
        }
    }

    /**
     * myQueue objerine dosyadan veri okur.
     * @param Q1
     * @param Q2
     * @param Q3
     * @param Q4
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void readFileToQ(myQueue Q1 ,myQueue Q2,myQueue Q3,myQueue Q4) throws FileNotFoundException, IOException {

        String COMMA = ",";
        BufferedReader fileReader = null;
        int count=1;
        try {
            String line = "";
            fileReader = new BufferedReader(new FileReader(new File(test)));

            //line = fileReader.readLine();

            if(line==null){return;}
            String[] toks=line.split(COMMA);


            while ((line = fileReader.readLine()) != null) {

                String[] tok = line.split(COMMA);

                if (count == 1) {
                    for (int i = 0; i < tok.length; ++i) {
                        Q1.addLast(tok[i]);
                    }

                } else if (count == 2) {
                    for (int i = 0; i < tok.length; ++i) {
                        Q2.addLast(tok[i]);
                    }

                } else if (count == 3) {
                    for (int i = 0; i < tok.length; ++i) {
                        Q3.addLast(tok[i]);
                    }

                } else if (count == 4) {
                    for (int i = 0; i < tok.length; ++i) {
                        Q4.addLast(tok[i]);
                    }

                }
                count++;
            }
            /*for(int i=0; i<Q1.size();++i){
                System.out.println("TT11--  "+Q1.get(i));
            }
            System.out.println();
            for(int i=0; i<Q2.size();++i){
                System.out.println("TT22  "+Q2.get(i));
            }
            System.out.println();
            for(int i=0; i<Q3.size();++i){
                System.out.println("TT33  "+Q3.get(i));
            }
            System.out.println();
            for(int i=0; i<Q4.size();++i){
                System.out.println("TT44  "+Q4.get(i));
            }*/

        }
        catch(IOException | NumberFormatException q){
            System.err.println(q.toString());
        }

    }

}
