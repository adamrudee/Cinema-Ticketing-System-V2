public abstract class AddOn{
    private String ticketID;
    private Customer composite;
    
    //normal constructor
    public AddOn(String ticketID, Customer composite) {
        this.ticketID = ticketID;
        this.composite = composite;
    }
    
    //mutator method
    public void setTicketID(String ticketID){this.ticketID = ticketID;}
    public void setComposite(Customer composite){this.composite = composite;}
    
    //accessor method
    public String getTicketID() {
        return ticketID;
    }

    // Method to calculate price (to be overridden by subclasses)
    public abstract double calcPrice();

    // Method to display details
    public String toString() {
        return "Customer information: " + composite.toString() + "\nTicket ID\t: " + ticketID;
    }
}