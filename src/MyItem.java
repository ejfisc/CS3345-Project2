import java.util.*;
public class MyItem implements IDedObject {
    //private class variables
    private int itemID;
    private int itemPrice;
    private List<Integer> itemDescription;

    //constructor
    public MyItem(int id, int price, List<Integer> description) {
        itemID = id;
        itemPrice = price;
        itemDescription = new ArrayList<>();
        for(int i : description) {
            itemDescription.add(i);
        }
    }

    //getID definition
    public int getID() {
        return itemID; 
    }

    //printID definition
    public String printID() {
        String idString = String.valueOf(itemID); //id to string

        String priceString = String.valueOf(itemPrice); //price to string

        //converts List<Integer> to one line string without the brackets and commas from .toString()
        String descriptionString = "";
        for(int i : itemDescription)
            descriptionString += " " + String.valueOf(i); 
        
        String details = idString + " " + priceString + descriptionString;
        return details;
    }
}
