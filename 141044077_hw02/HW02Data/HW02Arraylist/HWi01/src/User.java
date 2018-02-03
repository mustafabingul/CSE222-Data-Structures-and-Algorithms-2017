/**
 * ~ Simple Library Automation ~
 * User Objects.
 * 
 * Student Number 141044077
 * @author Mustafa BİNGÜL
 */
public class User extends Member implements UserProperty
{
    
    /**
     * Kullanicinin kitap sayisi.
     */
    protected int count = 0;

    /**
     * Kitaplar tutulur.
     */
    protected int[] bookIDs=new int[10];

    /**
     * Constructer.
     * @param ID user id 
     * @param memberName user name
     * @param password user password
     */
    public User(int ID,String memberName, String password) {
        super(ID,memberName, password);

    }

    public void setBookid(int x){
        for (int i=0; i<10; ++i){
            bookIDs[i]=x;
        }
    }
    
    /**
     * Kitap id ekler.
     * @param id book id
     */
    public void addBookID(int id){
        bookIDs[count] = id;
        ++count;
    }

    /**
     * User id e gore kullanici kitaplarini gösterir.
     */
    public void shwbookID(){        
        for (int i = 0; i < count; i++) {
            System.out.println(bookIDs[i]);
        }        
    }

    /**
     * Kitaplar arrayini return eder.
     * @return kitap bilgisi.
     */
    public int[] returBookID(){
        return bookIDs;
    }
    
    /**
     * User Menu.
     */
    @Override
    public void Menu() {    
        System.out.println("******** MENU *********");        
        System.out.println("1- List all my books   ");
        System.out.println("2- Borrow a book       ");
        System.out.println("3- Return a book       ");
        System.out.println("4- Exit                ");    
    }
    
    /**
     * Kullanicinin kitap odunc almasi saglanir.
     * @param bookID kitap id.
     * @return true or false.
     */
    @Override
    public boolean borrowBook(int bookID) {
        for (int i = 0; i < bookIDs.length; i++) {
            if(bookID==0){
                bookIDs[count]=bookID;
                count++;
                return true;
            }
            if(bookIDs[i]!=' ' && bookIDs[i]==bookID){
                return false;
            }
        }        
        bookIDs[count]=bookID;
        count++;
        return true;
    }

    /**
     * Kullanicinin kitap geri vermesini saglar.
     * @param bookID kitap id.
     * @return true or false.
     */
    @Override
    public boolean returnBook(int bookID) {
        for (int i = 0; i < bookIDs.length; i++) {
            if(bookIDs[i]==bookID && bookIDs[i]!=' '){
                bookIDs[i]=-1;
                return true;
            }
        }
        return false;
    }
}