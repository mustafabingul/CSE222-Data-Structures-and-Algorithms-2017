/**
 * Yetkili kullanicinin özelliklerini kalıtım(inheritance) olarak saglar.
 * 
 * Student Number 141044077
 * @author Mustafa BİNGÜL
 */
public interface StaffProperty {

    /**
     * Kullanici siler.
     * @param Id
     * @return
     */
    public boolean deleteUser(int Id);

    /**
     * Kitap ekler.
     * @param name
     * @param author
     * @return true or false.
     */
    public boolean addBook(String name, String author);

    /**
     * Kullanici ekler.
     * @param Name user name.
     * @param Pass user password.
     * @return true or false.
     */
    public boolean addUser(String Name, String Pass);

    /**
     * Kitap siler.
     * @param Id book id.
     * @return true or false.
     */
    public boolean deleteBook(int Id);
}
