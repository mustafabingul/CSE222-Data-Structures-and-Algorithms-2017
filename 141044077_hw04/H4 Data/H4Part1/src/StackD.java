
import javax.sound.sampled.Line;
import java.util.*;

/**
 * Data field olarak Queue tutan implement edilmiş olan stack.
 * @param <E>
 */
public class StackD<E> implements StackInterface<E> {
    /**
     * Data field.
     */
    Queue<E> data;

    /**
     * Constructer.
     */
    public StackD() {
        data = new LinkedList<E>();
    }

    /**
     * Stack push methodu.
     * Stack e veri ekler.
     * @param obj
     * @return
     */
    @Override
    public E push(E obj) {
        data.add(obj);
        return obj;
    }

    /**
     * Stack in pop methodu.
     * Stack in sonundaki elemanı çıkarır.
     * @return
     */
    @Override
    public E pop() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        E t=null;
        Iterator<E> iter = data.iterator();
        for(int i=0; i<size();++i){
            t=iter.next();
        }
        data.remove(t);
        return t;
    }

    /**
     * Stack size methodu.
     * Stack size ını return eder.
     * @return
     */
    @Override
    public int size() {
        return data.size();
    }

    /**
     * Stack isEmpty methodu.
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size()==0;
    }

    /**
     * Stack get methodu.
     * Stackten index e göre veri returun eder.
     * @param index
     * @return
     */
    public E get(int index){
        E t=null;
        Iterator<E> iter = data.iterator();
        for(int i=0; i<=index;++i){
            t= iter.next();
        }
        return t;
    }

    /**
     * Stack toString methodu.
     * Veriyi string olarak return eder.
     * @return
     */
    public String toString(){
        String str = new String();
        Iterator<E> iter = data.iterator();
        for(int i=0; i<size(); ++i){
            str+=iter.next();
            if(i<size()-1){
                str+=",";
            }
        }
        return str.toString();
    }
}
