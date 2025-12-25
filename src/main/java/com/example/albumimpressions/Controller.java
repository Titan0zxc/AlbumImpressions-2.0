package com.example.albumimpressions;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.util.List;

public class Controller {
    private final List<Slide> slides;
    private final SlideIterator iterator;
    private ImageView currentImageView;
    private final StackPane imagePane;
    private Timeline movementAnimation;

    public Controller(List<Slide> slides) {
        this.slides = slides;
        this.iterator = new SlideIterator(slides);
        this.imagePane = new StackPane();
    }

    public StackPane createUI() {
        Button nextButton = new Button("Следующий слайд → (итератор)");
        nextButton.setStyle("-fx-font-size: 18px; -fx-padding: 10px;");
        nextButton.setOnAction(this::showNextSlide);

        VBox layout = new VBox(20, nextButton, imagePane);
        layout.setStyle("-fx-alignment: center; -fx-padding: 20px;");

        // Показываем первый слайд сразу
        showNextSlide(null);

        return new StackPane(layout);
    }

    private void showNextSlide(ActionEvent event) {
        if (iterator.hasNext()) {
            Slide slide = iterator.next();
            currentImageView = slide.getImageView();

            imagePane.getChildren().clear();
            imagePane.getChildren().add(currentImageView);

            startAnimation();  // Запускаем анимацию (пункт 2)
        } else {
            // Если дошли до конца — начинаем сначала
            iterator.reset();
            showNextSlide(event);
        }
    }

    private void startAnimation() {
        // 1. FadeTransition — затухание/появление (пример из методички)
        FadeTransition fade = new FadeTransition(Duration.millis(2000), currentImageView);
        fade.setFromValue(0.0);
        fade.setToValue(1.0);
        fade.play();

        // 2. Движение по экрану — как в примере с шариком (Timeline + KeyFrame)
        final int UPDATE_PERIOD = 30;
        final double[] x = { -400 };  // начинаем слева за экраном
        final double step = 5;

        if (movementAnimation != null) movementAnimation.stop();

        movementAnimation = new Timeline(new KeyFrame(Duration.millis(UPDATE_PERIOD), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent evt) {
                x[0] += step;
                currentImageView.setTranslateX(x[0]);

                // Если вышел за правый край — останавливаем
                if (x[0] > 400) {
                    movementAnimation.stop();
                }
            }
        }));
        movementAnimation.setCycleCount(Timeline.INDEFINITE);
        movementAnimation.play();
    }
}