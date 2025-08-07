import java.util.Scanner;

class MinorCitizenException extends Exception {
    public MinorCitizenException(String message) {
        super(message);
    }
}

class CitizenCheck {
    Scanner myObj = new Scanner(System.in);
    String name, ageString;
    int age;
    String aadharNumber;
    String[] aadharNumbers =  {"123456789012", "2468101214", "369121518212"};

    void getInput(){
        System.out.print("Enter name: "); name = myObj.nextLine();
        System.out.print("Enter Aadhar Number: "); aadharNumber = myObj.nextLine();
        System.out.print("Enter age: "); // age = myObj.nextInt();
        try{
            // age = Integer.parseInt(ageString);
            age = myObj.nextInt();
        }
        catch (NumberFormatException e){
            throw new NumberFormatException("Invalid input, not an integer");
        }
    }
     
    void display(){
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Aadhar Number: " + aadharNumber);
    }

    void canVote() throws MinorCitizenException{
        if (age < 18){
            throw new MinorCitizenException("Citizen is a minor");
        }
        System.out.println("The citizen is eligible to vote");
    }

    void hasAadhar(){
        boolean flag = false;
        for (int i =0;i< aadharNumbers.length;i++){
            if (aadharNumbers[i].equals(aadharNumber)){
                flag = true;
                break;
            }
        }
        if (flag == false){
            throw new NullPointerException("Aadhar doesn't exist");
        }
        else
            System.out.println("Aadhar is verified");
    }
}


public class Citizen {
    public static void main(String[] args) {
        CitizenCheck myObj1 = new CitizenCheck();
        try{
            myObj1.getInput();
        }
        catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        myObj1.display();
        try{
            myObj1.canVote();
        }
        catch (MinorCitizenException e) {
            System.out.println(e.getMessage());
        }
        try {
            myObj1.hasAadhar();
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}
