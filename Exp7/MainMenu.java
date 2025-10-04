import java.util.*;

public class MainMenu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. ArrayList Operations on Strings");
            System.out.println("2. Operations on Two Integer Arrays");
            System.out.println("3. Doubly Linked List Operations on Integers");
            System.out.println("4. TreeSet Operations on Student Names");
            System.out.println("5. LinkedHashSet to Store Roll Numbers");
            System.out.println("6. PriorityQueue for Tasks");
            System.out.println("7. Phone Directory using HashMap");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    arrayListStrings(scanner);
                    break;
                case 2:
                    twoIntegerArrays(scanner);
                    break;
                case 3:
                    doublyLinkedListIntegers(scanner);
                    break;
                case 4:
                    treeSetStudentNames(scanner);
                    break;
                case 5:
                    linkedHashSetRollNumbers(scanner);
                    break;
                case 6:
                    priorityQueueTasks(scanner);
                    break;
                case 7:
                    hashMapPhoneDirectory(scanner);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } 
    }

    private static void arrayListStrings(Scanner scanner) {
        ArrayList<String> list = new ArrayList<>();

        
        System.out.println("Enter a string to append:");
        String appendStr = scanner.nextLine();
        list.add(appendStr);

        
        System.out.println("Enter index and string to insert:");
        int index = scanner.nextInt();
        scanner.nextLine(); 
        String insertStr = scanner.nextLine();
        if (index >= 0 && index <= list.size()) {
            list.add(index, insertStr);
        }

        
        System.out.println("Enter string to search:");
        String searchStr = scanner.nextLine();
        int foundIndex = list.indexOf(searchStr);
        System.out.println(
            "Found at index: " + (foundIndex != -1 ? foundIndex : "Not found")
        );

        
        System.out.println("Enter letter:");
        char letter = scanner.nextLine().charAt(0);
        System.out.println("Strings starting with " + letter + ":");
        for (String s : list) {
            if (!s.isEmpty() && s.charAt(0) == letter) {
                System.out.println(s);
            }
        }

        
        System.out.println("All strings:");
        for (String s : list) {
            System.out.println(s);
        }

        
        System.out.println("Substrings containing given string:");
        System.out.println("Enter substring:");
        String sub = scanner.nextLine();
        for (String s : list) {
            if (s.contains(sub)) {
                System.out.println(s);
            }
        }

        
        list.sort(String::compareTo);
        System.out.println("Sorted list: " + list);

        
        System.out.println("Enter string to remove:");
        String removeStr = scanner.nextLine();
        list.remove(removeStr);

        
        System.out.println("Enter old and new string:");
        String oldStr = scanner.nextLine();
        String newStr = scanner.nextLine();
        int replaceIndex = list.indexOf(oldStr);
        if (replaceIndex != -1) {
            list.set(replaceIndex, newStr);
        }

        
        ArrayList<String> unique = new ArrayList<>();
        for (String s : list) {
            if (!unique.contains(s)) {
                unique.add(s);
            }
        }
        list.clear();
        list.addAll(unique);
        System.out.println("List without duplicates: " + list);
    }

    private static void twoIntegerArrays(Scanner scanner) {
        System.out.println("Enter size of first array:");
        int size1 = scanner.nextInt();
        int[] arr1 = new int[size1];
        for (int i = 0; i < size1; i++) {
            arr1[i] = scanner.nextInt();
        }

        System.out.println("Enter size of second array:");
        int size2 = scanner.nextInt();
        int[] arr2 = new int[size2];
        for (int i = 0; i < size2; i++) {
            arr2[i] = scanner.nextInt();
        }

        
        int[] merged = new int[size1 + size2];
        System.arraycopy(arr1, 0, merged, 0, size1);
        System.arraycopy(arr2, 0, merged, size1, size2);
        System.out.println("Merged: " + Arrays.toString(merged));

        
        Set<Integer> union = new HashSet<>();
        for (int num : arr1) union.add(num);
        for (int num : arr2) union.add(num);
        System.out.println("Union: " + union);

        
        Set<Integer> intersection = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();
        for (int num : arr1) set1.add(num);
        for (int num : arr2) {
            if (set1.contains(num)) intersection.add(num);
        }
        System.out.println("Intersection: " + intersection);

        
        List<Integer> common = new ArrayList<>(intersection);
        List<Integer> different = new ArrayList<>();
        for (int num : union) {
            if (!intersection.contains(num)) different.add(num);
        }
        System.out.println("Common: " + common);
        System.out.println("Different: " + different);
    }

    private static void doublyLinkedListIntegers(Scanner scanner) {
        LinkedList<Integer> list = new LinkedList<>();

        
        list.add(10);
        list.add(20);
        list.add(30);

        
        System.out.println("Enter number to insert and side (left/right):");
        int num = scanner.nextInt();
        scanner.nextLine();
        String side = scanner.nextLine();
        if (side.equalsIgnoreCase("left")) {
            list.addFirst(num);
        } else {
            list.addLast(num);
        }

        
        System.out.println("Enter side to delete (left/right):");
        side = scanner.nextLine();
        if (side.equalsIgnoreCase("left")) {
            list.removeFirst();
        } else {
            list.removeLast();
        }

        
        System.out.println("Enter position (0-based) and number:");
        int pos = scanner.nextInt();
        num = scanner.nextInt();
        if (pos >= 0 && pos <= list.size()) {
            list.add(pos, num);
        }

        
        System.out.println("Enter number to delete:");
        num = scanner.nextInt();
        list.remove(Integer.valueOf(num));

        
        System.out.println("Enter number to search:");
        num = scanner.nextInt();
        int index = list.indexOf(num);
        System.out.println("Found at: " + (index != -1 ? index : "Not found"));

        
        System.out.println("Forward: " + list);
        System.out.print("Backward: ");
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        
        System.out.println("Enter old and new number:");
        int oldNum = scanner.nextInt();
        int newNum = scanner.nextInt();
        index = list.indexOf(oldNum);
        if (index != -1) {
            list.set(index, newNum);
        }

        
        LinkedList<Integer> unique = new LinkedList<>();
        for (int n : list) {
            if (!unique.contains(n)) {
                unique.add(n);
            }
        }
        list.clear();
        list.addAll(unique);
        System.out.println("Without duplicates: " + list);
    }

    private static void treeSetStudentNames(Scanner scanner) {
        TreeSet<String> set = new TreeSet<>();

        
        System.out.println("Enter 6 names (some duplicates):");
        for (int i = 0; i < 6; i++) {
            set.add(scanner.nextLine());
        }

        
        System.out.println("Ascending: " + set);

        
        System.out.println("First: " + set.first());
        System.out.println("Last: " + set.last());

        
        System.out.println("Enter name to remove:");
        String name = scanner.nextLine();
        set.remove(name);
        System.out.println("Updated: " + set);
    }

    private static void linkedHashSetRollNumbers(Scanner scanner) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();

        
        System.out.println("Enter 5 roll numbers (with duplicates):");
        for (int i = 0; i < 5; i++) {
            set.add(scanner.nextInt());
        }
        scanner.nextLine(); 

        
        System.out.println("Set (insertion order, no duplicates): " + set);

        
        System.out.println("Enter roll to check:");
        int roll = scanner.nextInt();
        System.out.println("Exists: " + set.contains(roll));
    }

    private static void priorityQueueTasks(Scanner scanner) {
        PriorityQueue<String> queue = new PriorityQueue<>(); 

        
        
        System.out.println("Enter 5 tasks with priority (e.g., 1-TaskA):");
        for (int i = 0; i < 5; i++) {
            queue.add(scanner.nextLine());
        }

        
        

        
        System.out.println("Tasks in priority order:");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

    private static void hashMapPhoneDirectory(Scanner scanner) {
        HashMap<String, String> directory = new HashMap<>();

        
        System.out.println(
            "Enter 3 name-phone pairs (name then phone on separate lines):"
        );
        for (int i = 0; i < 3; i++) {
            String name = scanner.nextLine();
            String phone = scanner.nextLine();
            directory.put(name, phone);
        }
        System.out.println("Directory: " + directory);

        
        System.out.println("Enter name to search:");
        String searchName = scanner.nextLine();
        System.out.println(
            "Phone: " + directory.getOrDefault(searchName, "Not found")
        );

        
        System.out.println("Enter name to remove:");
        String removeName = scanner.nextLine();
        directory.remove(removeName);
        System.out.println("Updated: " + directory);

        
        TreeMap<String, String> treeDirectory = new TreeMap<>(directory);
        System.out.println("TreeMap (sorted): " + treeDirectory);
    }
}
