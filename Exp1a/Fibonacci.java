import java.util.Scanner;
public class Fibonacci {
	public static void main(String[] args){
		int i, temp1 = 1, temp2 = 1, temp3 = 0;
		Scanner myObj = new Scanner(System.in);
		System.out.print("Enter no of terms: ");
		int n = myObj.nextInt();
		System.out.println(1);
		for(i=1;i<=n;i++){
			System.out.println(temp1+temp2);
			temp3 = temp1;
			temp1 = temp1+temp2;
			temp2 = temp3;
		}
		
	}
}
