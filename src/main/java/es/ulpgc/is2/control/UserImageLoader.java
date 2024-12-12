package es.ulpgc.is2.control;

import es.ulpgc.is2.model.Image;

import java.util.List;

public class UserImageLoader implements ImageLoader {
    private final List<byte[]> images;

    public UserImageLoader(List<byte[]> images) {
        this.images = images;
    }

    @Override
    public Image load() {
        return imageAt(0);
    }

    private Image imageAt(int i) {
        return new Image() {
            @Override
            public byte[] name() {
                return images.get(i);
            }

            @Override
            public Image next() {
                return imageAt((i+1) % images.size());
            }

            @Override
            public Image prev() {
                return imageAt((i-1 + images.size()) % images.size());
            }
        };
    }
}
