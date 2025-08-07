import java.util.Scanner;

interface ADT {
	void insert(int item);
	int remove();
	int peek();
	boolean isEmpty();
	int size();
}

class IntStack implements ADT {
	int[] elements;
	int indexOfLastElement;

	IntStack(int[] elements, int indexOfLastElement){
		this.elements = elements;
		this.indexOfLastElement = indexOfLastElement;
	}
	
	public void insert(int item){
		if (indexOfLastElement + 1 < 10){
			elements[indexOfLastElement++] = item;
		}
		else
			System.out.println("Stack is full");
	}
	public int remove(){
		int poppedElement = elements[indexOfLastElement--];
		// indexOfLastElement--;
		return poppedElement;
	}
	public int peek(){
		return elements[indexOfLastElement -1];
	}
	public boolean isEmpty(){
		if (indexOfLastElement == 0)
			return true;
		return false;
	}
	public int size(){
		return indexOfLastElement;
	}
	
}

class IntQueue implements ADT {
	int[] elements;
	int front;
	int end;
	
	IntQueue(int[] elements, int front, int end){
		this.elements = elements;
		this.front = front;
		this.end = end;
	}
	
	public boolean isEmpty(){
		if (front == end)
			return true;
		return false;
	}
	
	public void insert(int element){
		if (end +1 < 10){
			elements[end++] = element;
		}
		else
			System.out.println("Queue is full");
	}
	
	public int remove(){
		if (isEmpty()){
			System.out.println("Queue is empty");
			return 404;
		}
		else {
			return elements[front++];
		}
	}
	
	public int peek(){
		return elements[front];		
	}
	
	public int size(){
		return end - front;
	}
} 


public class JavaADT {
	public static void main(String[] args){
		// System.out.println("HelloWorld");
		
		int[] elements = new int[10];
		// int indexOfLastElement = 0;
		IntStack stack = new IntStack(elements, 0);
		Scanner myObj = new Scanner(System.in);
		IntQueue queue = new IntQueue(elements, 0, 0);
		
		System.out.print("Stack or Queue (S/Q): "); char adtType = myObj.next().charAt(0);
		
		while (true){
			System.out.print("\n1. Add\n2. Remove\n3. Peek\n4. Check if empty\n5. Check size of Stack\n\nEnter Choice: "); int choice = myObj.nextInt();
		
			if (adtType == 'S'){
				if (choice == 1){
					System.out.print("Enter element to add: "); int element = myObj.nextInt();
					stack.insert(element);
				}
				else if(choice == 2){
					System.out.println("Removed element: "+stack.remove());
				}
				else if(choice == 3){
					System.out.println("Top of Stack: "+stack.peek());
				}
				else if(choice == 4){
					System.out.println("Stack is empty: "+ stack.isEmpty());
				}
				else if(choice == 5){
					System.out.println("Size: "+stack.size());
				}
				else
					break; 
			}
			else if (adtType == 'Q'){
				if (choice == 1){
					System.out.print("Enter element to add: "); int element = myObj.nextInt();
					queue.insert(element);
				}
				else if(choice == 2){
					System.out.println("Removed element: "+queue.remove());
				}
				else if(choice == 3){
					System.out.println("Top of Stack: "+queue.peek());
				}
				else if(choice == 4){
					System.out.println("Queue is empty: "+ queue.isEmpty());
				}
				else if(choice == 5){
					System.out.println("Size: "+queue.size());
				}
				else
					break; 
			}
		}
	}
}
