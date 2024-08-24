/**
 * The <code>DepartmentStore</code> is where the main program will run
 * @author Andy Yang
 *    email:andy.yang.2@stonybrook.edu
 *    SBU ID: 115104866
 */
import java.util.Scanner;
public class DepartmentStore {
    /**
     * main program to run the simulation
     * @param args
     * @throws EmptyListException if list is empty
     */
    public static void main(String []args)
            throws EmptyListException,
            InvalidRfidTagNumberException, InvalidLocationException {
        ItemList items = new ItemList();
        System.out.println("Welcome!\n" +
                "\t\n" +
                "    C - Clean store \n" +
                "    I - Insert an item into the list \n" +
                "    L - List by location \n" +
                "    M - Move an item in the store \n" +
                "    O - Checkout  \n" +
                "    P - Print all items in store \n" +
                "    R - Print by RFID tag number \n" +
                "    U - Update inventory system   \n" +
                "    Q - Exit the program.");
        while (true) {
            Scanner stdin = new Scanner(System.in);
            System.out.println("Please select an option: ");
            String option = stdin.nextLine().toUpperCase();
            switch (option) {
                case "C":
                    System.out.println("The following item(s) have been" +
                            " moved back to their original locations:");
                    printHeader();
                    items.cleanStore();
                    break;
                case "I":
                    System.out.println("Enter the name: ");
                    String name = stdin.nextLine();
                    System.out.println("Enter the RFID: ");
                    String rfid = stdin.nextLine().toUpperCase();
                    if (!isValidRFID(rfid)) {
                        throw new InvalidRfidTagNumberException("Invalid Rfid");
                    }
                    System.out.println("Enter the original location:");
                    String location = stdin.nextLine().toLowerCase();
                    if (!isValidLocation(location)) {
                        throw new InvalidLocationException("Invalid location");
                    }
                    System.out.println("Enter the price:");
                    double price = stdin.nextDouble();
                    items.insertInfo(name, rfid, price, location);
                    System.out.println("Item inserted.");
                    break;
                case "L":
                    System.out.println("Enter the location");
                    String locate = stdin.nextLine();
                    printHeader();
                    items.printByLocation(locate);
                    break;
                case "M":
                    System.out.println("Enter the RFID:");
                    String id = stdin.nextLine().toUpperCase();
                    if (!isValidRFID(id)) {
                        throw new InvalidRfidTagNumberException("Invalid Rfid");
                    }
                    System.out.println("Enter the original location: ");
                    String original = stdin.nextLine();
                    if (!isValidLocation(original) && !isValidCart(original)) {
                        throw new InvalidLocationException("Invalid location");
                    }
                    System.out.println("Enter the new location:");
                    String dest = stdin.nextLine();
                    if (!isValidLocation(dest) && !isValidCart(dest)) {
                        throw new InvalidLocationException("Invalid location");
                    }
                    items.moveItem(id, original,dest);
                    break;
                case "O":
                    System.out.println("Enter the cart number: ");
                    String checkOut = stdin.nextLine();
                    if (!isValidCart(checkOut)) {
                        throw new InvalidLocationException("Invalid cart");
                    }
                    printHeader();
                    double total = items.checkOut(checkOut);
                    items.checkOut(checkOut);
                    System.out.println("Your total is " + String.format("%.2f",total));
                    break;
                case "P":
                    printHeader();
                    items.printAll();
                    break;
                case "U":
                    System.out.println("The following " +
                            "item(s) have removed from the system:");
                    printHeader();
                    items.removeAllPurchase();
                    break;
                case "Q":
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please select a valid option. ");

           }
        }
    }

    /**
     * checks if it's a valid RFID
     * @param rfid id number to be checked
     * @return true or false
     */
    public static boolean isValidRFID(String rfid){
        if (rfid.length() != 9) {
            return false;
        }
        return rfid.matches("^[0-9a-fA-F]+$");
    }

    /**
     * checks if it's a valid location
     * @param location to be checked
     * @return true of false
     */
    public static boolean isValidLocation(String location) {
        if (location.length() != 6) {
            return false;
        }
        if (location.charAt(0) != 's') {
            return false;
        }
        for (int i = 1; i < location.length(); i++) {
            if (!Character.isDigit(location.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * checks if the cart number is valid
     * @param cart to be checked
     * @return true or false
     */
    public static boolean isValidCart(String cart) {
        if (cart.length() != 4 || cart.charAt(0)  != 'c') {
            return false;
        }
        for (int i = 1; i < cart.length(); i++) {
            if (!Character.isDigit(cart.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Prints the header
     */
    public static void printHeader() {
        System.out.println("                               " +
                "Original        Current");
        System.out.println("Item Name         RFID         " +
                "Location        Location     Price");
        System.out.println("---------       ---------     " +
                "---------        ---------   ------");
    }
}
