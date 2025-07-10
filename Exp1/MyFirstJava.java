public class MyFirstJava{
	public static void main(String[] args){
		System.out.println("HelloWorld");
		// display();
		MySecondJava msj = new MySecondJava();
		msj.display();
	}
}

class MySecondJava {
	public void display(){
		System.out.println("Hi");
	}
}
