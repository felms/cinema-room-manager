import java.util.Scanner;

public class CinemaRoom {

    private String[][] seats;
    private Scanner scanner;
    private int rows;
    private int seatsPerRow;
    private int totalSeats;
    private int purchasedTickets;

    public CinemaRoom(int rows, int seatsPerRow) {

        scanner = new Scanner(System.in);
        this.rows = rows;
        this.seatsPerRow = seatsPerRow;
        this.totalSeats = rows * seatsPerRow;
        this.purchasedTickets = 0;
        this.seats = new String[rows][seatsPerRow];

        for(int i = 0; i < seats.length; i++) {
            for(int j = 0; j < seats[i].length; j++) {
                seats[i][j] = "S";
            }
        }
    }

    public void pickSeat() {


        boolean seatPicked = false;
        while (!seatPicked) {
            System.out.println("\nEnter a row number:");
            int row = this.scanner.nextInt();

            System.out.println("Enter a seat number in that row:");
            int seatNumber = this.scanner.nextInt();

            if (row - 1 >= this.rows || seatNumber - 1 >= this.seatsPerRow ||
                    row < 1 || seatNumber < 1) {
                System.out.println("\nWrong input!");

            } else if(seats[row - 1][seatNumber - 1].compareTo("B") == 0) {
                System.out.println("\nThat ticket has already been purchased!");

            }  else {
                seats[row - 1][seatNumber - 1] = "B";
                this.purchasedTickets++;

                int price = ticketPrice(row, seatNumber);

                System.out.println("\nTicket price: $" + price);
                seatPicked = true;
            }

        }


    }

    public void statistics() {
        double percentagePurchased = ((double) this.purchasedTickets / (double) this.totalSeats ) * 100.0;
        int currentIncome = currentProfit();
        int totalIncome = calculateProfit();

        System.out.printf("\nNumber of purchased tickets: %d\n" +
                        "Percentage: %.2f%%\n" +
                        "Current income: $%d\n" +
                        "Total income: $%d\n",
                this.purchasedTickets, percentagePurchased, currentIncome, totalIncome);

    }

    private int currentProfit() {

        int frontHalf = this.rows / 2;
        int sizeOfSmallerRoom = 60;
        int profit = 0;
        int frontHalfPrice = 10;
        int backHalfPrice = 8;

        for(int i = 0; i < this.rows; i++) {
            for(int j = 0; j < this.seatsPerRow; j++) {

                if (this.seats[i][j].compareTo("B") == 0) {
                    if (this.totalSeats <= sizeOfSmallerRoom || i < frontHalf) {
                        profit += frontHalfPrice;
                    } else {
                        profit += backHalfPrice;
                    }
                }
            }
        }

        return profit;
    }

    private int calculateProfit() {

        int sizeOfSmallerRoom = 60;
        int profit = 0;
        int frontHalfPrice = 10;
        int backHalfPrice = 8;

        if(this.totalSeats <= sizeOfSmallerRoom) {
            profit = this.totalSeats * frontHalfPrice;
        } else {
            int frontHalf = this.rows / 2;
            int backHalf = (this.rows % 2 == 0) ? this.rows / 2 : this.rows / 2 + 1;

            profit += frontHalf * seatsPerRow * frontHalfPrice;
            profit += backHalf * seatsPerRow * backHalfPrice;
        }

        return profit;

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
    }
}

