

import java.util.Iterator;
import java.util.LinkedList;

/**
 * myStringBuilder class ım.
 */
public class myStringBuilder {
    /**
     * Create ettiğim SingleLinkedList class ım.
     */
    private SingleLinkedList newstr;

    /**
     * mytringBuilder constructer.
     */
    public myStringBuilder(){

        newstr = new SingleLinkedList<String>();

    }

    /**
     * Verilen string i ekleyen append fonksiyonum.
     * @param str
     */
    public void append(String str){

        if(str!=null){
            newstr.add(str);
        }
    }

    /**
     * İndexes and method a göre toString() methodu.
     * @return
     */
    public String toString1(){
        String str=new String();
        for(int i=0; i<newstr.size(); i++) {
            if(newstr.get(i)!=null){
                str+=newstr.get(i);
            }
        }

        return str;
    }

    /**
     * İterator kullanilarak yapilan toString() methodum.
     * @return
     */
    public String toString2(){

        String str=new String();
        Iterator itr=newstr.iterator();
        int i=0;
        while(itr.hasNext()){
            str+=itr.next();
            ++i;
        }
        return new String(str);
    }

    /**
     * LinkedListin toString() methodu.
     * @return
     */
    public String toString3(){
        return newstr.toString3();
    }
}