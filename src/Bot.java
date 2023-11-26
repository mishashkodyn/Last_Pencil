import java.util.Random;

public class Bot {

    String name;

    public Bot(String name) {
        this.name = name;
    }

    public int getBotMove(int pencilCount) {
        if ((pencilCount - 1) % 4 == 0 && pencilCount >= 5){
            int ans = new Random().nextInt(2) + 1;
            System.out.println(ans);
            return ans;
        } else if (pencilCount % 4 == 0 && pencilCount >= 4){
            System.out.println(3);
            return 3;
        } else if ((pencilCount + 1) % 4 == 0 && pencilCount >= 3) {
            System.out.println(2);
            return 2;
        }

        System.out.println(1);
        return 1;
    }
}
