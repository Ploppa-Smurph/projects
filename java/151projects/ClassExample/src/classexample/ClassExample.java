package classexample;

public class ClassExample {
    public static void main(String[] args) {
       // Scanner scan = new Scanner(System.in);

        Car myCar = new Car("Dodge", "Caravan", "Gold");
        Car jimCar = new Car("Chevy", "Malibu", "Grey");
        Car raCar = new Car("Lexu", "ES330", "Black");

        System.out.println(myCar.getModel() + ", " + jimCar.getMake() + ", " + raCar.getColor());

        myCar.setColor("Plaid");                              // try to set the color to a non-listed color and cannot paint that color due to check in setter method
    }
}
