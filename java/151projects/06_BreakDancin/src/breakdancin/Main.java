package breakdancin;

public class Main {
    public static void main(String[] args) {
        int i = 1;
        while (i <=10) {
            switch (i) {
                case 1:
                    System.out.println("Break out the 'Stanky Leg'.");
                    break;
                case 2:
                    System.out.println("Clap " + i + " Times.");
                    break;
                case 3:
                    System.out.println("'Top Rock' to the Bronx Step.");
                    break;
                case 4:
                    System.out.println("Slide "+ i + " to the left.");
                    break;
                case 5:
                    System.out.println("Halt, 'Baby Freeze'.");
                    break;
                case 6:
                    System.out.println("To a "+ i +" beat.");
                    break;
                case 7:
                    System.out.println("Down to the floor and a 'Backspin'.");
                    break;
                case 8:
                    System.out.println("Stomp times "+ i +" if you feel it.");
                    break;
                case 9:
                    System.out.println("Finish with an 'Uprock' into the 'Moonwalk'.");
                    break;
                case 10:
                    System.out.println("Shake to the rhythm for a strong " + i +".");
                    break;
            }
            i++;
        }
    }
}