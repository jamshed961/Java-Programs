import java.util.Random;

class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(double initialBalance) {
        this.accountNumber = generateAccountNumber();
        this.balance = initialBalance;
    }

    private String generateAccountNumber() {
        Random rand = new Random();
        StringBuilder accountNumber = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            accountNumber.append(rand.nextInt(10)); 
        }
        return accountNumber.toString();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    
    public double getBalance() {
        return balance;
    }

    public void deposit(double depositAmount) {
    	if(depositAmount>0)
        balance = depositAmount+balance;
        System.out.println("Deposit successful! New balance: " + balance);
    }
   
    public void withdraw(double withdrawAmount) throws InsufficientBalanceException {
        if (withdrawAmount > balance) {
            throw new InsufficientBalanceException("Insufficient balance " + balance + " in your account.");
        }
        balance = balance-withdrawAmount;
        System.out.println("Withdrawal successful! New balance: " + balance);
    }

    
    
}

public class BankingSystem {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(5000);
        System.out.println("Account created with Account Number: " + account.getAccountNumber());
        System.out.println("Initial balance: " + account.getBalance());

        try {
            account.deposit(3000); 
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage()); 
        }
    
        try {
            account.withdraw(2000); 
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage()); 
        }

    }         

        
}