import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();

        System.out.println("Enter the number of seats in each row:");
        int seatsPerRow = scanner.nextInt();

        int profit = calculateProfit(rows, seatsPerRow);

        System.out.println("Total income:\n$" + profit);
    }

    public static int calculateProfit(int rows, int seatsPerRow) {        

        int sizeOfSmallerRoom = 60;
        int numberOfSeats = rows * seatsPerRow;
        int profit = 0;
        int frontHalfPrice = 10;
        int backHalfPrice = 8;

        if(numberOfSeats <= sizeOfSmallerRoom) {
            profit = numberOfSeats * frontHalfPrice;
        } else {
            int frontHalf = rows / 2;
            int backHalf = (rows % 2 == 0) ? rows / 2 : rows / 2 + 1;

            profit += frontHalf * seatsPerRow * frontHalfPrice;
            profit += backHalf * seatsPerRow * backHalfPrice;
        }

        return profit;

    }
}
