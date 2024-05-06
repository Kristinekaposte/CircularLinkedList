public class Main {
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();

        list.addNode(10, 0); // Adding at the beginning
        list.addNode(20, 1); // Adding at position 1
        list.addNode(30, 2); // Adding at the end
        list.addNode(40, 1); // Adding at position 1

        list.display(); // Display list

        list.deleteNode(0); // Delete first node
        list.display(); // Display list

        list.deleteNode(2); // Delete last node
        list.display(); // Display list

        System.out.println("Search for 20: " + list.search(20)); // Search for 20

        System.out.println("Is list empty: " + list.isEmpty()); // Check if list is empty
    }
}