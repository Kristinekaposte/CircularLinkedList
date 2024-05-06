public class CircularLinkedList {
    private Node head = null; // will store the reference to the first node in the list
    private Node tail = null; // will store the reference to the last node in the list

    private class Node { // inner class will be used to create new nodes for circular linked list
        int data; // data stored in node
        Node next; // the reference to next node

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }


    // Method to add a node to the circular linked list
    public void addNode(int data, int position) {
        Node newNode = new Node(data); // creates a new node with given data
        if (isEmpty()) {
            // if list is empty, new node becomes both head and tail, and points to itself
            head = tail = newNode;
            newNode.next = head;
        } else { // else, it will add the node either at the beginning, a specified position, or at the end
            if (position <= 0) {
                // Adding node at the beginning of the list
                newNode.next = head;
                head = newNode;
                tail.next = head;
            } else {
                // Adding at some specified position or at the end
                Node temp = head;
                for (int i = 1; temp.next != head && i < position; i++) {
                    temp = temp.next;
                }
                newNode.next = temp.next;
                temp.next = newNode;
                if (temp == tail) {
                    // If the new node is added after the tail, it becomes the new tail
                    tail = newNode;
                }
            }
        }
    }


    // Method to delete a node from the circular linked list
    public void deleteNode(int position) {
        if (isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }
        if (head == tail) {
            // Only one node in the list
            head = tail = null;
        } else {
            if (position <= 0) {
                // Deleting the first node
                head = head.next;
                tail.next = head;
            } else {
                // Deleting a node at some specified position or at the end
                Node temp = head;
                Node prev = null;
                for (int i = 0; temp.next != head && i < position; i++) {
                    prev = temp;
                    temp = temp.next;
                }
                if (temp == tail) {
                    // If the last node is deleted, update the tail
                    tail = prev;
                }
                prev.next = temp.next;
            }
        }
    }


    // Method to search for an element in the circular linked list
    public boolean search(int key) {
        if (isEmpty()) {
            return false;
        }
        Node temp = head;
        do {
            if (temp.data == key) {
                return true;
            }
            temp = temp.next;
        } while (temp != head);
        return false;
    }

    // to check whether a list is empty.
    public boolean isEmpty() {
        return head == null;
    }

    // to print a list data.
    public void display() {
        if (isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            Node temp = head;
            do {
                System.out.print(temp.data + " ");
                temp = temp.next;
            } while (temp != head);
            System.out.println();
        }
    }
}
