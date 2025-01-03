class Transaction
{
        static String accountID;  //Static field for accountID
        static int amount;// Static field for amount
        static String transactionType;// Static field for transactionType

        public Transaction(String accountID,int amount,String transactionType)// Constructor to initialize the Transaction object with accountID, amount, and transactionType
        {
            this.accountID = accountID;// Assign the provided accountID to the static field
            this.amount = amount; // Assign the provided amount to the static field
            this.transactionType = transactionType;// Assign the provided transactionType to the static field
        }

        public String getaccount_id()// Static method to get the accountID
        {
            return accountID;
        }

        public int getAmount()// Static method to get the amount
        {
            return amount;
        }

        public String getTransactionType()// Static method to get the transactionType
        {
            return transactionType;
        }
}

