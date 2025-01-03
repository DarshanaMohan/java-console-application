import java.util.ArrayList;// Importing the ArrayList class to store a list of transactions for the user.

public class User// Defining the User class
{
    private static String user_id ;// Static field for user_id
    private String user_pass;// Instance field for user_pass
    private static int balance;// Static field for balance
    private static ArrayList<Transaction> usertransaction;// Static field to store a list of transactions for the user

    // Constructor to initialize the User object with user_id, user_pass, and balance
    public User(String user_id,String user_pass,int balance)
    {
        this.user_id=user_id;    // Assigning the provided user_id to the static field
        this.user_pass=user_pass; // Assigning the provided user_pass to the instance field
        this.balance=balance;// Assigning the provided balance to the static field
        this.usertransaction = new ArrayList<>();// Initializing the usertransaction list as a new ArrayList

    }

    public static String getUser_id()// Static method to get the user_id
    {
        return user_id;
    }
    public void setUser_id(String user_id)// Instance method to set user_id
    {
        this.user_id=user_id;
    }

    public String getUser_pass()// Instance method to get user_pass
    {
        return user_pass;
    }

    public void setUser_pass(String user_pass)// Instance method to set user_pass
    {
        this.user_pass=user_pass;
    }

    public static int getbalance()// Static method to get the balance
    {
        return balance;
    }

    public static void setbalance(int balance)// Static method to set the balance
    {
         balance=balance;
    }

    public static ArrayList<Transaction> getUsertransaction(){// Static method to get the list of transactions for the user
        return usertransaction;
    }

    public void addTransaction(String accountID,int amount,String transactionType) { // Instance method to add a transaction to the list of transactions for this user
        Transaction transaction=new Transaction(accountID,amount,transactionType);// Creating a new Transaction object
        usertransaction.add(transaction); // Adding the new transaction to the static usertransaction list
    }


}
