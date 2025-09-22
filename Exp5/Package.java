import bank.Accounts;
import bank.Transactions;

public class Package {
    public static void main(String[] args) {
        
        Accounts acc1 = new Accounts(1001, 5000);
        Accounts acc2 = new Accounts(1002, 3000);

        System.out.println("Initial balances:");
        acc1.displayBalance();
        acc2.displayBalance();
        
        System.out.println("\nDepositing Rs.1000 to Account 1001");
        acc1.deposit(1000);
        acc1.displayBalance();
        
        System.out.println("\nWithdrawing Rs.2000 from Account 1001");
        acc1.withdraw(2000);
        acc1.displayBalance();

        System.out.println("\nTransferring Rs.1500 from Account 1001 to 1002");
        Transactions tx = new Transactions();
        tx.transfer(acc1, acc2, 1500);

        System.out.println("\nFinal balances:");
        acc1.displayBalance();
        acc2.displayBalance();
    }
}
