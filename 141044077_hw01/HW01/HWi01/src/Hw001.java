import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * ~ Simple Library Automation ~
 * 
 * Student Number 141044077
 * @author Mustafa BİNGÜL
 */
public class Hw001 {
    
    private static final String USERFILENAME="mem.csv";
    private static final String BOOKFILENAME="book.csv";
    
    private static User[] users;
    private static Staff staff;
    private static Book[] books;
    
    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        
        //kontrolll. bos dolu kontorll
        readCsvMemberFile();
        readCsvBookFile();
        
                
        Scanner scan = new Scanner(System.in);
        String userID = null;
        String password = null;
        boolean flag=true;
        
        System.out.println("    ~ WELCOME TO LIBRARY AUTOMATION ~   ");
        while(flag){
            System.out.println("User ID:");
            userID=scan.next();

            System.out.println("Password:");
            password=scan.next();

            switch(findUser(Integer.parseInt(userID),password)){
                case 1: modStaff();
                flag=false;
                break ;
                case 2: modUsers(userID);
                flag=false;
                break ;
                case 0: System.out.println("Access Denied.");
            }
        }
        writeCsvBookFile();
        writeCsvMemberFile();
        System.out.println("Good Byee.");
        
    }

    /**
     * Verilen id e gore kitap durumu yok olarak degisir.
     * @param bookID
     */
    public static void receiptedBook(int bookID){
        for (int i=0; i<books.length; ++i){

            if(books[i]!=null){
                if(books[i].getBookId()==bookID){
                    books[i].setStatus(false);
                }
            }

        }
    }
    /**
     * Verilen id e gore kitap durumu var olarak degisir.
     * @param bookID
     */
    public static void deliveryBook(int bookID){        
        books[bookID].setStatus(true);    
    }
    
    /**
     * Kullanici moduna girer.
     * @param USERID
     */
    public static void modUsers(String USERID){
    
        boolean flag=true;
        staff.setUsers(users);
        staff.setBooks(books);
        Scanner scan=new Scanner(System.in);
        while(flag){    
            System.out.println(users[Integer.parseInt(USERID)].getMemberName());
            int choo=0; 
            users[Integer.parseInt(USERID)].Menu();
            System.out.println("Enter choice:");
            choo=scan.nextInt();
            switch(choo){
                case 1:
                    System.out.println("My Books:");
                    listHavingBook(Integer.parseInt(USERID));
                    break ;
                case 2:
                    listBorrowingWillBook();
                    System.out.println("Select a book Id:");
                    int bookChooID = scan.nextInt();
                    if(findBook(bookChooID) && users[Integer.parseInt(USERID)].borrowBook(bookChooID)){
                        receiptedBook(bookChooID);
                        System.out.println("Book Borrowed.");
                    }
                    else{
                        System.out.println("Did not borrowed.");
                    }
                    break ;
                case 3:
                    listHavingBook(Integer.parseInt(USERID));
                    System.out.println("Select a book Id:");
                    int bookChooID2 = scan.nextInt();
                    if(users[Integer.parseInt(USERID)].returnBook(bookChooID2)){
                        deliveryBook(bookChooID2);
                        System.out.println("Book Returned.");
                    }
                    else{
                        System.out.println("Did not Returned.");
                    }
                    break ;
                case 4:
                    flag=false;
                    break ; 
            }
        }
    }

    /**
     * Admin moduna girer. Tek admin vardir.
     */
    public static void modStaff() throws IOException{
    
        boolean flag=true;
        staff.setUsers(users);
        staff.setBooks(books);
        Scanner scan=new Scanner(System.in);
        while(flag){
            System.out.println("");
            System.out.println("Admin:"+staff.getMemberName());
            int choo=0; 
            staff.Menu();
            System.out.println("Enter choice:");
            choo=scan.nextInt();
            switch(choo){
                case 1:
                    System.out.println("Username - Password");
                    if(staff.addUser(scan.next(),scan.next())){
                        System.out.println("Added.");
                    }
                    else
                        System.out.println("Did not Add.");
                    break ;
                case 2:
                    staff.listAcc();
                    System.out.println("Enter User ID:");
                    if(staff.deleteUser(scan.nextInt())){
                        System.out.println("User Deleted.");
                    }
                    else
                        System.out.println("There is no such a User.");
                    break ;
                case 3:
                    staff.listAcc();
                    break ;
                case 4:
                    staff.listBook();
                    break ;
                case 5:
                    System.out.println("Book Name - Author");
                    if(staff.addBook(scan.next(),scan.next())){
                        System.out.println("Added.");
                    }
                    else
                        System.out.println("Did not Add.");
                    break ;
                    
                case 6:
                    staff.listBook();
                    System.out.println("Enter Book ID:");
                    int bookID2 = scan.nextInt();
                    if(staff.deleteBook(bookID2)){
                        System.out.println("Book Deleted.");
                    }
                    else
                        System.out.println("Book is not Deleted.");
                    break ;
                case 7:
                    flag=false;
                    break ;
            }
        }
    }
    
    /**
     * Kullaciyi dogrular ve girisi saglar.
     * @param id
     * @param password
     * @return 
     */
    public static int findUser(int id,String password){
        Member mem = staff;
        
            try{
                if(staff!= null && mem.getMemberID()==id && mem.getPassword().contentEquals(password)){
                    return 1;
                }
            }
            catch(Exception e){
                System.err.println(e.toString());
            }
            
        for(int i=0; i<users.length; ++i){
            mem = users[i];
            try{
                if(users[i]!= null && mem.getMemberID()==id && mem.getPassword().contentEquals(password)){
                    return 2;
                }
            }
            catch(Exception e)
            {
                System.err.println(e.toString());
            }
        }
        return 0;
    }
    
    /**
     * Tabloda uygun kitap olup olmadigina bakar.
     * @param bookid
     * @return 
     */
    public static boolean findBook(int bookid){    
        for (int i = 0; i < books.length; i++){
            if(books[i]!=null && books[i].getBookId()==bookid && books[i].getStatus()==true){
                return true;
            }
            else if(books[i]==null){
                return false;
            }
        }
        return false;
    }

    /**
     * Kutuphaneye ait memberlari arrayda tutar.(ArrayList yasak diye kullanmamıstim.)
     * Veriler mem.csv dosyasından alinmaktadir.
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void readCsvMemberFile() throws FileNotFoundException, IOException {
        
        String COMMA = ";";        
        BufferedReader fileReader = null;        
        try {                   
            String line = "";            
            fileReader = new BufferedReader(new FileReader(USERFILENAME));
            int count=1;





            line = fileReader.readLine();

            if(line==null){return;}
            String[] toks=line.split(COMMA);

            users = new User[200];
            staff=new Staff(toks[1],toks[2]);
                while ((line = fileReader.readLine()) != null) {
                 
                    String[] tok = line.split(COMMA);                        
                    users[count]=new User(Integer.parseInt(tok[0]),tok[1],tok[2]);
                    for(int i = 3; i < tok.length; ++i){
                        users[count].setBookid(-1);
                        users[count].addBookID(Integer.parseInt(tok[i]));
                        
                    }
                    //doğgru okunuyor
                    /*System.out.println(users[count].getMemberID()+" - - "+
                                        users[count].getMemberName()+" - - "+
                                        users[count].getPassword()+" - - "+
                                        users[count].bookIDs[0]+"/"+users[count].bookIDs[1]+"/");
                    */
                    count++;
                }
        }        
        catch(IOException | NumberFormatException q){
            System.err.println(q.toString());
        }
        //fileReader.close();
    }

    /**
     * Kitaplari bir arrayda tutar.
     * Kitap verilerini book.csv dosyasindan alinmaktadir.
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static boolean readCsvBookFile() throws FileNotFoundException, IOException
   {
        boolean flag=false;
        String COMMA = ";";        
        BufferedReader fileReader = null;        
        try{        
            
            String line = "";            
            fileReader = new BufferedReader(new FileReader(BOOKFILENAME));
            int count=0;
            books = new Book[200];
                        
            while ((line = fileReader.readLine()) != null) {
                String[] tok = line.split(COMMA);
                if(tok.length==5){
                    books[count]=new Book(Integer.parseInt(tok[0]),tok[1],tok[2],(tok[3].charAt(0) == 't'),Integer.parseInt(tok[4]));
                }
                else
                    books[count]=new Book(Integer.parseInt(tok[0]),tok[1],tok[2],(tok[3].charAt(0) == 't'));                
                flag=true;
                count++;
            }
        }
        catch(IOException | NumberFormatException q){
            System.err.println(q.toString());
        }
        //fileReader.close();
        return flag;
    }
    
    /**
     * Kullanicinin sahip oldugu kitaplari gösterir.
     * @param userid
     */
    public static void listHavingBook(int userid){
        
        System.out.println("Book ID - Book Name - Author");
        int a[]=users[userid].returBookID();
        Book book ;
        for (int i = 0; i <users[userid].count; i++) {
            if(a[i]!=-1)
            {
                book = foundByBookId(a[i]);

                System.out.println(a[i] + " - "+book.getBookName()+" - "+book.getAuthor());
            }
        }
    }

    public static Book foundByBookId(int bookid){

        for (int i=0; i<books.length;++i){

            if (books[i]!=null && books[i].getBookId()==bookid){

                return books[i];

            }

        }
        return null;

    }

    /**
     * Kullanicinin alabilecegi kitaplari gösterir.
     */
    public static void listBorrowingWillBook(){
    
        System.out.println("Book ID - Book Name - Author");
        for (int i = 0; i < books.length; i++) {
            if(books[i]!=null && books[i].getStatus()==true)                
                System.out.println(books[i].getBookId()+" - "+
                                   books[i].getBookName()+" - "+
                                   books[i].getAuthor());
        }
    }
    
    /**
     * Kitaplari gosterir.
     */
    public static void shwBooks(){   
        for (int i = 0; i < 2; i++) {
            System.out.println(books[i].getBookId()+"**"+
                               books[i].getBookName()+"**"+
                               books[i].getAuthor()+"**"+
                               books[i].getStatus()+"**"+
                               books[i].getBarrower());
        }        
    }
    /**
     * Kullanicilari gosterir.
     */
    public static void shwUsers(){    
        for (int i = 0; i < 7; i++) {
            users[i].shwbookID();
        }
    }
    
    /**
     * Kitaplari dosyaya yazar.
     * Kitap verilerini book.csv dosyasina yazar..
     * @throws IOException
     */
    public static void writeCsvBookFile() throws IOException{
        int flag=0;
        FileWriter fileWriter = null;        
        try{        
            
            fileWriter = new FileWriter(new File(BOOKFILENAME));
            PrintWriter pw=new PrintWriter(fileWriter);
            StringBuilder sb = new StringBuilder();
            if(books[0]==null){

                sb.append(0);
                sb.append(";");
                sb.append("Tutunamayanlar");
                sb.append(";");
                sb.append("Oğuz");
                sb.append(";");
                sb.append("true");
                sb.append(";");
                sb.append(0);
                sb.append('\n');
                flag=1;

            }

            for (int i = flag; i < books.length; i++) {
                if(books[i]!=null){
                    sb.append(books[i].getBookId());
                    sb.append(";");
                    sb.append(books[i].getBookName());
                    sb.append(";");
                    sb.append(books[i].getAuthor());
                    sb.append(";");
                    sb.append(books[i].getStatus() ? true: false);
                    sb.append(";");
                    sb.append(books[i].getBarrower()==' '?' ':books[i].getBarrower());
                    sb.append('\n');
                }


            }
            fileWriter.write(sb.toString());
            fileWriter.close();
        }
        catch(IOException | NumberFormatException q){
            System.err.println(q.toString());
        }
               
    
    }
    /**
     * Memberlari dosyaya yazar.
     * Member verilerini mem.csv dosyasina yazar..
     */
    public static void writeCsvMemberFile(){
        FileWriter fileWriter = null;        
        try{        
            
            fileWriter = new FileWriter(new File(USERFILENAME)); 
            PrintWriter pw=new PrintWriter(fileWriter);
            fileWriter.write(0+";"+"Mustafa"+";"+"123");
            pw.println("");
            for (int i = 1; i < users.length && users[i]!=null; i++) {
                int a[]=users[i].returBookID();
                int c=users[i].count;
                int t=users[i].getMemberID();
                fileWriter.write(new Integer(t).toString());
                fileWriter.write(";");
                fileWriter.write(users[i].getMemberName());
                fileWriter.write(";");
                fileWriter.write(users[i].getPassword());
                for (int j = 0; j < c; j++) {
                    if(a[j]!=' '){
                        fileWriter.write(";"+a[j]);
                    }                    
                }                
                pw.println("");
                
            }
            pw.close();
            fileWriter.close();
        }
        catch(IOException | NumberFormatException q){
            System.err.println(q.toString());
        }   
    }
}
