/**
 * The <code>InvalidRfidTagNumber</code> is a custom exception that
 * will be thrown if the RFID is invalid
 * @author Andy Yang
 *    email:andy.yang.2@stonybrook.edu
 *    SBU ID: 115104866
 */
public class InvalidRfidTagNumberException extends Exception{
     public InvalidRfidTagNumberException(String message) {
        super(message);
    }

}
