import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();

        System.out.println("Enter the number of seats in each row:");
        int seatsPerRow = scanner.nextInt();

        CinemaRoom cinemaRoom = new CinemaRoom(rows, seatsPerRow);
        cinemaRoom.printSeats();
        cinemaRoom.pickSeat();

        scanner.close();
    }
    
}
