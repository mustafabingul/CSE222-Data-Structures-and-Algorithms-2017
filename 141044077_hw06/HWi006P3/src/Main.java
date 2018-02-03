import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;


public class Main {

    private static final String fileName="test.txt";
    public  static void main(String argv[]) throws IOException {
        try {
            FamilyTree family = null;
            FileReader filereader = new FileReader(new File(fileName));
            BufferedReader bufferreader = new BufferedReader(filereader);
            String line;
            String com=",";
            String[] lineTok;
            if((line = bufferreader.readLine()) != null ){
                lineTok = line.split(com);
                if(lineTok.length != 1)
                    throw new IOException();
                family = new FamilyTree(lineTok[0].trim().toLowerCase());
            }
            while((line = bufferreader.readLine()) != null ){
                lineTok = line.split(com);
                family.add(lineTok[0].trim().toLowerCase(),lineTok[1].trim().toLowerCase(),lineTok[2].trim().toLowerCase());
            }
            bufferreader.close();

            /**
             * LEVELORDER OLARAK GEZMEKDTERDIR BU ıTERATOR METHODU. iterator2();
             */
            Iterator iterr = family.iterator2();
            while(iterr.hasNext()){
                System.out.println(iterr.next()+"  ");
            }
        }
        catch (Exception e){
            System.out.println("Wrong.");
        }
    }
}
