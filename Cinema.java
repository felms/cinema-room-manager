public class Cinema {

    public static void main(String[] args) {
        
        int rows = 7;
        int seatsPerRow = 8;

        // Imprime o cabeçalho
        System.out.println("Cinema:\n  1 2 3 4 5 6 7 8");

        for(int i = 1; i <= rows; i++) {
            System.out.print(i);

            for(int j = 0; j < seatsPerRow; j++) {
                System.out.print(" S");
            }

            System.out.println();
        }
    }
}