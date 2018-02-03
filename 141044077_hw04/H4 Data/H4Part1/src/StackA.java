import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * ArrayListi i extend edip implement edilmiş olan Stack.
 * @param <E>
 */
public class StackA<E> extends ArrayList<E> implements StackInterface<E>{

    /**
     * Stack in push methodu.
     * @param obj
     * @return
     */
    @Override
    public E push(E obj) {
        super.add(obj);
        return obj;
    }

    /**
     * Stack in pop methodu.
     * @return
     */
    @Override
    public E pop() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        E t = super.get(super.size()-1);
        super.remove(super.size()-1);
        return t;
    }

    /**
     * Stack in size methodu.
     * @return
     */
    @Override
    public int size() {
        return super.size();
    }

    /**
     * Stack in isEmpty Methodu.
     * @return
     */
    @Override
    public boolean isEmpty() {
        return super.size()==0;
    }

    /**
     * Stack in toString Methodu. Verileri string olarak return eder.
     * @return
     */
    public String toString(){
        String str = new String();
        for(int i=0; i<size(); ++i){
            str+=get(i);
            if(i<size()-1){
                str+=",";
            }
        }
        return str.toString();
    }
}
