package collectionexamples;

public class Puppy implements Comparable<Puppy> {
    // fields
    private int age;
    private int cuteness;
    private String name;

    public Puppy(int age, int cuteness, String name) {
        this.age = age;
        this.cuteness = cuteness;
        this.name = name;
    }

    public String toString() {      // set toString()
        return name + " is " + age + " years old and is level " + cuteness + " cute.";
    }

    @Override
    public int compareTo(Puppy other) {
   /* // return negative number if this puppy is less than other puppy
    if(this.cuteness < other.cuteness) return -1;

    // return 0 if both puppy are equal
    else if (this.cuteness == other.cuteness) return 0;

    // return positive if this puppy is greater > than other puppy
    else return 1;
    */

        // this 1 line of code does the same as all of the above by using Comperable
        return this.cuteness - other.cuteness;                   // this sets the compare element to cuteness - if this item is cuter then result is positive, if both are equal result is 0, if this is less cute result is negative
    }
}