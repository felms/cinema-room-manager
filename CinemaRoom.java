import java.util.Scanner;

public class CinemaRoom {
    
    private String[][] seats;
    private Scanner scanner;
    private int rows;
    private int seatsPerRow;

    public CinemaRoom(int rows, int seatsPerRow) {

        scanner = new Scanner(System.in);
        this.rows = rows;
        this.seatsPerRow = seatsPerRow;
        this.seats = new String[rows][seatsPerRow];

        for(int i = 0; i < seats.length; i++) {
            for(int j = 0; j < seats[i].length; j++) {
                seats[i][j] = "S";
            }
        }
    }

    public void pickSeat() {

        System.out.println("Enter a row number:");
        int row = this.scanner.nextInt();

        System.out.println("Enter a seat number in that row:");
        int seatNumber = this.scanner.nextInt();

        seats[row - 1][seatNumber - 1] = "B";

        int price = ticketPrice(row, seatNumber);

        System.out.println("\n\nTicket price: $" + price);

        printSeats();

    }    

    public int ticketPrice(int row, int seat) {        

        int sizeOfSmallerRoom = 60;
        int numberOfSeats = this.rows * this.seatsPerRow;
        int frontHalfPrice = 10;
        int backHalfPrice = 8;
        int price = 0;

        if(numberOfSeats <= sizeOfSmallerRoom) {
            price = frontHalfPrice;
        } else {
            int frontHalf = this.rows / 2;

            if(row <= frontHalf) {
                price = frontHalfPrice;
            } else {
                price = backHalfPrice;
            }
        }

        return price;

    }

    public void printSeats() {

        System.out.println("\n\nCinema:");

        for(int i = 0; i < this.rows + 1; i++) {
            for(int j = 0; j < this.seatsPerRow + 1; j++) {
                if (i == 0 && j == 0) {
                    System.out.print("  ");
                } else if (i == 0) {
                    System.out.print(j + " ");
                } else if (j == 0) {
                    System.out.print(i + " ");
                } else {
                    System.out.print(seats[i - 1] [j - 1] + " ");
                }

            }
            System.out.println();
        }

        System.out.println("\n");
    }
}
