
import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry;

import javax.swing.*;
import java.util.*;


public class Main
{
    public static void main(String args[]){
        final Boolean q1 = Q1Test();
        final Boolean q2 = Q2Test();
        if (q1 == q2 == Boolean.TRUE) {
            System.out.println("Your tests is done. Make sure that you test all methods of class!! " );
            return;
        }
    }
    public static Boolean Q1Test(){

        NavigableMap<String,String> turkey = new BinaryNavMap<String,String>();
        turkey.put("uskudar","istanbul");
        turkey.put("kadikoy","istanbul");
        turkey.put("cekirge","bursa");
        turkey.put("gebze","kocaeli");
        turkey.put("niksar","tokat");
        turkey.put("kecıoren","ankara");
        turkey.put("aksaray","istanbul");
        turkey.put("foca","izmir");
        turkey.put("manavgat","antalya");
        turkey.put("kahta","adıyaman");
        turkey.put("biga","canakkale");


        /*Set<Map.Entry<String, String>> trSET = turkey.entrySet();
        Iterator itr = trSET.iterator();
        while(itr.hasNext()){
            Map.Entry mp= (Map.Entry) itr.next();
            System.out.println(mp.getKey()+" "+mp.getValue());
        }*/
/****************************************************************************************************************/
        /*Map.Entry lwEnt = turkey.lowerEntry("foca");
        System.out.println(lwEnt.getKey()+" "+lwEnt.getValue());*/

        /*System.out.println(turkey.lowerKey("kecioren"));*/

        /*Map.Entry flEnt = turkey.floorEntry("foca");
        System.out.println(flEnt.getKey()+" "+flEnt.getValue());*/

        /*System.out.println(turkey.floorKey("faca"));*/

        /*Map.Entry ceilnEnt = turkey.ceilingEntry("kahta");
        System.out.println(ceilnEnt.getKey()+" "+ceilnEnt.getValue());*/

       /*System.out.println(turkey.ceilingKey("kahaaaa"));*/

        /*Map.Entry highEnt = turkey.higherEntry("kahta");
        System.out.println(highEnt.getKey()+" "+highEnt.getValue());*/

        /*System.out.println(turkey.higherKey("kahaaaa"));*/

        /*Map.Entry Lent = turkey.lastEntry();
        Map.Entry Fent = turkey.firstEntry();
        System.out.println(Fent.getKey()+" "+Fent.getValue());
        System.out.println(Lent.getKey()+" "+Lent.getValue());*/

        /*TreeMap<String ,String> tMap = (TreeMap<String, String>) turkey.descendingMap();*/

        /*TreeSet<String> treest = (TreeSet<String>) turkey.navigableKeySet();
        Iterator itr = treest.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next()+" ->   NavigableKeySet");
        }*/

        /*TreeSet<String> treest2 = (TreeSet<String>) turkey.descendingKeySet();
        Iterator itr2 = treest2.iterator();
        while(itr2.hasNext()){
            System.out.println("descendingKeySet   ->"+itr2.next());
        }*/

        /*NavigableMap<String,String> nvmp1 = turkey.subMap("biga",true,"kadikoy",false);*/

        //NavigableMap<String,String> nvmp1 = turkey.headMap("cekirge",true);
        //NavigableMap<String,String> nvmp = turkey.tailMap("biga",true);

        /*TreeMap<String,String> mpp= (TreeMap<String, String>) turkey.subMap("biga","manavgat");*/

        /*TreeMap<String,String> mpp= (TreeMap<String, String>) turkey.headMap("kecıoren");*/

        //TreeMap<String,String> mpp= (TreeMap<String, String>) turkey.tailMap("kecıoren");

        /*System.out.println("lastKey -> "+turkey.lastKey());
        System.out.println("firstKey -> "+turkey.firstKey());*/


        System.out.println("The original set odds is " + turkey.toString());
        NavigableMap<String,String> m = turkey.subMap("gebze",true,"uskudar",false);
        System.out.println("The ordered set m is " + m);
        System.out.println("The first entry is " +turkey.firstEntry().getKey()+" "+turkey.firstEntry().getValue());

        //you should write more test function to show your solution
        //your test must contain all methods to get full points!!!
        //you also may need to owerwrite some methods to provide BST RULES

        /* *some links to help you

           https://docs.oracle.com/javase/8/docs/api/java/util/NavigableMap.html
           https://docs.oracle.com/javase/8/docs/api/java/util/AbstractMap.html

        * */
        return Boolean.TRUE;

    }
    public static Boolean Q2Test(){
        HashMap<String,String> turkey=new HashTableChaining<String,String>();
        turkey.put("edremit","balikesir");
        turkey.put("edremit","van");
        turkey.put("kemalpasa","bursa");
        turkey.put("kemalpasa","izmir");
        turkey.put("ortakoy","istanbul");//we assume a district
        turkey.put("ortakoy","aksaray");
        turkey.put("ortakoy","corum");
        turkey.put("kecıoren","ankara");
        turkey.put("pinarbasi","kastamonu");
        turkey.put("pinarbasi","kayseri");
        turkey.put("eregli","konya");
        turkey.put("eregli","tekirdag");
        turkey.put("eregli","zonguldak");
        turkey.put("golbasi","adıyaman");
        turkey.put("golbasi","ankara");
        turkey.put("biga","canakkale");

        /* *test all

            V get(Object key);

            V put(K key, V value);

            V remove(Object key);

            int size();

        * */


        return Boolean.TRUE;
    }


}
