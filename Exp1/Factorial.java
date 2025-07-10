import java.util.Scanner;
public class Factorial{
	public static void main(String[] args){
		Scanner myObj = new Scanner(System.in);
		int i, temp = 0, prod = 1;
		System.out.print("Enter number: ");
		int n = myObj.nextInt();
		for(i=1;i<=n;i++){
			if (n == 0)
				System.out.println(0);
			else
				prod = prod*i;	
		}
		System.out.println(prod);
	} 
}
