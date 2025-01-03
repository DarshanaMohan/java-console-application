import java.util.ArrayList;

public class Admin// Defining the Admin class
{
    private String admin_id;// Private variable to store the admin ID
    private String admin_pass;  // Private variable to store the admin password
    public static ArrayList<Transaction> admintransaction;// Static ArrayList to store all transactions performed by the admin

    // Constructor to initialize admin details (ID, password, and transaction list)
    public Admin(String admin_id,String admin_pass,int balance)
    {
        this.admin_id=admin_id; // Set the admin's ID to the passed parameter
        this.admin_pass=admin_pass;// Set the admin's password to the passed parameter
        this.admintransaction = new ArrayList<>();// Initialize the admintransaction list
    }

    // Default constructor for creating an Admin object
    public Admin() {

    }

    // Getter method to return the admin's ID
    public String getAdmin_id()
    {
        return admin_id;
    }

    // Getter method to return the admin's password
    public String getAdmin_pass()
    {
        return admin_pass;
    }

    // Getter method to return the list of transactions
    public ArrayList<Transaction> getAdmintransaction() {
        return admintransaction;
    }

    // Method to add a transaction to the admin's transaction list
    public void addTransaction(Transaction transaction) {
        admintransaction.add(transaction);
    }

}
