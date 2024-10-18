public class Truck implements Vehicle {
    private String driver;
    private String company;
    private int mileage;

    public Truck(String driver, String company) {
        this.driver = driver;
        this.company = company;
        this.mileage = 0; // Initial mileage
    }

    @Override
    public void drive() {
        System.out.println("honk honk I'm a truck.");
    }

    @Override
    public void drive(int distance) {
        System.out.println("On the road again, currently traveling " + distance + " miles, over-and-out.");
        this.mileage += distance;
    }

    @Override
    public int getMileage() {
        return mileage;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "driver='" + driver + '\'' +
                ", company='" + company + '\'' +
                ", mileage=" + mileage +
                '}';
    }
}