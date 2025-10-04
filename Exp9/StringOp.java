interface StringOperation
{
    public String operate(String str);
}

class StringOp
{
    public static void main(String args[])
    {    StringOperation upper = (str) -> {return str.toUpperCase();};
        StringOperation reverse = (str) -> {
            StringBuffer buf = new StringBuffer(str);
            return buf.reverse().toString();
        };
        StringOperation count = (str) -> {
            System.out.println("The length of the String is: " + str.length());
            return str;
        };

        System.out.println("Uppercase: " + upper.operate("Hello World"));
        System.out.println("Reversed: " + reverse.operate("Hello World"));
        count.operate("Hello World");
    }
}