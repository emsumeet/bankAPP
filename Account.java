import java.util.ArrayList;

public class Account
{
    private String name;

    //private double balance;

    private String uuid;

    private User holder;

    private ArrayList<transaction> transaction;

    public Account(String name, User holder, bank thebank)
    {
        this.name = name;
        this.holder = holder;

        this.uuid= thebank.getNewAccountUUID();

        this.transaction = new ArrayList<transaction>();


    }

    public String getUUID()
    {
        return this.uuid;
    }

    public String getSummaryLine()
    {
        double balance = this.getBalance();

        if(balance>=0)
        {
            return String.format("%s: $%.02f: %s",this.uuid, balance, this.name);
        }
        else{
            return String.format("%s: $(%.02f): %s",this.uuid, balance, this.name);
        }
    }
    
    public double getBalance()
        {
            double balance = 0;
            for(transaction t: this.transaction)
            {
                balance += t.getAmount();
            }

            return balance;
        }
    
        public void  printTransHistory()
        {
            System.out.println("trans history foor acc %s", this.uuid);
            for(int t= this.transaction.size()-1; t>=0 ;t--)
            {
                System.out.println(this.transaction.get(t).getSummaryLine());
            }
            System.out.println();
        }


        public void addTransaction(double amount, String memo)
        {
            Transaction newTrans = new Transaction(amount, memo, this);
            this.transaction.add(newTrans);
        }


        public void printAccountTransHistory() {
            for (Transaction t : this.transactions) {
                System.out.println(t.getSummaryLine());
            }
        }
        



}