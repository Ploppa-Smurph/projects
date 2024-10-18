/*
* (-=-) + |-=-| * <-=-> + [-=-] * wk02 Budget Program by Jeff Walley / Java 151-901 Fall 2024 * [-=-] + <-=-> * |-=-| + (-=-) *
 */

// import Scanner to accept user input
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

// Housing Budget
        System.out.println("What is the monthly Housing budget, by percent of total budget?");
        System.out.println("Please enter answer in 0.XX format: ");

// creates Scanner object named 'scan'
        double housing;
        Scanner input01 = new Scanner(System.in);

// sets a variable to hold the 'scan' String
        housing = input01.nextDouble();

// Food Budget
        System.out.println("What is the monthly Food budget, by percent of total budget?");
        System.out.println("Please enter answer in 0.XX format: ");

// creates Scanner object named 'scan'
        double food;
        Scanner input02 = new Scanner(System.in);

// sets a variable to hold the 'scan' String
        food = input02.nextDouble();

// Transportation Budget
        System.out.println("What is the monthly Transport budget, by percent of total budget?");
        System.out.println("Please enter answer in 0.XX format: ");

// creates Scanner object named 'scan'
        double transport;
        Scanner input03 = new Scanner(System.in);

// sets a variable to hold the 'scan' String
        transport = input03.nextDouble();

// Savings Amount
        double savings;
        savings = 1.0 - housing - food - transport;

// Savings Output
        System.out.println("Assuming you are saving every other penny...");
        System.out.println("Your Savings percent is: " + savings);

// Monthly Income
        System.out.println("What is the monthly Income? ");

// creates Scanner object named 'scan'
        double income;
        Scanner input04 = new Scanner(System.in);

// sets a variable to hold the 'scan' String
        income = input04.nextDouble();

// Area of Calculation
        System.out.println("Processing Budget, Please Wait...");

// Housing Conversion
        double housingDol;
        housingDol = income * housing;

        System.out.println("Housing expenditures are about = $" +(int) Math.round(housingDol) + ", more precisely they = $" + housingDol);

// Food Conversion
        double foodDol;
        foodDol = income * food;

        System.out.println("Food expenditures are about = $" +(int) Math.round(foodDol) + ", more precisely they = $" + foodDol);

// Transportation Conversion
        double transportDol;
        transportDol = income * transport;

        System.out.println("Transportation expenditures are about = $" +(int) Math.round(transportDol) + ", more precisely they = $" + transportDol);

// Savings Conversion
        double savingsDol;
        savingsDol = income * savings;

        System.out.println( "The Savings amount for this month can be = $" +(int) Math.round(savingsDol) + ", more precisely they = $" + savingsDol);
    }
}