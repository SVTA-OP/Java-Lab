interface Calculator {
    public void operation(int a, int b);
}

class Calc {
    public static void main(String args[]) {
        Calculator Add = (a,b) -> System.out.println(a + "+" + b + "=" + (a+b));
        Calculator Subtract = (a,b) -> System.out.println(a + "-" + b + "=" + (a-b));
        Calculator Multiply = (a,b) -> System.out.println(a + "*" + b + "=" + (a*b));
        Calculator Divide = (a,b) -> System.out.println(a + "/" + b + "=" + (a/b));      

        Add.operation(2,4);
        Subtract.operation(2,4);
        Multiply.operation(2,4);
        Divide.operation(4,2);

    }
}   