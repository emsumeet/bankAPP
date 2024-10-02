import java.util.Scanner;

public class ATM
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        bank thebank = new bank("Bank of America");

        User aUser = thebank.addUser("Sumeet", "Varghade", "1224");

        Account newAccount = new Account("Checkings", aUser, thebank);
        aUser.addAccount(newAccount);
        thebank.addAccount(newAccount);

        User curUser;
        while (true) {
            curUser = ATM.mainMenuPrompt(thebank, sc);
            ATM.printUserMenu(curUser, sc);
            
        }
    }

    public static User mainMenuPrompt(bank thebank, Scanner sc)
    {
        String userID;
        String pin;
        User authUser;

        do{
            System.out.printf("Welcome to %s\n", thebank.getName());
            System.out.printf("Enter user ID");
            userID = sc.nextLine();
            System.err.println("Enter pin");
            pin = sc.nextLine();

            authUser = thebank.userLogin(userID, pin);
            if(authUser == null)
            {
                System.out.printf("Incorrect UserID or pin" + "please try again");

            }
        } 
        while(authUser == null);

        return authUser;
    }

    public static void printUserMenu(User theUser, Scanner sc)
    {
        theUser.printAccountSummary();

        int choice;
        do{
            System.out.printf("Welcome %s, what would you like to do", theUser.getfirstname());
            System.out.println("1) show acc trasaction history");
            System.out.println("2) withdraw");
            System.out.println("3) deposit");
            System.out.println("4) transfer");
            System.out.println("5) exit");
            System.out.println();
            System.out.println("Enter your choice");
            choice = sc.nextLine();

            if (choice < 1 || choice>5)
            {
                System.out.println("Invalid choice");

            }
        } while (choice <1 || choice>5);


        switch (choice)
        {
            case 1:
                ATM.showTransHistory(theUser, sc);
                break;
            case 2:
                ATM.withdrawFunds(theUser, sc);
                break;
            case 3:
                ATM.depositFunds(theUser, sc);
                break;
            case 4:
                ATM.transferFunds(theUser, sc);
                break;
        }

        if (choice !=5)
        {
            ATM.printUserMenu(theUser, sc);
        }
    }

    public static void showTransHistory(User theUser, Scanner sc)
    {
        int theAcct;
        do{
            System.out.printf("enter the numer (1-%d) of the accounts" + 
                    " whose transcations you want to see:", theUser.numAccount() );

            theAcct = sc.nextInt()-1;
            if( theAcct <0 || theAcct >= theUser.numAccount())
            {
                System.out.println(" invalid account");

            }
        } while (theAcct< 0 || theAcct >= theUser.numAccount());

        theUser.printAccountSummary(theAcct);
    }

    public static void transferFunds(User theUser, Scanner sc)
    {
        int fromAcct;
        int toAcct;
        double amount;
        double acctBal;


        do{
            System.out.println("enter the number (1-%d) of the account" + 
                                    "to transfer from:");
            fromAcct = sc.nextInt() -1 ;
            if (fromAcct <0 || fromAcct >=theUser.numAccount())
            {
                System.out.println(" invalid account");
            }
        }while (fromAcct< 0 || fromAcctAcct >= theUser.numAccount());

        acctBal= theUser.getAcctBalance(fromAcct);
        //
        do{
            System.out.println("enter the number (1-%d) of the account" + 
                                    "to transfer to:");
            toAcct = sc.nextInt() -1 ;
            if (toAcct <0 || toAcct >=theUser.numAccount())
            {
                System.out.println(" invalid account");
            }
        }while (toAcct< 0 || toAcctAcct >= theUser.numAccount());
        
        //
        do{
            System.out.println("enter the amount to transfer (max $%0.2f): $", acctBal);
            amount =sc.nextDouble();
            if (amount<0 )
            {
                System.out.println(" amoumt must be greater than zero");
            } else if( amount > acctBal) {
                System.out.println("amount must not be greater than" + "balance of $%0.2f" , acctBal);
            }
        }while(amoumt < 0 || amoumt > acctBal);

        theUser.addAccountTransaction(fromAcct, -1*amoumt, String.format("tranfer to account %s", 
                                                theUser.getAcctUUID(toAcct)));
                                                
        theUser.addAccountTransaction(toAcct, amoumt, String.format("tranfer to account %s", 
                                                theUser.getAcctUUID(fromAcct)));
    }

    public static void withdrawFunds(User thUser, Scanner sc) 
    {
        int fromAcct;
        
        double amount;
        double acctBal;
        String memo;

        do{
            System.out.println("enter the number (1-%d) of the account" + 
                                    "to transfer from:");
            fromAcct = sc.nextInt() -1 ;
            if (fromAcct <0 || fromAcct >=theUser.numAccount())
            {
                System.out.println(" invalid account");
            }
        }while (fromAcct< 0 || fromAcctAcct >= theUser.numAccount());

        acctBal= theUser.getAcctBalance(fromAcct);


        //
        do{
            System.out.println("enter the amount to transfer (max $%0.2f): $", acctBal);
            amount =sc.nextDouble();
            if (amount<0 )
            {
                System.out.println(" amoumt must be greater than zero");
            } else if( amount > acctBal) {
                System.out.println("amount must not be greater than" + "balance of $%0.2f" , acctBal);
            }
        }while(amoumt < 0 || amoumt > acctBal);

        sc.nextLine();
        System.out.println("emter a memo");
        memo = sc.nextLine();

        theUser.addAccountTransaction(fromAcct, -1*amount, memo); 
    }

    public static void depositFunds(User thUser, Scanner sc)
    {
        int toAcct;
        
        double amount;
        double acctBal;
        String memo;

        do{
            System.out.println("enter the number (1-%d) of the account" + 
                                    "to transfer from:");
            toAcct = sc.nextInt() -1 ;
            if (toAcct <0 || toAcct >=theUser.numAccount())
            {
                System.out.println(" invalid account");
            }
        }while (toAcct< 0 || toAcct >=theUser.numAccount());

        acctBal= theUser.getAcctBalance(toAcct);


        //
        do{
            System.out.println("enter the amount to transfer (max $%0.2f): $", acctBal);
            amount =sc.nextDouble();
            if (amount<0 )
            {
                System.out.println(" amoumt must be greater than zero");
            } else if( amount > acctBal) {
                System.out.println("amount must not be greater than" + "balance of $%0.2f" , acctBal);
            }
        }while(amoumt < 0 || amoumt > acctBal);

        sc.nextLine();
        System.out.println("emter a memo");
        memo = sc.nextLine();

        theUser.addAccountTransaction(toAcct, amount, memo); 
    }


}