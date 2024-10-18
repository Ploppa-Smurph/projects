// imported Random public class
import java.util.Random;
// import Main;

public class Batter {
    // int MIN = 65;
    // int MAX = 115;

    public int atBat () {
        Random random = new Random();
        int swing = 80 + random.nextInt(22);

        System.out.println("The batter swings " + swing + " m.p.h.");
        return swing;
    }
}
