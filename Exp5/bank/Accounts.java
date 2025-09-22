package bank;

public class Accounts {
    public int accountNumber;
    public double balance;

    public Accounts(int accountNumber, double balance){
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public void deposit(double amount){
        balance +=amount;
        System.out.println("Added "+balance+" to account");
    }

    public void withdraw(double amount){
        if (balance >= amount){
            balance -=amount;
            System.out.println("Added "+balance+" to account");
        }
        else
            System.out.println("Insufficient balance");
    }

    public void displayBalance() {
        System.out.println("Account " + accountNumber + " Balance: " + balance);
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance(){
        return balance;
    }
}
