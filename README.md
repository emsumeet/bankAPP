ATM Application

Overview
The ATM Application simulates a banking system where users can manage their accounts, perform transactions (withdraw, deposit, transfer), and view their transaction history. 
The application is designed using Java and follows an object-oriented programming paradigm.

Features
User login with unique user IDs and PINs
Account management (Create, View, Withdraw, Deposit, Transfer)
Transaction history for each account

Prerequisites
Before running the application, ensure you have the following installed:
Java Development Kit (JDK) (version 11 or higher)
A suitable IDE or text editor (e.g., IntelliJ IDEA, Eclipse, or Visual Studio Code)

Running the Application

Step 1: Clone the Repository
bash

//Copy code

git clone https://github.com/emsumeet/bankAPP.git

cd bankAPP

Step 2: Compile the Java Files
Ensure you have all the necessary Java files in the same directory. The essential files are:
ATM.java
Account.java
Bank.java
Transaction.java
User.java

Compile the files using the following command:
bash

//Copy code

javac *.java

Step 3: Run the Application
After compiling, you can run the ATM class to start the application:
bash

//Copy code

java ATM

Step 4: Interacting with the Application

Upon starting, you will be prompted to enter your user ID and PIN to log in.
If the credentials are correct, you can choose from various options, such as viewing account transactions, withdrawing money, depositing money, and transferring funds.
Follow the on-screen prompts to complete each action.


Code Flow Explanation

Main Class (ATM.java):
The main entry point of the application.
Initializes the bank and creates a default user and account.
Displays the main menu and handles user input for various banking operations.

User Login:
Prompts the user for their ID and PIN.

Validates the credentials using the userLogin method from the Bank class.

User Menu:
Displays the user's account summary and options for transactions.

Calls specific methods (showTransHistory, withdrawFunds, depositFunds, transferFunds) based on user selection.

Transaction Methods:

Show Transaction History: Displays all transactions for a selected account.

Withdraw Funds: Allows the user to withdraw money from their account, validating available balance and recording the transaction.

Deposit Funds: Similar to withdrawal but adds money to the selected account.

Transfer Funds: Facilitates transferring money between accounts, ensuring sufficient balance before processing.

Transaction Management:
Each transaction (withdrawal, deposit, transfer) is recorded with a description using the addAccountTransaction method, which updates the account's transaction history.

Conclusion
This ATM application serves as a basic simulation of banking operations and demonstrates object-oriented principles, including encapsulation, inheritance, and polymorphism. 
It can be extended further to include additional features, such as user registration, improved security measures, and a graphical user interface (GUI).

Feel free to contribute or enhance the functionality as needed!

