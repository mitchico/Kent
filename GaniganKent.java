import java.util.Scanner;

public class CinemaTicketSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final double BASE_PRICE = 200;

        while (true) {
            
            System.out.print("\nEnter customer age or type 'exit' to quit: ");
            String ageInput = scanner.nextLine();
            if (ageInput.equalsIgnoreCase("exit")) {
                System.out.println("Exiting system... Thank you!");
                break;
            }

            int age;
            try {
                age = Integer.parseInt(ageInput);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid age.");
                continue;
            }

            
            System.out.print("Enter day of the week: ");
            String day = scanner.nextLine();

            
            System.out.print("Enter number of tickets: ");
            int numTickets;
            try {
                numTickets = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number of tickets.");
                continue;
            }

            double ticketPrice = BASE_PRICE;
            String discountApplied = "None";

            
            double ageDiscount = 0;
            double dayDiscount = 0;

            if (age < 7) {
                ticketPrice = 0;
                discountApplied = "Free for age below 7";
            } else if (age >= 60) {
                ageDiscount = 0.20;
            }

            if (day.equalsIgnoreCase("Wednesday")) {
                dayDiscount = 0.50;
            }

            
            if (ticketPrice > 0) {
                if (dayDiscount > ageDiscount) {
                    ticketPrice *= (1 - dayDiscount);
                    discountApplied = "50% Wednesday discount";
                } else if (ageDiscount > 0) {
                    ticketPrice *= (1 - ageDiscount);
                    discountApplied = "20% Senior discount";
                }
            }

            double totalPrice = ticketPrice * numTickets;

            
            if (totalPrice > 1000) {
                totalPrice *= 0.90;
                discountApplied += " + 10% bulk discount";
            }

            
            System.out.println("\n--- Ticket Summary ---");
            System.out.println("Tickets: " + numTickets + " x ₱" + String.format("%.2f", ticketPrice));
            System.out.println("Discount applied: " + discountApplied);
            System.out.println("Total price: ₱" + String.format("%.2f", totalPrice));

            if (totalPrice < 200) {
                System.out.println("Minimum purchase not reached");
            }
        }

        scanner.close();
    
		
	}
}