import java.util.ArrayList;
import java.util.Random;

public class bank
{
    private String name;

    private ArrayList<User> user;

    private ArrayList<Account> account;

    public bank(String name)
    {
        this.name = name;
        this.account = new ArrayList<Account>();
        this.user = new ArrayList<User>();
    }

    public String getNewUserUUID()
    {
        String uuid;
        Random rng = new Random();
        int len =6;
        boolean nonUnique;  //flag

        do{ 
            uuid = "";
            for (int c = 0; c< len;  c++)
            {
                uuid += ((Integer)rng.nextInt(10)).toString();
            }

            nonUnique = false;
            for (User u : this.user)
            {
                if (uuid.compareTo(u.getUUID())==0)
                {
                    nonUnique= true;
                    break;
                }
            }

        }while (nonUnique);

        return uuid;
    }

    public String getNewAccountUUID()
    {
        String uuid;
        Random rng = new Random();
        int len =10;
        boolean nonUnique;  //flag

        do{ 
            uuid = "";
            for (int c = 0; c< len;  c++)
            {
                uuid += ((Integer)rng.nextInt(10)).toString();
            }

            nonUnique = false;
            for (Account a : this.account)
            {
                if (uuid.compareTo(a.getUUID())==0)
                {
                    nonUnique= true;
                    break;
                }
            }

        }while (nonUnique);

        return uuid;
    }

    
    public void addAccount(Account anAcct)
    {
        this.account.add(anAcct);
    }


    public User addUser(String firstname, String lastname, String pin)
    {
       User newUser = new User(firstname, lastname, pin, this); 
       this.user.add(newUser);

       Account  newAccount = new Account("Savings", newUser, this);
       newUser.addAccount(newAccount);
        this.addAccount(newAccount);

        return newUser;
    }

    public User userLogin(String userID, String pin)
    {
        for (User u: this.user)
        {
            if(u.getUUID().compareTo(userID) == 0 && u.validatePin(pin))
            {
                return u;
            }
        }
        return null;
    }

    public String getName()
    {
        return this.name;
    }
}