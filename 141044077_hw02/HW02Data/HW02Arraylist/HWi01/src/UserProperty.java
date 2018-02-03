/**
 * Kullanicinin özelliklerini kalıtım yoluyla sagladigi interface.
 * 
 * Student Number 141044077
 * @author Mustafa BİNGÜL
 */
public interface UserProperty {    

    /**
     * Kullanici kitap odunc alir.
     * @param bookID book id.
     * @return true or false.
     */
    public boolean borrowBook(int bookID);

    /**
     * Kullanici kitap geri verir.
     * @param bookID book id.
     * @return true or false.s
     */
    public boolean returnBook(int bookID);
}
