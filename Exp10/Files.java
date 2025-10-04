// package Exp10;
import java.io.*;

public class Files {
    public static void main(String args[]) {
       // System.out.println("Files");
        try {
            FileOutputStream out = new FileOutputStream("students.txt");
            FileInputStream in = null;
            String str = "Bob 80\nAlice 90\nJohn 85\n";
            out.write(str.getBytes());
            out.close();

            in = new FileInputStream("students.txt");
            String content = "";
            int ch;
            while ((ch = in.read()) != -1) {
                content += (char) ch;
            }

            String[] lines = content.trim().split("\\s+");
            
            int score = Integer.MIN_VALUE;
            for (int i = 0; i + 1 < lines.length; i += 2) {
                int s = Integer.parseInt(lines[i+1]);
                if (score < s) {
                    score = s;
                }
            }
            System.out.println("Student with highest score: ");

            for (int i = 0; i + 1 < lines.length; i += 2) {
                if (score == Integer.parseInt(lines[i+1])) {
                    System.out.println(lines[i] + " " + lines[i+1]);
                }
            }
            out.close();
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error writing to file");
        }
    }
}
