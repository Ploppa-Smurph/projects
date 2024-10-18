// Jeffrey Walley | 09/05/24 | JavaFX Tutorial

package fxhelloworld;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.text.Text;


public class FXHelloWorld extends Application{
    public static void main(String[] args) {
            // TODO code application logic here
        launch();                   // method that builds window and passes information to the window -- starts the staging
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Text helloWorld = new Text(50, 50, "Hello World");            // text element.. (x coordinate, y coordinate, "text")
        Rectangle rect = new Rectangle(30, 30, 100, 33);      // create a rectangle
        Group root = new Group(rect, helloWorld);                               // can hold things together, groups them together -- group will draw each item in order
        rect.setFill(Color.CORAL);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
