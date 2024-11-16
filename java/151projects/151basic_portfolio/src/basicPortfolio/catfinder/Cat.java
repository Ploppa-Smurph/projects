package basicPortfolio.catfinder;

import java.io.Serializable;

public class Cat implements Serializable, Comparable<Cat> {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Cat other) {
        return this.name.compareTo(other.name);
    }
}