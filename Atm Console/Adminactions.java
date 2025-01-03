import java.util.ArrayList;
import java.util.Scanner;

public class Adminactions { //defining admin class
    static Scanner sc = new Scanner(System.in);// Creating a static Scanner object for user input

    public static int admin_login() {// Method for admin login
        ATM atm = ATM.getInstance();// to get the instance of ATM

        // If no admin exists in the ATM instance, add a default admin
        if (atm.getAdminArrayList().isEmpty()) {

            atm.getAdminArrayList().add(new Admin("admin123", "12345", 2000));// Adding a default admin with id 'admin123' and password '12345', and a balance of 2000
        }

        // Get the first admin from the list
        Admin admin = atm.getAdminArrayList().get(0);

        System.out.println("Enter the admin_id:");// Prompting the user to enter admin ID
        String enteredid = sc.nextLine();
        if (enteredid.equals(admin.getAdmin_id()))// Checking if the entered ID matches the admin's ID
        {
            // If IDs match, prompt for the password
            System.out.println("Enter your password:");
            String enteredpass = sc.nextLine();
            // Checking if the entered password matches the admin's password
            if (enteredpass.equals(admin.getAdmin_pass())) {
                // If password is correct, login successful
                System.out.println("Successfully logged in!!");
                return 1;// Return 1 for successful login
            } else {
                System.out.println("Incorrect password");// If password is incorrect, show error
                return -1;// Return -1 for failed logi  n
            }
        }
        return -1;// Return -1 if admin ID doesn't match
    }

    public static void adduser() {// Method for adding a new user
        ATM atm = ATM.getInstance();// Get the instance of ATM
        System.out.println("Enter the new user ID:");// Prompt for new user ID
        String us_id = sc.nextLine();
        System.out.println("Enter the new user password:");// Prompt for new user password
        String us_pass = sc.nextLine();
        System.out.println("Enter the balance:");// Prompt for initial balance
        int balance = Integer.parseInt(sc.nextLine());
        atm.getUserArrayList().add(new User(us_id, us_pass, balance)); // Create a new User object and add it to the ATM's user list
        System.out.println("User account has been created");
    }

    public static void deleteuser() {// Method for deleting a user
        ATM atm =ATM.getInstance();// Get the instance of ATM
        System.out.println("Enter the user ID:");// Prompt for user ID to delete
        String us_id = sc.nextLine();
        System.out.println("Enter the user password:");// Prompt for user password
        String us_pass = sc.nextLine();
        System.out.println("Enter the balance:");// Prompt for user balance
        int balance = Integer.parseInt(sc.nextLine());
        atm.getUserArrayList().remove(new User(us_id, us_pass, balance));// Create a new User object and remove it from the list
        System.out.println("User account has been deleted");
    }

    public static void depositamount(ArrayList<Notes>notes) {// Method to deposit amount into the ATM with note denominations
        Scanner sc = new Scanner(System.in);
        ATM atm = ATM.getInstance();// Get the instance of ATM
        System.out.println("Enter the amount to deposit to the ATM:");// Prompt for the total deposit amount
        int depositAmount = Integer.parseInt(sc.nextLine());
        ArrayList<Notes> note = ATM.getNotes();
        int[] denominations = {2000, 500, 200, 100};

        // Prompt for individual note counts
        System.out.print("2000: ");
        int notes2000Count = Integer.parseInt(sc.nextLine());
        System.out.print("500: ");
        int notes500Count = Integer.parseInt(sc.nextLine());
        System.out.print("200: ");
        int notes200Count = Integer.parseInt(sc.nextLine());
        System.out.print("100: ");
        int notes100Count = Integer.parseInt(sc.nextLine());

        note.add(new Notes(2000, notes2000Count));
        note.add(new Notes(500, notes500Count));
        note.add(new Notes(200, notes200Count));
        note.add(new Notes(100, notes100Count));

        ATM.setATMbalance(ATM.getATMbalance() + depositAmount);
        // Calculate the total deposit amount based on the number of notes
        double totalDepositAmount = (notes2000Count * 2000) + (notes500Count * 500) +
                (notes200Count * 200) + (notes100Count * 100);

        // Check if the entered deposit amount matches the calculated total deposit amount
        if (depositAmount == totalDepositAmount) {
            // If valid, deposit the amount into the ATM balance
            if (depositAmount > 0) {
                double currentATMBalance = atm.getATMbalance();// Get current ATM balance
                double updatedBalance = currentATMBalance + depositAmount; // Update the balance
                atm.setATMbalance(updatedBalance);// Set the new ATM balance

                System.out.println("Successfully deposited " + depositAmount + " into the ATM.");
                //System.out.println("Updated ATM balance: " + updatedBalance);
//                for(Notes note:notes)
//                {
//                    System.out.println(note.getNotes()+" "+ note.getCount());
//                }


                Admin admin = atm.getAdminArrayList().get(0);// Get the first admin
                Transaction transaction = new Transaction("ATM", depositAmount, "deposit");// Create transaction object
                admin.addTransaction(transaction);// Add transaction to admin's transaction history

                System.out.println("Transaction logged for admin.");
            } else {
                // If the amount entered is not positive, show an error message
                System.out.println("Invalid amount entered. Please enter a positive amount.");
            }
        }
    }

    public static void viewAdminTransactionHistory() {// Method to view the admin's transaction history
        ATM atm = ATM.getInstance();// Get the instance of ATM
        if (atm.getAdminArrayList().isEmpty()) {// Check if there are any admins in the system
            System.out.println("No admins available.");
            return;
        }

        Admin admin = atm.getAdminArrayList().get(0);// Get the first admin from the list
        System.out.println("Transaction History for Admin ID: " + admin.getAdmin_id());// Get the first admin from the list
        if (admin.getAdmintransaction().isEmpty()) {// If no transactions exist, notify the user
            System.out.println("No transactions available.");
        } else {
            for (Transaction transaction : admin.getAdmintransaction()) {// If transactions exist, loop through and display each one
                System.out.println("AccountID: " + transaction.getaccount_id() +
                        ", Amount: " + transaction.getAmount() +
                        ", Type: " + transaction.getTransactionType());
            }
        }
    }
}
