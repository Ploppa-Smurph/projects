import java.util.Random;

public class Ball {

    public void position () {
        String[] ballPosition = {"up and in.", "down and away.", "on the edge of the plate.", "around the batter's knees.", "right down the center of the plate."};

        Random random = new Random();
        int index = random.nextInt(ballPosition.length);

        System.out.println("The ball is " + ballPosition[index]);
    }
}
