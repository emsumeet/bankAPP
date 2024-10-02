import java.util.Date;


public class transaction 
{
    private double amount;

    private Date timestamp;

    private String memo;

    private account inAccount;

    public transaction(double amount, Account inAccount)
    {
        this.amount= amount;
        this.inAccount = inAccount;
        this.timestamp = new Date();
        this.memo = "";
    }

    public transaction(double amount, String memo, Account inAccount)
    {
        this(amount, inAccount);  //calling the transcation contructor here
        this.memo = memo;
    }

    public double getAmount()
    {
        return this.amount;
    }

    public String getSummaryLine()
    {
        if (this.amount >=0)
        {
            return String.format("%s : $%0.2f : %s", this.timestamp.toString(), 
                                    this.amount, this.memo);
        }
        else{
            return String.format("%s : $(%0.2f ): %s", this.timestamp.toString(), 
            this.amount, this.memo);
        }
    }

    
}