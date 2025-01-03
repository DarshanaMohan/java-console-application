import java.util.Scanner;
import java.util.ArrayList;

public class Useraction
{
    static Scanner sc = new Scanner(System.in);

    public static User user_login() {
        for (User user1 : ATM.getuser_id()) {
            System.out.println("Enter your user_id:");
            String enteredid = sc.nextLine();
            if (enteredid.equals(user1.getUser_id())) {
                int attempts =1;
                while (attempts <= 3) {
                    System.out.println("Enter your password:");
                    String enteredpass = sc.nextLine();
                    if (enteredpass.equals(user1.getUser_pass())) {
                        System.out.println("Successfully logged in!!");
                        return user1;
                    } else {
                        attempts++;
                        if (attempts == 3) {
                            System.out.println("incorrect password you have only one attempts remaining");
                        }
                    }
                }

                System.out.println("account was deactivated");

                return null;
            }
        }
        System.out.println("user id not found");
        return null;
    }


    public static void change_pin(User user)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter new PIN:");
        String newPin = sc.nextLine();
        user.setUser_pass(newPin);
        System.out.println("PIN successfully changed.");
    }


    public static void transaction_history(User user) {
        System.out.println("Transaction History for User ID: " + user.getUser_id());
        if (user.getUsertransaction().isEmpty()) {
            System.out.println("No transactions available.");
        } else {
            for (Transaction transaction : user.getUsertransaction()) {
                System.out.println("AccountID:" + transaction.getaccount_id() + ",Amount:" + transaction.getAmount() + "Type:" + transaction.getTransactionType());
            }
        }
    }


    public static void deposit_cash(User user, ArrayList<Notes> note) {
//        for (Notes notes : note) {
//            System.out.println(notes.getNotes() + " " + notes.getCount());
//        }
        System.out.print("Enter amount to deposit: ");
        double atmAmount = Double.parseDouble(sc.nextLine());
        System.out.println("Enter the 2000rs notes");
        int twothousand = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the 500rs notes");
        int fivhun = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the 200rs notes");
        int twohun = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the 100rs notes");
        int hun = Integer.parseInt(sc.nextLine());
        int tol = twothousand * 2000 + fivhun * 500 + twohun * 200 + hun * 100;
        if (tol == atmAmount) {
            for (Notes notes : ATM.getNotes()) {
                int type = notes.getNotes();
                switch (type) {
                    case 2000:
                        notes.setCount(notes.getCount() + twothousand);
                        break;
                    case 500:
                        notes.setCount(notes.getCount() + fivhun);
                        break;
                    case 200:
                        notes.setCount(notes.getCount() + twohun);
                        break;
                    case 100:
                        notes.setCount(notes.getCount() + hun);
                        break;
                    default:
                        System.out.println("you enter note is not their");

                }
            }
            System.out.println("Amount was successfully added to atm" + atmAmount);
            ATM.setATMbalance(ATM.getATMbalance() + atmAmount);
            User.setbalance((int) (User.getbalance() + atmAmount));

        } else {
            System.out.println("Wrong denomination entered");
        }
        for (Notes notes : note) {
            System.out.println(notes.getNotes() + " " + notes.getCount());
        }


    }

    public static void check_balance() {
        System.out.println("Your current balance***: " + User.getbalance());
    }



    public static void withdraw_cash(Scanner sc, ArrayList<Notes> note) throws CloneNotSupportedException {
        System.out.println("Enter your withdrawal amount: ");
        int amount = Integer.parseInt(sc.next()); // User input withdrawal amount

        // Check if user has enough balance before proceeding
        if (User.getbalance() < amount) {
            System.out.println("Insufficient balance in your account!");
            return;
        }

        // Check if ATM has enough cash to withdraw
        double atmBalance = ATM.getATMbalance();
        if (atmBalance < amount) {
            System.out.println("ATM doesn't have enough cash to fulfill your request.");
            return;
        }

        ArrayList<String> denomination = new ArrayList<>();  // Store the denominations used
        ArrayList<Notes> copy_note = new ArrayList<>();  // Copy of the ATM notes for withdrawal

        // Clone the ATM notes to make sure the original list is not directly modified
        for (Notes notes : ATM.getNotes()) {
            copy_note.add(notes.clone());
        }

        // Attempt to withdraw from the ATM
        while (amount > 0) {
            boolean success = false;

            // Loop through the available notes and try to deduct from the ATM
            for (Notes notes : copy_note) {
                int noteValue = notes.getNotes(); // The denomination value (e.g. 2000, 500, 100, 200)
                if (noteValue <= amount && notes.getCount() > 0) {
                    int maxNotescanWithdraw = amount / noteValue;  // Calculate how many notes can be withdrawn

                    // If there are enough notes in the ATM
                    if ( maxNotescanWithdraw<= notes.getCount()) {
                        amount -= maxNotescanWithdraw * noteValue; // Subtract the value from the withdrawal amount
                        notes.setCount(notes.getCount() - maxNotescanWithdraw);  // Update the note count in ATM
                        denomination.add(noteValue + " x " + maxNotescanWithdraw); // Track the denominations used
                        success = true;
                        break; // Exit inner loop once a valid denomination is found
                    }
                }
            }

            // If no denomination could fulfill the request, break and prompt the user again
            if (!success) {
                System.out.println("Unable to complete the withdrawal with available denominations. Please enter another amount.");
                break; // Exit while loop if no successful withdrawal is made
            }
        }

        // If withdrawal was successful, update user's balance and ATM balance
        if (amount == 0) {
            ATM.setATMbalance(ATM.getATMbalance() - amount); // Reduce ATM balance
            //User.setbalance(User.getbalance()-amount);
            System.out.println("Withdrawal successful! Denominations dispensed:");

            // Print out the denominations used
            for (String noteDetails : denomination) {
                System.out.println(noteDetails);
            }

            // Update the user's balance (this will depend on your implementation of User class)
            // Assuming `User.setbalance()` exists to update the balance
           // User.setbalance(User.getbalance() - amount);
            //ATM.setATMbalance(ATM.getATMbalance()-amount);


            // Update transaction history (you can implement this depending on your transaction system)
            // Transaction transaction = new Transaction(User.getUser_id(), amount, "withdrawal");
            // User.addTransaction(transaction);
        } else {
            System.out.println("There is an error or insufficient funds in the ATM.");
       }

        // Print updated ATM notes
        System.out.println("updated ATM notes");

    }

    public static double perform_Withdrawal(double Amount, ArrayList<String> denomination, Notes note) {
        int count = (int) (Amount / note.getNotes());
        if (note.getNotes() <= Amount && count <= note.getCount()) {
            Amount = Amount - (count * note.getNotes());
            note.setCount(note.getCount() - count);
            denomination.add(note.getNotes() + " " + count);
            return Amount; // Return the remaining amount after withdrawal
        }
        return Amount; // If withdrawal wasn't possible, return the remaining amount
    }
}





