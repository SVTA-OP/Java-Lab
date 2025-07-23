import java.util.Scanner;
import java.util.Arrays;

public class Search {
    public static void main(String[] args) {
        int n,i; int searchNumber;
        Scanner myObj = new Scanner(System.in);
        System.out.print("Enter number of elements: "); n = myObj.nextInt();
        int[] arr = new int[n];
        for (i=0;i<n;i++){
            System.out.print("Enter number "+(i+1)+": "); int num = myObj.nextInt();
            arr[i] = num;
        }
        System.out.print("Enter number to search: "); searchNumber = myObj.nextInt();
        System.out.println("Linear Search: ");
        for(i=0;i<n;i++){
            if (arr[i] == searchNumber){
                System.out.println(arr[i]+" found in position "+i);
                break;
            }
        }
        if (i == n)
            System.out.println("Number not found");

        System.out.println("Binary Search: ");
        System.out.print("Enter number to search: "); searchNumber = myObj.nextInt();
        
        int head = 0;
        int tail = arr.length - 1;
        int mid;
        Arrays.sort(arr);
        
        while (head <= tail){
            mid = head + (tail - head) / 2;
            if (arr[mid] == searchNumber){
                System.out.println(arr[mid]+" found in position "+(head + ((tail-head)/2)));
                break;
            }
            if (arr[mid] < searchNumber)
                head = mid + 1;
            else
                tail = mid - 1;
        }
        if (head > tail)
            System.out.println("Number not found");
    }
}
