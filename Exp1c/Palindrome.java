import java.util.Scanner;
public class Palindrome {
    public static void main(String[] args) {
        String word;
        Scanner myObj = new Scanner(System.in);

        System.out.print("Enter word: "); word = myObj.nextLine();
        int i = 0, j = word.length() - 1;
        boolean flag = true;
        while(i<j){
            if (word.charAt(i) != word.charAt(j)){
                flag = false;
                break;
            }
            i++;
            j--;
        }
        if (flag == false){
            System.out.println("Not a Palindrome");
        }
        else
            System.out.println("Palindrome");
    }
}
