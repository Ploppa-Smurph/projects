package basicPortfolio.ch04;

public class Movie {
    private String name;
    private int year;
    private String rating;
    private double review;

    // Getters and Setters for
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public double getReview() {
        return review;
    }

    public void setReview(double review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "You added: '" + name + "', filmed in " + year + ", rated '" + rating + "' by the film institute, with a critical review of " + review + " of 5 stars. Your Movie Collection has been updated.";
    }
}
