package com.example.albumimpressions;

public class SlideIterator {

    private final SlideCollection collection;
    private int position = 0;

    public SlideIterator(SlideCollection collection) {
        this.collection = collection;
    }

    public boolean hasNext() {
        return position < collection.getSize();
    }

    public Slide next() {
        if (hasNext()) {
            return collection.getSlide(position++);
        }
        return null;
    }

    public void reset() {
        position = 0;
    }
}
