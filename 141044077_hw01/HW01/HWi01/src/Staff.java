/**
 * ~ Simple Library Automation ~
 * Staff Objects.
 * 
 * Student Number 141044077
 * @author Mustafa BİNGÜL
 */
public class Staff extends Member implements StaffProperty
{
    private User[] users;
    private Book[] books;

    /**
     * Kullanici set eder.
     * @param users user array.
     */
    public void setUsers(User[] users) {
        this.users = users;
    }

    /**
     * Kitap set eder.
     * @param books book array.
     */
    public void setBooks(Book[] books) {
        this.books = books;
    }
    
    /**
     * Constructer.
     * @param memberName member name.
     * @param password member password.
     */
    public Staff(String memberName, String password) {
        super(0,memberName, password);
    }

    /**
     * Kullanici siler.
     * @param Id kullanici id.
     * @return true or false.
     */
    @Override
    public boolean deleteUser(int Id) {        
        for (int i = 0; i < users.length; i++) {            
            if(users[i]!=null && users[i].getMemberID()==Id){            
                users[i]=null;
                return true;
            }
        }
        return false;
    }
    
    /**
     * Kitaplari listeler.
     */
    public void listBook(){
    
        System.out.println("Book ID - Book Name - Author - Status");
        for (int i = 0; i < books.length; i++) {
            if(books[i]!=null)                
                System.out.println(books[i].getBookId()+" - "+
                                   books[i].getBookName()+" - "+
                                   books[i].getAuthor()+" - "+
                                   ((books[i].getStatus()==true)?"Available":"Not available"));
        }        
    }
    
    /**
     * User ekler.
     * @param Name user name.
     * @param Pass user password.
     * @return true or false.
     */
    @Override
    public boolean addUser(String Name,String Pass) {
        int lastId=0;
        int lastindex=0;                
        for (int i = 1; i < users.length; i++) {
            if(users[i]!=null){
                lastId=users[i].getMemberID();
                lastindex=i;
            }
        }
        if(lastindex==199){
            return false;
        }
        users[lastindex+1]=new User(lastId+1,Name,Pass);
        return true;
    }

    /**
     * Kitap siler.
     * @param Id book id.
     * @return true or false.
     */
    @Override
    public boolean deleteBook(int Id) {
        for (int i = 0; i < books.length; i++){            
            if(books[i]!=null && books[i].getBookId()==Id && books[i].getStatus()==true){            
                books[i]=null;
                return true;
            }
        }
        return false;
    }
    
    /**
     * Member lari listeler.
     */
    public void listAcc(){
        System.out.println("User ID - User Name");
        for (int i = 0; i < users.length; i++) {
            if(users[i]!=null)
                //lisele tüm id li litapları
                System.out.println(users[i].getMemberID()+" - "+users[i].getMemberName());
        }    
    }

    /**
     * Kitap ekler.
     * @param name book name.
     * @param author book author.
     * @return true or false.
     */
    @Override
    public boolean addBook(String name,String author) {
    
        int lastId=0;
        int lastindex=0;                
        for (int i = 0; i < books.length; i++) {
            if(books[i]!=null){
                lastId=books[i].getBookId();
                lastindex=i;
            }
        }
        if(lastindex==199){
            return false;
        }
        books[lastindex+1]=new Book(lastId+1,name,author,true,-1);
        return true;
    }

    /**
     * Staff Menu.
     */
    @Override
    public void Menu() {    
        System.out.println();
        System.out.println("************** MENU ***************");
        System.out.println("1- Add a new member                ");
        System.out.println("2- Delete a member                 ");
        System.out.println("3- List all accounts               ");
        System.out.println("4- List all books                  ");
        System.out.println("5- Add a Book                      ");
        System.out.println("6- Delete a book                   ");
        System.out.println("7- Exit                            ");
    }
}