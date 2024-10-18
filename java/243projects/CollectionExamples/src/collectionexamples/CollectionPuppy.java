package collectionexamples;

import java.util.ArrayList;

public class CollectionPuppy {
    public static void main(String[] args) {
        ArrayList<Puppy> puppyList = new ArrayList<>();

        puppyList.add(new Puppy(0, 9, "Thomas Riker"));
        puppyList.add(new Puppy(1,2, "Marmardurk"));
        puppyList.add(new Puppy(2, 1, "Marlmaldulk"));



        puppyList.sort(null);

        for(Puppy p : puppyList) {
            System.out.println(p);
        }
    }
}
