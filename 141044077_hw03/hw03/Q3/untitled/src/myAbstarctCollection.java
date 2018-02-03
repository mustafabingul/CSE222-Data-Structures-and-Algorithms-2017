import java.util.AbstractCollection;
import java.util.Iterator;

/**
 * myAbstractCollection sınıfı
 * bu sınıftan türeyen sınıflar
 *
 * appendAnything methodunu kullanmak isyteyen
 * iterator ünü ve add methodunu kendileri implement
 * etmeleri gerekir.
 *
 * @param <E>
 */
public abstract class myAbstarctCollection<E> extends AbstractCollection {

    /**
     * iki tane myAbstarctCollection objesini birbirine ekler.
     * @param other
     */
    public void appendAnything(myAbstarctCollection<E> other) {

        Iterator<E> itr= other.iterator();
        while(itr.hasNext()){
            add(itr.next());
        }
    }
}
