import java.util.Scanner;

class Student {
    String name, dept;
    int id, marks1, marks2, marks3;
    Scanner myObj = new Scanner(System.in);

    void inputData(){

        System.out.print("Enter Name: "); name = myObj.nextLine();
        System.out.print("Enter Department: "); dept = myObj.nextLine();
        System.out.print("Enter ID: "); id = myObj.nextInt();
        System.out.println("Enter 3 marks: "); marks1 = myObj.nextInt(); marks2 = myObj.nextInt(); marks3 = myObj.nextInt();
    }
    void displayInfo(){
        float avg = (marks1+marks2+marks3)/3;
        System.out.println("Name: "+ name);
        System.out.println("Department: "+ dept);
        System.out.println("ID: "+ id);
        System.out.println("Average Mark: "+ avg);
        System.out.println("-----------------------------------------");
    }
    void search(int sid, Student[] students, int n){
        boolean flag = false;
        for(int i = 0;i<n;i++){
            if (students[i].id == sid){
                students[i].displayInfo();
                flag = true;
            }
        }
        if (flag == false)
            System.out.println("Student not found");
    }
    void search(String sname, Student[] students, int n){
        boolean flag = false;
        for(int i = 0;i<n;i++){
            if (students[i].name.equals(sname)){
                students[i].displayInfo();
                flag = true;
            }
        }
        if (flag == false)
            System.out.println("Student not found");
    }
    void searchByDept(String dept, Student[] students, int n){
        boolean flag = false;
        System.out.println("Enter name: "); String sname = myObj.nextLine();
        for(int i = 0;i<n;i++){
            if (students[i].name.equals(sname)){
                students[i].displayInfo();
                flag = true;
            }
        }
        if (flag == false)
            System.out.println("Student not found");
    }
}

public class StudentRun {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        int n, i;
        System.out.println("Enter number of Students: ");
        n = myObj.nextInt();

        Student[] students = new Student[n];

        for (i=0;i<n;i++){
            students[i] = new Student();
            students[i].inputData();
            System.out.println("======================================");
        }
        for (i =0;i<n;i++)
            students[i].displayInfo();

        System.out.println("Enter 'D', 'I', or 'N' to search: "); char searchChar = myObj.next().charAt(0);
        Student searchObj = new Student();
        if (searchChar == 'D'){
            System.out.println("Enter Dept: "); String sdept = myObj.nextLine();
            searchObj.searchByDept(sdept, students, n);
        }
        else if (searchChar == 'I'){
            System.out.println("Enter ID: "); int sid = myObj.nextInt();
            searchObj.search(sid, students, n);
        }
        else if (searchChar == 'N'){
            System.out.println("Enter Name: "); String sname = myObj.nextLine();   
            searchObj.search(sname, students, n);
        }
        else
            System.err.println("Student not found");
    }
}