import java.util.Scanner;
public class Student{
	public static void main(String[] args){
		data Student1 = new data();
		data Student2 = new data();
		data Student3 = new data();
		
		Student1.inputData();
		Student2.inputData();
		Student3.inputData();
		
		Student1.displayInfo();
		Student2.displayInfo();
		Student3.displayInfo();
		
		
	}
}

class data {
	String name, dept;
	int marks1, marks2, marks3, id;
	
	public void inputData(){
		Scanner myObj = new Scanner(System.in);
		System.out.print("Enter ID: "); id = myObj.nextInt();
		System.out.print("Enter Name: "); name = myObj.nextLine();
		System.out.print("Enter Department: "); dept = myObj.nextLine();
		System.out.print("Enter Mark for Subject 1: "); marks1 = myObj.nextInt();
		System.out.print("Enter Mark for Subject 2: "); marks2 = myObj.nextInt();
		System.out.print("Enter Mark for Subject 3: "); marks3 = myObj.nextInt();
	}
	
	public void displayInfo(){
		System.out.println("Name: "+name);
		System.out.println("ID: "+id);
		System.out.println("Department: "+dept);
		System.out.print("Average Marks: "); System.out.println((marks1+marks2+marks3)/3);
		
	}
}
