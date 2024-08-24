/**
 * The <code>ItemInfoNode</code> creates the Nodes containing
 * information about an item along with a next and previous
 * reference
 * @author Andy Yang
 *    email:andy.yang.2@stonybrook.edu
 *    SBU ID: 115104866
 */
public class ItemInfoNode {
    private ItemInfo info;
    private ItemInfoNode next;
    private ItemInfoNode prev;

    /**
     * Constuctor for ItemInfoNode; next and prev
     * are initially set to null
     * @param info value of the Node
     */

    public ItemInfoNode(ItemInfo info) {
        this.info = info;
        this.next = null;
        this.prev = null;
    }

    /**
     * Getter method for info
     * @return the info Node
     */

    public ItemInfo getInfo() {
        return info;
    }

    /**
     * Setter method for info
     * @param info sets the info node
     */

    public void setInfo(ItemInfo info) {
        this.info = info;
    }

    /**
     * Getter method for next
     * @return the next reference of the node
     */

    public ItemInfoNode getNext() {
        return next;
    }

    /**
     * Setter method for next
     * @param next sets the next pointer
     */

    public void setNext(ItemInfoNode next) {
        this.next = next;
    }

    /**
     * Getter method for prev
     * @return the previous pointer
     */

    public ItemInfoNode getPrev() {
        return prev;
    }

    /**
     * Setter method for prev
     * @param prev sets the previous pointer
     */

    public void setPrev(ItemInfoNode prev) {
        this.prev = prev;
    }
}
