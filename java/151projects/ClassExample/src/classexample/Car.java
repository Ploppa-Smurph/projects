package classexample;

public class Car {
    // fields -- variables -- data that is stored
        // 'private' before String is an 'accessibility modifiers'
    private String make;
    private String model;
    private String color;

    // constructor -- what is run when you create / instantiate an object
    // takes parameters
    public Car(String setMake, String setModel, String setColor) {
        make = setMake;
        model = setModel;
        color = setColor;
    }

    // methods -- what the object can do

    // getters
    public String getMake() {
        return make;

    }public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    // setters
    public void setColor(String newColor) {
        if(newColor == "Green" || newColor == "Gold" || newColor == "Orange" || newColor == "Grey" || newColor == "Blue" || newColor == "Red")
            color = newColor;
        else {
            System.out.println("Cannot paint that color");
        }
    }
}
