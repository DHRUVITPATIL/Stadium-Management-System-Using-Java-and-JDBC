import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static ManageEv ev = new ManageEv();
    private static ManageTk tk = new ManageTk();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        int ch;
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n~~~~~~~~~~~~~Welcome to Stadium Management System~~~~~~~~~~~~~~~~~\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        do{
        System.out.println("Press 1 for Admin");
        System.out.println("Press 2 for user");
        System.out.println("Press 3 for exit");
        System.out.print("Please Enter your choice: ");
        ch = sc.nextInt();

     if(ch==1)
     {
        do {
            System.out.println("Stadium Management System. Welcome Admin!!");
            System.out.println("Press 1 to Add Event");
            System.out.println("Press 2 to View All Events");
            System.out.println("Press 3 to Update Event");
            System.out.println("Press 4 to Delete Event");
            System.out.println("Press 5 to View All Tickets");
            System.out.println("Press 6 to Update Ticket");
            System.out.println("Press 7 to Exit");
            System.out.print("Please Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addEvent(sc);
                    break;
                case 2:
                    viewAllEvents();
                    break;
                case 3:
                    updateEvent(sc);
                    break;
                case 4:
                    deleteEvent(sc);
                    break;
                case 5:
                    viewAllTickets();
                    break;
                case 6:
                    updateTicket(sc);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);
    }
    else if(ch==2)
    {
        do{
        System.out.println("Stadium Management System. Welcome User!!");
        System.out.println("Press 1 to Add Ticket");
        System.out.println("Press 2 to Delete Ticket");
        System.out.println("Press 3 to exit");
        System.out.print("Please Enter your choice: ");
        choice = sc.nextInt();
        switch (choice) {
            case 1:
            addTicket(sc);
            break;
            case 2:
            deleteTicket(sc);
             break;
            case 3:
            System.out.println("Exiting...");
            break;
            default:
                System.out.println("Invalid choice. Please try again.");
        
         } 
        }while (choice != 4);
    }
    else
    {
        System.out.println("Thank you !!");
    }
     }while(ch!=3);
    }



    private static void addEvent(Scanner sc) {
        System.out.print("Enter event name: ");
        String name = sc.next();
        System.out.print("Enter event date (YYYY-MM-DD): ");
        Date date = Date.valueOf(sc.next());
        System.out.print("Enter event time (HH:MM:SS): ");
        Time time = Time.valueOf(sc.next());

        Ev event = new Ev(name, date, time);
        ev.addEvent(event);
        System.out.println("Event added successfully.");
    }

    private static void viewAllEvents() {
        List<Ev> events = ev.getAllEvents();
        for (Ev event : events) {
            System.out.println("Event ID: " + event.getEventId() + ", Name: " + event.getName() +
                    ", Date: " + event.getDate() + ", Time: " + event.getTime());
        }
    }

    private static void updateEvent(Scanner sc) {
        System.out.print("Enter event ID to update: ");
        int eventId = sc.nextInt();
        System.out.print("Enter new event name: ");
        String name = sc.next();
        System.out.print("Enter new event date (YYYY-MM-DD): ");
        Date date = Date.valueOf(sc.next());
        System.out.print("Enter new event time (HH:MM:SS): ");
        Time time = Time.valueOf(sc.next());

        Ev event = new Ev(name, date, time);
        event.setEventId(eventId);
        ev.updateEvent(event);
        System.out.println("Event updated successfully.");
    }

    private static void deleteEvent(Scanner sc) {
        System.out.print("Enter event ID to delete: ");
        int eventId = sc.nextInt();
        ev.deleteEvent(eventId);
        System.out.println("Event deleted successfully.");
    }

    private static void addTicket(Scanner sc) {
        System.out.print("Enter event ID: ");
        int eventId = sc.nextInt();
        System.out.print("Enter customer ID: ");
        int customerId = sc.nextInt();
        System.out.print("Enter seat number: ");
        String seatNumber = sc.next();
        System.out.print("Enter ticket price: ");
        double price = sc.nextDouble();

        Tk ticket = new Tk(eventId, customerId, seatNumber, price);
        tk.addTicket(ticket);
        System.out.println("Ticket added successfully.");
    }

    private static void viewAllTickets() {
        List<Tk> tickets = tk.getAllTickets();
        for (Tk ticket : tickets) {
            System.out.println("Ticket ID: " + ticket.getTicketId() + ", Event ID: " + ticket.getEventId() +
                    ", Customer ID: " + ticket.getCustomerId() + ", Seat Number: " + ticket.getSeatNumber() +
                    ", Price: " + ticket.getPrice());
        }
    }

    private static void updateTicket(Scanner sc) {
        System.out.print("Enter ticket ID to update: ");
        int ticketId = sc.nextInt();
        System.out.print("Enter new event ID: ");
        int eventId = sc.nextInt();
        System.out.print("Enter new customer ID: ");
        int customerId = sc.nextInt();
        System.out.print("Enter new seat number: ");
        String seatNumber = sc.next();
        System.out.print("Enter new ticket price: ");
        double price = sc.nextDouble();

        Tk ticket = new Tk(eventId, customerId, seatNumber, price);
        ticket.setTicketId(ticketId);
        tk.updateTicket(ticket);
        System.out.println("Ticket updated successfully.");
    }

    private static void deleteTicket(Scanner sc) {
        System.out.print("Enter ticket ID to delete: ");
        int ticketId = sc.nextInt();
        tk.deleteTicket(ticketId);
        System.out.println("Ticket deleted successfully.");
    }
}
