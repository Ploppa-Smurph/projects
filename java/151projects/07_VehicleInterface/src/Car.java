public class Car implements Vehicle {
    private String make;
    private String model;
    private int mileage;

    public Car(String make, String model) {
        this.make = make;
        this.model = model;
        this.mileage = 0; // Initial mileage
    }

    @Override
    public void drive() {
        System.out.println("vroom vroom I'm a car.");
    }

    @Override
    public void drive(int distance) {
        System.out.println("Yay, we are travelling " + distance + " miles.");
        this.mileage += distance;
    }

    @Override
    public int getMileage() {
        return mileage;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", mileage=" + mileage +
                '}';
    }
}