/**
 * ~ Simple Library Automation ~
 * Book Objects.
 * 
 * Student Number 141044077
 * @author Mustafa BİNGÜL
 */
public class Book {
    
    private int bookId;
    private String bookName;
    private String author;
    private boolean status;
    int barrower;

    /**
     * No parameter Constructer.
     */
    public Book(){        
        this(0,null,null,false,0);
    }

    /**
     * Constructer.
     * @param bookId book id.
     * @param bookName book name.
     * @param author book author.
     * @param status book state.
     */
    public Book(int bookId, String bookName, String author, boolean status){
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.status = status;
    }

    /**
     * Constructer.
     * @param bookId book id.
     * @param bookName book name.
     * @param author book author.
     * @param status book state.
     * @param barrower kitap alan.
     */
    public Book(int bookId, String bookName, String author, boolean status, int barrower) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.status = status;
        this.barrower = barrower;
    }
    
    /**
     * Kitap id alir.
     * @return kitap id
     */
    public int getBookId() {
        return bookId;
    }

    /**
     * Kitap id ayarlar.
     * @param bookId kitap id.
     */
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    /**
     * Kitap ismine ulasilir.
     * @return book name.
     */
    public String getBookName() {
        return bookName;
    }

    /**
     * Kitap ismi ayarlar.
     * @param bookName book name.
     */
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    /**
     * Kitap in yazarı.
     * @return yazar name.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Kitap yazari ayarlar.     
     * @param author yazar name.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Kitap durumunu dondurur.
     * @return
     */
    public boolean getStatus() {
        return status;
    }

    /**
     * Kitap durumunu set eder.
     * @param status kitap durumu.
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * Kitap sahibini tutar.
     * @return
     */
    public int getBarrower() {
        return barrower;
    }

    /**
     * Kitap sahibini set eder.
     * @param barrower user id.
     */
    public void setBarrower(int barrower) {
        this.barrower = barrower;
    }
}