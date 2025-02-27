class TicketBookingSystem {
    private int availableSeats = 5; 

    public synchronized void bookTicket(String name, int seats) {
        if (seats <= availableSeats) {
            System.out.println(name + " booked " + seats + " seat(s) successfully.");
            availableSeats -= seats;
        } else {
            System.out.println(name + " booking failed. Not enough seats available.");
        }
    }
}

class Customer extends Thread {
    private TicketBookingSystem bookingSystem;
    private String name;
    private int seats;

    public Customer(TicketBookingSystem bookingSystem, String name, int seats, int priority) {
        this.bookingSystem = bookingSystem;
        this.name = name;
        this.seats = seats;
        setPriority(priority); 
    }

    public void run() {
        bookingSystem.bookTicket(name, seats);
    }
}

public class Assignment1Hard {
    public static void main(String[] args) {
        TicketBookingSystem bookingSystem = new TicketBookingSystem();

        Customer vip1 = new Customer(bookingSystem, "VIP-1", 2, Thread.MAX_PRIORITY);
        Customer vip2 = new Customer(bookingSystem, "VIP-2", 1, Thread.MAX_PRIORITY);
        Customer reg1 = new Customer(bookingSystem, "Regular-1", 1, Thread.NORM_PRIORITY);
        Customer reg2 = new Customer(bookingSystem, "Regular-2", 2, Thread.NORM_PRIORITY);
        Customer reg3 = new Customer(bookingSystem, "Regular-3", 1, Thread.MIN_PRIORITY);

        vip1.start();
        vip2.start();
        reg1.start();
        reg2.start();
        reg3.start();
    }
}
