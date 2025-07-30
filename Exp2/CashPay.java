interface Payable {
    void pay();
    String getPaymentDetails();
    boolean validatePayment();
    void generateReceipt();
}

abstract class Payment implements Payable {
    protected double amount;

    Payment(double amount) {
        this.amount = amount;
    }

    public boolean validatePayment() {
        return amount > 0;
    }

    public String getPaymentDetails() {
        return "Amount: " + amount;
    }
}

class CashPayment extends Payment {
    CashPayment(double amount) {
        super(amount);
    }

    public void pay() {
        System.out.println("Cash Payment of " + amount + " successful.");
    }

    public void generateReceipt() {
        System.out.println("Receipt: Cash payment of " + amount + " received.");
    }

    public String getPaymentDetails() {
        return "Cash Payment: " + amount;
    }
}

class CreditCardPayment extends Payment{
    private String cardNumber;
    private String cardHolderName;

    public CreditCardPayment(double amount, String cardNumber, String cardHolderName) {
        super(amount);
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    public void pay() {
        System.out.println("Credit Card Payment of " + amount + " made by " + cardHolderName + ".");
    }

    public void generateReceipt() {
        System.out.println("Receipt: Credit Card payment of " + amount + " for card " + cardNumber + ".");
    }

    public String getPaymentDetails() {
        return "Credit Card Payment: " + amount + " by " + cardHolderName + ", Card: " + cardNumber;
    }

    public void generateReceipt(boolean printReciept) {
        if (printReciept == true) {
            generateReceipt();
        } 
        else {
            System.out.println("Receipt not generated as per user request.");
        }
    }
}

class UPIPayment extends Payment {
    private String upiId;

    public UPIPayment(double amount, String upiId) {
        super(amount);
        this.upiId = upiId;
    }

    public void pay() {
        System.out.println("UPI Payment of " + amount + " made using UPI ID: " + upiId + ".");
    }

    public void generateReceipt() {
        System.out.println("Receipt: UPI payment of " + amount + " to UPI ID: " + upiId + ".");
    }

    public String getPaymentDetails() {
        return "UPI Payment: " + amount + ", UPI ID: " + upiId;
    }
}

public class CashPay {
    public static void main(String[] args) {
        Payment[] payments = new Payment[3];
        payments[0] = new CashPayment(1000);
        payments[1] = new CreditCardPayment(2500, "1234-5678-9012", "Riya Mehta");
        payments[2] = new UPIPayment(800, "riya@upi");

        for (int i=0; i<2;i++) {
            payments[i].pay();
            payments[i].generateReceipt();
            System.out.println(payments[i].getPaymentDetails());
            System.out.println("Validity: " + payments[i].validatePayment());
            System.out.println("\n");
        }

        // Demonstrate overloaded method
        CreditCardPayment alt_user = new CreditCardPayment(5000, "9876-5432-1010", "Ankit Sharma");
        alt_user.generateReceipt(true);
        alt_user.generateReceipt(false); 

    }
    
}
