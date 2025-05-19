import java.io.*;
import java.util.*;

public class TestTicket3 {
    public static void main(String args[]) {
        try {
            FileReader fr = new FileReader("input.txt"); // input file
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter("output.txt");
            PrintWriter pw = new PrintWriter(fw);

            Customer customers[] = new Customer[12];

            int i = 0;
            String indata = null;
            while ((indata = br.readLine()) != null && i < customers.length) {
                StringTokenizer st = new StringTokenizer(indata, ";");

                System.out.print("Enter your name\t\t\t: ");
                String customerName = st.nextToken();

                System.out.print("Enter your phone number\t\t: ");
                String customerPhone = st.nextToken();

                System.out.print("Pick a date to watch this movie? [xx/xx/xxxx]: ");
                String datePicked = st.nextToken();

                System.out.println("Code\t\t\tMovie\t\t\t\t\tGenre");
                System.out.println(" S\t\tSpider-Man: Across the Spider-Verse => Action and Comedy");
                System.out.println(" G\t\tGodzilla x Kong: The New Empire => Action and Sci-Fi");
                System.out.println(" J\t\tJohn Wick: Chapter 4           => Action and Thriller");

                System.out.print("\nPlease select the movie you want [S | G | J]: ");
                char movieAnswer = st.nextToken().charAt(0);

                String movieName = " ";
                if (movieAnswer == 'S') {
                    movieName = "Spider-Man: Across the Spider-Verse";
                } else if (movieAnswer == 'G') {
                    movieName = "Godzilla x Kong: The New Empire";
                } else if (movieAnswer == 'J') {
                    movieName = "John Wick: Chapter 4";
                }

                Customer customer = new Customer(customerName, customerPhone, " ", datePicked, movieAnswer, " ", 0, "", ' ');

                customer.displayMovieTimes();

                System.out.print("\nPlease Select the Showtime: ");
                int timeAnsS = Integer.parseInt(st.nextToken());

                String showTime = " ";
                if (movieAnswer == 'S') {
                    if (timeAnsS == 1) {
                        showTime = "10:30 am";
                    } else if (timeAnsS == 2) {
                        showTime = "3:15 pm";
                    } else if (timeAnsS == 3) {
                        showTime = "9:00 pm";
                    }
                } else if (movieAnswer == 'G') {
                    if (timeAnsS == 1) {
                        showTime = "11:00 am";
                    } else if (timeAnsS == 2) {
                        showTime = "4:30 pm";
                    } else if (timeAnsS == 3) {
                        showTime = "8:00 pm";
                    }
                } else if (movieAnswer == 'J') {
                    if (timeAnsS == 1) {
                        showTime = "12:00 am";
                    } else if (timeAnsS == 2) {
                        showTime = "6:40 pm";
                    } else if (timeAnsS == 3) {
                        showTime = "9:00 pm";
                    }
                }
                customer.setShowTime(showTime);
                customer.selectMovieTime(timeAnsS);

                System.out.println("\t\tCategory \t\t\tPrice(RM)");
                System.out.println("\t\tC-Child\t\t\t\t15.00");
                System.out.println("\t\tA-Adult\t\t\t\t30.00");
                System.out.println("\t\tS-Student\t\t\t20.00");

                System.out.print("\nIs there a student among you? [Y/N]: ");
                String student = st.nextToken();

                double studentPrice = 20.00;
                int numStudent = 0;
                double priceStudent = 0.0;

                while (student.equalsIgnoreCase("Y")) {
                    System.out.print("Please enter your student ID number: ");
                    String studentID = st.nextToken();
                    numStudent++;
                    priceStudent += studentPrice;

                    System.out.print("\nIs there another student among you? [Y|N] : ");
                    student = st.nextToken();
                }

                int cTicket = 0;
                int aTicket = 0;
                if (student.equalsIgnoreCase("N")) {
                    System.out.print("\nPlease enter number of child: ");
                    cTicket = Integer.parseInt(st.nextToken());

                    System.out.print("Please enter number of adult: ");
                    aTicket = Integer.parseInt(st.nextToken());
                }

                double childPrice = cTicket * 15.00;
                double adultPrice = aTicket * 30.00;

                int totalWatch = numStudent + cTicket + aTicket;
                double ticketPrice = childPrice + adultPrice + priceStudent;

                int seats[] = new int[157];
                for (int a = 1; a <= 156; a++) {
                    seats[a] = 1; // Mark all seats as available initially
                }

                int selectedSeats[] = new int[totalWatch]; // Fixed-size array to store selected seats
                int selectedIndex = 0; // Index to keep track of selected seats

                for (int a = 1; a <= totalWatch; a++) {
                    System.out.print("Please choose your no. " + a + " seat: ");
                    int chosenSeat = Integer.parseInt(st.nextToken());

                    if (chosenSeat >= 1 && chosenSeat <= 156 && seats[chosenSeat] != 0) {
                        seats[chosenSeat] = 0; // Mark the seat as taken
                        selectedSeats[selectedIndex++] = chosenSeat; // Add the seat to the array
                        System.out.println("Seat " + chosenSeat + " selected.");
                        System.out.println();
                    } else {
                        System.out.println("Invalid seat number or seat already taken. Please choose another seat.");
                        System.out.println();
                        a--; // Decrement i to re-prompt for the same seat
                    }
                }

                int selected = 0;
                System.out.println("\nHow much you want to Add-Ons?");
                System.out.println("1 - to pick only one");
                System.out.println("2 - to pick both");
                System.out.print("Please enter your choice\t: ");

                int addons = Integer.parseInt(st.nextToken());
                if (addons == 1) {
                    selected = 1;
                } else if (addons == 2) {
                    selected = 2;
                }

                AddOn addon[] = new AddOn[selected];

                for (int a = 0; a < addon.length; a++) {
                    System.out.print("\nEnter Ticket ID\t\t\t: ");
                    String ticketID = st.nextToken();

                    System.out.println("\n\t\t\tTypes of Add-ons");
                    System.out.println("\t\t     Enter 1 - Food and Beverage       ");
                    System.out.println("\t\t     Enter 2 - Merchandise          ");
                    System.out.print("Select option\t: ");
                    int option = Integer.parseInt(st.nextToken());

                    if (option == 1) {
                        System.out.println("\tCombo Code \tFood + beverage \t\tPrice(RM)");
                        System.out.println("\tFC01 \t\tCaramel Popcorn + Coke \t\t21.00");
                        System.out.println("\tFC02 \t\tChips + Coke  \t\t\t17.00");
                        System.out.println("\tFC03 \t\tChicken Nuggets + Coke \t\t14.00");

                        System.out.print("Enter FnB code\t: ");
                        String itemName = st.nextToken();

                        String foodName = " ";
                        if (itemName.equals("FC01")) {
                            foodName = "Caramel Popcorn + Coke";
                            System.out.println("Add-on selected\t: " + foodName + "!\n");
                        } else if (itemName.equals("FC02")) {
                            foodName = "Chips + Coke ";
                            System.out.println("Add-on selected\t: " + foodName + "!\n");
                        } else if (itemName.equals("FC03")) {
                            foodName = "Chicken Nuggets + Coke";
                            System.out.println("Add-on selected\t: " + foodName + "!\n");
                        }

                        System.out.print("Enter the quantity of food : ");
                        int quantity = Integer.parseInt(st.nextToken());

                        addon[a] = new FoodNBeverage(ticketID, customer, itemName, quantity);

                    } else if (option == 2) {
                        System.out.println("\tMerchandise Code \tMerchandise Name \t\tPrice(RM)");
                        System.out.println("\tA \t\t\tSpider-man toy \t\t\t50.00");
                        System.out.println("\tB \t\t\tGodzilla & Kong pillow \t\t100.00");
                        System.out.println("\tC \t\t\tJohn Wick wig \t\t\t30.00");

                        System.out.print("\nEnter Merchandise code : ");
                        String itemName = st.nextToken();

                        String merchandiseName = " ";
                        if (itemName.equals("A")) {
                            merchandiseName = "Spider-man toy";
                            System.out.println("Merchandise selected : " + merchandiseName + "\n");
                        } else if (itemName.equals("B")) {
                            merchandiseName = "Godzilla & Kong pillow";
                            System.out.println("Merchandise selected : " + merchandiseName + "\n");
                        } else if (itemName.equals("C")) {
                            merchandiseName = "John Wick wig";
                            System.out.println("Merchandise selected : " + merchandiseName + "\n");
                        }

                        System.out.print("Enter the quantity of merchandise : ");
                        int quantity = Integer.parseInt(st.nextToken());

                        addon[a] = new Merchandise(ticketID, customer, itemName, quantity);
                    }
                }

                double total = 0.0;
                for (int a = 0; a < addon.length; a++) {
                    total += addon[a].calcPrice();
                }
                double totalPrice = total + ticketPrice;
                customer.setQuantity(totalWatch);

                String membership = st.nextToken();
                customer.setMembership(membership);

                char paymentMethod = st.nextToken().charAt(0);
                customer.setPaymentMethod(paymentMethod);

                pw.println("THANK YOU FOR YOUR COMMITMENT!\nHERE'S IS YOUR RECEIPT: ");
                pw.println("--------------------------------------------");
                pw.println("name           : " + customerName);
                pw.println("phone number   : " + customerPhone);
                pw.println("selected date  : " + datePicked);
                pw.println("movie picked   : " + movieName);
                pw.println("time picked    : " + showTime);
                pw.println("Total student ticket (RM): " + priceStudent);
                pw.println("Total child ticket   (RM): " + childPrice);
                pw.println("Total adult ticket   (RM): " + adultPrice);
                pw.println("Total tickets        (RM): " + ticketPrice);
                pw.print("Selected seats : ");
                for (int a = 0; a < selectedSeats.length; a++) {
                    pw.print(selectedSeats[a]);
                    if (a < selectedSeats.length - 1) {
                        pw.print(", ");
                    }
                }
                pw.println();
                // Print details of the addon, using instanceof to determine the type
                for (int a = 0; a < addon.length; a++) {
                    if (addon[a] instanceof FoodNBeverage) {
                        FoodNBeverage foodNBeverage = (FoodNBeverage) addon[a];
                        pw.println("Food and Beverage Add-on:");
                        pw.println("Ticket ID      : " + foodNBeverage.getTicketID());
                        pw.println("Item Name      : " + foodNBeverage.getItemName());
                        pw.println("Quantity       : " + foodNBeverage.getQuantity());
                        pw.println("Price per unit : RM" + foodNBeverage.getPrice());
                        pw.println("Total Price    : RM" + foodNBeverage.calcPrice());
                    } else if (addon[a] instanceof Merchandise) {
                        Merchandise merchandise = (Merchandise) addon[a];
                        pw.println("Merchandise Add-on:");
                        pw.println("Ticket ID      : " + merchandise.getTicketID());
                        pw.println("Item Name      : " + merchandise.getItemName());
                        pw.println("Quantity       : " + merchandise.getQuantity());
                        pw.println("Price per unit : RM" + merchandise.getPrice());
                        pw.println("Total Price    : RM" + merchandise.calcPrice());
                    }
                }
                
                pw.println("Total Price[tickets + add-ons]  : RM" + totalPrice);
                pw.println("membership [yes/no]             : " + membership);
                String paymentName;
                if (paymentMethod == 'D') {
                    paymentName = "Debit/Credit Card";
                    pw.println("Payment method                  : " + paymentName);
                } else if (paymentMethod == 'T') {
                    paymentName = "Touch & Go eWallet";
                    pw.println("Payment method                  : " + paymentName);
                } else if (paymentMethod == 'C') {
                    paymentName = "Cash";
                    pw.println("Payment method                  : " + paymentName);
                }

                double priceAfterDiscount = customer.calcDiscount(totalPrice);
                pw.println("Price after Membership Discount : RM" + String.format("%.2f", priceAfterDiscount));
                double priceAfterDiscount2 = customer.calcPaymentMethod(priceAfterDiscount);
                pw.println("Price after Payment Discount    : RM" + String.format("%.2f", priceAfterDiscount2));
                pw.println("--------------------------------------------");

                String searchID = st.nextToken();
                boolean found = false;
                for (int a = 0; a < addon.length; a++) {
                    if (addon[a].getTicketID().equals(searchID)) {
                        pw.println("Add-on found:");
                        pw.println(addon[a]);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    pw.println("Add-on with Ticket ID " + searchID + " not found.");
                }
                
            }

            br.close();
            pw.close();
            fr.close();
            fw.close();

        } catch (IOException e) {
            System.out.println("Error reading/writing files: " + e.getMessage());
        }
    }
}
