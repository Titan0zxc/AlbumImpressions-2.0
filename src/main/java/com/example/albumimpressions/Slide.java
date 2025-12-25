package com.example.albumimpressions;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Slide {
    private final ImageView imageView;

    public Slide(String path) {
        Image image = new Image(getClass().getResourceAsStream(path));
        imageView = new ImageView(image);
        imageView.setFitWidth(800);
        imageView.setFitHeight(500);
        imageView.setPreserveRatio(true);
    }

    public ImageView getImageView() {
        return imageView;
    }
}