import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();

        System.out.println("Enter the number of seats in each row:");
        int seatsPerRow = scanner.nextInt();

        CinemaRoom cinemaRoom = new CinemaRoom(rows, seatsPerRow);
        int option = 0;
        do {
            System.out.println("\n1. Show the seats\n2. Buy a ticket\n0. Exit");
            option = scanner.nextInt();

            switch (option) {
                case 0:
                    break;
                case 1:
                    cinemaRoom.printSeats();
                    break;
                case 2:
                    cinemaRoom.pickSeat();
                    break;
            }

        } while(option != 0);

        scanner.close();
    }
    
}
