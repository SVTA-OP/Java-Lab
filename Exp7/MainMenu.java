import java.util.*;

public class MainMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
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
            scanner.nextLine(); // Consume newline

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
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void arrayListStrings(Scanner scanner) {
        ArrayList<String> list = new ArrayList<>();

        // a. Append to the list
        System.out.println("Enter a string to append:");
        String appendStr = scanner.nextLine();
        list.add(appendStr);

        // b. Insert at a particular index
        System.out.println("Enter index and string to insert:");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        String insertStr = scanner.nextLine();
        if (index >= 0 && index <= list.size()) {
            list.add(index, insertStr);
        }

        // c. Search for an element
        System.out.println("Enter string to search:");
        String searchStr = scanner.nextLine();
        int foundIndex = list.indexOf(searchStr);
        System.out.println("Found at index: " + (foundIndex != -1 ? foundIndex : "Not found"));

        // d. Display list starting with given letter
        System.out.println("Enter letter:");
        char letter = scanner.nextLine().charAt(0);
        System.out.println("Strings starting with " + letter + ":");
        for (String s : list) {
            if (!s.isEmpty() && s.charAt(0) == letter) {
                System.out.println(s);
            }
        }

        // e. Display all strings
        System.out.println("All strings:");
        for (String s : list) {
            System.out.println(s);
        }

        // f. Display substrings
        System.out.println("Substrings containing given string:");
        System.out.println("Enter substring:");
        String sub = scanner.nextLine();
        for (String s : list) {
            if (s.contains(sub)) {
                System.out.println(s);
            }
        }

        // g. Sort the elements
        list.sort(String::compareTo);
        System.out.println("Sorted list: " + list);

        // h. Remove a particular element
        System.out.println("Enter string to remove:");
        String removeStr = scanner.nextLine();
        list.remove(removeStr);

        // i. Replace one element with another
        System.out.println("Enter old and new string:");
        String oldStr = scanner.nextLine();
        String newStr = scanner.nextLine();
        int replaceIndex = list.indexOf(oldStr);
        if (replaceIndex != -1) {
            list.set(replaceIndex, newStr);
        }

        // j. Remove duplicates
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

        // a. Merge the two lists
        int[] merged = new int[size1 + size2];
        System.arraycopy(arr1, 0, merged, 0, size1);
        System.arraycopy(arr2, 0, merged, size1, size2);
        System.out.println("Merged: " + Arrays.toString(merged));

        // b. Find union
        Set<Integer> union = new HashSet<>();
        for (int num : arr1) union.add(num);
        for (int num : arr2) union.add(num);
        System.out.println("Union: " + union);

        // c. Find intersection
        Set<Integer> intersection = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();
        for (int num : arr1) set1.add(num);
        for (int num : arr2) {
            if (set1.contains(num)) intersection.add(num);
        }
        System.out.println("Intersection: " + intersection);

        // d. Compare and list common and different
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

        // Assume some initial elements
        list.add(10);
        list.add(20);
        list.add(30);

        // a. Insert on either side
        System.out.println("Enter number to insert and side (left/right):");
        int num = scanner.nextInt();
        scanner.nextLine();
        String side = scanner.nextLine();
        if (side.equalsIgnoreCase("left")) {
            list.addFirst(num);
        } else {
            list.addLast(num);
        }

        // b. Delete from either side
        System.out.println("Enter side to delete (left/right):");
        side = scanner.nextLine();
        if (side.equalsIgnoreCase("left")) {
            list.removeFirst();
        } else {
            list.removeLast();
        }

        // c. Insert at a particular position
        System.out.println("Enter position (0-based) and number:");
        int pos = scanner.nextInt();
        num = scanner.nextInt();
        if (pos >= 0 && pos <= list.size()) {
            list.add(pos, num);
        }

        // d. Delete a particular element
        System.out.println("Enter number to delete:");
        num = scanner.nextInt();
        list.remove(Integer.valueOf(num));

        // e. Search for a particular element
        System.out.println("Enter number to search:");
        num = scanner.nextInt();
        int index = list.indexOf(num);
        System.out.println("Found at: " + (index != -1 ? index : "Not found"));

        // f. Display forward and backward
        System.out.println("Forward: " + list);
        System.out.print("Backward: ");
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        // g. Replace one element in the list with another
        System.out.println("Enter old and new number:");
        int oldNum = scanner.nextInt();
        int newNum = scanner.nextInt();
        index = list.indexOf(oldNum);
        if (index != -1) {
            list.set(index, newNum);
        }

        // h. Remove duplicate elements
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

        // a. Insert at least 6 names (with duplicates)
        System.out.println("Enter 6 names (some duplicates):");
        for (int i = 0; i < 6; i++) {
            set.add(scanner.nextLine());
        }

        // b. Display in ascending order
        System.out.println("Ascending: " + set);

        // c. Find and display first and last elements
        System.out.println("First: " + set.first());
        System.out.println("Last: " + set.last());

        // d. Remove one element and display updated set
        System.out.println("Enter name to remove:");
        String name = scanner.nextLine();
        set.remove(name);
        System.out.println("Updated: " + set);
    }

    private static void linkedHashSetRollNumbers(Scanner scanner) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();

        // a. Insert roll numbers in random order with duplicates
        System.out.println("Enter 5 roll numbers (with duplicates):");
        for (int i = 0; i < 5; i++) {
            set.add(scanner.nextInt());
        }
        scanner.nextLine(); // Consume newline if needed

        // b. Display to show insertion order is maintained and duplicates eliminated
        System.out.println("Set (insertion order, no duplicates): " + set);

        // c. Check whether a specific roll number exists
        System.out.println("Enter roll to check:");
        int roll = scanner.nextInt();
        System.out.println("Exists: " + set.contains(roll));
    }

    private static void priorityQueueTasks(Scanner scanner) {
        PriorityQueue<String> queue = new PriorityQueue<>(); // Natural order (alphabetical for strings)

        // a. Each task has a String taskName and int priority (lower number = higher priority)
        // Note: For simplicity, using strings with priority prefix, e.g., "1-TaskA"
        System.out.println("Enter 5 tasks with priority (e.g., 1-TaskA):");
        for (int i = 0; i < 5; i++) {
            queue.add(scanner.nextLine());
        }

        // b. Insert at least 5 tasks into the queue
        // Already done above

        // c. Display tasks being executed in order of priority
        System.out.println("Tasks in priority order:");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

    private static void hashMapPhoneDirectory(Scanner scanner) {
        HashMap<String, String> directory = new HashMap<>();

        // a. Insert names as keys and phone numbers as values
        System.out.println("Enter 3 name-phone pairs (name then phone on separate lines):");
        for (int i = 0; i < 3; i++) {
            String name = scanner.nextLine();
            String phone = scanner.nextLine();
            directory.put(name, phone);
        }
        System.out.println("Directory: " + directory);

        // b. Search for a person's phone number by name
        System.out.println("Enter name to search:");
        String searchName = scanner.nextLine();
        System.out.println("Phone: " + directory.getOrDefault(searchName, "Not found"));

        // c. Remove an entry and display updated map
        System.out.println("Enter name to remove:");
        String removeName = scanner.nextLine();
        directory.remove(removeName);
        System.out.println("Updated: " + directory);

        // d. Try the same with TreeMap (keys stored in sorted order)
        TreeMap<String, String> treeDirectory = new TreeMap<>(directory);
        System.out.println("TreeMap (sorted): " + treeDirectory);
    }
}