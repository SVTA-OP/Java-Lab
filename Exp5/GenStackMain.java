import java.util.*;

class GenericStack<T>{
	ArrayList <T> stack = new ArrayList<>();
	int size = 0;
	
	void push(T element){
		stack.add(element);
		size++;
	}
	
	T pop(){
		if (size !=0){
			T x = stack.remove(size - 1);
			size--;
			// System.out.println("Popped value: "+x);
			return x;
		}
		else{
			System.out.println("Cannot pop: Empty Stack");
			return null;
		}
	}
	
	T peek(){                priorityQueue.add(new HashMap.Entry<>("Item "+item, item));
		if (size == 0){
			System.out.println("Stack is empty");
			return null;
		}
		else
			return stack.get(size-1);
	}
	
	boolean isEmpty(){
		return (size == 0);
	}
	
	int size(){
		return size;
	}
	
}

public class GenStackMain{
	public static void main(String[] args){
		GenericStack<Integer> intStack = new GenericStack<>();
		intStack.push(2);
		intStack.push(4);
		System.out.println("Popped element: "+intStack.pop());
		System.out.println("Peeked element: "+intStack.peek());
		System.out.println("Stack is empty: "+intStack.isEmpty());
		System.out.println("Stack size: "+intStack.size());
		
		System.out.println("==============================================");

		GenericStack<String> stringStack = new GenericStack<>();
		stringStack.push("Hello");
		stringStack.push("World");
		System.out.println("Popped element"+stringStack.pop());
		System.out.println("Peeked element: "+stringStack.peek());
		System.out.println("Stack is empty: "+stringStack.isEmpty());
		System.out.println("Stack size: "+stringStack.size());
		
	}
}
