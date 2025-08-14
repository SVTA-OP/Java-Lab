import java.util.*;

class GenericStack<T>{
	ArrayList <T> stack = new ArrayList<>();
	int size = 0;
	
	void push(T element){
		stack.add(element);
		size++;
	}
	
	void pop(){
		if (size !=0){
			T x = stack.remove(size - 1);
			size--;
			System.out.println("Popped value: "+x);
		}
		else
			System.out.println("Cannot pop: Empty Stack");
			
			
	}
	
	void peek(){
		T x;
		if (size == 0){
			System.out.println("Stack is empty");
			// return x;
		}
		else
			 System.out.println(stack.get(size-1));
	}
	
	void isEmpty(){
		System.out.println(size == 0);
	}
	
	void size(){
		System.out.println(size);
	}
	
}

public class GenStackMain{
	public static void main(String[] args){
		GenericStack<Integer> intStack = new GenericStack<>();
		intStack.push(2);
		intStack.push(4);
		intStack.pop();
		intStack.peek();
		intStack.isEmpty();
		intStack.size();
		
		GenericStack<String> stringStack = new GenericStack<>();
		stringStack.push("Hello");
		stringStack.push("World");
		stringStack.pop();
		stringStack.peek();
		stringStack.isEmpty();
		stringStack.size();
		
	}
}
