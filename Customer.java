public class Customer{
    private String customerName;
    private String customerPhone;
    private String showTime;
    private String datePicked;
    private char movieAnswer;
    private String category;
    private int quantity;
    private String membership;
    private char paymentMethod;
    
    
    public Customer() {
        this.customerName = "";
        this.customerPhone = "";
        this.showTime = "";
        this.datePicked = " ";
        this.movieAnswer = ' ';
        this.category = "";
        this.quantity = 0;
        this.membership = " ";
        this.paymentMethod = ' ';
    }
    
    //normal constructor
    public Customer(String customerName, String customerPhone, String showTime, String datePicked, char movieAnswer, String category, int quantity, String membership, char paymentMethod){
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.showTime = showTime;
        this.datePicked = datePicked;
        this.movieAnswer = movieAnswer;
        this.category = category;
        this.quantity = quantity;
        this.membership = membership;
        this.paymentMethod = paymentMethod;
    }
    
    //mutator method
    public void setCustomerName(String customerName){this.customerName = customerName;}
    public void setCustomerPhone(String customerPhone){this.customerPhone = customerPhone;}
    public void setShowTime(String showTime){this.showTime = showTime;}
    public void setDatePicked(String datePicked){this.datePicked = datePicked;;}
    public void setMovieAnswer(char movieAnswer){this.movieAnswer = movieAnswer;}
    public void setCategory(String category){this.category = category;}
    public void setQuantity(int quantity){this.quantity = quantity;}
    public void setMembership(String membership){this.membership = membership;}
    public void setPaymentMethod(char paymentMethod){this.paymentMethod = paymentMethod;}

    //accessor method
    public String getCustName(){return customerName;}
    public String getCustPhone(){return customerPhone;}
    public String getShowTime(){return showTime;}
    public String getDatePicked(){return datePicked;}
    public char getMovieAnswer(){return movieAnswer;}
    public String getCategory(){return category;}
    public int getQuantity(){return quantity;}
    public String getMembership(){return membership;}
    public char getPaymentMethod(){return paymentMethod;}
    
    public void displayMovieTimes() {
        if (movieAnswer == 'S') {
            System.out.println("Movie Time options:");
            System.out.println("1 - 10:30 am");
            System.out.println("2 - 3:15 pm");
            System.out.println("3 - 9:00 pm");
        } else if (movieAnswer == 'G') {
            System.out.println("Movie Time options:");
            System.out.println("1 - 11:00 am");
            System.out.println("2 - 4:30 pm");
            System.out.println("3 - 8:00 pm");
        } else if (movieAnswer == 'J') {
            System.out.println("Movie Time options:");
            System.out.println("1 - 12:00 am");
            System.out.println("2 - 6:40 pm");
            System.out.println("3 - 9:00 pm");
        }
    }

    public void selectMovieTime(int timeAnsS) {
        if (movieAnswer == 'S') {
            if (timeAnsS == 1) {
                System.out.println("Showtime selected at 10:30 am!");
            } else if (timeAnsS == 2) {
                System.out.println("Showtime selected at 3:15 pm!");
            } else if (timeAnsS == 3) {
                System.out.println("Showtime selected at 9:00 pm!");
            }
        } else if (movieAnswer == 'G') {
            if (timeAnsS == 1) {
                System.out.println("Showtime selected at 11:00 am!");
            } else if (timeAnsS == 2) {
                System.out.println("Showtime selected at 4:30 pm!");
            } else if (timeAnsS == 3) {
                System.out.println("Showtime selected at 8:00 pm!");
            }
        } else if (movieAnswer == 'J') {
            if (timeAnsS == 1) {
                System.out.println("Showtime selected at 12:00 am!");
            } else if (timeAnsS == 2) {
                System.out.println("Showtime selected at 6:40 pm!");
            } else if (timeAnsS == 3) {
                System.out.println("Showtime selected at 9:00 pm!");
            }
        }
    }
    
    public double calcDiscount(double totalIncome){
        if(getMembership().equalsIgnoreCase("yes")){
            return totalIncome - (totalIncome * 0.05); // %5discount
        }
        else{
            return totalIncome;
        }
    }
    
    //processor method
    public double calcPaymentMethod(double priceAfterDiscount){
        double totalCharge = 0.0, methodDiscount = 0.0;
        if(getPaymentMethod() =='D'){
            methodDiscount = 0.03;
        }
        else if(getPaymentMethod() == 'T'){
            methodDiscount = 0.05;
        }
        else if(getPaymentMethod() == 'C'){
            methodDiscount = 0.0;
        }

        return totalCharge = priceAfterDiscount - (priceAfterDiscount * methodDiscount);
    }
    
    public String toString(){
        return "\nCustomer Name   : " + customerName + "\nCustomer Phone  : " + customerPhone;
    }
}