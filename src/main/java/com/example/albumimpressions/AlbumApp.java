package com.example.albumimpressions;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class AlbumApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        List<Slide> slides = new ArrayList<>();
        slides.add(new Slide("/image1.jpg"));
        slides.add(new Slide("/image2.jpg"));
        slides.add(new Slide("/image3.jpg"));
        slides.add(new Slide("/image4.jpg"));
        slides.add(new Slide("/image5.jpg"));
        slides.add(new Slide("/image6.jpg"));
        slides.add(new Slide("/image7.jpg"));
        slides.add(new Slide("/image8.jpg"));
        slides.add(new Slide("/image9.jpg"));


        Controller controller = new Controller(slides);

        StackPane root = controller.createUI();
        Scene scene = new Scene(root, 900, 700);

        primaryStage.setTitle("Альбом впечатлений");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}