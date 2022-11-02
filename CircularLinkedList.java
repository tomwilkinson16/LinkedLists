package uk.ac.tees.linkedlistica;

/**
 * Represents a circular linked list.
 *
 * @author Thomas Wilkinson (A0307220@live.tees.ac.uk)
 * @author Annalisa Occhipinti (a.occhipinti@tees.ac.uk)
 */
public class CircularLinkedList {

    /**
     * Stores the first node in the list. Should always be a sentinel node.
     */
    public ListNode head;

    /**
     * Creates a new circular linked list from an existing array.
     *
     * @param data the array to create the new linked list from
     */
    public CircularLinkedList(int[] data) {

        // DO NOT MODIFY THIS CONSTRUCTOR.
        // The head is a sentinel node.
        head = new ListNode(-999, null);
        head.next = head; // Complete the circle.

        // Populate list.
        ListNode n = head; // The last item in the circle.
        for (int i = 0; i < data.length; i++) {
            n.next = new ListNode(data[i], head);
            n = n.next;
        }
    }

    /**
     * Gets whether or not the list is empty.
     *
     * @return true if list is empty, otherwise false
     */
    public boolean isEmpty() {

        if (head.next == head) {
            System.out.println("The list is empty");
            return true;
        } else {
            return false;
        }

    }

    /**
     * Returns the list as a string of the form "{item1, item2, ...}"
     *
     * @return the resulting string
     */
    @Override
    public String toString() {

        ListNode current = head.next;
        String output = "{";

        while (current != head) {

            output += current.data;

            if (current.next == head) {

                break;
            }

            output += ", ";

            current = current.next;

        }
        return output + "}";

    }

    /**
     * Count all nodes with the given value, returning the number of nodes.
     *
     * @param obj the value
     * @return the number of nodes with value obj
     */
    public int countNodesWithValue(int obj) {

        int counter = 0;
        ListNode current = head.next;

        while (current != head) {

            if (head.next == head) {
                return 0;
            }

            if (current.data == obj) {
                System.out.println("counter is: " + counter);

                System.out.println("current is: " + current.data);

                counter++;
            }
            current = current.next;
        }
        return counter;
    }

    /**
     * return the index of the first node containing value val, if it exists.
     *
     * Return -999 if the value is not in the list.
     *
     * Remember that we are using a 0-based index system.
     *
     * @param obj the value
     * @return return the index of the first node containing value val, if it
     * exists.
     */
    public int searchIndex(int obj) {

        int index = 0;
        ListNode current = head.next;
        boolean found = false;

        if (head.next == head) {
            return -999;
        }

        while (current != head) {

            if (current.data == obj) {
                found = true;
                break;
            }

            current = current.next;
            index++;
        }
        if (found == false){
            return -999;
            
        }
        return index;
    }

    /**
     * Returns the product of all integers in the list.
     *
     * @return the product
     */
    public int product() {

        ListNode current = head.next;
        int sum = 1;

        while (current != head) {

            if (head.next == head) {
                return sum;
            }
            sum *= current.data;
            current = current.next;

        }
        System.out.println("sum = " + sum);
        return sum;
    }

    /**
     * Deletes any node containing a value that is a multiple of three.
     *
     * @return the number of nodes deleted
     */
    public int deleteMultiplesOfThree() {
        ListNode current = head;
        ListNode nextNode = new ListNode();
        int counter = 0;

        if (head.next == head) {
            System.out.println("\n The list is empty");
        }

        while (current.next != head) {

            
            if (current.next.data % 3 == 0) {
                nextNode.next = current.next.next;
                current.next.next = null;
                current.next = nextNode.next;
                
                counter++;

            }else{
            current = current.next;
            }
        }
        return counter;
    }
}
