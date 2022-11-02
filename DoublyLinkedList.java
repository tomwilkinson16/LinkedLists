package uk.ac.tees.linkedlistica;

/**
 * Represents a singly linked list.
 *
 * @author Thomas Wilkinson (A0307220@live.tees.ac.uk)
 * @author Annalisa Occhipinti (a.occhipinti@tees.ac.uk)
 */
public class DoublyLinkedList {

    /**
     * Stores the first node in the list.
     */
    public DoublyLinkedListNode head;

    /**
     * Creates a new doubly linked list from an existing array.
     *
     * @param data the array to create the new linked list from
     */
    public DoublyLinkedList(int[] data) {

        // DO NOT MODIFY THIS CONSTRUCTOR.
        for (int i = data.length - 1; i >= 0; i--) {
            DoublyLinkedListNode n = new DoublyLinkedListNode(data[i], head,
                    null);
            if (head != null) {
                head.prev = n;
            }
            head = n;
        }
    }

    /**
     * Gets the length of the doubly linked list.
     *
     * @return the length
     */
    public int getSize() {

        DoublyLinkedListNode current = head;
        int size = 0;

        if (head == null) {
            return 0;
        } else {
            while (current != null) {
                current = current.next;
                size++;

            }
            return size;
        }
    }

    /**
     * Gets the last item in the doubly linked list, or -999 if not found.
     *
     * @return the last item, or -999 if empty
     */
    public int getLast() {

        DoublyLinkedListNode current = head;

        if (head == null) {
            return -999;
        } else {
            while (current.next != null) {
                current = current.next;
            }
            return current.data;
        }
    }

    /**
     * Deletes all nodes with the given value, returning the number of nodes
     * deleted.
     *
     * @param obj the value
     * @return the number of nodes deleted
     */
    public int deleteAllNodesWithValue(int obj) {

        DoublyLinkedListNode current = head.next;

        int counter = 0;

        if (head == null) {
            return counter;
        }
        while (current != null) {
            if (current.data == obj && current.next == null) {
                DoublyLinkedListNode pred = current.prev;

                pred.next = null;
                current.prev = null;
                counter++;
                current = pred;
            }
            if (head.data == obj && head.next == null) {
                head = null;
                counter++;

            } else if (head.data == obj && head.next != null) {
                DoublyLinkedListNode toDelete = head;
                head = toDelete.next;
                toDelete.next.prev = null;
                toDelete = null;
                counter++;
            }
            if (current.data == obj) {
                DoublyLinkedListNode toDelete = current;
                DoublyLinkedListNode pred1 = current.prev;

                pred1.next = toDelete.next;
                toDelete.next.prev = pred1;
                toDelete.next = null;
                toDelete.prev = null;
                current = pred1.next;
                counter++;
            } else {
                current = current.next;
            }
        }
        return counter;
    }

    /**
     * Deletes the node in the list at the specified index.
     *
     * @param index the index
     * @return true if successful, otherwise false
     */
    public boolean deleteAtPos(int index) {

        DoublyLinkedListNode current = head;
        int counter = 0;

        if (head == null) {
            System.out.println("List is empty");
            return false;

        }

        if (index == 0) {
            if (head.next != null) {
                head.next.prev = null;
                head = head.next;
                return true;
            } else {
                head = null;
                return true;
            }
        }

        while (current != null && index >= 1) {
            current = current.next;
            counter++;

            if (index == counter && current.next == null) {
                DoublyLinkedListNode toDelete = current;
                toDelete.prev.next = null;
                toDelete.prev = null;
                toDelete = null;
                return true;
            }
            if (index == counter) {
                DoublyLinkedListNode toDelete = current;
                DoublyLinkedListNode pred = current.prev;

                pred.next = toDelete.next;
                toDelete.next.prev = pred;
                toDelete.prev = null;
                toDelete.next = null;
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    /**
     * Count the number of even nodes in the list.
     *
     * @return number of even nodes
     */
    public int evenNodes() {

        DoublyLinkedListNode current = head;
        int even = 1;

        if (head == null) {
            System.out.println("The list is empty");
            return even;
        }

        while (current.next != null) {
            current = current.next;
            if (current.data % 2 == 0) {
                even++;
            }
        }
        return even;
    }

    /**
     * Delete second node in the list
     *
     * @return true if successful, false if there is no second node in the list
     */
    public boolean deleteSecond() {

        DoublyLinkedListNode current = head;

        int counter = 0;

        if (head == null || head.next == null) {
            return false;
        }

        while (current != null) {
            current = current.next;
            counter++;

            if (counter == 1) {

                DoublyLinkedListNode toDelete = current;
                DoublyLinkedListNode pred = toDelete.prev;
                pred.next = toDelete.next;
                toDelete.next.prev = pred;
                toDelete.prev = null;
                toDelete.next = null;
                return true;
            } else {
                break;
            }
        }
        return false;
    }

    /**
     * Add a new node with value val before the last node (i.e. add it as the
     * second last – or last but one – node). Return true if the node has been
     * added, false if the list has only one node and it can’t be added as
     * second last.
     *
     * @param val the item
     * @return
     */
    public boolean addSecondLast(int val) {

        DoublyLinkedListNode current = head;

        if (head == null) {
            return false;

        }      

        while (current.next != null) {
            current = current.next;

            if (current.next.next == null) {
                DoublyLinkedListNode toAdd = new DoublyLinkedListNode(val);
                DoublyLinkedListNode last = current.next;
                last.prev = toAdd;
                toAdd.next = last;
                current.next = toAdd;
                toAdd.prev = current;
                return true;
            }
        }
        return false;
    }
}
