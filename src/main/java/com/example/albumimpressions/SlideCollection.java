package com.example.albumimpressions;

public class SlideCollection {

    private final Slide[] slides;
    private int size = 0;

    public SlideCollection(int capacity) {
        slides = new Slide[capacity];
    }

    public void addSlide(Slide slide) {
        if (size < slides.length) {
            slides[size++] = slide;
        }
    }

    public int getSize() {
        return size;
    }

    public Slide getSlide(int index) {
        if (index >= 0 && index < size) {
            return slides[index];
        }
        return null;
    }

    public SlideIterator createIterator() {
        return new SlideIterator(this);
    }
}
