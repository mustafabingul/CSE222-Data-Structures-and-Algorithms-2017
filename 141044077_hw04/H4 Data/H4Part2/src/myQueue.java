import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * myQueue class ım {@link KWLinkedList} sınıfını extends eder.
 *
 * @param <E>
 */
public class myQueue<E> extends KWLinkedList<E> {

    /**
     * Bu method yeni bir node kullanmadan. Objemizdeki verileri reverse eder.
     */
    public void reverseIQueue(){
        int i=0;

        while((i!=super.size()-1-i)&&i<=size()-1-i){
            E t=super.get(i);
            super.set(i,get(size()-1-i));
            super.set(size()-1-i,t);
            ++i;
        }
    }

    /**
     * Elimizdeki objeye verilen indexe verilen data yı set eder.
     * @param index index
     * @param item set edilecek veri.
     */
    public void set(int index, E item){
        super.set(index,item);
    }

    /**
     * Veri yapımızdaki verilen index deki data yı return eder.
     * @param index Position of item to be retrieved
     * @return data.
     */
    public E get(int index){
        return super.get(index);

    }

    /**
     * ToString methodu.
     * verileri string olarak return eder.
     *
     * @return
    */
    public String toString(){

        String str = new String();
        Iterator iter = super.iterator();
        for(int i=0; i<super.size(); ++i){
            str+=iter.next();
            if(i<size()-1){
                str+=",";
            }
        }
        return str.toString();

    }

    /*Q2--------2--Q2--------2--Q2--------2--Q2--------2--*/
    /**
     *  Verilern Queue yapısını colum olarak ters cevirir.
     * @param other
     */
    public Queue reverseQueue(Queue<E> other){
        int a=other.size();
        LinkedList<E> data = new LinkedList<E>();

        for(int i=0; i<a;++i){
            data.add(other.element());
            other.remove();
        }

        reverseHelp(data,0,a);
        /*for (int i=0; i<a;++i)
        {
            System.out.println(data.get(i)+" AA ");
        }*/
        for(int i=0; i<a;++i){
            other.add(data.get(i));
            //System.out.println(data.get(i));
        }
        return other;
    }

    /**
     * Helper recursive method. verileri column olarak ters cevirir.
     * @param other1
     * @param i
     * @param s
     * @return
     */
    private LinkedList reverseHelp(LinkedList<E> other1,int i,int s){
        E temp = null;
        if(s-i == i || i>=s-i){
            return null;
        }
        temp=other1.get(i);

        other1.set(i, other1.get(s-1));
        other1.set(s-1,temp);
        i++;
        s--;
        reverseHelp(other1,i,s);
        return other1;
    }

}
