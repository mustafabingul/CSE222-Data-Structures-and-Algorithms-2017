import java.io.*;

public class test {
    /**
     * Dosya ttanımlamaları.
     */
    private static final String resultFile="testResult_1.csv";
    private static final String writeAfile="testResult_1A.csv";
    private static final String writeBfile="testResult_1B.csv";
    private static final String writeCfile="testResult_1C.csv";
    private static final String writeDfile="testResult_1D.csv";

    public static void main(String args[]) throws IOException {

        StackA A1 = new StackA();
        StackA A2 = new StackA();
        StackA A3 = new StackA();
        StackA A4 = new StackA();

        StackB B1 = new StackB();
        StackB B2 = new StackB();
        StackB B3 = new StackB();
        StackB B4 = new StackB();

        StackC C1 = new StackC();
        StackC C2 = new StackC();
        StackC C3 = new StackC();
        StackC C4 = new StackC();

        StackD D1 = new StackD();
        StackD D2 = new StackD();
        StackD D3 = new StackD();
        StackD D4 = new StackD();

        long s=0;
        long e=0;
        s=System.nanoTime();
        readFileToA(A1,A2,A3,A4);
        e=System.nanoTime();
        System.out.println("A stack veri okuma nanosaniye= "+(e-s));

        s=System.nanoTime();
        readFileToB(B1,B2,B3,B4);
        e=System.nanoTime();
        System.out.println("B stack veri okuma nanosaniye= "+(e-s));

        s=System.nanoTime();
        readFileToC(C1,C2,C3,C4);
        e=System.nanoTime();
        System.out.println("C stack veri okuma nanosaniye= "+(e-s));

        s=System.nanoTime();
        readFileToD(D1,D2,D3,D4);
        e=System.nanoTime();
        System.out.println("D stack veri okuma nanosaniye= "+(e-s));

        writeResult(A1,A2,A3,A4,B1,B2,B3,B4,C1,C2,C3,C4,D1,D2,D3,D4);

        //writeFileToA(A1,A2,A3,A4);
        //writeFileToB(B1,B2,B3,B4);
        //writeFileToC(C1,C2,C3,C4);
        //writeFileToD(D1,D2,D3,D4);

    }

    /**
     * Stacklari tek bir dosyaya yazıyor.
     * @param A1 StackA1
     * @param A2 StackA2
     * @param A3 StackA3
     * @param A4 StackA4
     * @param B1 StackB1
     * @param B2 StackB2
     * @param B3 StackB3
     * @param B4 StackB4
     * @param C1 StackC1
     * @param C2 StackC2
     * @param C3 StackC3
     * @param C4 StackC4
     * @param D1 StackD1
     * @param D2 StackD2
     * @param D3 StackD3
     * @param D4 StackD4
     */
    public static void writeResult(StackA A1,StackA A2,StackA A3,StackA A4,
                                   StackB B1,StackB B2,StackB B3,StackB B4,
                                   StackC C1,StackC C2,StackC C3,StackC C4,
                                   StackD D1,StackD D2,StackD D3,StackD D4){


        FileWriter fileWriter = null;
        try{

            fileWriter = new FileWriter(new File(resultFile));

            fileWriter.write(A1.size()+",");
            fileWriter.write(A1.toString());
            fileWriter.write('\n');
            fileWriter.write(A2.size()+",");
            fileWriter.write(A2.toString());
            fileWriter.write('\n');
            fileWriter.write(A3.size()+",");
            fileWriter.write(A3.toString());
            fileWriter.write('\n');
            fileWriter.write(A4.size()+",");
            fileWriter.write(A4.toString());
            fileWriter.write('\n');

            fileWriter.write(B1.size()+",");
            fileWriter.write(B1.toString());
            fileWriter.write('\n');
            fileWriter.write(B2.size()+",");
            fileWriter.write(B2.toString());
            fileWriter.write('\n');
            fileWriter.write(B3.size()+",");
            fileWriter.write(B3.toString());
            fileWriter.write('\n');
            fileWriter.write(B4.size()+",");
            fileWriter.write(B4.toString());
            fileWriter.write('\n');

            fileWriter.write(C1.size()+",");
            fileWriter.write(C1.toString());
            fileWriter.write('\n');
            fileWriter.write(C2.size()+",");
            fileWriter.write(C2.toString());
            fileWriter.write('\n');
            fileWriter.write(C3.size()+",");
            fileWriter.write(C3.toString());
            fileWriter.write('\n');
            fileWriter.write(C4.size()+",");
            fileWriter.write(C4.toString());
            fileWriter.write('\n');

            fileWriter.write(D1.size()+",");
            fileWriter.write(D1.toString());
            fileWriter.write('\n');
            fileWriter.write(D2.size()+",");
            fileWriter.write(D2.toString());
            fileWriter.write('\n');
            fileWriter.write(D3.size()+",");
            fileWriter.write(D3.toString());
            fileWriter.write('\n');
            fileWriter.write(D4.size()+",");
            fileWriter.write(D4.toString());
            fileWriter.write('\n');

            fileWriter.close();
        }
        catch(IOException | NumberFormatException q){
            System.err.println(q.toString());
        }
    }

    /**
     * Sadece StackA ları dosyaya yazar.
     * @param A1
     * @param A2
     * @param A3
     * @param A4
     */
    public static void writeFileToA(StackA A1,StackA A2,StackA A3,StackA A4){


        FileWriter fileWriter = null;
        try{

            fileWriter = new FileWriter(new File(writeAfile));

            fileWriter.write(A1.toString());
            fileWriter.write('\n');
            fileWriter.write(A2.toString());
            fileWriter.write('\n');
            fileWriter.write(A3.toString());
            fileWriter.write('\n');
            fileWriter.write(A4.toString());
            fileWriter.write('\n');


            fileWriter.close();
        }
        catch(IOException | NumberFormatException q){
            System.err.println(q.toString());
        }
    }

    /**
     * Sadece StackB ları dosyaya yazar.
     * @param B1
     * @param B2
     * @param B3
     * @param B4
     */
    public static void writeFileToB(StackB B1,StackB B2,StackB B3,StackB B4){
        FileWriter fileWriter = null;
        try{

            fileWriter = new FileWriter(new File(writeBfile));

            fileWriter.write(B1.toString());
            fileWriter.write('\n');
            fileWriter.write(B2.toString());
            fileWriter.write('\n');
            fileWriter.write(B3.toString());
            fileWriter.write('\n');
            fileWriter.write(B4.toString());
            fileWriter.write('\n');


            fileWriter.close();
        }
        catch(IOException | NumberFormatException q){
            System.err.println(q.toString());
        }
    }

    /**
     * Sadece StackC ları dosyaya yazar.
     * @param C1
     * @param C2
     * @param C3
     * @param C4
     */
    public static void writeFileToC(StackC C1,StackC C2,StackC C3,StackC C4){
        FileWriter fileWriter = null;
        try{

            fileWriter = new FileWriter(new File(writeCfile));

            fileWriter.write(C1.toString());
            fileWriter.write('\n');
            fileWriter.write(C2.toString());
            fileWriter.write('\n');
            fileWriter.write(C3.toString());
            fileWriter.write('\n');
            fileWriter.write(C4.toString());
            fileWriter.write('\n');


            fileWriter.close();
        }
        catch(IOException | NumberFormatException q){
            System.err.println(q.toString());
        }
    }

    /**
     * Sadece StackD ları dosyaya yazar.
     * @param D1
     * @param D2
     * @param D3
     * @param D4
     */
    public static void writeFileToD(StackD D1,StackD D2,StackD D3,StackD D4){
        FileWriter fileWriter = null;
        try{

            fileWriter = new FileWriter(new File(writeDfile));

            fileWriter.write(D1.toString());
            fileWriter.write('\n');
            fileWriter.write(D2.toString());
            fileWriter.write('\n');
            fileWriter.write(D3.toString());
            fileWriter.write('\n');
            fileWriter.write(D4.toString());
            fileWriter.write('\n');

            fileWriter.close();
        }
        catch(IOException | NumberFormatException q){
            System.err.println(q.toString());
        }
    }

    /**
     * A stack ine dosyadan okuma yapar.
     * @param A1
     * @param A2
     * @param A3
     * @param A4
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void readFileToA(StackA A1,StackA A2,StackA A3,StackA A4) throws FileNotFoundException, IOException {

        String COMMA = ",";
        BufferedReader fileReader = null;
        int count=1;
        try {
            String line = "";
            fileReader = new BufferedReader(new FileReader(new File("test.csv")));

            //line = fileReader.readLine();

            if(line==null){return;}
            String[] toks=line.split(COMMA);


            while ((line = fileReader.readLine()) != null) {

                String[] tok = line.split(COMMA);

                if (count == 1) {
                    for (int i = 0; i < tok.length; ++i) {
                        A1.push(tok[i]);
                    }

                } else if (count == 2) {
                    for (int i = 0; i < tok.length; ++i) {
                        A2.push(tok[i]);
                    }

                } else if (count == 3) {
                    for (int i = 0; i < tok.length; ++i) {
                        A3.push(tok[i]);
                    }

                } else if (count == 4) {
                    for (int i = 0; i < tok.length; ++i) {
                        A4.push(tok[i]);
                    }

                }
                count++;
            }
            /*for(int i=0; i<A1.size();++i){
                System.out.println("UU11  "+A1.get(i));
            }
            System.out.println();
            for(int i=0; i<A2.size();++i){
                System.out.println("UU22  "+A2.get(i));
            }
            System.out.println();
            for(int i=0; i<A3.size();++i){
                System.out.println("UU33  "+A3.get(i));
            }
            System.out.println();
            for(int i=0; i<A4.size();++i){
                System.out.println("UU44  "+A4.get(i));
            }*/

        }
        catch(IOException | NumberFormatException q){
            System.err.println(q.toString());
        }

    }

    /**
     * B stack ine dosyadan okuma yapar.
     * @param B1
     * @param B2
     * @param B3
     * @param B4
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void readFileToB(StackB B1,StackB B2,StackB B3,StackB B4) throws FileNotFoundException, IOException {

        String COMMA = ",";
        BufferedReader fileReader = null;
        int count=1;
        try {
            String line = "";
            fileReader = new BufferedReader(new FileReader(new File("test.csv")));

            //line = fileReader.readLine();

            if(line==null){return;}
            String[] toks=line.split(COMMA);


            while ((line = fileReader.readLine()) != null) {

                String[] tok = line.split(COMMA);

                if (count == 1) {
                    for (int i = 0; i < tok.length; ++i) {
                        B1.push(tok[i]);
                    }

                } else if (count == 2) {
                    for (int i = 0; i < tok.length; ++i) {
                        B2.push(tok[i]);
                    }

                } else if (count == 3) {
                    for (int i = 0; i < tok.length; ++i) {
                        B3.push(tok[i]);
                    }

                } else if (count == 4) {
                    for (int i = 0; i < tok.length; ++i) {
                        B4.push(tok[i]);
                    }

                }
                count++;
            }
            /*for(int i=0; i<B1.size();++i){
                System.out.println("UU11  "+B1.get(i));
            }
            System.out.println();
            for(int i=0; i<B2.size();++i){
                System.out.println("UU22  "+B2.get(i));
            }
            System.out.println();
            for(int i=0; i<B3.size();++i){
                System.out.println("UU33  "+B3.get(i));
            }
            System.out.println();
            for(int i=0; i<B4.size();++i){
                System.out.println("UU44  "+B4.get(i));
            }*/

        }
        catch(IOException | NumberFormatException q){
            System.err.println(q.toString());
        }

    }

    /**
     * C stack ine dosyadan okuma yapar.
     * @param C1
     * @param C2
     * @param C3
     * @param C4
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void readFileToC(StackC C1,StackC C2,StackC C3,StackC C4) throws FileNotFoundException, IOException {

        String COMMA = ",";
        BufferedReader fileReader = null;
        int count=1;
        try {
            String line = "";
            fileReader = new BufferedReader(new FileReader(new File("test.csv")));

            //line = fileReader.readLine();

            if(line==null){return;}
            String[] toks=line.split(COMMA);


            while ((line = fileReader.readLine()) != null) {

                String[] tok = line.split(COMMA);

                if (count == 1) {
                    for (int i = 0; i < tok.length; ++i) {
                        C1.push(tok[i]);
                    }

                } else if (count == 2) {
                    for (int i = 0; i < tok.length; ++i) {
                        C2.push(tok[i]);
                    }

                } else if (count == 3) {
                    for (int i = 0; i < tok.length; ++i) {
                        C3.push(tok[i]);
                    }

                } else if (count == 4) {
                    for (int i = 0; i < tok.length; ++i) {
                        C4.push(tok[i]);
                    }

                }
                count++;
            }
            /*for(int i=0; i<C1.size();++i){
                System.out.println("UU11  "+C1.get(i));
            }
            System.out.println();
            for(int i=0; i<C2.size();++i){
                System.out.println("UU22  "+C2.get(i));
            }
            System.out.println();
            for(int i=0; i<C3.size();++i){
                System.out.println("UU33  "+C3.get(i));
            }
            System.out.println();
            for(int i=0; i<C4.size();++i){
                System.out.println("UU44  "+C4.get(i));
            }*/

        }
        catch(IOException | NumberFormatException q){
            System.err.println(q.toString());
        }

    }

    /**
     * D stack ine dosyadan okuma yapar.
     * @param D1
     * @param D2
     * @param D3
     * @param D4
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void readFileToD(StackD D1,StackD D2,StackD D3,StackD D4) throws FileNotFoundException, IOException {

        String COMMA = ",";
        BufferedReader fileReader = null;
        int count=1;
        try {
            String line = "";
            fileReader = new BufferedReader(new FileReader(new File("test.csv")));

            //line = fileReader.readLine();

            if(line==null){return;}
            String[] toks=line.split(COMMA);


            while ((line = fileReader.readLine()) != null) {

                String[] tok = line.split(COMMA);

                if (count == 1) {
                    for (int i = 0; i < tok.length; ++i) {
                        D1.push(tok[i]);
                    }

                } else if (count == 2) {
                    for (int i = 0; i < tok.length; ++i) {
                        D2.push(tok[i]);
                    }

                } else if (count == 3) {
                    for (int i = 0; i < tok.length; ++i) {
                        D3.push(tok[i]);
                    }

                } else if (count == 4) {
                    for (int i = 0; i < tok.length; ++i) {
                        D4.push(tok[i]);
                    }

                }
                count++;
            }
            /*for(int i=0; i<D1.size();++i){
                System.out.println("UU11  "+D1.get(i));
            }
            System.out.println();
            for(int i=0; i<D2.size();++i){
                System.out.println("UU22  "+D2.get(i));
            }
            System.out.println();
            for(int i=0; i<D3.size();++i){
                System.out.println("UU33  "+D3.get(i));
            }
            System.out.println();
            for(int i=0; i<D4.size();++i){
                System.out.println("UU44  "+D4.get(i));
            }*/

        }
        catch(IOException | NumberFormatException q){
            System.err.println(q.toString());
        }

    }
}
