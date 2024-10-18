public class Main {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Corolla");
        Truck truck = new Truck("John Doe", "XYZ Logistics");

        System.out.println("Initial State:");
        System.out.println(car);
        System.out.println(truck);

        car.drive();
        car.drive(50); // Drive 50 units
        truck.drive();
        truck.drive(100); // Drive 100 units

        System.out.println("\nAfter driving:");
        System.out.println(car);
        System.out.println(truck);
    }
}