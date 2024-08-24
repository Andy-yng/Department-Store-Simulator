/**
 * The <code>ItemList</code> creates a list of ItemInfoNodes and
 * allows it to be manipulated
 * @author Andy Yang
 *    email:andy.yang.2@stonybrook.edu
 *    SBU ID: 115104866
 */
public class ItemList {
    private ItemInfoNode head;
    private ItemInfoNode tail;
    private ItemInfoNode cursor;

    /**
     * Constructor for ItemList
     */

    public ItemList() {
        this.head = null;
        this.tail = null;
        this.cursor = null;
    }

    /**
     * insertInfo inserts a new info into the list. The
     * time complexity for this method is O(n) because
     * worst scenario we need to traverse through the entire
     * list and insert it as the tail
     *
     * @param name name of the item
     * @param rfidTag id of the item
     * @param price cost of the item
     * @param initPosition current/original location of the item
     */
    public void insertInfo(String name, String rfidTag,
                                  double price, String initPosition) {
        ItemInfo newItem = new ItemInfo(name, rfidTag,
                price, initPosition, initPosition);
        ItemInfoNode newNode = new ItemInfoNode(newItem);
        if (head == null) {
            head = newNode;
            tail = newNode;
            cursor = newNode;
            return;
        }
        if (newNode.getInfo().getRfidTagNumber().compareTo
                (head.getInfo().getRfidTagNumber()) <= 0) {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
            return;
        }
        if (tail != null && newNode.getInfo().getRfidTagNumber()
                .compareTo(tail.getInfo().getRfidTagNumber()) >= 0) {
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
            return;
        }
        cursor = head;
        while (cursor.getNext() != null && newNode.getInfo()
                .getRfidTagNumber().compareTo
                (cursor.getNext().getInfo().getRfidTagNumber()) > 0) {
            cursor = cursor.getNext();
        }
        newNode.setNext(cursor.getNext());
        newNode.setPrev(cursor);
        cursor.getNext().setPrev(newNode);
        cursor.setNext(newNode);
    }

    /**
     * removeAllPurchase removes items that have already been checked out
     * @throws EmptyListException if the list is empty
     */
    public void removeAllPurchase() throws EmptyListException {
        if (head == null) {
            throw new EmptyListException("Empty Linked List");
        }
        cursor = head;
        while (cursor != null) {
            if (cursor.getInfo().getCurrentLocation().equals("out")) {
                System.out.println(cursor.getInfo().toString());
                if (cursor == head) {
                    head = cursor.getNext();
                }
                if (cursor == tail) {
                    tail = cursor.getPrev();
                    tail.setNext(null);
                } else {
                    ItemInfoNode temp = cursor.getNext();
                    cursor.getPrev().setNext(cursor.getNext());
                    cursor = temp;
                }
            }

            cursor = cursor.getNext();
        }
    }

    /**
     * moveItem moves changes an item's current location.
     * The time complexity for this method is O(n)
     * because worst case scenario we're changing the last
     * node of the list
     * @param rfidTag id of the item
     * @param source original location of the item
     * @param dest new location of the item
     * @return true if item is successfully moved
     * @throws EmptyListException if the list is empty
     */
    public boolean moveItem(String rfidTag, String source,
                            String dest) throws EmptyListException {
        if (head == null) {
            throw new EmptyListException("Empty Linked List");
        }
        cursor = head;
        while (cursor != null) {
            if ((cursor.getInfo().getOriginalLocation().
                    equals(source) || cursor.getInfo().getCurrentLocation().equals(source)) &&
                    cursor.getInfo().getRfidTagNumber().
                            equals(rfidTag)) {
                if (cursor.getInfo().getCurrentLocation().equals(source)){
                    cursor.getInfo().setOriginalLocation(source);
                }
                cursor.getInfo().setCurrentLocation(dest);
                return true;
            } else {
                cursor = cursor.getNext();
            }
        }
        return false;
    }

    /**
     * Prints all the nodes in the list. Time complexity
     * is O(n)
     * because we need to print all n nodes
     * @throws EmptyListException if the list is empty
     */
    public void printAll() throws EmptyListException {
        if (head == null) {
            throw new EmptyListException("Empty linked list");
        }
        cursor = head;
        while (cursor != null) {
            System.out.println(cursor.getInfo().toString());
            cursor = cursor.getNext();
        }

    }

    /**
     * printByLocation prints only the items of the
     * specified location.
     * The time complexity of this is O(n) because
     * we need to check
     * every single node for its location
     * @param location location of items to be printed
     * @throws EmptyListException if the list is empty
     */
    public void printByLocation(String location)
            throws EmptyListException {
        if (head == null) {
            throw new EmptyListException("Empty linked list");
        }
        cursor = head;
        while (cursor.getNext() != null) {
            if (cursor.getInfo().getCurrentLocation().
                    equals(location)) {
                System.out.println(cursor.getInfo().
                        toString());
            }
            cursor = cursor.getNext();
        }

    }

    /**
     * cleanStore places all the items that's not in cart
     * or checked out back to its original location.
     * Time complexity is O(n) because we need to
     * traverse the entire list to check if the current location
     * does not match the original
     * @throws EmptyListException if list is empty
     */
    public void cleanStore() throws EmptyListException {
        if (head == null) {
            throw new EmptyListException("Empty Linked List");
        }
        cursor = head;
        while (cursor != null) {
            if (cursor.getInfo().getCurrentLocation().
                    charAt(0) != 'c' || !cursor.getInfo().
                    getCurrentLocation().equals("out")) {
                if (!cursor.getInfo().getOriginalLocation().
                        equals(cursor.getInfo().getCurrentLocation())) {
                cursor.getInfo().setCurrentLocation
                        (cursor.getInfo().getOriginalLocation());
                System.out.println(cursor.getInfo().toString());
            }
            }
            cursor = cursor.getNext();
        }
    }

    /**
     * checkOut checks out the items in the cart.
     * Time complexity is O(n) because we need to traverse
     * the entire list to check for items in the cart
     * @param cartNumber cart to be checked out
     * @return total price
     * @throws EmptyListException if list is empty
     */
    public double checkOut(String cartNumber)
            throws EmptyListException {
        if (head == null) {
            throw new EmptyListException("Empty Linked List");
        }
        cursor = head;
        double total = 0;
        while (cursor != null) {
            if (cursor.getInfo().getCurrentLocation()
                    .equals(cartNumber)) {
                total += cursor.getInfo().getPrice();
                cursor.getInfo().setCurrentLocation("out");
                System.out.println(cursor.getInfo().toString());
            }
            cursor = cursor.getNext();
        }
        return total;
    }


}
