package bank;

public class Transactions {
    public void transfer(Accounts from, Accounts to, double amount) {
        
        if (from.balance >= amount) {
            from.withdraw(amount);
            to.deposit(amount);
            
            System.out.println("--------------------");
            System.out.println("Transfer Complete!");
            System.out.println("Amount: Rs." + amount);
            System.out.println("From Account: " + from.getAccountNumber());
            System.out.println("To Account: " + to.getAccountNumber());
            System.out.println("--------------------");
        }
        else {    
            System.out.println("--------------------");
            System.out.println("Transfer Failed!");
            System.out.println("Insufficient balance in Account " + from.getAccountNumber());
            System.out.println("--------------------");
        }
    }
}