import java.util.Scanner;
public class Student{
	public static void main(String[] args){
		Data Student1 = new Data();
		Data Student2 = new Data();
		Data Student3 = new Data();
		
		Student1.inputData();
		Student2.inputData();
		Student3.inputData();
		
		Student1.displayInfo();
		Student2.displayInfo();
		Student3.displayInfo();
		
        Data[] students = new Data[3];
        students[0] = Student1;
        students[1] = Student2;
        students[2] = Student3;

        Data.searchStudent(students);
	}
}

class Data {
	String name, dept;
	int marks1, marks2, marks3, id;

	/*Data[] students = new Data[3];
		students[0] = Student1;
		students[1] = Student2;
		students[2] = Student3; */
	
	
	public void inputData(){
		Scanner myObj = new Scanner(System.in);
		System.out.print("Enter ID: "); id = myObj.nextInt();
		System.out.print("Enter Name: "); name = myObj.nextLine();
		myObj.nextLine();
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
	
	public static void searchStudent(Data[] students){
		char searchChar;
		Scanner myObj = new Scanner(System.in);
		System.out.print("Search by: (I/N): "); searchChar = myObj.next().charAt(0);
		for (int i = 0; i<3; i++){
			if (searchChar == 'I' || searchChar == 'i'){
				System.out.print("Enter ID: "); int sid = myObj.nextInt();
				if (students[i].id == sid){
					students[i].displayInfo();
				}
				else
					System.out.println("Student Not found");
			}
			else if (searchChar == 'N' || searchChar == 'n'){
				System.out.print("Enter Name: "); String sname = myObj.nextLine();
				if (students[i].name.equals(sname)){
					students[i].displayInfo();
				}
				else
					System.out.println("Student Not found");
			}
		}
	}
	
}
