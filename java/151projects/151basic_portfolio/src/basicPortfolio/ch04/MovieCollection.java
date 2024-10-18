package basicPortfolio.ch04;

import java.util.ArrayList;
import java.util.Scanner;

public class MovieCollection {
    private ArrayList<Movie> movies;

    public MovieCollection() {
        movies = new ArrayList<>();
    }

    public void addMovie() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n" + "*".repeat(20));
        System.out.println("MOVIE COLLECTION APP");
        System.out.println("*".repeat(20) + "\n");
        System.out.print("Enter the name of the movie: ");
        String name = scanner.nextLine();

        System.out.print("Enter the year the movie was released: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // consume the leftover newline

        System.out.print("Enter the movie rating (G, PG, R, NC17, X, XXX, Unrated, etc...): ");
        String rating = scanner.nextLine();

        System.out.print("Enter the movie review out of 5 stars: (can hold decimal ratings)");
        double review = scanner.nextDouble();
        scanner.nextLine(); // consume the leftover newline

        Movie movie = new Movie();
        movie.setName(name);
        movie.setYear(year);
        movie.setRating(rating);
        movie.setReview(review);

        movies.add(movie);
    }

    public void displayMovies() {
        System.out.println("\nYour movie collection:");
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public void addMoviesLoop() {
        Scanner scanner = new Scanner(System.in);
        boolean continueAdding = true;

        // Add movies until the user decides to stop
        while (continueAdding) {
            addMovie();
            System.out.print("Do you want to add another movie? (yes/no): ");
            String response = scanner.nextLine();

            // Update continueAdding based on the user's input
            continueAdding = !response.equalsIgnoreCase("no");
        }

        // Display the list of movies after the user chooses to stop adding
        displayMovies();
    }

    public static void main(String[] args) {
        MovieCollection collection = new MovieCollection();
        collection.addMoviesLoop();
    }
}
