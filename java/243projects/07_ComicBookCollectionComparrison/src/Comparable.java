public interface Comparable {
        int getConditionScore(); // Returns a score representing the condition of the comic book.
        int getPublicationYear(); // Returns the year the comic was published.
        String getTitle(); // Returns the title of the comic book.

        // Default method to compare two comics based on the given rules.
        default int compareTo(ComicBook other) {
            int conditionComparison = Integer.compare(this.getConditionScore(), other.getConditionScore());
            if (conditionComparison != 0) {
                return conditionComparison;
            }

            int ageComparison = Integer.compare(this.getPublicationYear(), other.getPublicationYear());
            if (ageComparison != 0) {
                return ageComparison;
            }

            return this.getTitle().compareTo(other.getTitle());
        }
}
