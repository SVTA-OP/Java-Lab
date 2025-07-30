import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = myObj.nextInt();
        int temp = n, digits = 0, sum = 0;

        int x = n;
        while (x != 0) {
            digits++;
            x /= 10;
        }

        temp = n;
        while (temp != 0) {
            int d = temp % 10;
            sum += Math.pow(d, digits);
            temp /= 10;
        }

        if (sum == n)
            System.out.println("Armstrong Number");
        else
            System.out.println("Not Armstrong Number");
    }
}