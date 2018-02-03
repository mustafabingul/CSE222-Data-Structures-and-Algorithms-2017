/**
 * ~ Simple Library Automation ~
 * Member Abstract Class
 * 
 * Student Number 141044077
 * @author Mustafa BİNGÜL
 */
public abstract class Member {
    
    private int memberID;
    private String memberName;
    private String password;   
    
    /**
     * Constructer.
     */
    public Member(){
        this(0,null,null);
    }

    /**
     * Constructer.
     * @param memberID
     * @param memberName
     * @param password
     */
    public Member(int memberID,String memberName, String password){
    
        this.memberID=memberID;
        this.memberName=memberName;
        this.password=password;
    }

    /**
     * Menu fonksiyonu.
     */
    public void Menu(){}

    /**
     * Member id return eder.
     * @return
     */
    public int getMemberID() {
        return memberID;
    }

    /**
     * Member id set eder.
     * @param memberID
     */
    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    /**
     * Member name return eder.
     * @return
     */
    public String getMemberName() {
        return memberName;
    }

    /**
     * Member name set eder.
     * @param memberName
     */
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    /**
     * Member password return eder.
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * Member password set eder.
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }  
}