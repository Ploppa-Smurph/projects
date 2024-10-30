public class Test {

    // Main method to test the Sentence class
    public static void main(String[] args) {

        // Create two Sentence objects
        Sentence sentence1 = new Sentence("This is the time to shine, to love, to dive, a hen, and now Fin.");
        Sentence sentence2 = new Sentence("Have you seen the big game? It's about a fallen knight in a land filled with a golden tree.");

        // Print and iterate through the first sentence
        System.out.println("Sentence 1:");
        for (String word : sentence1) {
            System.out.println(word);
        }

        // Print and iterate through the second sentence
        System.out.println("\nSentence 2:");
        for (String word : sentence2) {
            System.out.println(word);
        }
    }
}
