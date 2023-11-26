import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] players = new String[]{"John", "Jack"};

        System.out.println("How many pencils would you like to use:");
        int pencilCount = getPencilCount(scanner);

        String firstName = getFirstName(scanner, players);


        Player player = new Player(players[0]);
        Bot bot = new Bot(players[1]);

        System.out.println("|".repeat(pencilCount));

        boolean isPlayerTurn = firstName.equals(players[0]);
        int nextTurn = isPlayerTurn ? 1 : 0;
        while (pencilCount > 0) {
            System.out.printf("%s's turn!\n", firstName);

            if (nextTurn == 0) {
                pencilCount -= bot.getBotMove(pencilCount);
            } else {
                pencilCount -= player.getPlayerMove(pencilCount);
            }

            System.out.println("|".repeat(pencilCount));

            if (pencilCount == 0) System.out.println(players[nextTurn] + " won!");

            firstName = nextTurn == 0 ? players[0] : players[1];
            nextTurn = nextTurn == 0 ? 1 : 0;
        }
    }



    public static int getPencilCount(Scanner scanner) {
        int pencilCount;
        while (true) {
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("The number of pencils should be numeric");
                continue;
            }
            if (!input.matches("[0-9]+")) {
                System.out.println("The number of pencils should be numeric");
                continue;
            }

            pencilCount = Integer.parseInt(input);

            if (pencilCount == 0) {
                System.out.println("The number of pencils should be positive");
                continue;
            }
            if (pencilCount < 0) {
                System.out.println("The number of pencils should be numeric");
                continue;
            }
            break;
        }
        return pencilCount;
    }



    public static String getFirstName(Scanner scanner, String[] names) {
        System.out.println("Who will be the first (John, Jack):");
        while (true) {
            String answer = scanner.nextLine();
            if (!(answer.equals(names[0]) || answer.equals(names[1]))) {
                System.out.printf("Choose between %s and %s\n", names[0], names[1]);
            } else {
                return answer;
            }
        }
    }
}