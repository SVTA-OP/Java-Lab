import java.util.Scanner;
public class ElecBill{
    public static void main(String[] args) {
        ConsumerData consumer = new ConsumerData();
        consumer.InputData();
        float amt = consumer.CalculateAmount();

        System.out.println("======================================================================");
        System.out.println("Consumer Name: "+ consumer.consumerName);
        String type;
        if (consumer.connectionType == 'D')
            type = "Domestic";
        else
            type = "Commercial";
        System.out.println("Counsumer Type: "+type);
        System.out.println("Amount Due: "+ amt);
        
    }
}

class ConsumerData {
    String consumerName;
    char connectionType;
    int prevReading, currentReading;

    void InputData(){
        Scanner myObj = new Scanner(System.in);
        System.out.print("Enter Consumer Name: "); consumerName = myObj.nextLine();
        System.out.print("Enter Consumer Type (D/C): "); connectionType = myObj.next().charAt(0);
        System.out.print("Enter Prev and Current Amount (p,c): "); prevReading = myObj.nextInt(); currentReading = myObj.nextInt();
    }
    float CalculateAmount(){
        int currentUsed = currentReading - prevReading;
        float amount = 0, a = 0;
        if (connectionType == 'D'){
            while(a != currentUsed){
                if (a<=100){
                    amount+=1;
                }
                else if (a<=200){
                    amount+=2.5;
                }
                else if (a<=500){
                    amount+=4;
                }
                else
                    amount+=6;
                a++;
            }
        }
        else if (connectionType == 'C'){
            while(a != currentUsed){
                if (a<=100){
                    amount+=2;
                }
                else if (a<=200){
                    amount+=4.5;
                }
                else if (a<=500){
                    amount+=6;
                }
                else
                    amount+=7;
                a++;
            }
        }
        return amount;
    }
}

