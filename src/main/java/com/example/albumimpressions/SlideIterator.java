package com.example.albumimpressions;

import java.util.List;

public class SlideIterator {
    private final List<Slide> slides;
    private int position = 0;

    public SlideIterator(List<Slide> slides) {
        this.slides = slides;
    }

    public boolean hasNext() {
        return position < slides.size();
    }

    public Slide next() {
        if (hasNext()) {
            return slides.get(position++);
        }
        return null;
    }

    public void reset() {
        position = 0;
    }
}