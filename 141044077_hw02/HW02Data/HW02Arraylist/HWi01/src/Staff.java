import java.util.ArrayList;

/**
 * ~ Simple Library Automation ~
 * Staff Objects.
 * 
 * Student Number 141044077
 * @author Mustafa BİNGÜL
 */
public class Staff extends Member implements StaffProperty
{
    private ArrayList<User> users;
    private ArrayList<Book> books;

    /**
     * Kullanici set eder.
     * @param users user array.
     */
    public void setUsers(ArrayList users) {
        this.users = users;
    }

    /**
     * Kitap set eder.
     * @param books book array.
     */
    public void setBooks(ArrayList books) {
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
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i)!=null && users.get(i).getMemberID()==Id){
                users.remove(i);
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
        for (int i = 0; i < books.size(); i++) {
            if(books.get(i)!=null)
                System.out.println(books.get(i).getBookId()+" - "+
                                   books.get(i).getBookName()+" - "+
                                   books.get(i).getAuthor()+" - "+
                                   ((books.get(i).getStatus()==true)?"Available":"Not available"));
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
        for (int i = 1; i < users.size(); i++) {
            if(users.get(i)!=null){
                lastId=users.get(i).getMemberID();
                lastindex=i;
            }
        }
        if(lastindex==199){
            return false;
        }
        users.add(lastindex+1,new User(lastId+1,Name,Pass));
        return true;
    }

    /**
     * Kitap siler.
     * @param Id book id.
     * @return true or false.
     */
    @Override
    public boolean deleteBook(int Id) {
        //System.out.println("delbaş       "+System.currentTimeMillis());
        for (int i = 0; i < books.size(); i++){
            if(books.get(i)!=null && books.get(i).getBookId()==Id && books.get(i).getStatus()==true){
                books.remove(i);
                //System.out.println("delbit       "+System.currentTimeMillis());
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
        for (int i = 1; i < users.size(); i++) {
            if(users.get(i)!=null)
                //lisele tüm id li litapları
                System.out.println(users.get(i).getMemberID()+" - "+users.get(i).getMemberName());
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
        //System.out.println("addbaş       "+System.currentTimeMillis());
        int lastId=0;
        int lastindex=0;
        for (int i = 0; i < books.size(); i++) {
            if(books.get(i)!=null){
                lastId=books.get(i).getBookId();
                lastindex=books.lastIndexOf(books.get(i));
            }
        }
        if(lastindex==199){
            return false;
        }
        books.add(lastindex+1,new Book(lastId+1,name,author,true,-1));
        //System.out.println("addbit       "+System.currentTimeMillis());
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