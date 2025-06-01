import java.util.ArrayList;
import java.util.List;

// Account interface
// interface Account {
//     void deposit(double amount);
//     void withdraw(double amount);
// }

interface NonWithdrawlableAccount{
    void deposit(double amount);
}

interface  WithdrawlableAccount extends NonWithdrawlableAccount{
    void withdraw(double amount);
}

class SavingAccount implements WithdrawlableAccount {
    private double balance;

    public SavingAccount() {
        balance = 0;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " in Savings Account. New Balance: " + balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + " from Savings Account. New Balance: " + balance);
        } else {
            System.out.println("Insufficient funds in Savings Account!");
        }
    }
}

class CurrentAccount implements WithdrawlableAccount {
    private double balance;

    public CurrentAccount() {
        balance = 0;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " in Current Account. New Balance: " + balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + " from Current Account. New Balance: " + balance);
        } else {
            System.out.println("Insufficient funds in Current Account!");
        }
    }
}

class FixedTermAccount implements NonWithdrawlableAccount {
    private double balance;

    public FixedTermAccount() {
        balance = 0;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " in Fixed Term Account. New Balance: " + balance);
    }

}

class BankClient {
    private List<WithdrawlableAccount> allWithdrawlableAccounts;
    private List<NonWithdrawlableAccount> alNonWithdrawlableAccounts;

    public BankClient(List<WithdrawlableAccount> allWithdrawlableAccounts,List<NonWithdrawlableAccount> alNonWithdrawlableAccounts){
         this.allWithdrawlableAccounts = allWithdrawlableAccounts;
         this.alNonWithdrawlableAccounts = alNonWithdrawlableAccounts;
    }


    public void processTransactions() {
        for(WithdrawlableAccount acc : allWithdrawlableAccounts){
            acc.deposit(1000);
            acc.withdraw(500);
        }

        for(NonWithdrawlableAccount acc : alNonWithdrawlableAccounts){
            acc.deposit(5000);
        }
    }
      
}

public class LSPFollowed {
    public static void main(String[] args) {
        List<WithdrawlableAccount> nonWithdrawlableAccounts = new ArrayList<>();
         nonWithdrawlableAccounts.add(new SavingAccount());
         nonWithdrawlableAccounts.add(new CurrentAccount());
        List<NonWithdrawlableAccount> depositAccounts = new ArrayList<>();
        depositAccounts.add(new FixedTermAccount());

        BankClient client = new BankClient(nonWithdrawlableAccounts,depositAccounts);

        client.processTransactions(); 
    }
}