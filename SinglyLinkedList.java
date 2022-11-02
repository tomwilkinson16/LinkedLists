package uk.ac.tees.linkedlistica;

/**
 * Represents a singly linked list.
 * @author Thomas Wilkinson (A0307220@live.tees.ac.uk)
 * @author Annalisa Occhipinti (a.occhipinti@tees.ac.uk)
 */
public class SinglyLinkedList {
    
    /**
     * Stores the first node in the list.
     */
    public ListNode head;
    
    /**
     * Creates a new singly linked list from an existing array.
     * @param data  the array to create the new linked list from
     */
    public SinglyLinkedList(int[] data) {
        
        // DO NOT MODIFY THIS CONSTRUCTOR.
        
        // Populate list.
        for (int i = data.length - 1; i >= 0; i--) {
            head = new ListNode(data[i], head);
        }
    }
    
    /**
     * Creates a new, empty singly linked list.
     */
    public SinglyLinkedList() {
        
        // DO NOT MODIFY THIS CONSTRUCTOR.
        
        this(new int[] {});
    }
    
    
   /**
     * Adds an item at the front of the list.
     * @param value   the item to add
     */
    public void addFirst(int value){
        
        ListNode n = new ListNode(value);
        n.next = head;
        head = n;
        
    }
     
    /**
     * Gets the item at the specified index in the list.
     * @param index the index
     * @return      the item, or -999 if not found
     */
    public int getAtPos(int index) {
        
        int counter = 0;
        ListNode current = head;
        
        if (head == null){
            return -999;
        }else
            while (counter != index){
                counter++;
                current = current.next;
                    
            }return current.data;
    }    
     /**
     * Count all nodes with the given value, returning the number of nodes.
     * @param obj   the value
     * @return      the number of nodes with value obj
     */
    public int countNodesWithValue(int obj) {
        
        
        ListNode current = head;
        int countObj = 0;
        
        if (head == null){
            return 0;
        }else
        
            while (current.next != null){

                current = current.next;
                if (current.data == obj){
                    countObj++;
                }
            }
        return countObj;
    }
    
    
        /**
     * Gets the last item in the circular linked list, or -999 if not found.
     * @return  the last item, or -999 if empty
     */
    public int getLast() {  
        
        ListNode current = head;

        if (head == null) {
            return -999;
        }else
            while (current.next != null) {
                current = current.next;
            }
        return current.data;
    }
    
    
     /**
     * Adds a piece of data at the specified index.
     * @param obj   the data
     * @param index the index
     * @return      true on successful insert, otherwise false
     */
    public boolean addAtPos(int obj, int index) {

        ListNode current = head;
        ListNode newNode = new ListNode(obj);
        
        if (head == null) {
            head = newNode;
            return true;
        } else{
            int counter = 0;
            while (current != null) {
                if (counter == index-1){
                    counter++;
                    newNode.next = current.next;
                    current.next = newNode;
                    return true;
                }
                counter++;
                current = current.next;
            }
            if (counter == index){
                current.next = newNode;
                return true;
            }return false;
            
                
        }
    }
    
    
    
         /**
     * Appends a singly linked list to this circular linked list.
     * @param list  the singly linked list to append
     */
    public void appendSinglyLinkedList(SinglyLinkedList list) {

        ListNode current = head;
        if (head == null){
            head = current;

            
        }else{        
            while(current != null) {    
                current = current.next;    
            }
            head.next = current.next;
            
            

        }    
    }       

       /**
     * Returns the sum of all integers in the list.
     * @return  the sum
     */
    public int sum() {

        ListNode current = head;
        int total = 0;

        if (head == null){
            System.out.println("The List is empty");
        }else{
            
            while (current.next != null){
                current = current.next;
                total += current.data;

            }
        }return total;
        
    }
    
}

