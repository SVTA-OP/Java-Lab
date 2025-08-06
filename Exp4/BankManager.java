import java.util.Scanner;

class PANRequiredException extends Exception {
    PANRequiredException(String msg) {
        super(msg);
    }
}

class MinBalRequiredException extends Exception {
    public MinBalRequiredException(String msg) {
        super(msg);
    }
}

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String msg) {
        super(msg);
    }
}

class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String msg) {
        super(msg);
    }
}

class BranchNotFoundException extends Exception {
    public BranchNotFoundException(String msg) {
        super(msg);
    }
}

class PANFormatMismatchException extends Exception {
    public PANFormatMismatchException(String msg) {
        super(msg);
    }
}

class BankAccount {
    static String[] validBranches = { "Main", "North", "South", "East", "West" };
    String name, acct_num, branch, PAN_num;
    double balance;
    static final double MIN_BALANCE = 500.0;

    BankAccount(String name, String acct_num, String branch, double balance, String PAN_num)
            throws BranchNotFoundException {
        if (isValidBranch(branch) == false)
            throw new BranchNotFoundException("Invalid branch");

        this.name = name;
        this.acct_num = acct_num;
        this.branch = branch;
        this.balance = balance;
        this.PAN_num = PAN_num;
    }

    static boolean isValidBranch(String br) {
        for (int i = 0; i < validBranches.length; i++) {
            if (validBranches[i].equalsIgnoreCase(br) == true)
                return true;
        }
        return false;
    }

    static boolean isValidPAN(String pan) {
        if (pan == null)
            return false;

        // pattern match remains unchanged
        return pan.matches("[A-Za-z]{5}\\d{4}[A-Za-z]");
    }

    void deposit(double amt, String panInp) throws PANRequiredException, PANFormatMismatchException {
        if (amt > 25000) {
            if (panInp == null || panInp.length() == 0)
                throw new PANRequiredException("PAN required");

            if (isValidPAN(panInp) == false)
                throw new PANFormatMismatchException("PAN format incorrect");

            PAN_num = panInp;
        }
        balance += amt;
        System.out.println("Deposited " + amt + ", New balance " + balance);
    }

    void withdraw(double amt) throws MinBalRequiredException, InsufficientBalanceException {
        if (balance < MIN_BALANCE)
            throw new MinBalRequiredException("Below min balance");

        if (amt > balance)
            throw new InsufficientBalanceException("Insufficient balance");

        balance -= amt;
        System.out.println("Withdrew " + amt + ", New balance " + balance);
    }

    void display() {
        System.out.println(name + " | " + acct_num + " | " + branch + " | " + balance + " | " + PAN_num);
    }
}

public class BankManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        System.out.print("Valid branches ");
        for (int i = 0; i < BankAccount.validBranches.length; i++) {
            System.out.print(BankAccount.validBranches[i] + " ");
        }
        System.out.println();

        System.out.print("How many users ");
        n = Integer.parseInt(sc.nextLine());
        BankAccount[] accounts = new BankAccount[n];

        // Enter user data for all accounts
        for (int i = 0; i < n; i++) {
            while (true) {
                try {
                    System.out.println("\nEnter details for user " + (i + 1));
                    System.out.print("Name ");
                    String name = sc.nextLine();
                    System.out.print("Account number ");
                    String acct_num = sc.nextLine();
                    System.out.print("Branch ");
                    String branch = sc.nextLine();
                    System.out.print("Initial balance ");
                    double balance = Double.parseDouble(sc.nextLine());
                    System.out.print("PAN number ");
                    String PAN_num = sc.nextLine();
                    accounts[i] = new BankAccount(name, acct_num, branch, balance, PAN_num);
                    break;
                } catch (BranchNotFoundException e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    System.out.println("Invalid input. Enter again.");
                }
            }
        }

        // Deposit and withdraw operations for all accounts
        for (int i = 0; i < n; i++) {
            System.out.println("\nAccount " + accounts[i].acct_num);
            accounts[i].display();

            // Deposit
            try {
                System.out.print("Deposit amount ");
                double damt = Double.parseDouble(sc.nextLine());
                String panInput = "";
                if (damt > 25000) {
                    System.out.print("Enter PAN for deposit ");
                    panInput = sc.nextLine();
                }
                accounts[i].deposit(damt, panInput);
            } catch (Exception e) {
                System.out.println("Deposit error " + e.getMessage());
            }

            // Withdraw
            try {
                System.out.print("Withdraw amount ");
                double wamt = Double.parseDouble(sc.nextLine());
                accounts[i].withdraw(wamt);
            } catch (Exception e) {
                System.out.println("Withdraw error " + e.getMessage());
            }
        }

        // Show all accounts
        System.out.println("\nAll account details");
        for (int i = 0; i < n; i++) {
            accounts[i].display();
        }
        sc.close();
    }
}
