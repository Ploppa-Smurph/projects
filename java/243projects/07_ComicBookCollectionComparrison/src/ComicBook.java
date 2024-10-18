public class ComicBook implements Comparable {
    private int conditionScore;
    private int publicationYear;
    private String title;

    public ComicBook(String title, int publicationYear, int conditionScore) {
        this.title = title;
        this.publicationYear = publicationYear;
        this.conditionScore = conditionScore;
        }

    // Getters for the fields
    public String getTitle() {
        return this.title;
    }

    public int getPublicationYear() {
        return this.publicationYear;
    }

    public int getConditionScore() {
        return this.conditionScore;
    }
    // Override toString method to provide a formatted string of comic details
    @Override
    public String toString() {
        return "ComicBook{" +
                "title='" + title + '\'' +
                ", publicationYear=" + publicationYear +
                ", conditionScore=" + conditionScore +
                '}';
    }

    // Implement compareTo method from Comparable interface
    @Override
    public int compareTo(ComicBook other) {
        int conditionComparison = Integer.compare(this.conditionScore, other.conditionScore);
            if (conditionComparison != 0) {
                return conditionComparison;
            }
        int ageComparison = Integer.compare(this.publicationYear, other.publicationYear);
            if (ageComparison != 0) {
                return ageComparison;
            }
            return this.title.compareTo(other.title);
        }
    }

