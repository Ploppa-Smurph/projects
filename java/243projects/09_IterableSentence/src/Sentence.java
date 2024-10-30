import java.util.Iterator;

public class Sentence implements Iterable<String> {
    // Field to hold the sentence
    private String sentence;

    // Constructor to initialize the sentence field
    public Sentence(String sentence) {
        this.sentence = sentence;
    }

    // toString method to return the sentence as a string
    @Override
    public String toString() {
        return sentence;
    }

    // iterator method to return an iterator for the sentence
    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {

            // Split the sentence into words based on spaces
            private String[] words = sentence.split(" ");
            // Index to keep track of the current position
            private int index = 0;

            // hasNext method to check if there are more words left
            @Override
            public boolean hasNext() {
                return index < words.length;
            }

            // next method to return the next word in the sentence
            @Override
            public String next() {
                return words[index++];
            }
        };
    }
}
