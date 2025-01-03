import java.util.ArrayList;    // Importing ArrayList class to use in this class
import java.util.Arrays;       // Importing Arrays class to initialize notes list
import java.util.Scanner;      // Importing Scanner class for user input


public class ATM        // Main ATM class
{
    static Scanner sc = new Scanner(System.in);       // Scanner is declared static to allow direct access without creating an instance, used for user input
    private static ArrayList<Admin> admin = new ArrayList<>();   // List to store admin objects, static so it is shared among all instances of ATM
    private static ArrayList<User> user = new ArrayList<>();      // List to store user objects, static to share among all instances of ATM
    private static ArrayList<Notes>notes=new ArrayList<>(Arrays.asList(new Note2000(2000,0),new Note500(500,0),new Note200(200,0),new Note100(100,0)));     // Static list of notes initialized with note objects for denominations 2000, 500, 200, and 100

    private static ATM instance=null;   // Static variable to store the single instance of ATM


    private static double ATMbalance = 0.0;// Static variable to store ATM balance, shared among all instances of ATM


    private ATM(){}

    public static ATM getInstance()    // Static method to get the instance of ATM
    {
        if(instance==null){     // If instance is null, create a new one
            instance=new ATM();
        }
        return instance;     // Return the existing instance
    }

    public static ArrayList<Admin> getAdminArrayList() {
        return admin;      // Getter for the admin ArrayList
    }

    public static ArrayList<User> getUserArrayList() {
        return user;      // Getter for the user ArrayList
    }

    public static double getATMbalance()
    {
        return ATMbalance;    // Getter for ATM balance
    }
    public static void setATMbalance(double balance)
    {
        ATMbalance = balance;    // setter for ATM balance
    }

    public static ArrayList<Notes> getNotes() {
        return notes;       // Getter for the notes ArrayList
    }

    public static void setNotes(ArrayList<Notes> notes) {
        ATM.notes = notes;    // Setter for the notes ArrayList
    }

    // Main method to start the ATM application
    public static void start() throws CloneNotSupportedException{
        while (true) {        // Infinite loop to keep the ATM running until user chooses to exit
            System.out.println("Enter whether you are\n 1.ADMIN\n 2.CUSTOMER\n 3.EXIT\n");
            int ch = Integer.parseInt(sc.nextLine());    // Read user input for admin, customer, or exit option
            switch (ch) {       // Switch case to handle the user's choice
                case 1:
                    int a = Adminactions.admin_login();    //call the admin login method
                    if (a == 1) {
                        operation();    // Call the operation method if admin login is successful
                    } else if (a==-1) {
                        start();     // Restart the ATM application if login fails
                    }
                    break;

                case 2:
                    User loggedinuser = Useraction.user_login();    // Call the user login method
                    if (loggedinuser != null) {      // If user login is successful
                        operation1(loggedinuser); // Call operations available to the logged-in user
                    }
                    break;

                case 3:
                    System.out.println("Exiting...");// Exit the ATM application
                    return;
            }
        }
    }

    // Method for performing admin operations
    public static void operation() {
        int operation = 0;// Initialize operation variable
        while (operation != 5) {// Keep looping until user selects exit (operation 5)
            System.out.println("Enter your operation:\n 1.add user account\n 2.delete user account\n 3.deposit amount\n 4.view all transactions\n 5.exit");
            operation = Integer.parseInt(ATM.sc.nextLine());// Read operation choice from admin

            switch (operation) {// Switch case to handle admin operations
                case 1:
                    Adminactions.adduser();// Admin can add a user account
                    break;

                case 2:
                    Adminactions.deleteuser();// Admin can delete a user account
                    break;

                case 3:
                    Adminactions.depositamount(notes);// Admin can deposit amount into ATM
                    break;

                case 4:
                    Adminactions.viewAdminTransactionHistory();// Admin can view all transactions
                    break;


                case 5:
                    System.out.println("Exiting...!!!");// Exit the operation menu for admin
                    break;
            }
        }
    }

    // Method for performing user operations
    public static void operation1(User loggedinuser)throws CloneNotSupportedException {
        int operation = 0;// Initialize operation variable
        while (operation !=6) {// Keep looping until user selects exit (operation 6)
            System.out.println("Enter your operation:\n 1.check balance\n 2.withdraw cash\n 3.deposit cash\n 4.change pin\n 5.view transaction\n 6.exit\n");
            operation = Integer.parseInt(sc.nextLine());// Read operation choice from user

            switch (operation) {// Switch case to handle user operations
                case 1:
                    Useraction.check_balance();// User can check balance
                    break;

                case 2:
                    Scanner sc=new Scanner(System.in);// Create new scanner instance for user input
                    Useraction useraction=new Useraction();
                    Useraction.withdraw_cash(sc,notes);// User can withdraw cash
                    break;

                case 3:
                    Useraction.deposit_cash(loggedinuser,notes);// User can deposit cash
                    break;

                case 4:
                    Useraction.change_pin(loggedinuser); // Option for changing pin
                    break;

                case 5:
                    Useraction useraction1=new Useraction();
                    useraction1.transaction_history(loggedinuser);// User can view transaction history
                    break;

                case 6:
                    System.out.println("Exiting!!"); // Exit the operation menu for user
                    break;

                default:
                    System.out.println("Invalid operation");// Handle invalid operation
            }
        }
    }

    // Getter for the user ArrayList
    public static ArrayList<User> getuser_id()
    {
        return user; // Return the list of users
    }

    // Method for calculating the total deposit amount to the ATM
    public static double depositAmountToATM(Note2000 notes2000, Note500 notes500, Note200 notes200, Note100 notes100) {
        return notes2000.getNotes() * notes2000.getCount() +// Calculate the total amount for 2000 denomination
                notes500.getNotes() * notes500.getCount() +// Calculate the total amount for 500 denomination
                notes200.getNotes() * notes200.getCount() + // Calculate the total amount for 200 denomination
                notes100.getNotes() * notes100.getCount();// Calculate the total amount for 100 denomination
    }




}




