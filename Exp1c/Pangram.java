import java.util.Scanner;

public class Pangram {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        int[] freq = new int[26];
        String input;
        boolean isPangram = true;
        int i;

        System.out.print("Enter a sentence: ");
        input = myObj.nextLine();
        input = input.toLowerCase();

        for (i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c >= 97 && c <= 122) {
                freq[c - 97] +=1;
            }
        }

        System.out.println("\nLetter Frequencies:");
        for (i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                System.out.println((char) (97 + i) + ": " + freq[i]);
            }
        }

        for (i = 0; i < 26; i++) {
            if (freq[i] == 0) {
                isPangram = false;
                break;
            }
        }

        System.out.println("\nIs pangram? " + isPangram);
    }
}
