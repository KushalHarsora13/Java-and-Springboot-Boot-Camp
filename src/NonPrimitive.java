import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

void main() {

    // =========================
    // Primitive Data Type Array
    // =========================

    // Create an integer array with 20 elements
    int[] arr = new int[20];

    // Fill the array with values 1 to 20
    for (int i = 0; i < arr.length; i++) {
        arr[i] = i + 1;
    }

    // Print all array elements
    for (int i = 0; i < arr.length; i++) {
        System.out.print(arr[i] + " ");
    }

    System.out.println();

    // =========================
    // Non-Primitive Data Types
    // =========================

    // List is an interface, ArrayList is its implementation
    // Stores Integer objects (wrapper class for int)
    List<Integer> list = new ArrayList<>();

    // Add values 1 to 100 into the list
    for (int i = 0; i < 100; i++) {
        list.add(i + 1);
    }

    // Replace the first element
    list.set(0, 1001);

    // Print using a traditional for loop
    System.out.println("Printing list using index-based loop:");
    for (int i = 0; i < list.size(); i++) {
        System.out.print(list.get(i) + " ");
    }

    System.out.println();

    // Print using an enhanced for-each loop
    System.out.println("Printing list using for-each loop:");
    for (Integer record : list) {
        System.out.print(record + " ");
    }

    System.out.println();

    // =========================
    // HashMap Example
    // =========================

    // HashMap stores key-value pairs
    // Character -> Integer
    HashMap<Character, Integer> map = new HashMap<>();

    // Insert entries into the map
    map.put('A', 10);
    map.put('B', 20);
    map.put('C', 30);

    // Retrieve value associated with key 'A'
    System.out.println("A -> " + map.get('A'));

    // Print all key-value pairs
    System.out.println("Contents of HashMap:");
    for (Character key : map.keySet()) {
        System.out.println(key + " -> " + map.get(key));
    }
}