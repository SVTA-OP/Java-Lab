import java.util.Scanner;
public class LongestWord {
    public static void main(String[] args) {
        String userInput;
        int i, len = 0, indexOfLongestWord = 0;
        Scanner myObj = new Scanner(System.in);
        System.out.print("Enter sentence: "); userInput = myObj.nextLine();
        String[] words = userInput.split(" ");
        for(i=0;i<words.length;i++){
            if (words[i].length() > len){
                indexOfLongestWord = i;
                len = words[i].length();
            }
        }
        System.out.println("Longest Word: "+words[indexOfLongestWord]);
        System.out.println("Index: "+userInput.indexOf(words[indexOfLongestWord]));

    }
}
