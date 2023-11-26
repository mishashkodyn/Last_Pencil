import java.util.Scanner;

public class Player {
    static final Scanner scanner = new Scanner(System.in);
    String name;

    public Player(String name) {
        this.name = name;
    }

    public int getPlayerMove(int pencilCount) {
        int takenPencils;

        while (true) {
            if (!scanner.hasNextInt()) {
                System.out.println("Possible values: '1', '2' or '3'");
                scanner.next();
                continue;
            }
            takenPencils = scanner.nextInt();

            if (!(takenPencils >= 1 && takenPencils <= 3)) {
                System.out.println("Possible values: '1', '2' or '3'");
                continue;
            } else if(takenPencils > pencilCount) {
                System.out.println("Too many pencils were taken");
                continue;
            }
            break;
        }
        return takenPencils;
    }
}
