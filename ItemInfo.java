/**
 * The <code>ItemInfo</code> creates the information for
 * an item within the Node
 * @author Andy Yang
 *    email:andy.yang.2@stonybrook.edu
 *    SBU ID: 115104866
 */
public class ItemInfo {
    private String name;
    private double price;
    private String rfidTagNumber;
    private String originalLocation;
    private String currentLocation;

    /**
     * Constructor for ItemInfo
     * @param name name of item
     * @param rfidTagNumber rfid of item
     * @param price cost of item
     * @param originalLocation original location of item
     * @param currentLocation current location of item which is initially
     * set to originalLocation by default
     */

    public ItemInfo(String name, String rfidTagNumber,
                    double price, String originalLocation, String currentLocation) {
        this.name = name;
        this.price = price;
        this.rfidTagNumber = rfidTagNumber;
        this.originalLocation = originalLocation;
        this.currentLocation = currentLocation;
    }

    /**
     * Getter method for the name of the item
     * @return name of the item
     */

    public String getName() {
        return name;
    }

    /**
     * Setter method for the name of the item
     * @param name sets name
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for price
     * @return price of an item
     */

    public double getPrice() {
        return price;
    }

    /**
     * Setter method for price
     * @param price sets the price of the item
     */

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Getter method for RfidTagNumber
     * @return RfidTagNumber of the item
     */

    public String getRfidTagNumber() {
        return rfidTagNumber;
    }

    /**
     * Setter method for RfidTagNumber
     * @param rfidTagNumber sets the RfidTag for the item
     */

    public void setRfidTagNumber(String rfidTagNumber) {
        this.rfidTagNumber = rfidTagNumber;
    }

    /**
     * Getter method for originalLocation
     * @return the original location of the item
     */

    public String getOriginalLocation() {
        return originalLocation;
    }

    /**
     * Setter method for originalLocation
     * @param originalLocation sets the original location of the item
     */

    public void setOriginalLocation(String originalLocation) {
        this.originalLocation = originalLocation;
    }

    /**
     * Getter method for currentLocation
     * @return the current location of the item
     */

    public String getCurrentLocation() {
        return currentLocation;
    }

    /**
     * Setter method for currentLocation
     * @param currentLocation sets the current location of the item
     */

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    /**
     * toString method for ItemInfo
     * @return the name, tag number, original location,
     * current location, and the price of the item
     */
    public String toString() {
        return String.format("%-15s %-13s %-16s %-11s %-3.2f",
                this.name, this.rfidTagNumber, this.originalLocation,
                this.currentLocation, this.price );
    }
}
