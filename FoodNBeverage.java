// Subclass FoodNBeverage
public class FoodNBeverage extends AddOn {
    private String itemName;
    private int quantity;

    public FoodNBeverage(String ticketID, Customer customer, String itemName, int quantity) {
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
        double comboPrice = 0.0;
        // Set prices based on itemName (adjust according to your needs)
        switch (itemName) {
            case "FC01":
                comboPrice = 21.00;
                break;
            case "FC02":
                comboPrice = 17.00;
                break;
            case "FC03":
                comboPrice = 14.00;
                break;
            default:
                comboPrice = 0.0; // Handle default case if needed
                break;
        }
        return comboPrice * quantity;
    }
    
    public double getPrice() {
        double price = 0.0;
        if (itemName.equals("FC01")) {
            price = 21.00;
        } else if (itemName.equals("FC02")) {
            price = 17.00;
        } else if (itemName.equals("FC03")) {
            price = 14.00;
        }
        return price;
    }

    // Override toString method to display details
    @Override
    public String toString() {
        return super.toString() + "\nFood & Beverage Price: RM" + calcPrice() + "\n";
    }
}
