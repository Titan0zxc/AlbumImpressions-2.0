package com.example;

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
        slides.add(new Slide("/image1.png"));
        slides.add(new Slide("/image2.png"));
        slides.add(new Slide("/image3.png"));
        slides.add(new Slide("/image4.png"));
        slides.add(new Slide("/image5.png"));
        // Добавьте остальные до image9.jpeg по желанию

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