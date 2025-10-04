import java.util.*;

class ListQ {
    public static void main(String args[]){
        
        List<Integer> list = new ArrayList<>();

        for (int i=1; i<7; i++) {
            list.add(i);
        }
        System.out.println("Original List: ");
        list.forEach(num -> System.out.println(num));

        list.removeIf(num -> num % 2 == 0);

        System.out.println("Modified List: ");
        list.forEach(num -> System.out.println(num));
    }
}