// Subclass Merchandise
public class Merchandise extends AddOn {
    private String itemName;
    private int quantity;

    public Merchandise(String ticketID, Customer customer, String itemName, int quantity) {
        super(ticketID, customer);
        this.itemName = itemName;
        this.quantity = quantity;
    }

    // Mutator methods
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Getter methods
    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    // Calculate price based on itemName and quantity
    public double calcPrice() {
        double merchPrice = 0.0;
        // Set prices based on itemName (adjust according to your needs)
        switch (itemName) {
            case "A":
                merchPrice = 50.00;
                break;
            case "B":
                merchPrice = 100.00;
                break;
            case "C":
                merchPrice = 30.00;
                break;
            default:
                merchPrice = 0.0; // Handle default case if needed
                break;
        }
        return merchPrice * quantity;
    }
    
    public double getPrice() {
        double price = 0.0;
        if (itemName.equals("A")) {
            price = 50.00;
        } else if (itemName.equals("B")) {
            price = 100.00;
        } else if (itemName.equals("C")) {
            price = 30.00;
        }
        return price;
    }
    
    // Override toString method to display details
    @Override
    public String toString() {
        return super.toString() + "\nMerchandise Price: RM" + calcPrice() + "\n";
    }
}
