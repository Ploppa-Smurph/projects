import java.util.Random;

public class Pitcher {

    public int thrown () {
        Random random = new Random();
        int pitchSpeed = 65 + random.nextInt(35);

        System.out.println();
        System.out.println("The pitcher throws the ball " + pitchSpeed + " m.p.h.");
        return pitchSpeed;
    }
}
