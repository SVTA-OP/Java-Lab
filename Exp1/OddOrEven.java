import java.util.Scanner;
public class OddOrEven {
	public static void main(String[] args){
		Scanner myObj = new Scanner(System.in);
		System.out.print("Enter number: ");
		int userInput = myObj.nextInt();
		if (userInput%2 == 0){
			System.out.println("Even");
		}
		else
			System.out.println("Odd");
	} 
}
