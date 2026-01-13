package com.example.albumimpressions;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class AlbumApp extends Application {

    @Override
    public void start(Stage stage) {
        SlideCollection collection = new SlideCollection(9);

        collection.addSlide(new Slide("/image1.jpg"));
        collection.addSlide(new Slide("/image2.jpg"));
        collection.addSlide(new Slide("/image3.jpg"));
        collection.addSlide(new Slide("/image4.jpg"));
        collection.addSlide(new Slide("/image5.jpg"));
        collection.addSlide(new Slide("/image6.jpg"));
        collection.addSlide(new Slide("/image7.jpg"));
        collection.addSlide(new Slide("/image8.jpg"));
        collection.addSlide(new Slide("/image9.jpg"));

        Controller controller = new Controller(collection);

        StackPane root = controller.createUI();
        Scene scene = new Scene(root, 900, 700);

        stage.setTitle("Альбом впечатлений");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
