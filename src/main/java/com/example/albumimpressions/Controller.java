package com.example.albumimpressions;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class Controller {

    private final SlideIterator iterator;
    private ImageView currentImageView;
    private final StackPane imagePane = new StackPane();
    private Timeline movementAnimation;

    public Controller(SlideCollection collection) {
        this.iterator = collection.createIterator();
    }

    public StackPane createUI() {
        Button nextButton = new Button("Следующий слайд → (итератор)");
        nextButton.setStyle("-fx-font-size: 18px; -fx-padding: 10px;");
        nextButton.setOnAction(this::showNextSlide);

        VBox layout = new VBox(20, nextButton, imagePane);
        layout.setStyle("-fx-alignment: center; -fx-padding: 20px;");

        showNextSlide(null);
        return new StackPane(layout);
    }

    private void showNextSlide(ActionEvent event) {
        if (!iterator.hasNext()) {
            iterator.reset();
        }

        Slide slide = iterator.next();
        if (slide == null) return;

        currentImageView = slide.getImageView();
        imagePane.getChildren().setAll(currentImageView);
        startAnimation();
    }

    private void startAnimation() {
        FadeTransition fade = new FadeTransition(Duration.millis(2000), currentImageView);
        fade.setFromValue(0.0);
        fade.setToValue(1.0);
        fade.play();

        final int UPDATE_PERIOD = 30;
        final double[] x = { -400 };
        final double step = 5;

        if (movementAnimation != null) movementAnimation.stop();

        movementAnimation = new Timeline(
                new KeyFrame(Duration.millis(UPDATE_PERIOD), e -> {
                    x[0] += step;
                    currentImageView.setTranslateX(x[0]);
                    if (x[0] > 400) movementAnimation.stop();
                })
        );

        movementAnimation.setCycleCount(Timeline.INDEFINITE);
        movementAnimation.play();
    }
}
