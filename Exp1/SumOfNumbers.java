import java.util.Scanner;
public class SumOfNumbers{
	public static void main(String[] args){
		Scanner myObj = new Scanner(System.in);
		int i, temp = 0, prod = 1;
		System.out.print("Enter nth term: ");
		int n = myObj.nextInt();
		for(i=1;i<=n;i++){
			temp +=i;	
		}
		System.out.println(temp);
	} 
}
