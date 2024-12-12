package es.ulpgc.is2.model;

public interface Image {
    byte[] name();
    Image next();
    Image prev();
}
