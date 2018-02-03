/**
 * Stack Interfacei
 * Stacklerdeki ortak methodların tanımlandığı yer.
 * @param <E>
 */
public interface StackInterface<E> {

    public E push(E obj);
    public  E pop();
    public int size();
    public boolean isEmpty();
}
