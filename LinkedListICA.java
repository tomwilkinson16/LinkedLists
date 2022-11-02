package uk.ac.tees.linkedlistica;

/**
 * The project main class (intentionally empty).
 *
 * @author Thomas Wilkinson (A0307220@live.tees.ac.uk)
 * @author Saul Johnson (saul.johnson@tees.ac.uk)
 * @author Annalisa Occhipinti (a.occhipinti@tees.ac.uk)
 * @since 23/01/2020
 */
public class LinkedListICA {

    /**
     * The entry point for your program.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* This main method is intentionally left blank. You should test your
         * code using the unit tests provided, and/or write your own if you're
         * feeling up to it. You may also write code here to test your ADTs.
         */

        CircularLinkedList instance = new CircularLinkedList(new int[]{2, 4, 4, 3, 5, 6, 7, 8,9});
        DoublyLinkedList instance1 = new DoublyLinkedList(new int[]{1});

        
        System.out.println("before : " + instance1.toString());
        System.out.println("adding second last " + instance1.addSecondLast(5));
        System.out.println("after: " + instance1.toString());


//
    }

}
