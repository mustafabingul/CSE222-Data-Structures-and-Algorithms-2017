import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * Data field inde ArrayList tutarak implement edilmiş Stack.
 * @param <E>
 */
public class StackB<E> implements StackInterface<E>{

    /**
     * Data field.
     */
    private ArrayList<E> data ;

    /**
     * Constructer.
     */
    public StackB(){
        data = new ArrayList<E>();
    }

    /**
     * Stack push methodu.
     * Veri ekler.
     * @param obj
     * @return
     */
    @Override
    public E push(E obj) {
        data.add(obj);
        return obj;
    }

    /**
     * Stack in pop Methodu.
     * Stackin sonundan veri siler.
     * @return
     */
    @Override
    public E pop() {
        if(isEmpty()){
            throw new EmptyStackException();
        }

        return data.remove(data.size()-1);
    }

    /**
     * Stack in size methodu.
     * @return
     */
    @Override
    public int size() {
        return data.size();
    }

    /**
     * Stack in isEmpty methodu.
     * @return
     */
    @Override
    public boolean isEmpty() {
        return data.size()==0;
    }

    /**
     * Stack in get Methodu. Veri return eder.
     * @param index
     * @return
     */
    public E get(int index){
        return data.get(index);
    }

    /**
     * Stackin toString methodu.
     * Veri yi string olarak return eder.
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
