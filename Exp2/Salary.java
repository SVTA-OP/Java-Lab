import java.util.Scanner;
class Employee{
    String name, designation;
    int id, yOfExp, hoursWorked;
    float hra,lic,basicPay;
    double pf;
    Scanner myObj = new Scanner(System.in);
    char licOpt;

    void insertData(){
        System.out.print("Enter Name: "); name = myObj.nextLine();    
        System.out.print("Enter ID: "); id = myObj.nextInt();
        System.out.print("Enter Designation: "); designation = myObj.nextLine();
        System.out.print("Enter Years worked: "); yOfExp = myObj.nextInt();
        System.out.print("Enter Basic Pay: "); basicPay = myObj.nextInt();
        System.out.print("LIC (Y/N): "); licOpt = myObj.next().charAt(0);
        if (designation.equals("intern")){
           System.out.print("Enter hours worked: "); hoursWorked = myObj.next().charAt(0);        
        }

    }
    double CalculateAmount(){
        double grossSalary;
        if (designation.equals("intern")){
            grossSalary =  300*hoursWorked+3000; 
            pf = 500;
        }
        else {
            grossSalary = basicPay+(basicPay*0.5); 
            pf = 0.08*basicPay;
        }
        double deductions = pf;
        if (licOpt == 'Y'){
            deductions += (double)lic;
        }
        double netSalary = grossSalary - deductions;
        return netSalary;
    
    }

    void paySlip(){
        System.out.println("Name: "+name);
        System.out.println("ID: "+id);
        System.out.println("Salary: "+ CalculateAmount());
        if (yOfExp >=10)
            System.out.println("Employee is eligible for promotion");
    }
    void search(int id, Employee[] employees, int n){
        boolean found = false;
        for(int i = 0;i<n;i++){
            if (id == employees[i].id)
                employees[i].paySlip();
        }
        if (found == false)
            System.out.println("Employee not found");
    }
}

public class Salary {
    public static void main(String[] args){
        int n;
        Scanner myObj = new Scanner(System.in);
        System.err.print("Enter number of employees: "); n = myObj.nextInt();
        Employee[] employees = new Employee[n];
        Employee empSearch = new Employee();
        for (int i=0;i<n;i++){
            employees[i] =  new Employee();
            employees[i].insertData();
        }
        System.out.print("Enter ID to search: "); int sid = myObj.nextInt();
        empSearch.search(sid, employees, n);

        
    }
}