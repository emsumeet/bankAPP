import java.util.ArrayList;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User 
{
    private String firstname;

    private String lastname;
     
    private String uuid;

    private byte pinHash[]; //MD5 Hashing algo

    private ArrayList<Account> accounts;   //import ArrayList

    public User(String firstname, String lastname, String pin, bank thebank)
    {
        this.firstname = firstname;
        this.lastname = lastname;
        try
        {
        MessageDigest md = MessageDigest.getInstance("MD5");
        this.pinHash = md.digest(pin.getBytes());
        } catch (NoSuchAlgorithmException e) 
           {
            System.err.println("error, caught NoSuchALogorithmException");
            e.printStackTrace();
            System.exit(1);
           }

        this.uuid = thebank.getNewUserUUID();

        this.accounts = new ArrayList<Account>();

        System.out.printf("New User %s, %s with ID %s created. \n", lastname, firstname, this.uuid);


    }

    public void addAccount(Account anAcct)
    {
        this.accounts.add(anAcct);
    }

    public String getUUID()
    {
        return this.uuid;
    }

    public boolean validatePin(String aPin)
    {
        try
        {
        MessageDigest md = MessageDigest.getInstance("MD5");
        return MessageDigest.isEqual(md.digest(aPin.getBytes()), this.pinHash);
        } catch (NoSuchAlgorithmException e) 
           {
            System.err.println("error, caught NoSuchALogorithmException");
            e.printStackTrace();
            System.exit(1);
           }

           return false;
    }

    public String getfirstname()
    {
        return this.firstname;
    }

    public String printAccountSummary()
    {
        System.out.printf("%s' s accout summary", this.firstname);
        for (int a =0; a < this.accounts.size(); a++)
        {
        System.out.printf("%d %s", a+1 ,this.accounts.get(a).getSummaryLine());
        }
                return firstname;
    }

    public int numAccount()
    {
        return this.accounts.size();
    }

    public void printAccountTransHistory(int acctIdx)
    {
        this.accounts.get(acctIdx).printAccountTransHistory();

    }


    public double getAccontBalance(int acctIdx) 
    {
        return this.accounts.get(acctIdx).getBalance();
    }

    public String getAcctUUID(int acctIdx)
    {
       return this.accounts.get(acctIdx).getUUID(); 
    }

    public void addAcctTransaction(int acctIdx, double amount, String memo)
    {
        this.accounts.get(acctIdx).addTransaction(amount, memo);
    }

}